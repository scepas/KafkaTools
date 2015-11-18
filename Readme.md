## KafkaManager

Simple tool that:
    - Produces simple test events to a Kafka topic
    - Produces avro events
    - Consumes avro events

To test Kafka I used [Kafka Docker](http://wurstmeister.github.io/kafka-docker/).

### Usage
```
KafkaManager [-a] [-consumer] [-g <arg>] [-k <arg>] [-producer] [-t
        <arg>] [-z <arg>]
  -a          avro
  -consumer   consumer
  -g <arg>    group_id
  -k <arg>    kafka connection string (hostname:port
  -producer   producer
  -t <arg>    topic
  -z <arg>    zookeeper connection string (hostname:port)

```

### TODO
- Text consumer

