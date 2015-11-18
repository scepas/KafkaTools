package com.cepas.pruebas.kafka;

import com.cepas.events.avro.EventPrueba;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

import kafka.message.MessageAndMetadata;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.specific.SpecificDatumReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by scepas on 17/11/15.
 */
public class AvroConsumer {
    public AvroConsumer(Properties props, String topic, String group) {
        run(props, topic, group);
    }

    private void run(Properties props, String topic, String group) {
        //props.put("metadata.broker.list", "172.17.0.1:9092");
        props.put("group.id", group);

        ConsumerConfig cfg = new ConsumerConfig(props);
        ConsumerConnector consumer = Consumer.createJavaConsumerConnector(cfg) ;
        Map<String, Integer> topicCountMap = new HashMap<>();
        topicCountMap.put(topic, 1);//1 thread

        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumer.createMessageStreams(topicCountMap);
        List<KafkaStream<byte[], byte[]>> streams = consumerMap.get(topic);

        KafkaStream<byte[],byte[]> stream = streams.get(0) ;

        for (MessageAndMetadata<byte[], byte[]> aStream : stream) {
            try {
                EventPrueba event = new SpecificDatumReader<>(EventPrueba.class).read(
                        null
                        , DecoderFactory.get().binaryDecoder(aStream.message(), null)
                );
                System.out.println(event.toString());
                System.out.println("event name: " + event.getNombre());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        consumer.shutdown();
    }
}
