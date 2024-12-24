package br.com.rhssolutions.GDProjetos.service.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionsHandler {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionsHandler.class);

    @ExceptionHandler(IllegalArgumentException.class)
    public void handleIllegalArgumentException(IllegalArgumentException ex) {
        logger.error("Erro: " + ex.getMessage());
    }

    @ExceptionHandler(Throwable.class)
    public void handleException(Exception ex) {
        logger.error("Erro não esperado, verifique o log da aplicação!!!" + ex.getMessage());
    }
}
