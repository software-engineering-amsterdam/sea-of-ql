package nl.stgm.ql.ast.form;

import java.util.List;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.interfaces.*;

public class Conditional extends FormItem
{
	private ASTExpressionNode condition;
	private List<Question> ifQuestions;
	private List<Question> elseQuestions;
	
	private boolean hasElse;
	
	public Conditional(ASTExpressionNode condition, List<Question> ifQuestions, List<Question> elseQuestions)
	{
		this.condition = condition;
		this.ifQuestions = ifQuestions;
		this.elseQuestions = elseQuestions;
		this.hasElse = true;
	}

	public Conditional(ASTExpressionNode condition, List<Question> ifQuestions)
	{
		this.condition = condition;
		this.ifQuestions = ifQuestions;
		this.hasElse = false;
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
		return this.hasElse;
	}

	public void accept(Visitor v)
	{
		v.visit(this);
	}
}
