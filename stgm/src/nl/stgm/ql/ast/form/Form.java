package nl.stgm.ql.ast.form;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.inspectors.*;

import java.util.List;

public class Form extends AbstractElement
{
	private String id;
	private List<FormItem> formItems;
	
	public Form(String id, List<FormItem> formItems)
	{
		this.id = id;
		this.formItems = formItems;
	}

	public void print(PrettyPrinter context)
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

	public void check(SemanticChecker context)
	{
		System.out.println("Check 1 element!" + this.toString());

		for(FormItem f: formItems)
		{
			f.check(context);
		}
	}
}
