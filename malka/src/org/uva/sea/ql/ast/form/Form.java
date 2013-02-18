package org.uva.sea.ql.ast.form;
import java.util.List;

import org.uva.sea.ql.ast.ASTNode;

public class Form extends ASTNode {
	
	protected List<IFormElement> elements;
	
	public Form(List<IFormElement> elements) {
		this.elements = elements;
	}
}
