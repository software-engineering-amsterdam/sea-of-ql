package nl.stgm.ql.interpreter;

import java.awt.*;
import java.awt.event.*;

public class AWTForm extends Panel implements IUIElement
{
	InterpreterApplication delegate;
	
	public AWTForm(InterpreterApplication delegate)
	{
		super(new GridLayout(1, 1));
		this.delegate = delegate;
	}
	
	public void addElement(IUIElement e)
	{
		super.add((Component)e);
		
		// fit gridlayout to amount of fields in form
		GridLayout g = (GridLayout) super.getLayout();
		g.setRows(super.getComponentCount());
	}
	
	public void clear()
	{
		removeAll();
	}
}
