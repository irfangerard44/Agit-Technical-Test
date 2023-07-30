FROM maven:3.8.3-openjdk-17 AS build
COPY Agit/. /home/app/
RUN mvn -f /home/app/pom.xml package

# # PACKAGE STAGE
FROM openjdk:17-alpine
WORKDIR /app
RUN apk add --no-cache g++ tzdata && cp /usr/share/zoneinfo/Asia/Jakarta /etc/localtime && echo "Asia/Jakarta" > /etc/timezone && apk del g++ tzdata
COPY --from=build /home/app/target/Agit-0.0.1-SNAPSHOT.war /app/

ENTRYPOINT ["java","-jar","Agit-0.0.1-SNAPSHOT.war"]

