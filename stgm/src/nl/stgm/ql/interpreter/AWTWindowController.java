package nl.stgm.ql.interpreter;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import nl.stgm.ql.data.*;

public class AWTWindowController
{
	ApplicationController delegate;
	Frame window;
	AWTFormController form;
	
	public AWTWindowController(ApplicationController delegate)
	{
		this.delegate = delegate;
		this.window = new Frame("Aangifteprogramma");
		this.window.add(new AWTPrevNextPanel(this), BorderLayout.SOUTH);
	}
	
	public void showForm(InterpreterForm form)
	{
		if (this.form != null) window.remove(this.form.getPanel());
		this.form = new AWTFormController(delegate, form);
		this.window.add(this.form.getPanel(), BorderLayout.CENTER);
		this.window.validate();
		this.show();
	}

	public void show()
	{
		this.window.pack();
		this.window.setVisible(true);
	}
	
	public void nextClicked()
	{
		if (delegate.hasNextForm()) delegate.nextForm();
	}

	public void previousClicked()
	{
		if (delegate.hasPreviousForm()) delegate.previousForm();
	}
	
	public void update()
	{
		
	}
}
