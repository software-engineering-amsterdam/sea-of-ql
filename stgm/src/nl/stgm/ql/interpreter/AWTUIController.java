package nl.stgm.ql.interpreter;

import java.awt.*;
import java.awt.event.*;

public class AWTUIController
{
	InterpreterApplication delegate;
	Frame window;
	AWTForm form;
	
	public AWTUIController(InterpreterApplication delegate)
	{
		this.delegate = delegate;
		
		window = new Frame("Aangifteprogramma");
		window.add(new AWTPrevNextPanel(delegate), BorderLayout.SOUTH);
	}
	
	public void clear()
	{
		if (this.form != null) window.remove(this.form.getPanel());
		this.form = new AWTForm(delegate);
		window.add(this.form.getPanel(), BorderLayout.CENTER);
	}

	public void addElement(IUIElement e)
	{
		form.addElement(e);
	}

	public void validate()
	{
		window.validate();
		window.pack();
		window.setVisible(true);
	}
}
