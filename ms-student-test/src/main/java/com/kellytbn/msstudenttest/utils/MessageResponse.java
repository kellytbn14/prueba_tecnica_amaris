package com.kellytbn.msstudenttest.utils;

import lombok.Getter;

@Getter
public enum MessageResponse {
    MISSING_REQUIRED_FIELD("Required field is missing", "Required field is missing"),

    /*NOT_FOUND_EXCEPTION*/
    STUDENT_NOT_FOUND_EXCEPTION("STUDENT_NOT_FOUND_EXCEPTION", "Student could not be found"),
    ;

    private final String message;
    private final String description;

    MessageResponse(String message, String description) {
        this.message = message;
        this.description = description;
    }
}
