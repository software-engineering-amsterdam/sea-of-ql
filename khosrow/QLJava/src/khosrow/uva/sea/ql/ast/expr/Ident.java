package khosrow.uva.sea.ql.ast.expr;

import khosrow.uva.sea.ql.ast.type.Type;
import khosrow.uva.sea.ql.ast.type.Error;
import khosrow.uva.sea.ql.env.Env;
import khosrow.uva.sea.ql.visitor.IExpressionVisitor;


public class Ident extends Expr {
	private final String name;

	public Ident(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public Type TypeOf(Env typeEnv) {
		if(typeEnv.Contains(this))
			return typeEnv.TypeOf(this);
		return new Error("undefined identifier: " + name);
	}
	
	@Override
	public <T> T Accept(IExpressionVisitor<T> visitor) {
		return visitor.Visit(this);
	}
}
