package nl.stgm.ql.ast.expr;

import nl.stgm.ql.ast.*;

public abstract class UnaryExpr extends ASTExpressionNode
{
	protected ASTExpressionNode arg;

	public UnaryExpr(ASTExpressionNode arg)
	{
		this.arg = arg;
	}

	public String render()
	{
		return this.toString() + arg.render();
	}
}
