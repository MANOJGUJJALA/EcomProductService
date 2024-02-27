package com.example.EcomProductService.controller.controllerAdvice;


import com.example.EcomProductService.Exception.ProductNotFoundexception;
import com.example.EcomProductService.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(value = ProductNotFoundexception.class)
    public ResponseEntity<ErrorResponseDto> productNotFoundException(Exception e){

        ErrorResponseDto errorResponseDto=new ErrorResponseDto();
        errorResponseDto.setCode("404");
        errorResponseDto.setMessage(e.getMessage());

        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);

    }


}
