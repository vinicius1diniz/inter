FROM maven:3.8.5-openjdk-17 AS BUILD

COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
COPY --from=BUILD /target/SpringbootMongodbAtlas-0.0.1-SNAPSHOT.jar kitbyte.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "kitbyte.jar"]