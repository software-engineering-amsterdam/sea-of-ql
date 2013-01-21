package org.uva.sea.ql.ast.values;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.visitor.ASTNodeVisitor;

public class BoolLit extends Expr{
	private final String value;

	public BoolLit(String value) {
		this.value = value;
		

	}
	
	public String getValue() {
		return value;
	}

	@Override
	public void accept(ASTNodeVisitor nodeVisitor) {
		// TODO Auto-generated method stub
		
	}

}
