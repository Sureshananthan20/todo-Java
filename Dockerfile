# -------- First Stage: Build the app --------
FROM maven:3.9.6-openjdk-18 AS builder

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# -------- Second Stage: Run the app --------
FROM eclipse-temurin:18-jdk-alpine

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
