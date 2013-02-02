package khosrow.uva.sea.ql.ast.expr;

import khosrow.uva.sea.ql.ast.ASTNode;
import khosrow.uva.sea.ql.ast.type.Type;
import khosrow.uva.sea.ql.env.Env;
import khosrow.uva.sea.ql.visitor.IExpressionVisitor;

public abstract class Expr extends ASTNode {
	public abstract Type TypeOf(Env typeEnv);
	public abstract <T> T Accept(IExpressionVisitor<T> visitor);
}
