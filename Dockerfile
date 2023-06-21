FROM eclipse-temurin:11
COPY ./application/app-service/build/libs/price-validator.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]