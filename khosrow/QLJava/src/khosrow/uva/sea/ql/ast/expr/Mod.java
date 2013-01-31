package khosrow.uva.sea.ql.ast.expr;

import khosrow.uva.sea.ql.ast.type.Numeric;
import khosrow.uva.sea.ql.ast.type.Type;
import khosrow.uva.sea.ql.eval.env.Env;


public class Mod extends Binary {
	public Mod(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}
	
	@Override
	public Type TypeOf(Env typeEnv) {
		return new Numeric();
	}
}
