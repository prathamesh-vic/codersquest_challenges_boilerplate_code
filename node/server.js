const express = require('express');
const app = express();
const port = 4567;

// Middleware to parse JSON body
app.use(express.json());

// Code below is for testing the setup of the server, do not modify or else the first test
// might fail.
app.get('/test_setup', (req, res) => {
  res.json({ status: "success" });
});

// Example POST endpoint
// curl --location --request POST 'localhost:4567/example_post_endpoint/12?foo=bar' --header 'Content-Type: application/json' --data-raw '{ "message": "Hello World!" }'
// below is an example of how to define a POST endpoint and read path params (id), query params (foo) and request body
app.post('/example_post_endpoint/:id', (req, res) => {
  // path params can be read like this
  const id = req.params.id;
  // query params can be read like this
  const foo = req.query.foo;
  // request body can be read like this
  const req_body = req.body;

  res.json({ status: "success", id, foo, req_body });
});

// define routes below as needed for submitting test.

// Start the server
app.listen(port, () => {
  console.log(`Server is running on http://localhost:${port}`);
});
