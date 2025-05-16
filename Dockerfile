# -------- First Stage: Build the app --------
FROM maven:3.9.4-eclipse-temurin-18-alpine AS builder

WORKDIR /app

# Copy all files and download dependencies
COPY pom.xml .
COPY src ./src

# Build the Spring Boot app
RUN mvn clean package -DskipTests

# -------- Second Stage: Run the app --------
FROM eclipse-temurin:18-jdk-alpine

WORKDIR /app

# Copy only the JAR file from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
