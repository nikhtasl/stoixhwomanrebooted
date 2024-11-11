# Start from an official OpenJDK image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged JAR file into the container
COPY target/stoixhwomanrebooted-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your Spring Boot app uses (default is 8080)
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]