package com.kellytbn.msstudenttest.utils.handlers.exceptions;

import com.kellytbn.msstudenttest.utils.MessageResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataDuplicateException extends RuntimeException {

    private String description;

    public DataDuplicateException(String exception) {
        super(exception);
    }

    public DataDuplicateException(String message, Exception exception) {
        super(message, exception);
    }

    public DataDuplicateException(MessageResponse message) {
        super(message.getMessage());
        this.description = message.getDescription();
    }

}
