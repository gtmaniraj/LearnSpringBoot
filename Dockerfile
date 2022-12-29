FROM openjdk:17
EXPOSE 8080
ADD target/demo-0.0.1-SNAPSHOT.jar fsboot.jar
ENTRYPOINT ["java","-jar","/fsboot.jar"]