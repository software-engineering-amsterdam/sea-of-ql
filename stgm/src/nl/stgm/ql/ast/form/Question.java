package nl.stgm.ql.ast.form;

import nl.stgm.ql.data.*;

public abstract class Question extends FormItem
{
	protected String id;
	protected String question;
	
	public Question(String id, String question)
	{
		this.id = id;
		this.question = question;
	}
	
	public String id()
	{
		return this.id;
	}
	
	public String question()
	{
		return this.question;
	}
}
