FROM openjdk:8-jre

COPY Mathilda-1.0.jar myapp.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/.urandom","-jar","/myapp.jar"]
