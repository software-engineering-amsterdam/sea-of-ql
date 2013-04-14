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
		
		this.label = new Label();
		this.add(label);
		this.textField = new TextField();
		this.add(textField);
		
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
		// returning 0 for an empty field is legitimate in the domain
		int retval = 0;
		
		if(!textField.getText().equals(""))
			retval = Integer.parseInt(textField.getText());

		delegate.answerChanged(this.id, retval);
	}
}
