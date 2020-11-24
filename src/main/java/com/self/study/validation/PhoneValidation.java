package com.self.study.validation;

import com.self.study.annotation.Phone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * @author: duyubo
 * @date: 2020年11月19日, 0019 11:19
 * @description:
 */
public class PhoneValidation implements ConstraintValidator<Phone, String> {

    private String regexp;

    @Override
    public void initialize(Phone phone) {
        this.regexp = phone.regexp();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        Pattern p = Pattern.compile(regexp);
        return p.matcher(s).matches();
    }
}
