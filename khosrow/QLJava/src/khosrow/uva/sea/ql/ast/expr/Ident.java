package khosrow.uva.sea.ql.ast.expr;

import khosrow.uva.sea.ql.ast.type.Type;
import khosrow.uva.sea.ql.env.Env;
import khosrow.uva.sea.ql.resources.QlTypeError;
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
	public int hashCode() {
		return name.hashCode();
	}	

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Ident))
			return false;
		return name.equals(((Ident)obj).name);
	}

	@Override
	public Type typeOf(Env env) {
		if(env.lookUpIdent(this))
			return env.typeOf(this);
		return new QlTypeError("undefined identifier: " + name);
	}
	
	@Override
	public <T> T accept(IExprVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
