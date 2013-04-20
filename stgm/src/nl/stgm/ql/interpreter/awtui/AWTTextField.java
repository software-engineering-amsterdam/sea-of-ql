package nl.stgm.ql.interpreter.awtui;

import nl.stgm.ql.interpreter.*;

import java.awt.*;
import java.awt.event.*;

public class AWTTextField extends Panel implements UIElementText
{
	UIDelegate delegate;
	String id;
	Label label;
	TextField textField;
	
	public AWTTextField(UIDelegate delegate, String id, String label)
	{
		this.delegate = delegate;
		this.id = id;
		
		this.setLayout(new BorderLayout());
		
		this.label = new Label();
		this.add(this.label, BorderLayout.WEST);
		this.label.setText(label);
		
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
	
	public void update(String value)
	{
		textField.setText(value);
	}
	
	private void textChanged()
	{
		delegate.answerChanged(this.id, textField.getText());
	}
}
