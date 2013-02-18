package org.uva.sea.ql.ast.stmt.question;

import org.uva.sea.ql.ast.expr.primary.Ident;
import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.visitor.IFormVisitor;

public class NormalQuestion extends Question {

	public NormalQuestion(Ident id, String label, Type type) {
		super(id, label, type);
	}

	@Override
	public void accept(IFormVisitor visitor) {
		visitor.visit(this);		
	}

}
