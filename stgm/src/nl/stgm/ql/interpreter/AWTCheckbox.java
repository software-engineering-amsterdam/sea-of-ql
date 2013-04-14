package nl.stgm.ql.interpreter;

import java.awt.*;
import java.awt.event.*;

import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.ast.form.*;
import nl.stgm.ql.data.*;

public class AWTCheckbox extends Checkbox implements IUIElement, ItemListener
{
	InterpreterApplication delegate;
	String id;
	
	public AWTCheckbox(InterpreterApplication delegate, String id)
	{
		this.delegate = delegate;
		this.id = id;
		this.addItemListener(this);
	}
	
	public void update(String question, boolean value)
	{
		this.setLabel(question);
		this.setState(value);
	}

	public void itemStateChanged(ItemEvent e)
	{
		delegate.answerChanged(this.id, new Bool(getState()));
	}
}
