package khosrow.uva.sea.ql.ast.expr;

import khosrow.uva.sea.ql.ast.type.Money;
import khosrow.uva.sea.ql.ast.type.Type;
import khosrow.uva.sea.ql.env.Env;
import khosrow.uva.sea.ql.visitor.IExprVisitor;

public class MoneyLiteral extends Literal<Double> {	
	public MoneyLiteral(double value) {
		super(value);
	}
	
	@Override
	public Type typeOf(Env typeEnv) {
		return new Money();
	}
	
	@Override
	public <T> T accept(IExprVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
