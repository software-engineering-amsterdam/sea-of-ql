package org.uva.sea.ql.ast.expr;

import java.util.Map;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.types.Numeric;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.ASTNodeVisitor;

public class Sub extends Binary {

	public Sub(Expr result, Expr rhs) {
		super(result,rhs) ;
	}

	@Override
	public void accept(ASTNodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
		
	}
	
	@Override
	public Type isOfType(Map<Ident, Type> typeEnv) {
		return new Numeric();
	}

}
