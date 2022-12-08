package ru.hogwarts.school.reception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudentNotFoundReception extends RuntimeException {
    public StudentNotFoundReception() {
    }
}
