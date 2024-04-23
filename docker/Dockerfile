FROM eclipse-temurin:17.0.10_7-jre-jammy
WORKDIR /app
COPY ./target/LocalGems*.jar ./lg.jar
CMD ["java", "-jar", "./lg.jar"]