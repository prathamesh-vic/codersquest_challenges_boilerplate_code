package com.example;

import io.javalin.Javalin;
import io.javalin.http.Context;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.requestLogger.http((ctx, ms) -> {
                System.out.printf(
                    "Request: %s %s - Response: %d (%.2fms)%n", 
                    ctx.method(), 
                    ctx.path(), 
                    ctx.status().getCode(),
                    ms
                );
            });
        });

        // Code below is for testing the setup of the server, do not modify or else the first test
        // might fail.
        app.get("/test_setup", ctx -> {
          ctx.json(Map.of("status", "success"));
        });

        // Example POST endpoint
        // curl --location --request POST 'localhost:4567/example_post_endpoint/12?foo=bar' --header 'Content-Type: application/json' --data-raw '{ "message": "Hello World!" }'
        // below is an example of how to define a POST endpoint and read path params (id), query params (foo) and request body
        app.post("/example_post_endpoint/{id}", ctx -> {
            // Get path parameter
            String id = ctx.pathParam("id");
            
            // Get query parameter
            String foo = ctx.queryParam("foo");
            
            // Get request body
            RequestBody body = ctx.bodyAsClass(RequestBody.class);
            
            // Create response
            Map<String, Object> response = Map.of(
                "id", id,
                "queryParam", foo,
                "receivedMessage", body.getMessage()
            );
            
            ctx.json(response);
        });

        // Additional detail on how to use Javalin can be found here https://javalin.io/documentation

        // define routes below as needed for submitting test.

        // Start the server
        app.start(4567);
    }
    
    // Request body class
    private static class RequestBody {
        private String message;
        
        public String getMessage() {
            return message;
        }
        
        public void setMessage(String message) {
            this.message = message;
        }
    }
}
