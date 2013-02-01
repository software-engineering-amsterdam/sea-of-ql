package khosrow.uva.sea.ql.ast.expr;

import khosrow.uva.sea.ql.ast.type.Int;
import khosrow.uva.sea.ql.ast.type.Type;
import khosrow.uva.sea.ql.eval.env.Env;


public class IntLiteral extends Literal<Integer> {
	public IntLiteral(Integer value) {
		super(value);
	}

	@Override
	public Type TypeOf(Env typeEnv) {		
		return new Int();
	}
}
