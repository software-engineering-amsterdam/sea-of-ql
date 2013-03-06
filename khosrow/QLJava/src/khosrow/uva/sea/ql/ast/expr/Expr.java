package khosrow.uva.sea.ql.ast.expr;

import khosrow.uva.sea.ql.ast.ASTNode;
import khosrow.uva.sea.ql.ast.type.Type;
import khosrow.uva.sea.ql.env.Env;
import khosrow.uva.sea.ql.visitor.IExprVisitor;

public abstract class Expr extends ASTNode {
	public Type typeOf(){
		return typeOf(null);
	}
	public abstract Type typeOf(Env typeEnv);
	public abstract <T> T accept(IExprVisitor<T> visitor);
}
