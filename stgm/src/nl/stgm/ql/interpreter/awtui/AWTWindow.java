package nl.stgm.ql.interpreter.awtui;

import nl.stgm.ql.interpreter.*;

import java.awt.*;
import java.awt.event.*;

public class AWTWindow extends Frame implements UIContainerElement
{
	UIDelegate delegate;
	
	public AWTWindow(String title)
	{
		super(title);
		super.setMinimumSize(new Dimension(800,600));

		this.delegate = delegate;
	}
	
	public void addElement(UIElement e)
	{
		super.add((Component)e);
	}
	
	public void clear()
	{
		removeAll();
	}
}
