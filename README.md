# Multi Path REST API Project

This project demonstrates a simple REST API with multiple endpoints, including paths for `/hello/*` and `/users/*`, using Java, Servlets, and Jetty.

## Project Setup

This project uses the **Jetty Maven Plugin** for running the application and **Maven** for building the project. It includes two servlets:

1. **HelloWorldServlet**: Handles requests at `/hello/*`
2. **UserServlet**: Handles requests at `/users/*`

## Requirements

- Java 8 or higher
- Maven 3.x or higher

==If these are not already installed on your system, follow the steps below to install them:==

### Install Java 8 or Higher

1. Update the package list and install OpenJDK 8 (or later):

   ```bash
   sudo apt update
   sudo apt install openjdk-8-jdk
   ```

2. Verify the installation by checking the Java version:

   ```bash
   java -version
   ```

   You should see something like:

   ```bash
   openjdk version "1.8.0_xxx"
   ```

   If you need a newer version (e.g., OpenJDK 11 or 17), replace `openjdk-8-jdk` with `openjdk-11-jdk` or `openjdk-17-jdk` in the command above.

### Install Maven 3.x or Higher

1. Update the package list and install Maven:

   ```bash
   sudo apt update
   sudo apt install maven
   ```

2. Verify the installation by checking the Maven version:

   ```bash
   mvn -version
   ```

   You should see output similar to:

   ```bash
   Apache Maven 3.x.x (or higher)
   Maven home: /usr/share/maven
   Java version: 1.8.x
   ```

Once you have both Java and Maven installed, you are ready to build and run the project.

---

## Project Structure

- **src/main/java**: Contains the Java source files (servlets).
- **src/main/webapp**: Contains the web resources (e.g., `web.xml` configuration).
- **pom.xml**: Maven build file.

## How to Build and Run the Project

### Step 1: Build the Project

To build the project, run the following command:

```bash
mvn clean package
```

This will clean any previous build artifacts, compile the Java files, package the web application into a `.war` file, and prepare the project for running.

### Step 2: Start the Server

To start the Jetty server and run the application, execute the following Maven command:

```bash
mvn jetty:run
```

This will start the Jetty server, and the application will be accessible at `http://0.0.0.0:1234/`.

>[!Note:]
To run the Jetty server in the background (and keep it running even after you close the terminal), you can use the following methods:

```bash
nohup mvn jetty:run &> output.log &
```

- `nohup`: Ensures that the process keeps running after you close the terminal.
- `mvn jetty:run`: Starts the Jetty server.
- `&> output.log`: Redirects all the output (including errors) to a file named `output.log`.
- `&`: Runs the process in the background.

Once it's running, you can check the logs by:

```bash
tail -f output.log
```

To stop the server, you can simply find the process and kill it using `ps` and `kill`, or by terminating the `nohup` process from the terminal:

```bash
ps aux | grep jetty
kill <process_id>
```

This is the easiest way to run the server in the background without additional setup.

---

### Step 3: Test the REST API

You can test the REST API using `curl` commands.

#### Example 1: Test `/hello/*` endpoint

To test the `HelloWorldServlet` endpoint:

```bash
curl http://localhost:1234/hello/j
```

This should return a response from the `HelloWorldServlet`.

#### Example 2: Test `/users/*` endpoint

To test the `UserServlet` endpoint:

```bash
curl http://localhost:1234/users/1
```

This should return a response from the `UserServlet` for user ID `1`.

### Expected Output

1. **`curl http://localhost:1234/hello/`**: This will respond with a greeting message like:

   ```json
   {
       "message": "Hello, World!"
   }
   ```

2. **`curl http://localhost:1234/users/`**: This will respond with user information for user ID `1` (e.g., mock data).

   ```json
   {"users": ["user1", "user2", "user3"]}
   ```

## Troubleshooting
==NOTE==
- **503 Service Unavailable**: This error typically occurs if the server is not running or if there is a configuration issue. Ensure the Jetty server is started correctly and is listening on the specified port (`1234`).
- **Port Conflict**: If port `1234` is already in use, modify the `pom.xml` file to use a different port under the `<httpConnector>` configuration in the `jetty-maven-plugin` section.