package nl.stgm.ql.interpreter;

import nl.stgm.ql.ast.form.Document;
import nl.stgm.ql.data.*;
import nl.stgm.ql.interfaces.*;

public class InterpreterApplication
{
	private InterpreterDocument document;
	private AWTUIController ui;
	
	public InterpreterApplication(Document ast)
	{
		// combine source ast and ui in document
		this.ui = new AWTUIController(this);
		this.document = new InterpreterDocument(this, ast, this.ui);
	}
	
	public void run()
	{
		document.update();
	}
	
	public boolean hasNextForm()
	{
		return document.hasNextForm();
	}
	
	public void nextClicked()
	{
		if(document.hasNextForm()) document.nextForm();
	}
	
	public boolean hasPreviousForm()
	{
		return document.hasPreviousForm();
	}
	
	public void previousClicked()
	{
		if(document.hasPreviousForm()) document.previousForm();
	}
	
	public void answerChanged(String name, Value value)
	{
		System.out.println("answer changed");
		document.putValue(name, value);
		document.update();
	}
}
