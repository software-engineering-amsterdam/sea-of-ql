package nl.stgm.ql.ast.form;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.inspectors.*;
import nl.stgm.ql.inspectors.checker.*;
import nl.stgm.ql.inspectors.interpreter.*;

import java.util.List;

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
