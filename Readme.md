## KafkaManager

Simple tool that:

- Produces simple test events to a Kafka topic
- Produces avro events
- Consumes avro events

To test Kafka I used [Kafka Docker](http://wurstmeister.github.io/kafka-docker/).

### Build

`mvn package`

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

### Example

Start kafka docker cluster:

`docker-compose -f docker-compose.yml up`

Connect to kafka broker:

`./start-kafka-shell.sh 192.168.59.103 172.17.0.1:2181`

Create avro topic:

`$KAFKA_HOME/bin/kafka-topics.sh --create --topic avro --partitions 2 --zookeeper $ZK --replication-factor 1`

Produce avro events:

`java -jar kafkatools-1.0-SNAPSHOT.jar -producer -a -k 172.17.0.1:9092`

Consume avro events:

`java -jar kafkatools-1.0-SNAPSHOT.jar -consumer -a -z 172.17.0.1:2181`

Clean up

`docker-compose stop`

`docker-compose rm`

### TODO
- Text consumer
- Test decimal data type
