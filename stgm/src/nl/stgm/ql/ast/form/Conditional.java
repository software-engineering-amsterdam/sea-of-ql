package nl.stgm.ql.ast.form;

import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.ast.expr.literal.*;
import nl.stgm.ql.inspectors.*;
import nl.stgm.ql.inspectors.checker.*;
import nl.stgm.ql.inspectors.interpreter.*;

import java.util.List;

public class Conditional extends FormItem
{
	private Expr condition;
	private List<Question> ifQuestions;
	private List<Question> elseQuestions;
	
	private boolean hasElse;
	
	public Conditional(Expr condition, List<Question> ifQuestions, List<Question> elseQuestions)
	{
		this.condition = condition;
		this.ifQuestions = ifQuestions;
		this.elseQuestions = elseQuestions;
		this.hasElse = true;
	}

	public Conditional(Expr condition, List<Question> ifQuestions)
	{
		this.condition = condition;
		this.ifQuestions = ifQuestions;
		this.hasElse = false;
	}
	
	public Expr condition()
	{
		return this.condition;
	}
	
	// TODO make iterator
	public List<Question> ifQuestions()
	{
		return this.ifQuestions;
	}

	// TODO make iterator
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
