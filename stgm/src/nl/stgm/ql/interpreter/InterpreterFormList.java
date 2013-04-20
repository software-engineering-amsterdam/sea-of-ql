package nl.stgm.ql.interpreter;

import java.util.List;
import java.util.Vector;
import nl.stgm.ql.ast.form.*;

public class InterpreterFormList
{
	private List<Form> forms = new Vector<Form>();
	private int currentFormID = 0;
	
	public void add(Form f)
	{
		this.forms.add(f);
	}
	
	public int size()
	{
		return forms.size();
	}
	
	public Form getCurrent()
	{
		return this.forms.get(currentFormID);
	}
	
	public boolean hasNext()
	{
		return currentFormID < forms.size() - 1;
	}

	public void next()
	{
		currentFormID++;
	}

	public boolean hasPrevious()
	{
		return currentFormID > 0;
	}

	public void previous()
	{
		currentFormID--;
	}	
}
