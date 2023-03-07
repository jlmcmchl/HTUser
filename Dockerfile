FROM gradle:8.0.2-jdk17

RUN mkdir /application
RUN mkdir /data

COPY app/build.gradle /application

WORKDIR /application

RUN gradle tasks

COPY app/src /application/src

RUN gradle build

WORKDIR /data

ENTRYPOINT ["/opt/java/openjdk/bin/java", "-cp", "/application/build/libs/application.jar", "htuser.App"]