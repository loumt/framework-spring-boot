package com.boot.exception;

import com.boot.base.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.xml.ws.Service;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
@Slf4j
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 3398269585574684157L;

    public ServiceException(String message) {
        super(message);
        log.error(message);
    }

    public ServiceException(String message, Throwable throwable) {
        super(message, throwable);
        log.error(message + " :Throwable[" + throwable.getMessage() + "]");
    }
}
