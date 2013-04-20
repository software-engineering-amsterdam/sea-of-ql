package nl.stgm.ql.interpreter;

import nl.stgm.ql.ast.form.Document;
import nl.stgm.ql.data.*;
import nl.stgm.ql.interfaces.*;

public class InterpreterApplication implements PagedUIDelegate
{
	private PagedUIController ui;
	private InterpreterViewManager manager;
	private InterpreterContext context;
	private Document ast;
	
	public InterpreterApplication(Document ast)
	{
		this.ast = ast;
		this.context = new InterpreterContext();
	}
	
	public void run(PagedUIController ui)
	{
		this.ui = ui;
		this.manager = new InterpreterViewManager(ast, context, ui);
		ui.show();
	}
	
	public void nextClicked()
	{
		if(manager.hasNextForm())
		{
			ui.clear();
			manager.nextForm();
			this.update();
		}
	}
	
	public void previousClicked()
	{
		if(manager.hasPreviousForm())
		{
			ui.clear();
			manager.previousForm();
			this.update();
		}
	}
	
	public void answerChanged(String id, Integer value)
	{
		if(value == null)
			context.removeValue(id);
		else
			context.putValue(id, new Int(value));
		
		this.update();
	}
	
	public void answerChanged(String id, boolean value)
	{
		context.putValue(id, new Bool(value));
		this.update();
	}

	private void update()
	{
		manager.update();
		ui.validate();
	}
}
