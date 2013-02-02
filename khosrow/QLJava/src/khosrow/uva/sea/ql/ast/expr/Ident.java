package khosrow.uva.sea.ql.ast.expr;

import khosrow.uva.sea.ql.ast.type.Type;
import khosrow.uva.sea.ql.ast.type.QlError;
import khosrow.uva.sea.ql.env.Env;
import khosrow.uva.sea.ql.visitor.IExprVisitor;

public class Ident extends Expr {
	private final String name;

	public Ident(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public Type typeOf(Env typeEnv) {
		if(typeEnv.Contains(this))
			return typeEnv.TypeOf(this);
		return new QlError("undefined identifier: " + name);
	}
	
	@Override
	public <T> T accept(IExprVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
