package br.com.fiap.helper;

import java.time.LocalDate;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("birthDateValidator")
public class BirthDateValidator implements Validator{

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		String stringDate = value.toString();
		LocalDate inputDate = LocalDate.parse(stringDate);
		Integer inputYear = inputDate.getYear();
		Integer currentYear = LocalDate.now().getYear();
		Integer difference = currentYear - inputYear;
		
		if(inputDate.isAfter(LocalDate.now()) || difference < 18 || difference > 120) {
			FacesMessage fmsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Date Validation failed", "Invalid Date.");
			throw new ValidatorException(fmsg);
		} 
	}
}
