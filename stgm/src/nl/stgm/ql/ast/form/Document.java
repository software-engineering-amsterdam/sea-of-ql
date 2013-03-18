package nl.stgm.ql.ast.form;

import nl.stgm.ql.ast.*;

import nl.stgm.ql.inspectors.*;
import nl.stgm.ql.inspectors.checker.*;
import nl.stgm.ql.inspectors.interpreter.*;

import java.util.List;

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
