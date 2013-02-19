package org.uva.sea.ql.ast.expr;

import java.util.Map;

import org.uva.sea.ql.ast.type.NumericType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.visitor.Visitor;

public class Sub extends BinaryExpr{

	
    public Sub(Expr lhs, Expr rhs) {
    	super(lhs,rhs);
     
}
    
	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new NumericType();
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return "SUB lhs("+this.lhs.toString()+")"+ " |Êrhs("+this.rhs.toString()+")";
	}
}
