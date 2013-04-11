package nl.stgm.ql.interpreter;

import java.awt.*;
import java.awt.event.*;

import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.ast.form.*;
import nl.stgm.ql.data.*;

public class AWTCheckbox extends Checkbox implements ItemListener
{
	ApplicationController delegate;
	Question question;
	
	public AWTCheckbox(ApplicationController delegate, Question question, Bool initialValue)
	{
		this.delegate = delegate;
		this.question = question;
		this.addItemListener(this);
		this.setLabel(question.question());
		
		if(initialValue != null)
			this.setState(initialValue.getValue());
	}
	
	public void itemStateChanged(ItemEvent e)
	{
		delegate.answerChanged(question.id(), new Bool(getState()));
	}
}
