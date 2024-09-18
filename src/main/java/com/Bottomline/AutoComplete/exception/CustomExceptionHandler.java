package com.Bottomline.AutoComplete.exception;

import com.Bottomline.AutoComplete.model.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@ControllerAdvice
public class CustomExceptionHandler {
    @Autowired
    ErrorResponse errorResponse;

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleRequestValidationException(Exception ex, HttpServletRequest request) {

        errorResponse.setTimestamp(new Date());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setError(ex.getMessage());
        errorResponse.setPath(request.getServletPath());

        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
}
