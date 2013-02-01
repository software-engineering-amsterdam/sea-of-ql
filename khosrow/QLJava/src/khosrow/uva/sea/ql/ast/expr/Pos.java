package khosrow.uva.sea.ql.ast.expr;

import khosrow.uva.sea.ql.ast.type.Numeric;
import khosrow.uva.sea.ql.ast.type.Type;
import khosrow.uva.sea.ql.eval.env.Env;


public class Pos extends Unary {
	public Pos(Expr arg) {
		super(arg);
	}
	
	@Override
	public Type TypeOf(Env typeEnv) {
		return new Numeric();
	}
}
