FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/status-service-0.0.1-SNAPSHOT.jar status-service.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "status-service.jar"]
