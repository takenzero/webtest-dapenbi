package com.mtahir.dapenbi.utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.mtahir.dapenbi.dto.SimRegistrationDto;

/*
This class is used to validate data and parse every error validation message to an array list
*/
public class ValidationUtility {
    
    // validation process
    public List<String> doValidate(SimRegistrationDto simRegistrationDto) {
        Validator validator;
        List<String> errors = new ArrayList<>();

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        Set<ConstraintViolation<SimRegistrationDto>> cvs = validator.validate(simRegistrationDto);

        // check if the data has error message or not
        if (!cvs.isEmpty()) {
            for (ConstraintViolation<SimRegistrationDto> cv : cvs) {
                errors.add(cv.getMessage()); // add every error message to list
            } 
        }

        return errors; //return error message
    }
}
