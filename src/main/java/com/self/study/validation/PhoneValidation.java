package com.self.study.validation;

import com.self.study.annotation.Phone;
import com.self.study.utils.PhoneValidationUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

/**
 * @author: duyubo
 * @date: 2020年11月19日, 0019 11:19
 * @description:
 */
public class PhoneValidation implements ConstraintValidator<Phone, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return PhoneValidationUtil.isPhone(s);
    }
}
