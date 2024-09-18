# AutoComplete Project

This is a Spring Boot project which provides Autocomplete feature based on list of words provided.It is a maven project and uses JDK 17 and H2 in-memory database for storing the list of words. Trie datastructure has been used to implement the auto complete feature.

## Setup

Building this project requires maven, JDK 17 and Docker for running the docker image.
Dockerfile has been created which helps to build the docker image. You can build the docker image locally and run the container instance. Also the Docker image has been pushed to Docker hub.

Default port and URL for running the project in local machine using postman:

Default port:8081

URL: http://localhost:8081/getAllEmployees?searchName=Jose

Default port and URL for running docker image:

Default port:9090

URL: http://localhost:9090/getAllEmployees?searchName=Jose

You can provide your own word for searching in the searchName variable.

URL for checking the inserted data in H2 console:
http://localhost:8081/h2-console