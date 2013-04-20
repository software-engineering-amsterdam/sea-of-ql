package nl.stgm.ql.interpreter;

import nl.stgm.ql.ast.form.*;
import nl.stgm.ql.interpreter.awtui.*;
import nl.stgm.ql.data.*;

public class InterpreterController implements UIDelegate, PagedUIDelegate
{
	private PagedUIController ui;
	private InterpreterContext context = new InterpreterContext();
	private InterpreterViewManager manager;
	private InterpreterFormList forms;
	private InterpreterViewUpdater updater;
	
	public InterpreterController(Document astDocument)
	{
		this.ui = new AWTUIController(this);
		this.context = new InterpreterContext();
		this.manager = new InterpreterViewManager(this, astDocument, context, ui);
		this.forms = manager.getFormList();
	}
	
	public void run()
	{
		this.updater = manager.load(forms.getCurrent());
		ui.show();
	}
	
	public void nextClicked()
	{
		if(forms.hasNext())
		{
			forms.next();
			updater = manager.load(forms.getCurrent());
			updater.update();
			ui.validate();
		}
	}

	public void previousClicked()
	{
		if(forms.hasPrevious())
		{
			forms.previous();
			updater = manager.load(forms.getCurrent());
			updater.update();
			ui.validate();
		}
	}

	public void answerChanged(String id, String value)
	{
		if(value.length() == 0)
			context.removeValue(id);
		else
			context.putValue(id, new Int(value));

		updater.update();
		ui.validate();
	}
	
	public void answerChanged(String id, boolean value)
	{
		context.putValue(id, new Bool(value));
		updater.update();
		ui.validate();
	}
}
