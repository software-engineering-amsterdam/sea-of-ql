package khosrow.uva.sea.ql.ast.expr;

import khosrow.uva.sea.ql.ast.type.Bool;
import khosrow.uva.sea.ql.ast.type.Type;
import khosrow.uva.sea.ql.env.Env;
import khosrow.uva.sea.ql.visitor.IExpressionVisitor;


public class Not extends Unary {
	public Not(Expr arg) {
		super(arg);
	}
	
	@Override
	public Type TypeOf(Env typeEnv) {		
		return new Bool();
	}
	
	@Override
	public <T> T Accept(IExpressionVisitor<T> visitor) {
		return visitor.Visit(this);
	}
}
