package nl.stgm.ql.ast.expr;
import nl.stgm.ql.ast.ASTNode;
import nl.stgm.ql.inspector.CodeInspector;

public abstract class Expr implements ASTNode
{
	/*
	 * Default acceptor for visitors: needs to be overridden 
	 * for classes that are composed (in order to also visit
	 * child nodes).
	 */
	public void accept(CodeInspector inspector)
	{
		inspector.visit(this);
	}
}
