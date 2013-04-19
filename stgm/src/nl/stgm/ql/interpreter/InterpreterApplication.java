package nl.stgm.ql.interpreter;

import nl.stgm.ql.ast.form.Document;
import nl.stgm.ql.data.*;
import nl.stgm.ql.interfaces.*;

public class InterpreterApplication implements PagedUIDelegate
{
	private PagedUIController ui;
	private PagedInterpreter document;
	private Document ast;
	
	public InterpreterApplication(Document ast)
	{
		this.ast = ast;
	}
	
	public void run(PagedUIController ui)
	{
		this.ui = ui;
		this.document = new PagedInterpreter(ast, ui);
		this.update();
		ui.show();
	}
	
	public void nextClicked()
	{
		if(document.hasNextForm())
		{
			ui.clear();
			document.nextForm();
			this.update();
		}
	}
	
	public void previousClicked()
	{
		if(document.hasPreviousForm())
		{
			ui.clear();
			document.previousForm();
			this.update();
		}
	}
	
	public void answerChanged(String id, Integer value)
	{
		if(value == null)
			document.removeValue(id);
		else
			document.putValue(id, new Int(value));
		
		this.update();
	}
	
	public void answerChanged(String id, boolean value)
	{
		document.putValue(id, new Bool(value));
		this.update();
	}

	private void update()
	{
		document.update();
		ui.validate();
	}
}
