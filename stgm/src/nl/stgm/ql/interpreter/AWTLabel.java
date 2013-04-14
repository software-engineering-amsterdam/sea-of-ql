package nl.stgm.ql.interpreter;

import java.awt.*;
import java.awt.event.*;

public class AWTLabel extends Label implements IUIElement
{
	InterpreterApplication delegate;
	String id;
	String question;
	
	public AWTLabel(InterpreterApplication delegate)
	{
		this.delegate = delegate;
	}

	public void update(String question, String value)
	{
		this.question = question;
		this.setText(value);
	}
}
