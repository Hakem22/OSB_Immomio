package com.example.OSB.advices;

import com.example.OSB.exceptions.CatalogNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CatalogNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(CatalogNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String catalogNotFoundHandler(CatalogNotFoundException ex) {
        return ex.getMessage();
    }
}
