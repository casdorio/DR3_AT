FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/*.jar status-service.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "status-service.jar"]
