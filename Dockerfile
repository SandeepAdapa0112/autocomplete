FROM openjdk:17

EXPOSE 8081

ADD target/bottomline-autocomplete-project.jar bottomline-autocomplete-project.jar

ENTRYPOINT ["java","-jar","/bottomline-autocomplete-project.jar"]