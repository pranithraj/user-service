package com.pranith.rest.microservice.restfulwebservices.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class User {
    private int id;
    @Size(min = 2, message = "Name should have at least 2 characters")
    private String name;
    @Past (message = "Birth Date should be in the past")
    private LocalDate birthDate;
}
