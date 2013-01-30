package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.values.StringLit;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.IElementVisitor;

public class Question extends SingleLineElement {

	public Question(Ident id, StringLit label, Type type) {
		super(id, label, type);
	}

	@Override
	public void accept(IElementVisitor qlElement) {
		qlElement.visit(this);
	}

}
