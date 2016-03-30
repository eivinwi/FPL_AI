package rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by eivwik on 30.03.16.
 */
@EnableWebMvc
@ControllerAdvice
public class ErrorController {


    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    @ResponseBody
    public String errorPage(Exception e) {
        return "Something bad happened: " + e.getCause();
    }

}
