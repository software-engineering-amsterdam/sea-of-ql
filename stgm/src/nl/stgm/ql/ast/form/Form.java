package nl.stgm.ql.ast.form;

import java.util.List;
import nl.stgm.ql.ast.ASTNode;
import nl.stgm.ql.inspector.CodeInspector;

public class Form implements ASTNode
{
	private String id;
	private List<FormItem> formItems;
	
	public Form(String id, List<FormItem> formItems)
	{
		this.id = id;
		this.formItems = formItems;
	}

	public void accept(CodeInspector inspector)
	{
		for (FormItem item: formItems)
		{
			item.accept(inspector);
		}
		
		inspector.visit(this);
	}
	
	public String toString()
	{
		return("Form " + id);
	}
}
