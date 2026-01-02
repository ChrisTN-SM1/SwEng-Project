FROM maven:3.9.11-eclipse-temurin-25 AS build

RUN mkdir -p /otp/app
WORKDIR /opt/app

COPY pom.xml /opt/app
COPY .env /opt/app

COPY src /opt/app/src
RUN mvn package

EXPOSE 8080

ENTRYPOINT [ "mvn", "exec:java"]
