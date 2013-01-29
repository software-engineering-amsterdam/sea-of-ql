package org.uva.sea.ql.ast.operative;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Primitive;
import org.uva.sea.ql.interfaces.IVisitor;
import org.uva.sea.ql.util.Environment;

public class Not extends OperatorUnaryBoolean {
	
	public Not(Expr operand){
		super(operand);
	}

	@Override
	public Primitive interpret(Environment env) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public <T> T accept(IVisitor<T> visitor) {
		return visitor.visit(this);
	}
		
}
