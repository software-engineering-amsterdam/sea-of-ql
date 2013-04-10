package nl.stgm.ql.interpreter;

import java.util.Vector;
import nl.stgm.ql.ast.form.*;
import nl.stgm.ql.data.*;

public class InterpreterDocument
{
	private Vector<Form> forms = new Vector<Form>();
	private Context context = new Context();
	private int currentForm;

	public InterpreterDocument(Document ast)
	{
		// gather forms from document
		for(Form f: ast.forms())
		{
			this.forms.add(f);
		}

		// set initial state
		if(this.forms.size() > 0)
		{
			this.currentForm = 0;
		}
		else
		{
			// no forms in document
		}
	}

	public boolean hasNextForm()
	{
		return currentForm < forms.size() - 1;
	}
	
	public void nextForm()
	{
		System.out.println("next");
		assert hasNextForm();
		currentForm++;
	}
	
	public boolean hasPreviousForm()
	{
		return currentForm > 0;
	}
	
	public void previousForm()
	{
		System.out.println("prev");
		assert hasPreviousForm();
		currentForm--;
	}
	
	public InterpreterForm getForm()
	{
		return new InterpreterForm(forms.get(currentForm), context);
	}
	
	public void putValue(String name, Value value)
	{
		context.putValue(name, value);
	}
}
