package nl.stgm.ql.interpreter;

import java.awt.*;
import java.awt.event.*;

public class AWTCheckbox extends Checkbox implements IUIElement
{
	InterpreterApplication delegate;
	String id;
	
	public AWTCheckbox(InterpreterApplication delegate, String id)
	{
		this.delegate = delegate;
		this.id = id;

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
	
	public void update(String question, boolean value)
	{
		this.setLabel(question);
		this.setState(value);
	}

	private void checked()
	{
		delegate.answerChanged(this.id, getState());
	}
}
