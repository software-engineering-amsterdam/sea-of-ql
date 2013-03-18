package nl.stgm.ql.ast.form;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.inspectors.pretty.*;
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
	
	// document element has no content, so defer everything to forms
		
	public void print(PrettyPrinter context)
	{
		for(Form f: forms)
		{
			f.print(context);
		}
	}
	
	public void check(Checker context)
	{
		for(Form f: forms)
		{
			f.check(context);
		}
	}

	public void interpret(Interpreter context)
	{
		for(Form f: forms)
		{
			f.interpret(context);
		}
	}
}
