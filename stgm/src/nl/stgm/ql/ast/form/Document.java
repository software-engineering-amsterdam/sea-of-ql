package nl.stgm.ql.ast.form;

import java.util.List;
import nl.stgm.ql.ast.*;
import nl.stgm.ql.inspector.pretty.*;

public class Document extends AbstractElement
{
	private List<Form> forms;
	
	public Document(List<Form> forms)
	{
		this.forms = forms;
	}
	
	public void print(ConsolePrinter context)
	{
		// hint: document element has no visual representation, so
		// only prints children
		
		for (Form form: forms)
		{
			form.print(context);
		}
	}
}
