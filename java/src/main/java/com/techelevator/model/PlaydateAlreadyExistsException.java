package com.techelevator.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Playdate Already Exists.")
public class PlaydateAlreadyExistsException extends RuntimeException{
}
