FROM eclipse-temurin:17-jre-noble

RUN apt update && apt install -y netcat
RUN mkdir -p /usr/local/tomcat/webapps
RUN rm -rf /usr/local/tomcat/webapps/*
COPY target/shayan-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

COPY wait-for-it.sh /usr/local/bin/
COPY entrypoint.sh /usr/local/bin/
RUN chmod +x /usr/local/bin/wait-for-it.sh /usr/local/bin/entrypoint.sh

RUN mkdir -p /app/config
EXPOSE 8080
ENTRYPOINT ["/usr/local/bin/entrypoint.sh"]