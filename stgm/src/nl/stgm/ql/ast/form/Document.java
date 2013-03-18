package nl.stgm.ql.ast.form;

import java.util.List;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.interfaces.*;

public class Document extends AbstractNode
{
	private List<Form> forms;
	
	public Document(List<Form> forms)
	{
		this.forms = forms;
	}
	
	public List<Form> forms()
	{
		return this.forms;
	}
	
	public void accept(Visitor v)
	{
		v.visit(this);
	}
}
