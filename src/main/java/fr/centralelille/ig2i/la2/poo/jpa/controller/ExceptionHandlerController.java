package fr.centralelille.ig2i.la2.poo.jpa.controller;

import fr.centralelille.ig2i.la2.poo.jpa.domain.exceptions.BusinessException;
import fr.centralelille.ig2i.la2.poo.jpa.domain.exceptions.ErrorMessage;
import fr.centralelille.ig2i.la2.poo.jpa.domain.exceptions.NotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Log4j2
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> handleNotFoundException(NotFoundException e) {
        log.error(e.getClass().getName() + " thrown");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getErrorMessage());
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> handleBusinessException(BusinessException e) {
        log.error(e.getClass().getName() + " thrown");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getErrorMessage());
    }

}