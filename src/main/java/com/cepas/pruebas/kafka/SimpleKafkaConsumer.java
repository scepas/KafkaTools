package com.cepas.pruebas.kafka;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

import kafka.message.MessageAndMetadata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by scepas on 19/11/15.
 */
public class SimpleKafkaConsumer {
    public SimpleKafkaConsumer (Properties props, String topic, String group) {
        run(props, topic, group);
    }

    private void run (Properties props, String topic, String group) {
        props.put("group.id", group);
        ConsumerConfig cfg = new ConsumerConfig(props);
        ConsumerConnector consumer = Consumer.createJavaConsumerConnector(cfg) ;
        Map<String, Integer> topicCountMap = new HashMap<>();
        topicCountMap.put(topic, 1);//1 thread

        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumer.createMessageStreams(topicCountMap);
        List<KafkaStream<byte[], byte[]>> streams = consumerMap.get(topic);

        KafkaStream<byte[],byte[]> stream = streams.get(0);

        for (MessageAndMetadata<byte[], byte[]> aStream : stream) {
            System.out.println(new String(aStream.message()));
        }
    }
}
