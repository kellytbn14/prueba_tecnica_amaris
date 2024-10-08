package com.kellytbn.msstudenttest.utils.handlers;


import com.kellytbn.msstudenttest.utils.StandardResponse;
import com.kellytbn.msstudenttest.utils.handlers.exceptions.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({BusinessException.class})
    protected ResponseEntity<StandardResponse<String>> handleBusinessException(HttpServletRequest request, BusinessException ex) {
        HttpStatus status = HttpStatus.CONFLICT;
        StandardResponse<String> response = new StandardResponse<>(ex.getMessage(), ex.getDescription());
        return new ResponseEntity<>(response, status);
    }

    @ExceptionHandler({RequiredException.class})
    protected ResponseEntity<StandardResponse<String>> handleRequiredException(HttpServletRequest request, RequiredException ex) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardResponse<String> response = new StandardResponse<>(ex.getMessage(), ex.getDescription());
        return new ResponseEntity<>(response, status);
    }

    @ExceptionHandler({RequestErrorException.class})
    protected ResponseEntity<StandardResponse<String>> handleRequestErrorException(HttpServletRequest request, RequestErrorException ex) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardResponse<String> response = new StandardResponse<>(ex.getMessage(), ex.getDescription());
        return new ResponseEntity<>(response, status);
    }

    @ExceptionHandler({DataNotFoundException.class})
    protected ResponseEntity<StandardResponse<String>> handleDataNotFoundException(HttpServletRequest request, DataNotFoundException ex) {
        HttpStatus status = HttpStatus.CONFLICT;
        StandardResponse<String> response = new StandardResponse<>(ex.getMessage(), ex.getDescription());
        return new ResponseEntity<>(response, status);
    }

    @ExceptionHandler({DataDuplicateException.class})
    protected ResponseEntity<StandardResponse<String>> handleDataDuplicateException(HttpServletRequest request, DataDuplicateException ex) {
        HttpStatus status = HttpStatus.CONFLICT;
        StandardResponse<String> response = new StandardResponse<>(ex.getMessage(), ex.getDescription());
        return new ResponseEntity<>(response, status);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    protected ResponseEntity<StandardResponse<String>> handleIllegalArgumentException(HttpServletRequest request, IllegalArgumentException ex) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardResponse<String> response = new StandardResponse<>(ex.getMessage());
        return new ResponseEntity<>(response, status);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    protected ResponseEntity<StandardResponse<String>> handleDataIntegrityViolationException(HttpServletRequest request, DataIntegrityViolationException ex) {
        HttpStatus status = HttpStatus.CONFLICT;
        StandardResponse<String> response = new StandardResponse<>(ex.getMessage(), ex.getMessage());
        return new ResponseEntity<>(response, status);
    }

    @ExceptionHandler(Throwable.class)
    protected ResponseEntity<StandardResponse<String>> handleUnhandledException(
            HttpServletRequest request, Throwable ex) {
        logger.error(request.getRequestURL().toString(), ex);
        return new ResponseEntity<>(new StandardResponse<>("Your request could not be processed. Contact the administrator.", "error"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

