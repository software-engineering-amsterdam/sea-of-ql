package khosrow.uva.sea.ql.ast.expr;

import khosrow.uva.sea.ql.ast.type.Bool;
import khosrow.uva.sea.ql.ast.type.Type;
import khosrow.uva.sea.ql.eval.env.Env;


public class Not extends Unary {
	public Not(Expr arg) {
		super(arg);
	}
	
	@Override
	public Type TypeOf(Env typeEnv) {		
		return new Bool();
	}
}
