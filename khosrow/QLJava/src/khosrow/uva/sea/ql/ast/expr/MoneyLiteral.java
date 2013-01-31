package khosrow.uva.sea.ql.ast.expr;

import khosrow.uva.sea.ql.ast.type.Money;
import khosrow.uva.sea.ql.ast.type.Type;
import khosrow.uva.sea.ql.eval.env.Env;


public class MoneyLiteral extends Literal<Double> {	
	public MoneyLiteral(double value) {
		super(value);
	}
	
	@Override
	public Type TypeOf(Env typeEnv) {
		return new Money();
	}
}
