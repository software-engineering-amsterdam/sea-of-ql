package org.uva.sea.ql.ast.expr;

import java.util.Map;

import org.uva.sea.ql.ast.types.Numeric;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.ASTNodeVisitor;


public class And extends Expr {

	public And(Expr result, Expr rhs) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accept(ASTNodeVisitor nodeVisitor) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Type isOfType(Map<Ident, Type> typeEnv) {
		return new Numeric();
	}

}
