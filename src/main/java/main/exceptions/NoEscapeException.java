package main.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class NoEscapeException extends Exception {

    public NoEscapeException(){
        super("No route out of the maze!");
    }
}
