package nl.stgm.ql.ast.form;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.inspectors.*;

import java.util.List;

public class Document extends AbstractElement
{
	private List<Form> forms;
	
	public Document(List<Form> forms)
	{
		this.forms = forms;
	}
	
	public void print(PrettyPrinter context)
	{
		// hint: document element has no visual representation, so
		// only prints children
		
		for(Form form: forms)
		{
			form.print(context);
		}
	}
	
	public void check(SemanticChecker context)
	{
		System.out.println("Check 1 element!" + this.toString());

		for(Form f: forms)
		{
			f.check(context);
		}
	}
}
