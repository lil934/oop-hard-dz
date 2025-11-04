package ru.oop.dz.itf;

import java.util.List;

public interface Validatable {
    List<String> validate();

    default boolean validateAndThrow() {
        List<String> errors = validate();
        if (errors.isEmpty())
            return true;
        for (String error : errors) {
            System.out.println(error);
        }
        throw new IllegalArgumentException("Validation field: " + String.join(";", errors));
    }
}