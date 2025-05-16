# Use Java 18 base image
FROM eclipse-temurin:18-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the Spring Boot jar file into the container
COPY target/ToDo-app-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your Spring Boot app runs on
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
