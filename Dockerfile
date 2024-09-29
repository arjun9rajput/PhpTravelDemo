
FROM openjdk:11-jre-slim


WORKDIR /app


COPY pom.xml .

COPY src ./src


RUN apt-get update && \
    apt-get install -y maven && \
    mvn clean install



CMD ["mvn", "test"]
