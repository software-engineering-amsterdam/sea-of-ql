package org.uva.sea.ql.ast.conditionals;

import java.util.List;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.form.Element;

public class IfThen extends IfStatement {
	private Expression statement = null;
	private List<Element> successStatements = null;
	
	public IfThen(Expression statement, List<Element> successStatements) {
		this.statement = statement;
		this.successStatements = successStatements;		
	}
}
