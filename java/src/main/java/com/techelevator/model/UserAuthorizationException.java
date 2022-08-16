package com.techelevator.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( value = HttpStatus.NOT_FOUND, reason = "You do not have the credentials to perform this task.")
public class UserAuthorizationException extends RuntimeException {

}