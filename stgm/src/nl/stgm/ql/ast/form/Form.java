package nl.stgm.ql.ast.form;

import java.util.List;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.interfaces.*;
import nl.stgm.ql.inspectors.*;

public class Form extends AbstractNode
{
	private String id;
	private List<FormItem> formItems;
	
	public Form(String id, List<FormItem> formItems)
	{
		this.id = id;
		this.formItems = formItems;
	}
	
	public String id()
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
