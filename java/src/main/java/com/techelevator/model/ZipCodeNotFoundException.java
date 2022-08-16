package com.techelevator.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( value = HttpStatus.NOT_FOUND, reason = "That zip code didn't work, try again.")
public class ZipCodeNotFoundException extends RuntimeException {
}
