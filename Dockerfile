FROM alpine/java:22-jre

WORKDIR /application

COPY target/*.war app.war

COPY uploads/* uploads/

ENTRYPOINT [ "java", "-jar", "app.war" ]
