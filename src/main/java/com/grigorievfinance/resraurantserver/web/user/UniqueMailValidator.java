package com.grigorievfinance.resraurantserver.web.user;

import com.grigorievfinance.resraurantserver.HasIdAndEmail;
import com.grigorievfinance.resraurantserver.repository.UserRepository;
import com.grigorievfinance.resraurantserver.web.GlobalExceptionHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

@Component
@AllArgsConstructor
public class UniqueMailValidator implements org.springframework.validation.Validator {

    private final UserRepository repository;

    @Override
    public boolean supports(Class<?> aClass) {
        return HasIdAndEmail.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        HasIdAndEmail user = (HasIdAndEmail) o;
        if (StringUtils.hasText(user.getEmail())) {
            if (repository.getByEmail(user.getEmail().toLowerCase()).
                    filter(u -> !u.getId().equals(user.getId())).isPresent()) {
                errors.rejectValue("email", "", GlobalExceptionHandler.EXCEPTION_DUPLICATE_EMAIL);
            }
        }
    }
}
