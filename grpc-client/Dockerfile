FROM adoptopenjdk/openjdk11:alpine

RUN addgroup -S spring && adduser -S spring -G spring

USER spring:spring

ADD target/grpc-client-1.0-jar-with-dependencies.jar /app/app.jar

ENTRYPOINT ["java","-jar","/app/app.jar"]
