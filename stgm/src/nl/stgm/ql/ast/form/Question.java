package nl.stgm.ql.ast.form;

import nl.stgm.ql.data.*;
import nl.stgm.ql.interfaces.*;
import nl.stgm.ql.inspectors.*;

public abstract class Question extends FormItem
{
	protected String id;
	protected String question;
	
	public Question(String id, String question)
	{
		this.id = id;
		this.question = question;
		// this.type = Type.parse(type);
	}
	
	public String id()
	{
		return this.id;
	}
	
	public String question()
	{
		return this.question;
	}
	
	// public Type type()
	// {
	// 	return this.type;
	// }

	// public void accept(Visitor v)
	// {
	// 	v.visit(this);
	// }
}
