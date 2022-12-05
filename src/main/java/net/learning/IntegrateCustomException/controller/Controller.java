package net.learning.IntegrateCustomException.controller;

import lombok.extern.slf4j.Slf4j;
import net.learning.ExceptionHandlerUtility.exceptions.*;
import net.learning.ExceptionHandlerUtility.model.Errors;
import net.learning.IntegrateCustomException.model.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.net.BindException;
import java.util.List;

@RestController
@Slf4j
public class Controller {

    @PostMapping("/test")
    public ResponseEntity<Response> testCustomExceptionHandlerUtility(@RequestHeader("exception") String exception) throws BindException {

        if (exception.equals("AccessDeniedException")) {
            throw new AccessDeniedException();
        }else if (exception.equals("DataNotFoundException")) {
            throw new DataNotFoundException(erros("Data is not found"));
        }else if (exception.equals("ServerException")) {
            throw new ServerException(erros("Server Error Reason"));
        }else if (exception.equals("TimeOutException")) {
            throw new TimeOutException();
        }else if (exception.equals("UnAuthorizedException")) {
            throw new UnAuthorizedException();
        }else if (exception.equals("ValidationException")) {
            throw new ValidationException(erros("Validation Error"));
        }else if (exception.equals("BindException")) {
            throw new BindException();
        }
//        else if (exception.equals("MethodArgumentNotValidException")) {
//           //throw new MethodArgumentNotValidException();
//        }
        else{
            // NoHandlerFoundException
        }

        Response res = Response.builder()
                .data("Success")
                .build();

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(res);
    }

    private List<Errors> erros(String error){
        return List.of(Errors.builder().errorMessage(error).build());
    }
}
