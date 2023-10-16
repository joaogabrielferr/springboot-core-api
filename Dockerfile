FROM maven:3.8.3-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package

FROM openjdk:17-jdk-alpine
EXPOSE 8080
COPY ./target/api-spring-boot-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
