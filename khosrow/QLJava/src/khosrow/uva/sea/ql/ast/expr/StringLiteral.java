package khosrow.uva.sea.ql.ast.expr;

import khosrow.uva.sea.ql.ast.type.Str;
import khosrow.uva.sea.ql.ast.type.Type;
import khosrow.uva.sea.ql.eval.env.Env;


public class StringLiteral extends Literal<String> {
	public StringLiteral(String value) {
		super(value);
	}

	@Override
	public Type TypeOf(Env typeEnv) {
		return new Str();
	}
}
