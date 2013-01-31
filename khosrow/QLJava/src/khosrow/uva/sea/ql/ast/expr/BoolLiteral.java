package khosrow.uva.sea.ql.ast.expr;

import khosrow.uva.sea.ql.ast.type.Bool;
import khosrow.uva.sea.ql.ast.type.Type;
import khosrow.uva.sea.ql.eval.env.Env;

public class BoolLiteral extends Literal<Boolean> {
	public BoolLiteral(Boolean value){
		super(value);
	}

	@Override
	public Type TypeOf(Env typeEnv) {		
		return new Bool();
	}
}
