# Parking System Design Challenge in Node

Assumption is that you have Java already installed. We will be using a lightweight framework called Javalin.

##  Build the project

```sh
mvn clean install
```

## Run the application

```sh
mvn exec:java
```


To test if the setup is working fine, run:

```sh
curl http://localhost:4567/test_setup
```

You should get the following response:

```json
{"status":"success"}
```

Please note that you would have to restart the server to let changes take effect. You can use code reloader if you want to avoid restarting your server.