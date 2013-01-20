package nl.stgm.ql.ast.form;
import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.inspector.CodeInspector;

public class Condition extends Expr
{
	public Condition()
	{
	}

	public void accept(CodeInspector inspector)
	{
		inspector.visit(this);
	}
}
