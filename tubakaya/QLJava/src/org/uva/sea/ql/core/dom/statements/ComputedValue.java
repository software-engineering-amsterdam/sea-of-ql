package org.uva.sea.ql.core.dom.statements;

import org.uva.sea.ql.core.dom.Expression;
import org.uva.sea.ql.core.dom.Identifier;
import org.uva.sea.ql.core.dom.Statement;
import org.uva.sea.ql.core.dom.StatementVisitor;
import org.uva.sea.ql.core.dom.types.primitive.StringLiteral;

public class ComputedValue extends Statement{

	public Identifier name;
	public StringLiteral text;
	public Expression expression;
	
	public ComputedValue(Identifier name,StringLiteral text, Expression expression) {
		this.name=name;
		this.text=text;
		this.expression=expression;
	}
	
	@Override
	public void accept(StatementVisitor visitor) {
		visitor.visit(this);
	}
}
