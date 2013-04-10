package nl.stgm.ql.interpreter;

import nl.stgm.ql.ast.form.Document;
import nl.stgm.ql.data.*;
import nl.stgm.ql.interfaces.*;

public class ApplicationController
{
	private InterpreterDocument document;
	private AWTWindowController ui;
	
	public ApplicationController(Document ast)
	{
		this.document = new InterpreterDocument(ast);
		this.ui = new AWTWindowController(this);
	}
	
	public void run()
	{
		this.loadForm();
	}
	
	public boolean hasNextForm()
	{
		return document.hasNextForm();
	}
	
	public void nextForm()
	{
		document.nextForm();
		this.loadForm();
	}
	
	public boolean hasPreviousForm()
	{
		return document.hasPreviousForm();
	}
	
	public void previousForm()
	{
		document.previousForm();
		this.loadForm();
	}
	
	public void answerChanged(String name, Value value)
	{
		document.putValue(name, value);
		ui.update();
	}

	private void loadForm()
	{
		ui.showForm(document.getForm());
	}
}
