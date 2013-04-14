package nl.stgm.ql.interpreter;

import java.awt.*;
import java.awt.event.*;

public class AWTForm implements IUIElement
{
	InterpreterApplication delegate;
	Panel panel;
	
	public AWTForm(InterpreterApplication delegate)
	{
		this.delegate = delegate;
		this.panel = new Panel(new GridLayout(6, 2));
		this.update();
	}
	
	public Panel getPanel()
	{
		return this.panel;
	}
	
	public void addElement(IUIElement e)
	{
		panel.add((Component)e);
	}
	
	public void update()
	{
		// reload controls from model
		panel.removeAll();
	}
}
