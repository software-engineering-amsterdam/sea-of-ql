package org.uva.sea.ql.parser.typechecking;

import java.util.ArrayList;
import java.util.List;

public class FormError {
	private List<String> exprErrors;
	private String formElementName;
	
	public FormError(String formElementName, List<String> exprErrors) {
		this.formElementName = formElementName; 
		this.exprErrors = new ArrayList<>(exprErrors);
	}
	
	
	
}
