package org.uva.sea.ql.ast.values;

import java.util.Map;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.types.Type;
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

	@Override
	public Type isOfType(Map<Ident, Type> typeEnv) {
		return new BoolType();
	}

}
