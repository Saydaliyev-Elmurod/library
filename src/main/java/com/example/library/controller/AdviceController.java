package com.example.library.controller;

import com.example.library.exp.AppBadRequestException;
import com.example.library.exp.NotValidException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdviceController {
    @ExceptionHandler({NotValidException.class, AppBadRequestException.class})
    public ResponseEntity<?> handlerException(RuntimeException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
