package org.uva.sea.ql.ast.values;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.visitor.ASTNodeVisitor;

public class StringLit extends Expr  {
    private final String value;
	
	public StringLit(String value) {
		this.value=value;
		
	}

	@Override
	public void accept(ASTNodeVisitor nodeVisitor) {
		// TODO Auto-generated method stub
		
	}

}
