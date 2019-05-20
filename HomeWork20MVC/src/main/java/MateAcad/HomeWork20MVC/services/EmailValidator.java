package MateAcad.HomeWork20MVC.services;

import MateAcad.HomeWork20MVC.entities.Programmer;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.util.regex.Pattern;

@Service
public class EmailValidator implements Validator {

    private static final String emailPattern = "^\\w+([.\\w]+)*\\w@\\w((.\\w)*\\w+)*\\.\\D{2,3}$";

    @Override
    public boolean supports(Class<?> aClass) {
        return Programmer.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Programmer programmer = (Programmer) o;
        Pattern pattern = Pattern.compile(emailPattern);
        if (!pattern.matcher(programmer.getEmail()).matches()) {
            errors.rejectValue("E-mail", "Incorrect email format");
        }
        if (programmer.getBirthDay().isAfter(LocalDate.now())
                || programmer.getBirthDay().isBefore(LocalDate.now().minusYears(100))) {
            errors.rejectValue("BirthDay", "Incorrect day of birth");
        }
    }
}
