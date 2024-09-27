FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/catalogo-veiculos-service-0.0.1-SNAPSHOT.jar catalogo-veiculos-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "catalogo-veiculos-service.jar"]
