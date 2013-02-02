package khosrow.uva.sea.ql.ast.expr;

import khosrow.uva.sea.ql.ast.type.Bool;
import khosrow.uva.sea.ql.ast.type.Type;
import khosrow.uva.sea.ql.env.Env;
import khosrow.uva.sea.ql.visitor.IExpressionVisitor;

public class BoolLiteral extends Literal<Boolean> {
	public BoolLiteral(Boolean value){
		super(value);
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
