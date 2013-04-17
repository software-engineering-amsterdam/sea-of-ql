package nl.stgm.ql.ast.expr;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.interfaces.*;
import nl.stgm.ql.inspectors.*;

public abstract class LiteralExpr extends ASTExpressionNode
{
	public String renderExpressionString()
	{
		return this.toString();
	}
}
