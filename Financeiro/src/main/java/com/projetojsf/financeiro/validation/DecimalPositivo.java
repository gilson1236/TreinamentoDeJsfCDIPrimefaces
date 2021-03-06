package com.projetojsf.financeiro.validation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@Target({ java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.ANNOTATION_TYPE, java.lang.annotation.ElementType.CONSTRUCTOR, java.lang.annotation.ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@NotNull
@DecimalMin("0")
public @interface DecimalPositivo {

	@OverridesAttribute(constraint = DecimalMin.class, name = "message")
	String message() default "{com.projetojsf.NumeroDecimal.message}";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
