FROM amazoncorretto:17-alpine-jdk

WORKDIR /app
COPY ./pom.xml /app

ENV MVNW=/app/mvnw
COPY ./.mvn /app/.mvn
COPY ./mvnw /app/mvnw
COPY ./src /app/src

RUN cd /app
RUN $MVNW dependency:go-offline
RUN $MVNW clean package -DskipTests

RUN mkdir ./logs
COPY /*/backend-template-api-*.jar /app.jar
EXPOSE 9006

RUN rm -R /app

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
