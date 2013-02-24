package org.uva.sea.ql.core.dom.statements;

import org.uva.sea.ql.core.dom.Identifier;
import org.uva.sea.ql.core.dom.Statement;
import org.uva.sea.ql.core.dom.StatementVisitor;
import org.uva.sea.ql.core.dom.types.primitive.StringLiteral;

public class Question extends Statement{

	public Identifier identifier;
	public StringLiteral text;
	
	public Question(Identifier identifier, StringLiteral text) {
		this.identifier=identifier;
		this.text=text;
	}
	
	@Override
	public void accept(StatementVisitor visitor) {
		visitor.visit(this);
	}
}
