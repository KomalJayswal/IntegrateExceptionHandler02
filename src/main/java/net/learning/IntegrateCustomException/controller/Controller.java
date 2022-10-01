package net.learning.IntegrateCustomException.controller;

import lombok.extern.slf4j.Slf4j;
import net.learning.ExceptionHandlerUtility.exceptions.CustomException;
import net.learning.IntegrateCustomException.model.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class Controller {
    @PostMapping("/test")
    public ResponseEntity<Response> testCustomexceptionHandlerUtility(@RequestHeader("id") String id) {

        if(id.equals("komal"))
            throw new CustomException(HttpStatus.BAD_REQUEST,"ERRORSS");

        Response res = Response.builder()
                .data("komal")
                .build();

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(res);
    }
}
