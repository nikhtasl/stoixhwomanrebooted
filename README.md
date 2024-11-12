# Stoixhwoman Rebooted

A Spring Boot application for managing football games and odds.

## Requirements

- **Java 17**
- **Maven**
- **Docker**

## Project Setup

### Build the Application

1. First, clone the repository if you haven’t already:
   ```bash
   git clone https://github.com/nikhtasl/stoixhwomanrebooted
   cd <your-project-folder>

    Use Maven to build the project and create a JAR file. Run:

    mvn clean package

    This command will generate a JAR file in the target directory (e.g., stoixhwomanrebooted-0.0.1-SNAPSHOT.jar).

Build the Docker Image

    Ensure Docker Desktop is running.

    Build the Docker image using the following command:

    docker build -t stoixhwomanrebooted .

        The -t flag tags the image with the specified name (stoixhwomanrebooted).

Run the Docker Container

    Start a container from the Docker image:

    docker run -p 8080:8080 stoixhwomanrebooted

        The -p flag maps port 8080 on your local machine to port 8080 in the container, where the application will be running.

    You can now access the application at http://localhost:8080.

Additional Docker Commands

    Stop the Docker container: To stop the running container, first get the container ID by running:

docker ps

Then, stop the container using:

docker stop <container-id>

Remove the Docker container:

docker rm <container-id>

Remove the Docker image:

    docker rmi stoixhwomanrebooted

Troubleshooting

    Ensure Docker Desktop is running before building or running containers.
    If you encounter a file not found error during the Docker build, verify that the JAR file is correctly named in the Dockerfile.
    Ensure WSL 2 is enabled if you’re running Docker Desktop on Windows.

Swagger UI available on: http://localhost:8080/swagger-ui/index.html