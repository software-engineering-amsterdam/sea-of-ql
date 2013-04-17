package nl.stgm.ql.interpreter;

import java.awt.*;
import java.awt.event.*;

public class AWTConditional extends AWTForm
{
	AWTForm truePart;
	AWTForm falsePart;
	boolean prevPart = true;
	
	public AWTConditional(InterpreterApplication delegate, AWTForm truePart, AWTForm falsePart)
	{
		super(delegate);
		
		this.truePart = truePart;
		this.falsePart = falsePart;

		setLayout(new GridLayout(1, 1));
	}
	
	public AWTForm truePart()
	{
		return this.truePart;
	}

	public AWTForm falsePart()
	{
		return this.falsePart;
	}

	public void displayPart(boolean whichPart)
	{
		removeAll();

		if(whichPart)
			super.add(truePart);
		else if(falsePart != null) // so just display nothing if no falsePart
			super.add(falsePart);
	}
}
