FROM java:8
VOLUME /tmp
ADD ace-center.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]