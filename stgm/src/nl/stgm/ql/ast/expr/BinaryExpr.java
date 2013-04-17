package nl.stgm.ql.ast.expr;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.data.*;
import nl.stgm.ql.interfaces.*;
import nl.stgm.ql.inspectors.*;

public abstract class BinaryExpr extends ASTExpressionNode
{
	protected ASTExpressionNode left;
	protected ASTExpressionNode right;
	
	public BinaryExpr(ASTExpressionNode left, ASTExpressionNode right)
	{
		this.left = left;
		this.right = right;
	}

	public String render()
	{
		return left.render() + " " + this.toString() + " " + right.render();
	}
}
