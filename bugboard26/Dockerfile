FROM amazoncorretto:25-alpine

COPY target/hello-world-docker-1.0-SNAPSHOT.jar /usr/src/hello-world-docker.jar
ENTRYPOINT ["java", "-jar", "/usr/src/hello-world-docker.jar"]