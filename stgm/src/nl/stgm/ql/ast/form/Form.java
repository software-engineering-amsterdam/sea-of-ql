package nl.stgm.ql.ast.form;

import java.util.List;
import nl.stgm.ql.ast.*;
import nl.stgm.ql.inspector.pretty.*;

public class Form extends AbstractElement
{
	private String id;
	private List<FormItem> formItems;
	
	public Form(String id, List<FormItem> formItems)
	{
		this.id = id;
		this.formItems = formItems;
	}

	public void print(ConsolePrinter context)
	{
		context.println("form " + this.id + " {");
		context.increaseIndent();
		for (FormItem formItem: formItems)
		{
			formItem.print(context);
		}
		context.decreaseIndent();
		context.println("}");
	}
}
