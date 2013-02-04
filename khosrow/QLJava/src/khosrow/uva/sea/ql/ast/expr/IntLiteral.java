package khosrow.uva.sea.ql.ast.expr;

import khosrow.uva.sea.ql.ast.type.Int;
import khosrow.uva.sea.ql.ast.type.Type;
import khosrow.uva.sea.ql.env.Env;
import khosrow.uva.sea.ql.visitor.IExprVisitor;


public class IntLiteral extends Literal<Integer> {
	public IntLiteral(Integer value) {
		super(value);
	}

	@Override
	public Type typeOf(Env typeEnv) {		
		return new Int();
	}
	
	@Override
	public <T> T accept(IExprVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
