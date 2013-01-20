package nl.stgm.ql.ast.form;

import java.util.List;

import nl.stgm.ql.ast.expr.Expr;
import nl.stgm.ql.inspector.CodeInspector;

public class Condition extends Expr
{
	private Expr expression;
	
	public Condition(Expr expression)
	{
		this.expression = expression;
	}

	public void accept(CodeInspector inspector)
	{
		expression.accept(inspector);
		inspector.visit(this);
	}
}
