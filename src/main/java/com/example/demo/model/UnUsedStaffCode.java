package com.example.demo.model;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = {UnUsedStaffCodeValidator.class})
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
/* カスタム＠UnUsedStaffCodeに関するメソッド */

public @interface UnUsedStaffCode {
	
	 String message() default "このメールアドレスは既に登録されています";
	    Class<?>[] groups() default {};
	    Class<? extends Payload>[] payload() default {};
	    
	    @Target(ElementType.FIELD)
	    @Retention(RetentionPolicy.RUNTIME)
	    @Documented
	    public @interface List {
	        UnUsedStaffCode[] value();
	    }

}
