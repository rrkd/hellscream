package au.com.iglooit.hellscream.validation;

import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Nicholas Zhu
 */
public class SurnameValidator implements ConstraintValidator<Surname, String> {
    private static final Pattern VALID = Pattern.compile("[\\p{L}'\\-,.]+") ;

    public void initialize(Surname constraintAnnotation) {}

    public boolean isValid(String value, ConstraintValidatorContext context) {
        return VALID.matcher(value).matches();
    }
}