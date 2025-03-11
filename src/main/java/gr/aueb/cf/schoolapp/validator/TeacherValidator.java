package gr.aueb.cf.schoolapp.validator;

import gr.aueb.cf.schoolapp.dto.BaseDTO;

import java.util.HashMap;
import java.util.Map;

public class TeacherValidator<T> {

    private TeacherValidator() {}

    public static <T extends BaseDTO> Map<String, String> validate(T dto) {
        Map<String, String> errors = new HashMap<>();
        if (dto.getFirstname().length() < 2 || dto.getFirstname().length() > 32) {
            errors.put("firstname", "Firstname must be between 2 and 32 characters.");
        }

        if (dto.getLastname().length() < 2 || dto.getLastname().length() > 32) {
            errors.put("lastname", "Lastname must be between 2 and 32 characters.");
        }

        // for all form fields, we need validation for length

        if (dto.getFirstname().matches("^.*\\s+.*$")) {
            errors.put("firstname", "Firstname must not include spaces");
        }

        if (dto.getLastname().matches("^.*\\s+.*$")) {
            errors.put("lastname", "Lastname must not include spaces");
        }

        // for all form fields, we need validation for whitespaces
        return errors;
    }
}
