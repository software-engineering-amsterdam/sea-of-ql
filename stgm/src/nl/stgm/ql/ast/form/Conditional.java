package nl.stgm.ql.ast.form;

import java.util.List;

import nl.stgm.ql.ast.ASTNode;
import nl.stgm.ql.ast.expr.Expr;
import nl.stgm.ql.inspector.CodeInspector;

public class Conditional extends FormItem
{
	private Expr condition;
	private List<Question> questions;
	
	public Conditional(Expr condition, List<Question> questions)
	{
		this.condition = condition;
		this.questions = questions;
	}

	public void accept(CodeInspector inspector)
	{
		for (Question question: questions)
		{
			question.accept(inspector);
		}
		
		inspector.visit(this);
	}

	public String toString()
	{
		return("Conditional");
	}
}
