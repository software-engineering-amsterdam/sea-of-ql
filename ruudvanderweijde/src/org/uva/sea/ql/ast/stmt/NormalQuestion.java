package org.uva.sea.ql.ast.stmt;

import org.uva.sea.ql.ast.expr.primary.Ident;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.FormVisitor;

public class NormalQuestion extends Question {

	public NormalQuestion(Ident id, String label, Type type) {
		super(id, label, type);
	}

	@Override
	public void accept(FormVisitor visitor) {
		visitor.visit(this);		
	}

}
