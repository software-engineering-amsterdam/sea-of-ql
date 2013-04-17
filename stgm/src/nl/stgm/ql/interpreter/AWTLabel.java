package nl.stgm.ql.interpreter;

import java.awt.*;
import java.awt.event.*;

public class AWTLabel extends Panel implements IUIElement
{
	String id;

	Label lblQuestion;
	Label lblAnswer;
	
	public AWTLabel(InterpreterApplication delegate)
	{
		this.setLayout(new BorderLayout());

		this.lblQuestion = new Label();
		this.lblAnswer = new Label();
		this.add(lblQuestion, BorderLayout.WEST);
		this.add(lblAnswer, BorderLayout.EAST);
	}

	public void update(String question, String value)
	{
		lblQuestion.setText(question);
		lblAnswer.setText(value);
	}
}
