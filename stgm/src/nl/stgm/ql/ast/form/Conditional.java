package nl.stgm.ql.ast.form;

import nl.stgm.ql.ast.*;
import java.util.List;
import java.util.Collections;

public class Conditional extends FormItem
{
	private ASTExpressionNode condition;
	private List<Question> ifQuestions;
	private List<Question> elseQuestions;
	
	public Conditional(ASTExpressionNode condition, List<Question> ifQuestions, List<Question> elseQuestions)
	{
		this.condition = condition;
		this.ifQuestions = ifQuestions;
		this.elseQuestions = elseQuestions;
	}

	public Conditional(ASTExpressionNode condition, List<Question> ifQuestions)
	{
		this(condition, ifQuestions, Collections.<Question>emptyList());
	}
	
	public ASTExpressionNode condition()
	{
		return this.condition;
	}
	
	public List<Question> ifQuestions()
	{
		return this.ifQuestions;
	}

	public List<Question> elseQuestions()
	{
		return this.elseQuestions;
	}
	
	public boolean hasElse()
	{
		return !this.elseQuestions.isEmpty();
	}

	public void accept(Visitor v)
	{
		v.visit(this);
	}
}
