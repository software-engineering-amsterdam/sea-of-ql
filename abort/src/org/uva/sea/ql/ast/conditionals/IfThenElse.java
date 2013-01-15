package org.uva.sea.ql.ast.conditionals;

import java.util.List;

import org.uva.sea.ql.ast.base.Expression;
import org.uva.sea.ql.ast.form.Element;

public class IfThenElse extends IfStatement {
	private Expression condition = null;
	private List<Element> successStatements = null;
	private List<Element> elseStatements = null;
	
	public IfThenElse(Expression condition, List<Element> successStatements, List<Element> elseStatements) {
		this.condition = condition;
		this.successStatements = successStatements;
		this.elseStatements = elseStatements;
	}
}
