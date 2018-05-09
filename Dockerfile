FROM maven:3.5.3-jdk-10 as package

ARG SEMIVE_DIRECTORY=semive-backend

WORKDIR /${SEMIVE_DIRECTORY}/
COPY . /${SEMIVE_DIRECTORY}/

RUN mvn clean package

FROM openjdk:10.0.1 as API
LABEL description="Image for run Semive Backend API" version="1.0.0" maintainer="Matheus Castiglioni<matheushcastiglioni@gmail.com"

ARG SEMIVE_DIRECTORY=semive-backend

WORKDIR /${SEMIVE_DIRECTORY}/
COPY --from=package /${SEMIVE_DIRECTORY}/target/*.jar /${SEMIVE_DIRECTORY}/semive-backend.jar
COPY ./docker-entrypoint.sh /${SEMIVE_DIRECTORY}/

EXPOSE 9090

ENV SEMIVE_CORS=*
ENV SEMIVE_PORT=9090
ENV SEMIVE_CONTEXT_API=/semive/api
ENV SEMIVE_DATABASE_PASSWORD=root
ENV SEMIVE_DATABASE_URL=127.0.0.1
ENV SEMIVE_DATABASE_PORT=3306
ENV SEMIVE_DATABASE_NAME=semive
ENV SEMIVE_DATABASE_USERNAME=root
ENV SEMIVE_INIT_DB=true

ENTRYPOINT [ "./docker-entrypoint.sh", "semive-backend" ]