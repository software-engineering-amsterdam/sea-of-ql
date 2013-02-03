package khosrow.uva.sea.ql.ast.expr;

import khosrow.uva.sea.ql.ast.type.Bool;
import khosrow.uva.sea.ql.ast.type.Type;
import khosrow.uva.sea.ql.env.Env;
import khosrow.uva.sea.ql.visitor.IExprVisitor;

public class BoolLiteral extends Literal<Boolean> {
	public BoolLiteral(Boolean value){
		super(value);
	}

	@Override
	public Type typeOf(Env typeEnv) {		
		return new Bool();
	}
	
	@Override
	public <T> T accept(IExprVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
