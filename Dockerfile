FROM maven:3.9.6-amazoncorretto-17 as builder

WORKDIR /app
COPY ./pom.xml /app

COPY ./src /app/src
RUN mvn clean package -DskipTests

FROM amazoncorretto:17-alpine-jdk
WORKDIR /app

RUN mkdir ./logs
COPY --from=builder /app/target/backend-template-api-*.jar ./app.jar
EXPOSE 8001

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]