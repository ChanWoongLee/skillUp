package com.example.prj.validator;

import com.example.prj.annotation.Birthday;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
// 유효성 2가지로 검사할 수 있다.
// AssertTrue나
// 따라서 ConstraintValidator를 상속받아서 유효성을 체크할수 있다.
public class BirthdayValidator implements ConstraintValidator<Birthday,String> {

    private String pattern;

    @Override
    public void initialize(Birthday constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            LocalDate localDate = LocalDate.parse(value, DateTimeFormatter.ofPattern("yyyyyMMDD"));
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
