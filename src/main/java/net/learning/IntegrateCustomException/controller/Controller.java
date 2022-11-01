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
