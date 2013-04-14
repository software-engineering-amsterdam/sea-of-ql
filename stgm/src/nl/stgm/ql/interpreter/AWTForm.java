package nl.stgm.ql.interpreter;

import java.awt.*;
import java.awt.event.*;

import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.ast.form.*;

import nl.stgm.ql.data.*;
import nl.stgm.ql.interfaces.*;
import nl.stgm.ql.inspectors.*;

public class AWTForm implements IUIElement
{
	InterpreterApplication delegate;
	Panel panel;
	
	public AWTForm(InterpreterApplication delegate)
	{
		this.delegate = delegate;
		// this.form = form;
		
		this.panel = new Panel(new GridLayout(6, 2));
		this.panel.setPreferredSize(new Dimension(800, 600));
		
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
