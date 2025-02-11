# Parking System Design Challenge in Node

Assumption is that you have Node.js already installed.

## Spinning up the server

Here we have used Express.js for creating a lightweight web application. Refer to https://expressjs.com/ for installation and documentation.

Run the following command to install dependencies:

```sh
npm install
```

To start the server, run:

```sh
node server.js
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