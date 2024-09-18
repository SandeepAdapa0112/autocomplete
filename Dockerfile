FROM openjdk:17

EXPOSE 8081

ADD target/bottomline-autocomplete-feature.jar bottomline-autocomplete-feature.jar

ENTRYPOINT ["java","-jar","/bottomline-autocomplete-feature.jar"]