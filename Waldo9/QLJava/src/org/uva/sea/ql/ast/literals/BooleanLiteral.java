package org.uva.sea.ql.ast.literals;

import org.uva.sea.ql.ast.ASTNodeVisitor;
import org.uva.sea.ql.ast.expressions.Expr;

public class BooleanLiteral extends Expr {
	
	private boolean value;
	
	public BooleanLiteral(String value) {
		if (value.equals("true"))
			this.value = true;
		else
			this.value = false;
	}
	
	public boolean getValue() {
		return value;
	}

	public void accept(ASTNodeVisitor visitor) {
        visitor.visit(this);
    }

}
