FROM openjdk:14

ARG PROFILE
ARG ADDITIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

WORKDIR /opt/restapi-jpa-rabbitmq
COPY /build/libs/restapi-jpa-rabbitmq*.jar restapi-jpa-rabbitmq.jar

SHELL ["/bin/sh", "-c"]

EXPOSE 8080
EXPOSE 5005

CMD java ${ADDITIONAL_OPTS} -jar restapi-jpa-rabbitmq.jar --spring.profiles.active=${PROFILE}