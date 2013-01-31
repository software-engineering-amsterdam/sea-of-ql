package khosrow.uva.sea.ql.ast.expr;

import khosrow.uva.sea.ql.ast.ASTNode;
import khosrow.uva.sea.ql.ast.type.Type;
import khosrow.uva.sea.ql.eval.env.Env;

public abstract class Expr extends ASTNode {
	public abstract Type TypeOf(Env typeEnv);
}
