package nl.stgm.ql.ast.form;

import java.util.List;
import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.inspector.CodeInspector;

public class Conditional extends FormItem
{
	private Expr condition;
	private List<Question> ifQuestions;
	private List<Question> elseQuestions;
	
	public Conditional(Expr condition, List<Question> ifQuestions, List<Question> elseQuestions)
	{
		this.condition = condition;
		this.ifQuestions = ifQuestions;
		this.elseQuestions = elseQuestions;
	}

	public void accept(CodeInspector inspector)
	{
		condition.accept(inspector);
		
		for (Question question: ifQuestions)
		{
			question.accept(inspector);
		}
		
		if(elseQuestions != null)
		{
			for (Question question: elseQuestions)
			{
				question.accept(inspector);
			}
		}
		
		inspector.visit(this);
	}
}
