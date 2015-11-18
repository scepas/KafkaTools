package com.cepas.pruebas.kafka;

import java.util.Properties;
import org.apache.commons.cli.*;

/**
 * Created by scepas on 18/11/15.
 */
public class KafkaManager {
    public static void main(String[] args) {
        final CommandLineParser parser = new DefaultParser();
        final Options options = createOptions();
        final HelpFormatter formatter = new HelpFormatter();

        String topic = "test";
        String zookeeper = "172.17.0.1:2181";
        String kafka = "172.17.0.1:9092";
        boolean isAvro = false;
        boolean isProducer = false;
        boolean isConsumer = false;
        String group = "group";

        try {
            CommandLine cmd = parser.parse(options, args);
            if (cmd.hasOption("t")) {
                topic = cmd.getOptionValue("t");
            }
            if (cmd.hasOption("z")) {
                zookeeper = cmd.getOptionValue("z");
            }
            if (cmd.hasOption("k")) {
                kafka = cmd.getOptionValue("k");
            }
            if (cmd.hasOption("g")) {
                group = cmd.getOptionValue("g");
            }

            isProducer = cmd.hasOption("producer");
            isConsumer = cmd.hasOption("consumer");
            isAvro = cmd.hasOption("a");
        }
        catch (ParseException ex)   {
            formatter.printHelp("KafkaManager", options, true);
            System.exit(1);
        }

        if (!isConsumer && !isProducer) {
            formatter.printHelp("KafkaManager", options, true);
            System.exit(1);
        }

        Properties props = new Properties();
        props.put("bootstrap.servers", kafka);
        props.put("zookeeper.connect", zookeeper);
        props.put("request.required.acks", "1");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        if (isAvro) {
            props.put("value.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");
        }
        else    {
            props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        }

        props.put("zookeeper.session.timeout.ms", "413");
        props.put("zookeeper.sync.time.ms", "203");
        props.put("auto.commit.interval.ms", "1000");
        props.put("auto.offset.reset", "smallest"); //read from beginning


        if (isProducer)  {
            if (isAvro) {
                new AvroProducer(props, topic);
            }
            else {
                new SimpleKafkaProducer(props, topic);
            }
        }
        else    {
            new AvroConsumer(props, topic, group);
        }
    }

    private static Options createOptions()  {
        Options options = new Options();
        options.addOption("producer", false, "producer");
        options.addOption("consumer", false, "consumer");
        options.addOption("a", false, "avro");
        options.addOption("t", true, "topic");
        options.addOption("z", true, "zookeeper connection string (hostname:port)");
        options.addOption("k", true, "kafka connection string (hostname:port");
        options.addOption("g", true, "group_id");
        return options;
    }
}
