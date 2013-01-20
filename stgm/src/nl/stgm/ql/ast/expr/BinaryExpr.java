package nl.stgm.ql.ast.expr;

import nl.stgm.ql.ast.Expr;
import nl.stgm.ql.inspector.CodeInspector;

public class BinaryExpr extends Expr
{
	protected Expr left;
	protected Expr right;

	public void accept(CodeInspector inspector)
	{
		left.accept(inspector);
		right.accept(inspector);
		inspector.visit(this);
	}
}
