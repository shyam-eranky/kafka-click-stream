# kafka-click-stream
This project demonstrates a simple kafka producer and consumer of click events. 
# Zookeeper Setup
Download Zookeeper first and unzip it. Create 3 nodes for ZK on your localhost. Use this folder structure
/zookeeper
  /zk-server-1
  /zk-server-2
  /zk-server-3
  /data
    /zk1
    /zk2
    /zk3
  /log
    /zk1
    /zk2
    /zk3
Copy zookeeper dist into each zk-server folder. Then open the zoo.cfg file in conf folder and update the paths and add the other servers 
with diff ports in there (2288:3888, 2889:3889 etc). Do this in every folder
# Kafka Setup
