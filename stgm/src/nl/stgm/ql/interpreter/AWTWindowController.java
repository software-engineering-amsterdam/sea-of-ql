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
		
		window = new Frame("Aangifteprogramma");
		window.add(new AWTPrevNextPanel(this), BorderLayout.SOUTH);
	}
	
	public void showForm(InterpreterForm form)
	{
		if (this.form != null) window.remove(this.form.getPanel());
		this.form = new AWTFormController(delegate, form);
		
		window.add(this.form.getPanel(), BorderLayout.CENTER);
		window.validate();
		this.show();
	}

	public void show()
	{
		window.pack();
		window.setVisible(true);
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
		System.out.println("form update not implemented");
	}
}
