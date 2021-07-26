package com.mtahir.dapenbi.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.mtahir.dapenbi.utilities.FileTxtUtility;

/*
This class as NIP Validator, or implement of Custom anotation class
*/
public class NipUniqueValidator implements ConstraintValidator<NipUniqueConstraint, String> {
    
    @Override
    public boolean isValid(String nip, ConstraintValidatorContext context) {
        return !(new FileTxtUtility().isNipExists(nip)); // class TxtUtility class to check the txt file is exists or not
    }    
}
