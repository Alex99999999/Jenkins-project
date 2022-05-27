package com.cool.application.validator;

import com.cool.application.exception.user.IllegalAgeException;
import com.cool.application.exception.user.IllegalNameException;
import com.cool.application.notifications.warnings.UserWarnings;

public class Validator {

    public static void validateStringNotNullNotEmpty(String field) {
        if (field == null || field.isEmpty()) {
            throw new IllegalNameException(UserWarnings.NAME_IS_NULL_OR_EMPTY);
        }
    }

    public static void validateNumberGreaterThanZero(int param) {
        if (param < 0) {
            throw new IllegalAgeException(UserWarnings.AGE_MUST_BE_ZERO_OR_GREATER);
        }
    }

    public static boolean isEmptyOrNullString(String field) {
        return field == null || field.isEmpty();
    }

}