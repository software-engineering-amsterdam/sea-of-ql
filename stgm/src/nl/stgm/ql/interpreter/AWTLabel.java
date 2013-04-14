package nl.stgm.ql.interpreter;

import java.awt.*;
import java.awt.event.*;

import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.ast.form.*;
import nl.stgm.ql.data.*;

public class AWTLabel extends Label implements IUIElement
{
	InterpreterApplication delegate;
	String id;
	String question;
	
	public AWTLabel(InterpreterApplication delegate)
	{
		this.delegate = delegate;
		// this.question = question;
		// this.setText(initialValue);
	}

	public void update(String question, String value)
	{
		this.question = question;
		this.setText(value);
	}
}
