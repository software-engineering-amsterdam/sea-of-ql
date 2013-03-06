package org.uva.sea.ql.ast.alg;

import java.util.Map;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.AlgebricElementVisitor;

public class NEq extends Expr {

	private final Expr lhs;
	private final Expr rhs;
	
	public NEq(Expr lhs, Expr rhs){
		
		this.lhs = lhs;
		this.rhs = rhs;
		System.out.println( lhs + "       " + rhs + "              NEq Class" );
	
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new BoolType();
	}
		
	@Override
	public <T> T accept(AlgebricElementVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
}
