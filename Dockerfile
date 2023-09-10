FROM openjdk:17-oracle
LABEL authors="nikola"

COPY ./build/libs/*-SNAPSHOT.jar /etc/app.jar

RUN java -jar /etc/app.jar

EXPOSE 8080/tcp