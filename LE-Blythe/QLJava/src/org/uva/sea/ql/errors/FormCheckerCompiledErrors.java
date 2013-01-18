package org.uva.sea.ql.errors;

import java.util.List;

public class FormCheckerCompiledErrors extends FormCheckerError{
	
	private static final long serialVersionUID = 6L;
	
	private List<FormCheckerError> errors;
	
	public FormCheckerCompiledErrors(List<FormCheckerError> errors){
		super();
		
		this.errors = errors;
	}
	
	
	@Override
	public String getMessage() {
		String result = "";
		
		for(FormCheckerError e: errors){
			result += String.format("%s", e.getMessage());
		}
	
		return result;
	}
	
	
	public List<FormCheckerError> getErrors(){
		return errors;
	}
}
