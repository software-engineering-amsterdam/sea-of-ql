package org.uva.sea.ql.ast.types;
import java.util.List;

public class Form extends Expr{

	protected List<FormElement> elements;

	public Form(List<FormElement> elements) {
		this.elements = elements;
	}	
}
