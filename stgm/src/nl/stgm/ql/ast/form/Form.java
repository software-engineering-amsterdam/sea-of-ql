package nl.stgm.ql.ast.form;

import nl.stgm.ql.ast.*;
import java.util.List;

public class Form extends ASTDocumentNode
{
	private String id;
	private List<FormItem> formItems;
	
	public Form(String id, List<FormItem> formItems)
	{
		this.id = id;
		this.formItems = formItems;
	}
	
	public String getID()
	{
		return this.id;
	}
	
	public List<FormItem> formItems()
	{
		return this.formItems;
	}

	public void accept(Visitor v)
	{
		v.visit(this);
	}
}
