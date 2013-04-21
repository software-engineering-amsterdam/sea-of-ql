package nl.stgm.ql.ast.expr;

import nl.stgm.ql.ast.*;

public abstract class LiteralExpr extends ASTExpressionNode
{
	public String render()
	{
		return this.toString();
	}
	
	public void checkType(TypeCheckContext context)
	{
		return; // no type errors on literals
	}
}
