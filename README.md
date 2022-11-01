# Integrate Custom Exception

The service is used to test the [Exception-Handler-Utlity](https://github.com/KomalJayswal/Exception-Handler-Utlity) .

## Getting Started With Solution

1. Please install Java 11, maven and postman in your system.
2. Create a springboot project using https://start.spring.io. <br>
* Select `Maven Project`
* Add Dependency : `lombok and spring-web`
* Group : `net.learning`
* Artifact : `IntegrateCustomException`

3. Clone the [Exception-Handler-Utlity](https://github.com/KomalJayswal/Exception-Handler-Utlity) in the local system.

4. Checkout to the version/1.0.0 .
5. Now, execute `mvn clean install` command to create the JAR
6. Once, build is done, you can now see the repository JAR is created in your .m2 folder
7. Now, resume on `IntegrateCustomException` repository and Add this dependency in the POM.
```bash
<dependency>
    <groupId>net.learning</groupId>
    <artifactId>ExceptionHandlerUtility</artifactId>
    <version>1.0.0</version>
 </dependency>
```
This will import the `ExceptionHandlerUtility maven jar dependency` in your applications
8. Create a controller package. Then, under it create a `Controller` class.
```java
package net.learning.IntegrateCustomException.controller;

import lombok.extern.slf4j.Slf4j;
import net.learning.IntegrateCustomException.model.Response;
import net.learning.ExceptionHandlerUtility.exceptions.CustomException;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class Controller {
    @PostMapping("/test")
    public ResponseEntity<Response> testCustomexceptionHandlerUtility(@RequestHeader("id") String id) {

        if (id.equals("fail")) {
            throw new CustomException(HttpStatus.BAD_REQUEST,"ERRORSS");
        }
        Response res = Response.builder()
                .data(id)
                .build();

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(res);
    }
}
```
9. Create a model package. Then, under it create a `Response` class.
```java
package net.learning.IntegrateCustomException.model;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {

    private String data;
}
```
10. Run the application in your IDE.
11. Open Postman. Import the below curl commands and hit the end point. <br>

<b><u> Error Use Case </u></b>
```java
curl --location --request POST 'http://localhost:8080/test' \
--header 'Cache-Control: no-cache' \
--header 'Content-Type: application/json' \
--header 'Postman-Token: e3a65198-8509-48e9-9b70-ca8cda14923f' \
--header 'id: fail' \
--data-raw ''
```
Response :
```java
{
    "method": "POST",
    "requestUri": "/test",
    "statusCode": "BAD_REQUEST",
    "timestamp": "2022-11-01T19:01:01",
    "errors": [
        {
            "errorMessage": "customized error"
        }
    ]
}
```

<b><u> Success Use Case </u></b>

```java
curl --location --request POST 'http://localhost:8080/test' \
--header 'Cache-Control: no-cache' \
--header 'Content-Type: application/json' \
--header 'Postman-Token: e3a65198-8509-48e9-9b70-ca8cda14923f' \
--header 'id: success' \
--data-raw ''
```
Response :
```java
{
    "data": "success"
}
```

**Congratulation! You have successfully Integrated Exception Handler JAR of version/1.0.0 .** 
