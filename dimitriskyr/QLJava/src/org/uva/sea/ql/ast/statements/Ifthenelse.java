package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.visitor.IStatementVisitor;

public class IfThenElse extends StatementElement {

	public IfThenElse(Expr expression, Block ifBlock, Block elseBlock) {
		super(expression, ifBlock, elseBlock);
	}

	@Override
	public void accept(IStatementVisitor visitor) {
		visitor.visit(this);
	}

}
