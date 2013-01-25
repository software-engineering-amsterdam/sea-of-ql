package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.ASTNodeVisitor;
import org.uva.sea.ql.ast.expressions.Expr;

public class IfThenElse extends Statement {

	private Block body;
	private Block elseBody;
	private Expr condition;

	public IfThenElse(Expr condition, Block body, Block elseBody) {
		this.body = body;
		this.elseBody = elseBody;
		this.condition = condition;
	}
	
	public void accept(ASTNodeVisitor visitor) {
		body.accept(visitor);
		if (elseBody != null)
			elseBody.accept(visitor);
		condition.accept(visitor);
        visitor.visit(this);
    }
	
}
