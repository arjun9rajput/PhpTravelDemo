# Use an official Java runtime as a parent image
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Maven or Gradle build file (pom.xml or build.gradle)
COPY pom.xml .   # for Maven
# COPY build.gradle .  # for Gradle

# Copy the source code and resources
COPY src ./src

# Install dependencies (Maven)
RUN apt-get update && \
    apt-get install -y maven && \
    mvn clean install

# Expose the port if your application runs a server (optional)
# EXPOSE 8080

# Command to run your tests
CMD ["mvn", "test"]  # Adjust if using Gradle
