package nl.stgm.ql.ast.form;

public abstract class Question extends FormItem
{
	protected String id;
	protected String question;
	
	public Question(String id, String question)
	{
		this.id = id;
		this.question = question;
	}
	
	public String getID()
	{
		return this.id;
	}
	
	public String getQuestion()
	{
		return this.question;
	}
}
