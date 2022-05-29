FROM openjdk:8-jdk-alpine
COPY target/uploadjson-0.0.1-SNAPSHOT.jar /usr/app/uploadjson-0.0.1-SNAPSHOT.jar
WORKDIR /usr/app
ENTRYPOINT ["java","-jar","uploadjson-0.0.1-SNAPSHOT.jar"]