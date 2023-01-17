package com.pranith.rest.microservice.restfulwebservices.service.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter @AllArgsConstructor
public class ErrorDetails {
    LocalDateTime localDateTime;
    String message;
    String description;
}
