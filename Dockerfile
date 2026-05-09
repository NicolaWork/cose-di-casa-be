FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY target/casa-0.0.1-SNAPSHOT.jar casa.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "casa.jar"]
