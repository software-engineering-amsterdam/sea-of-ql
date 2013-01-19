package nl.stgm.ql.ast.expr;
import nl.stgm.ql.ast.ASTNode;
import nl.stgm.ql.inspector.CodeInspector;

public abstract class Expr implements ASTNode
{
	public void accept(CodeInspector inspector)
	{
		inspector.visit(this);
	}
}
