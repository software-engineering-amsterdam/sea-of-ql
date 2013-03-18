package nl.stgm.ql.ast.form;

import nl.stgm.ql.inspectors.*;

public class Question extends FormItem
{
	protected String id;
	protected String question;
	protected Type type;
	
	public Question(String id, String question, String type)
	{
		this.id = id;
		this.question = question;
		this.type = Type.parse(type);
	}
	
	public String id()
	{
		return this.id;
	}
	
	public String question()
	{
		return this.question;
	}
	
	public Type type()
	{
		return this.type;
	}

	public void accept(Visitor v)
	{
		v.visit(this);
	}
}
