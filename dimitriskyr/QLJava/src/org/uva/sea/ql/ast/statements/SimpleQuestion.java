package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.values.Ident;
import org.uva.sea.ql.ast.values.String_lit;
import org.uva.sea.ql.visitor.IStatementVisitor;

public class SimpleQuestion extends QuestionElement {

	public SimpleQuestion(Ident ident, String_lit string, Type bool) {
		super(ident, string, bool);
	}

	@Override
	public void accept(IStatementVisitor visitor) {
		visitor.visit(this);
	}

}
