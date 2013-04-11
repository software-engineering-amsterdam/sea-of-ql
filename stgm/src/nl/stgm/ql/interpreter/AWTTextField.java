package nl.stgm.ql.interpreter;

import java.awt.*;
import java.awt.event.*;

import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.ast.form.*;
import nl.stgm.ql.data.*;

public class AWTTextField extends TextField
{
	ApplicationController delegate;
	Question question;
	
	public AWTTextField(ApplicationController delegate, Question question, Int initialValue)
	{
		this.delegate = delegate;
		this.question = question;
		
		this.addKeyListener(
			new KeyAdapter()
			{
				public void keyReleased(KeyEvent e)
				{
					textChanged();
				}
			}
		);
		
		if(initialValue != null)
			this.setText(Integer.toString(initialValue.getValue()));
	}
	
	private void textChanged()
	{
		System.out.println(question.id());

		if(!getText().equals(""))
			delegate.answerChanged(question.id(), new Int(Integer.parseInt(getText())));
	}
}
