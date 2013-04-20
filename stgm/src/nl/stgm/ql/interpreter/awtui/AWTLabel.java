package nl.stgm.ql.interpreter.awtui;

import nl.stgm.ql.interpreter.*;

import java.awt.*;
import java.awt.event.*;

public class AWTLabel extends Panel implements UIElement
{
	String id;

	Label lblQuestion;
	Label lblAnswer;
	
	public AWTLabel(String label)
	{
		this.setLayout(new BorderLayout());

		this.lblQuestion = new Label();
		this.add(lblQuestion, BorderLayout.WEST);
		lblQuestion.setText(label);

		this.lblAnswer = new Label();
		this.add(lblAnswer, BorderLayout.EAST);
	}

	public void update(String value)
	{
		lblAnswer.setText(value);
	}
}
