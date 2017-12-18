package ua.com.hav.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by sunny on 18.12.17
 */
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        String login = user.getLogin();
        if (login == null || login.equals("")) {
            errors.rejectValue("login", "user.login.empty", "login must not be empty");
        } else if (login.length() < 3 || login.length() > 10) {
            errors.rejectValue("login", "user.login.size", "login's size must be from 3 to 10");
        } else if (!login.toLowerCase().matches("^[a-z]{1}.+")) {
            errors.rejectValue("login", "user.login.starts", "login must start with a letter");
        } else if (login.indexOf(' ') >= 0) {
            errors.rejectValue("login", "user.login.space", "login must be a single word");
        }
        String password = user.getPassword();
        if (password == null || password.equals("")) {
            errors.rejectValue("password", "user.password.empty", "password must not be empty");
        } else if (password.length() < 3 || password.length() > 10) {
            errors.rejectValue("password", "user.password.size", "password's size must be from 3 to 10");
        } else if (password.indexOf(' ') >= 0) {
            errors.rejectValue("password", "user.password.space", "password must be a single word");
        }
        String name = user.getName();
        if (name == null || name.equals("")) {
            errors.rejectValue("name", "user.name.empty", "name must not be empty");
        } else if (name.length() < 3 || name.length() > 10) {
            errors.rejectValue("name", "user.name.size", "name's size must be from 3 to 10");
        } else if (!name.toLowerCase().matches("^[a-z]{1}.+")) {
            errors.rejectValue("name", "user.name.starts", "name must start with a letter");
        }
    }
}
