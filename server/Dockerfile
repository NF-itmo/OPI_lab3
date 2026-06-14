FROM eclipse-temurin:17-jdk-alpine AS build

COPY build.gradle params.gradle settings.gradle gradle.properties gradlew ./
COPY gradle gradle
COPY src src
COPY .gradle .gradle
RUN ./gradlew clean2 build2

FROM quay.io/wildfly/wildfly:38.0.1.Final-jdk17

# adding posgresql jdbc driver
USER root
RUN mkdir -p /opt/jboss/wildfly/modules/org/postgresql/main/
ADD https://jdbc.postgresql.org/download/postgresql-42.7.3.jar /opt/jboss/wildfly/modules/org/postgresql/main/postgresql.jar
COPY ./postgresql-module.xml /opt/jboss/wildfly/modules/org/postgresql/main/module.xml
RUN chown -R jboss:jboss /opt/jboss/wildfly/modules/org

USER jboss
COPY --chown=jboss:jboss ./standalone.xml /opt/jboss/wildfly/standalone/configuration/
COPY --from=build --chown=jboss:jboss build/libs/web3.war /opt/jboss/wildfly/standalone/deployments/web3.war

EXPOSE 8080 8080
