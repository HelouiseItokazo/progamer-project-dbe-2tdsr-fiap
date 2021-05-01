package br.com.fiap.helper;

import java.util.InputMismatchException;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("cpfValidator")
public class CPFValidator implements Validator{

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		
		String stringCPF = value.toString().trim();
		
		//Remover caracteres da máscara
		stringCPF = stringCPF.replace(".", "");
		stringCPF = stringCPF.replace("-", "");
		
		//Verificar se é uma sequência de números iguais e validar o tamanho
        if (stringCPF.equals("00000000000") || stringCPF.equals("11111111111") ||
        	stringCPF.equals("22222222222") || stringCPF.equals("33333333333") ||
        	stringCPF.equals("44444444444") || stringCPF.equals("55555555555") ||
        	stringCPF.equals("66666666666") || stringCPF.equals("77777777777") ||
        	stringCPF.equals("88888888888") || stringCPF.equals("99999999999") ||
            (stringCPF.length() != 11)) {
        	FacesMessage fmsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "CPF Validation failed", "Invalid CPF.");
			throw new ValidatorException(fmsg);
        }//endIf
          
        //Declarar variáveis
        char dig10, dig11;
        int sm, i, r, num, peso;

        //"try" - protege o codigo para eventuais erros de conversao de tipo (int)
   
        try {
			// Calculo do 1o. Digito Verificador
			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {
				// converte o i-esimo caractere do CPF em um numero:
				// por exemplo, transforma o caractere '0' no inteiro 0        
				// (48 eh a posicao de '0' na tabela ASCII)        
				num = (int) (stringCPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}//endFor

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48); // converte no respectivo caractere numerico

			// Calculo do 2o. Digito Verificador
			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (stringCPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}//endFor

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);

			// Verifica se os digitos calculados conferem com os digitos informados.
			if (!isValidCpf(stringCPF, dig10, dig11)) {

				FacesMessage fmsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "CPF Validation failed", "Invalid CPF.");
				throw new ValidatorException(fmsg);
				
			}//endIf
			
		//endTry		
		} catch (InputMismatchException erro) {
			FacesMessage fmsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "CPF Validation failed", "Invalid CPF.");
			throw new ValidatorException(fmsg);
		}//catch
                
               
    }//endValidate

	private boolean isValidCpf(String stringCPF, char dig10, char dig11) {
		return (dig10 == stringCPF.charAt(9)) && (dig11 == stringCPF.charAt(10));
	}//endIf
	
}//endClass


