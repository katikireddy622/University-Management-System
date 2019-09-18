FROM java:8-jdk-alpine

COPY ./target/dms-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch dms-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","dms-0.0.1-SNAPSHOT.jar"]

EXPOSE 9999