package com.cepas.pruebas.kafka;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer ;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;
import java.util.concurrent.Future;

/**
 * Created by scepas on 17/11/15.
 *
 * Simple kafka producer that generates 100 events
 */
public class SimpleKafkaProducer {
    public SimpleKafkaProducer(Properties props, String topic)   {
        run(props, topic);
    }

    private void run(Properties props, String topic) {
        KafkaProducer<String, String> producer = new KafkaProducer<>(props);
        for (int i = 0; i < 100; i++){
            String message = String.format("message: %d", i);
            ProducerRecord<String, String> data = new ProducerRecord<>(topic, String.valueOf(i), message);
            Future<RecordMetadata> rs = producer.send(data, new Callback() {
                @Override
                public void onCompletion(RecordMetadata rm, Exception e) {
                    System.out.println("Partition: " + rm.partition() + " - offset = " + rm.offset()) ;
                }
            });

            try {
                RecordMetadata rm = rs.get();
                message = message + "  partition = " + rm.partition() +  " offset =" + rm.offset() ;
                System.out.println(message) ;
            } catch(Exception ex) {
                System.out.println(ex) ;
            }
        }
        producer.close();
    }
}
