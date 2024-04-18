package com.sst.productsevicesst.exceptionhandlers;

import com.sst.productsevicesst.dtos.ExceptionDto;
import com.sst.productsevicesst.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ArithmeticException.class)
        public ResponseEntity<ExceptionDto> handleArithmeticException(){
        ExceptionDto dto = new ExceptionDto();
        dto.setMessage("Something went wrong");
        dto.setResolution("Arithmetic Resolution");
        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
        return response;
    }
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<ExceptionDto>handleArrayIndexOutOfBoundsException(){
        ExceptionDto dto = new ExceptionDto();
        dto.setMessage("Something went wrong");
        dto.setResolution("ArrayIndexOutofBound");
        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
        return response;
    }
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDto>handleProductNotFoundException(ProductNotFoundException productNotFoundException){
        ExceptionDto dto = new ExceptionDto();
        dto.setMessage("Invalid id " + productNotFoundException.getId());
        dto.setResolution("ProductNotFoundException");
        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
        return response;
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDto>handleGeneralException(){
        ExceptionDto dto = new ExceptionDto();
        dto.setMessage("Something went wrong");
        dto.setResolution("Exception");
        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
        return response;
    }

}
