FROM openjdk:11

ARG TIMEZONE="Asia/Seoul"

ARG DEBIAN_FROMTEND=noninteracive
ENV TZ=Asia/Seoul
RUN apt-get install -y tzdata
RUN cp /usr/share/zoneinfo/${TIMEZONE} /etc/localtime

RUN useradd -ms /bin/bash -u 1001 wbl

RUN mkdir -p /foodcalorie/run
RUN mkdir -p /foodcalorie/logs
COPY target/foodcalorie-0.0.1-SNAPSHOT.jar /foodcalorie/app.jar
RUN chown -R wbl:wbl /foodcalorie
USER wbl

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","-Dspring.profiles.active=prod","-Duser.timezone=Asia/Seoul","/foodcalorie/app.jar"]
