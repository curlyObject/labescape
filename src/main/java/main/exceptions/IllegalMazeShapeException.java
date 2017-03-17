package main.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IllegalMazeShapeException extends Exception{

    public IllegalMazeShapeException(String message){
        super(message);
    }

}
