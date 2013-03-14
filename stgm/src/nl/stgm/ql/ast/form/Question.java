package nl.stgm.ql.ast.form;
import nl.stgm.ql.ast.*;
import nl.stgm.ql.inspector.pretty.*;

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
	
	public void print(ConsolePrinter context)
	{
		context.println(id + ": " + question + " " + type);
	}
}
