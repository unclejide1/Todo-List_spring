FROM openjdk:13
WORKDIR /usr/app
COPY ./target/todo-0.0.1-SNAPSHOT.jar .
EXPOSE 8070
ENTRYPOINT ["java","-jar","todo-0.0.1-SNAPSHOT.jar"]