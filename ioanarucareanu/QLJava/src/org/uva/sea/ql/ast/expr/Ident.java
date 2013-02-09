package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.semanticchecker.ExpressionSemanticVisitor;

public class Ident extends Expr {

	private final String name;

	public Ident(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public Type accept(ExpressionSemanticVisitor visitor) {
		
		return visitor.visit(this);
	}

}
