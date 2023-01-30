FROM adoptopenjdk/openjdk11:alpine

RUN addgroup -S spring && adduser -S spring -G spring

USER spring:spring

ADD target/grpc-server-1.0-jar-with-dependencies.jar /app/app.jar

EXPOSE 7565

ENTRYPOINT ["java","-jar","/app/app.jar"]
