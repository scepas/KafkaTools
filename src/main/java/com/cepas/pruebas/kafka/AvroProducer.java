package com.cepas.pruebas.kafka;

import com.cepas.events.avro.EventPrueba;
import org.apache.avro.io.BinaryEncoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by scepas on 17/11/15.
 */
public class AvroProducer {
    public AvroProducer(Properties props, String topic)   {
        run(props, topic);
    }

    private void run(Properties props, String topic) {
        KafkaProducer<String, byte[]> producer = new KafkaProducer<>(props);
        for (int i = 0; i < 1000; i++) {
            String name = String.format("name_%d", i);
            int age = i % 50;
            EventPrueba evt = new EventPrueba();
            evt.setNombre(name);
            evt.setEdad(age);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            BinaryEncoder enc= EncoderFactory.get().binaryEncoder(out, null);
            SpecificDatumWriter<EventPrueba> writer = new SpecificDatumWriter<>(EventPrueba.getClassSchema());

            ProducerRecord<String, byte[]> record;
            try {
                writer.write(evt, enc);
                enc.flush();
                out.close();
                record = new ProducerRecord<>(topic, null, out.toByteArray());
                producer.send(record);
                System.out.println(String.format("generado evento %s", name));
                Thread.sleep(100);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
