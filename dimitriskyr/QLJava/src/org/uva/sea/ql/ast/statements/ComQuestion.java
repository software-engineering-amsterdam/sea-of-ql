package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.values.Ident;
import org.uva.sea.ql.ast.values.String_lit;
import org.uva.sea.ql.ast.visitor.IStatementVisitor;

public class ComQuestion extends QuestionElement {

	public ComQuestion(Ident ident, String_lit string, Type bool,
			Expr expression) {
		super(ident, string, bool, expression);
	}

	@Override
	public void accept(IStatementVisitor visitor) {
		visitor.visit(this);
	}

}
