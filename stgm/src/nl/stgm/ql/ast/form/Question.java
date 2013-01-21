package nl.stgm.ql.ast.form;

public class Question extends FormItem
{
	protected String id;
	protected String question;
	protected String type;
	
	public Question(String id, String question, String type)
	{
		this.id = id;
		this.question = question;
		this.type = type;
	}
	
	public String toString()
	{
		return("Question: " + question);
	}
}
