package nl.stgm.ql.ast.expr;

import nl.stgm.ql.ast.Expr;
import nl.stgm.ql.inspector.CodeInspector;

public class UnaryExpr extends Expr
{
	protected Expr arg;

	public void accept(CodeInspector inspector)
	{
		arg.accept(inspector);
		inspector.visit(this);
	}
}
