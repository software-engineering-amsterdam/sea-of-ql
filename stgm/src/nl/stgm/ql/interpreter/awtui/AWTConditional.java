package nl.stgm.ql.interpreter.awtui;

import nl.stgm.ql.interpreter.*;

import java.awt.*;
import java.awt.event.*;

public class AWTConditional extends AWTForm
{
	AWTForm truePart;
	AWTForm falsePart;
	Boolean prevPart;
	
	public AWTConditional(UIDelegate delegate)
	{
		super(delegate);
		
		truePart = new AWTForm(delegate);
		falsePart = new AWTForm(delegate);
		
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
		if(prevPart == null || whichPart != prevPart)
		{
			prevPart = whichPart;
			removeAll();

			if(whichPart)
			{
				super.add(truePart);
			}
			else if(falsePart != null) // just display nothing if no falsePart
				super.add(falsePart);
		}
	}
}
