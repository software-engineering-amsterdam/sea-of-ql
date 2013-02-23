package org.uva.sea.ql.core.dom.statements;

import org.uva.sea.ql.core.dom.Statement;
import org.uva.sea.ql.core.dom.StatementVisitor;
import org.uva.sea.ql.core.dom.Variable;
import org.uva.sea.ql.core.dom.types.primitive.StringLiteral;

public class Question extends Statement{

	public Variable variable;
	public StringLiteral text;
	
	public Question(Variable variable, StringLiteral text) {
		this.variable=variable;
		this.text=text;
	}
	
	@Override
	public void accept(StatementVisitor visitor) {
		visitor.visit(this);
	}
}
