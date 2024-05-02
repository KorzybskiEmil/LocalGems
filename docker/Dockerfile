FROM eclipse-temurin:17.0.11_9-jre-jammy
WORKDIR /app
COPY ./target/LocalGems*.jar ./localgems.jar
COPY ./docker/application.yaml ./
CMD ["java", "-jar", "./localgems.jar"]