package com.example.demo.model;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Dao.DaoImpl.StaffDaoImpl;

public class UnUsedStaffCodeValidator implements ConstraintValidator<UnUsedStaffCode, String> {

	@Autowired
    StaffDaoImpl staffDaoImpl;
	
	@Override
    public void initialize(UnUsedStaffCode constraintAnnotation) {
    }
	
	@Override
	public boolean isValid(String staffCode, ConstraintValidatorContext context) {
		
		User user = staffDaoImpl.selectOne(staffCode);
		if(user!=null) {
            return false;
        }
        
        return true;
		
	}

}
