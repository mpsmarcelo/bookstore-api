FROM openjdk:11
ARG JAR_FILE = target/*.jar
COPY ${JAR_FILE} bookstore.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","/bookstore.jar"]