package com.example.demo.model;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Dao.DaoImpl.StaffDaoImpl;

public class NotTrueFalseValidator implements ConstraintValidator<NotTrueFalse, String>  {
	
	@Autowired
    StaffDaoImpl staffDaoImpl;
	
	@Override
    public void initialize(NotTrueFalse constraintAnnotation) {
    }
	
	@Override
	public boolean isValid(String newGladFlgValue, ConstraintValidatorContext context) {
		
		User user = staffDaoImpl.findNewGladFlg(newGladFlgValue);
		if(user!=null) {
            return false;
        }
        
        return true;
		
	}

}
