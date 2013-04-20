package nl.stgm.ql.interpreter.awtui;

import nl.stgm.ql.interpreter.*;

import java.awt.*;
import java.awt.event.*;

public class AWTCheckbox extends Checkbox implements UIElementBool
{
	UIDelegate delegate;
	String id;
	
	public AWTCheckbox(UIDelegate delegate, String id, String label)
	{
		this.delegate = delegate;
		this.id = id;
		this.setLabel(label);

		this.addItemListener(
			new ItemListener()
			{
				public void itemStateChanged(ItemEvent e)
				{
					checked();
				}
			}
		);
	}
	
	public void update(boolean value)
	{
		this.setState(value);
	}

	private void checked()
	{
		delegate.answerChanged(this.id, getState());
	}
}
