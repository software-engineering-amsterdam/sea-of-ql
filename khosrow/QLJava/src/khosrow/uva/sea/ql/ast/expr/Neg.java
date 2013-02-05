package khosrow.uva.sea.ql.ast.expr;

import khosrow.uva.sea.ql.ast.type.Numeric;
import khosrow.uva.sea.ql.ast.type.Type;
import khosrow.uva.sea.ql.env.Env;
import khosrow.uva.sea.ql.visitor.IExprVisitor;

public class Neg extends Unary {
	public Neg(Expr arg) {
		super(arg);
	}
	
	@Override
	public Type typeOf(Env typeEnv) {
		return new Numeric();
	}
	
	@Override
	public <T> T accept(IExprVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
