package br.codenation.projectfinal.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class ValidationError extends RuntimeException{
    public ValidationError(String message){
        super(message);
    }
}
