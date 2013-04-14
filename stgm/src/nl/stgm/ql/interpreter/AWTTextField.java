package nl.stgm.ql.interpreter;

import java.awt.*;
import java.awt.event.*;

import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.ast.form.*;
import nl.stgm.ql.data.*;

public class AWTTextField extends TextField implements IUIElement
{
	InterpreterApplication delegate;
	String id;
	
	public AWTTextField(InterpreterApplication delegate, String id)
	{
		this.delegate = delegate;
		this.id = id;
		
		this.addKeyListener(
			new KeyAdapter()
			{
				public void keyReleased(KeyEvent e)
				{
					textChanged();
				}
			}
		);
	}
	
	public void update(String question, String value)
	{
		// label.setText(value);
		this.setText(value);
	}
	
	private void textChanged()
	{
		System.out.println(this.id);

		if(!getText().equals(""))
			delegate.answerChanged(this.id, new Int(Integer.parseInt(getText())));
	}
}
