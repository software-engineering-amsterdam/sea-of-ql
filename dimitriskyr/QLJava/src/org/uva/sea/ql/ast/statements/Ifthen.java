package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.visitor.IStatementVisitor;

public class IfThen extends StatementElement {

	public IfThen(Expr expression, Block ifBlock) {
		super(expression, ifBlock);
	}

	@Override
	public void accept(IStatementVisitor visitor) {
		visitor.visit(this);
	}

}
