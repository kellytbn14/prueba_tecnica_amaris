package com.kellytbn.msstudenttest.utils;


import com.kellytbn.msstudenttest.utils.handlers.exceptions.RequiredException;

import java.util.Objects;

public class CustomUtils {

    public static void ValidateRequired(Object object) {
        if (Objects.isNull(object)) {
            throw new RequiredException(MessageResponse.MISSING_REQUIRED_FIELD);
        }
    }

    public static void ValidateBooleanRequired(Object object) {
        if (!(object instanceof Boolean)) {
            throw new RequiredException(MessageResponse.MISSING_REQUIRED_FIELD);
        }
    }
}
