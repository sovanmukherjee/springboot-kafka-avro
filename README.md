
# Getting Started
##Spring Boot 3 + Kafka + Schema Registry and Avro

### Overview



### Guides 

1. [Download](https://www.docker.com/products/docker-desktop/) and install Docker Desktop 
2. You can check the version of Docker you have installed:
   
   <img width="823" alt="Screenshot 2023-10-02 at 1 35 25 AM" src="https://github.com/sovanmukherjee/springboot-kafka-avro/assets/26097904/221c7875-11e6-44b2-88e9-e82f549159fa">

3. Starting confluent platform on Docker:
   
   Download [docker-compose.yml](https://github.com/sovanmukherjee/springboot-kafka-avro/blob/5c21b667de1e6000be9556f1fa7c876afb81b5ac/docker-compose.yml) file and run docker compose command with -d option to run in detached mode

   `docker-compose up -d`

   You should see all the containers come up as shown below:
   
   <img width="1503" alt="Screenshot 2023-10-02 at 12 13 38 AM" src="https://github.com/sovanmukherjee/springboot-kafka-avro/assets/26097904/f563c9e8-3997-4062-8cba-31556c870515">

4. Create Kafka topics

   Navigate to Control Center at http://localhost:9021. It may take a minute or two for Control Center to start and load.
   Click on the cluster.
  
   <img width="1076" alt="Screenshot 2023-10-02 at 12 19 47 AM" src="https://github.com/sovanmukherjee/springboot-kafka-avro/assets/26097904/27e09e7d-0054-464a-87fd-267961fd0f88">

  
   <img width="1322" alt="Screenshot 2023-10-02 at 12 20 19 AM" src="https://github.com/sovanmukherjee/springboot-kafka-avro/assets/26097904/5fb7a313-8c33-4bbc-b73a-929b00421083">

   In the navigation menu, click Topics to open the topics list. Click on Add topic button

   <img width="1370" alt="Screenshot 2023-10-02 at 2 16 03 AM" src="https://github.com/sovanmukherjee/springboot-kafka-avro/assets/26097904/3f8f83e7-54fb-44df-994e-e2f8a745d011">

   In the Topic name field, enter topic name and click Create with defaults. Topic names are case-sensitive.

    <img width="1420" alt="Screenshot 2023-10-02 at 12 29 00 AM" src="https://github.com/sovanmukherjee/springboot-kafka-avro/assets/26097904/60bcd90b-7688-4751-ac58-ca25e125e664">

    Create retry topic
   
    <img width="1404" alt="Screenshot 2023-10-02 at 12 32 27 AM" src="https://github.com/sovanmukherjee/springboot-kafka-avro/assets/26097904/6b2f2ce9-793b-45f3-b63e-2c6722a94756">

    Create dlt topic

    <img width="1418" alt="Screenshot 2023-10-02 at 12 33 05 AM" src="https://github.com/sovanmukherjee/springboot-kafka-avro/assets/26097904/e1394b6d-9b9b-4344-86d5-32c0629caccf">

    You should see all the new topics in the Topics list.
   
   <img width="1403" alt="Screenshot 2023-10-02 at 12 35 28 AM" src="https://github.com/sovanmukherjee/springboot-kafka-avro/assets/26097904/ed373433-2e0d-4c20-a452-d30ce6f729b3">


6. Verify registered schema types:
   
   `http://localhost:8081/schemas/types`
   
   Response:
   ```
   [
    "JSON",
    "PROTOBUF",
    "AVRO"
   ]

   ```

8. Generated Avro Schema: [student.avsc](https://github.com/sovanmukherjee/springboot-kafka-avro/blob/5c21b667de1e6000be9556f1fa7c876afb81b5ac/springboot-kafka-avro-producer/src/main/resources/avro/schemas/student.avsc)
    

9. Run [springboot-kafka-avro-producer](https://github.com/sovanmukherjee/springboot-kafka-avro/tree/5c21b667de1e6000be9556f1fa7c876afb81b5ac/springboot-kafka-avro-producer) service
   
  <img width="1286" alt="Screenshot 2023-10-02 at 2 34 00 AM" src="https://github.com/sovanmukherjee/springboot-kafka-avro/assets/26097904/5a95b5f4-5a97-4d21-b101-c7b2ddba4c77">

10. Open [Swagger-Ui](http://localhost:8080/swagger-ui/index.html)
    
  <img width="1417" alt="image" src="https://github.com/sovanmukherjee/springboot-kafka-avro/assets/26097904/76d5e748-4c2d-43d1-8f9d-72ad4b7493db">

12. Run [springboot-kafka-avro-consumer](https://github.com/sovanmukherjee/springboot-kafka-avro/tree/5c21b667de1e6000be9556f1fa7c876afb81b5ac/springboot-kafka-avro-consumer) service
   
   <img width="1288" alt="image" src="https://github.com/sovanmukherjee/springboot-kafka-avro/assets/26097904/e508906a-6a79-43c3-9f7b-aff4fd24e2cc">

13. Execute Student API

   <img width="1436" alt="image" src="https://github.com/sovanmukherjee/springboot-kafka-avro/assets/26097904/a9600ef5-c7f2-4d2f-9532-6f6aa539fb9c">

14. [springboot-kafka-avro-producer](https://github.com/sovanmukherjee/springboot-kafka-avro/tree/5c21b667de1e6000be9556f1fa7c876afb81b5ac/springboot-kafka-avro-producer) console log

   <img width="1281" alt="image" src="https://github.com/sovanmukherjee/springboot-kafka-avro/assets/26097904/be49c44f-f681-4989-8c6d-4179ee03783d">

  Student API response:
  
   <img width="1421" alt="image" src="https://github.com/sovanmukherjee/springboot-kafka-avro/assets/26097904/84478542-468d-4d1d-af3c-58daf8be7949">

15. [springboot-kafka-avro-consumer](https://github.com/sovanmukherjee/springboot-kafka-avro/tree/5c21b667de1e6000be9556f1fa7c876afb81b5ac/springboot-kafka-avro-consumer) console log

   <img width="1267" alt="Screenshot 2023-10-02 at 3 19 37 AM" src="https://github.com/sovanmukherjee/springboot-kafka-avro/assets/26097904/38ecfc2f-d84d-4d14-b4eb-f6ed0035c303">



### Additional Links
These additional references should also help you:

* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Avro Schema Serializer and Deserializer](https://docs.confluent.io/platform/current/schema-registry/fundamentals/serdes-develop/serdes-avro.html)
* [Install Confluent Platform](https://docs.confluent.io/platform/current/installation/overview.html)
* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)







