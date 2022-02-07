FROM pawanprjl/hashgen:1.0
VOLUME /tmp
EXPOSE 8080

#RUN sed -i'' 's/archive\.ubuntu\.com/us\.archive\.ubuntu\.com/' /etc/apt/sources.list

#RUN apt update -y && apt upgrade -y
#
#RUN apt install default-jre -y --fix-missing
#RUN apt install wget -y
#
## install google chrome
#COPY browser/* browser/
#RUN apt install ./browser/google-chrome-*.deb -y --fix-missing
#
#RUN google-chrome --version

COPY build/libs/*.jar app.jar
COPY data/output.json data/output.json
COPY driver/* driver/

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]