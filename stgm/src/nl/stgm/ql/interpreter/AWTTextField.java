package nl.stgm.ql.interpreter;

import java.awt.*;
import java.awt.event.*;

public class AWTTextField extends Panel implements IUIElement
{
	InterpreterApplication delegate;
	String id;
	Label label;
	TextField textField;
	
	public AWTTextField(InterpreterApplication delegate, String id)
	{
		this.delegate = delegate;
		this.id = id;
		
		this.setLayout(new BorderLayout());
		
		this.label = new Label();
		this.add(label, BorderLayout.WEST);
		
		this.textField = new TextField(6);
		this.add(textField, BorderLayout.EAST);
		
		textField.addKeyListener(
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
		label.setText(question);
		textField.setText(value);
	}
	
	private void textChanged()
	{
		if(textField.getText().equals(""))
			delegate.answerChanged(this.id, null);
		else
			delegate.answerChanged(this.id, new Integer(textField.getText()));

	}
}
