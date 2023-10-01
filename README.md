
# Getting Started
## Spring Boot 3 + Kafka + Schema Registry and Avro

### Overview



### Guides 

1. [Download](https://www.docker.com/products/docker-desktop/) and install Docker Desktop 
2. You can check the version of Docker you have installed:
   
   <img width="823" alt="Screenshot 2023-10-02 at 1 35 25 AM" src="https://github.com/sovanmukherjee/springboot-kafka-avro/assets/26097904/f9db90bc-90e2-4d15-b9c1-31d0d0a58d05">


3. Starting confluent platform on Docker:
   
   Download [docker-compose.yml](https://github.com/sovanmukherjee/springboot-kafka-avro/blob/5c21b667de1e6000be9556f1fa7c876afb81b5ac/docker-compose.yml) file and run docker compose command with -d option to run in detached mode

   `docker-compose up -d`

   You should see all the containers come up as shown below:
   
   <img width="1503" alt="Screenshot 2023-10-02 at 12 13 38 AM" src="https://github.com/sovanmukherjee/springboot-kafka-avro/assets/26097904/596ac75c-8a3e-446d-91e8-98f40f982e4d">


4. Create Kafka topics

   Navigate to Control Center at http://localhost:9021. It may take a minute or two for Control Center to start and load.
   Click on the cluster.
  
   <img width="1076" alt="Screenshot 2023-10-02 at 12 19 47 AM" src="https://github.com/sovanmukherjee/springboot-kafka-avro/assets/26097904/8cee616b-a92d-4ff0-88db-8906c45b4167">

  
   <img width="1322" alt="Screenshot 2023-10-02 at 12 20 19 AM" src="https://github.com/sovanmukherjee/springboot-kafka-avro/assets/26097904/86fd3b41-237e-4b1f-945f-f1818af1adbc">


   In the navigation menu, click Topics to open the topics list. Click on Add topic button

   <img width="1370" alt="Screenshot 2023-10-02 at 2 16 03 AM" src="https://github.com/sovanmukherjee/springboot-kafka-avro/assets/26097904/3d559951-cc70-415d-afc9-7104f291f82c">


   In the Topic name field, enter topic name and click Create with defaults. Topic names are case-sensitive.

    <img width="1420" alt="Screenshot 2023-10-02 at 12 29 00 AM" src="https://github.com/sovanmukherjee/springboot-kafka-avro/assets/26097904/56dc3da0-4d70-4b61-95da-dd9294716bd9">


    Create retry topic
   
   <img width="1404" alt="Screenshot 2023-10-02 at 12 32 27 AM" src="https://github.com/sovanmukherjee/springboot-kafka-avro/assets/26097904/3d434a78-4e28-4561-aa19-f0a76c5943d4">


    Create dlt topic

    <img width="1418" alt="Screenshot 2023-10-02 at 12 33 05 AM" src="https://github.com/sovanmukherjee/springboot-kafka-avro/assets/26097904/43e25824-8ad0-4c1e-af63-4c22fe2e5f2b">


    You should see all the new topics in the Topics list.
   
   <img width="1403" alt="Screenshot 2023-10-02 at 12 35 28 AM" src="https://github.com/sovanmukherjee/springboot-kafka-avro/assets/26097904/912f58c4-cc9c-4622-a563-755ff396feb6">



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
   
  <img width="1286" alt="Screenshot 2023-10-02 at 2 34 00 AM" src="https://github.com/sovanmukherjee/springboot-kafka-avro/assets/26097904/c898929d-97e0-44d2-a5c5-40e06235b21f">


10. Open [Swagger-Ui](http://localhost:8080/swagger-ui/index.html)
    
 <img width="1417" alt="Screenshot 2023-10-02 at 3 02 02 AM" src="https://github.com/sovanmukherjee/springboot-kafka-avro/assets/26097904/b3d8061d-8da3-4ab2-8c7f-07996e6fb1dc">


12. Run [springboot-kafka-avro-consumer](https://github.com/sovanmukherjee/springboot-kafka-avro/tree/5c21b667de1e6000be9556f1fa7c876afb81b5ac/springboot-kafka-avro-consumer) service
   
   <img width="1288" alt="Screenshot 2023-10-02 at 3 07 29 AM" src="https://github.com/sovanmukherjee/springboot-kafka-avro/assets/26097904/bc48baa3-6d9f-4900-a17b-bcbdbe5c4491">


13. Execute Students API

   <img width="1436" alt="Screenshot 2023-10-02 at 3 11 34 AM" src="https://github.com/sovanmukherjee/springboot-kafka-avro/assets/26097904/5e038523-66f1-4af3-b301-7908d7195e9e">


14. [springboot-kafka-avro-producer](https://github.com/sovanmukherjee/springboot-kafka-avro/tree/5c21b667de1e6000be9556f1fa7c876afb81b5ac/springboot-kafka-avro-producer) console log

   <img width="1281" alt="Screenshot 2023-10-02 at 3 14 13 AM" src="https://github.com/sovanmukherjee/springboot-kafka-avro/assets/26097904/1fd7cd20-4a33-47a6-9f74-b866d3081389">


  Students API response:
  
   <img width="1421" alt="Screenshot 2023-10-02 at 3 16 54 AM" src="https://github.com/sovanmukherjee/springboot-kafka-avro/assets/26097904/c53c6a06-fe67-450b-9633-c3519b87ca70">


15. [springboot-kafka-avro-consumer](https://github.com/sovanmukherjee/springboot-kafka-avro/tree/5c21b667de1e6000be9556f1fa7c876afb81b5ac/springboot-kafka-avro-consumer) console log

   <img width="1267" alt="Screenshot 2023-10-02 at 3 19 37 AM" src="https://github.com/sovanmukherjee/springboot-kafka-avro/assets/26097904/9094c1ab-964c-4af4-961d-df7e1393bb2e">




### Additional Links
These additional references should also help you:

* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Avro Schema Serializer and Deserializer](https://docs.confluent.io/platform/current/schema-registry/fundamentals/serdes-develop/serdes-avro.html)
* [Install Confluent Platform](https://docs.confluent.io/platform/current/installation/overview.html)
* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)







