# Containerize a simple Java microservice
FROM armhf/openjdk:openjdk-8-jdk

RUN apt-get update && apt-get upgrade -y
RUN apt-get install -y maven

EXPOSE 8080

WORKDIR /usr/src/myapp/

# create a cache layer with dependencies
# the pom file changes less frequently
COPY style_service/pom.xml /usr/src/myapp
RUN mvn dependency:resolve

COPY style_service /usr/src/myapp

RUN mvn compile package

CMD java -jar target/style_service-1.0.jar server
