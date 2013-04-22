package nl.stgm.ql.interpreter.awtui;

import nl.stgm.ql.interpreter.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AWTCheckbox extends Panel implements UIElementBool
{
	UIDelegate delegate;
	String id;
	
	Label questionLabel = new Label();
	Panel buttonContainer = new Panel();
	JToggleButton yesButton = new JToggleButton("Ja");
	JToggleButton noButton = new JToggleButton("Nee");
	ButtonGroup buttonGroup = new ButtonGroup();

	public AWTCheckbox(UIDelegate delegate, String id, String label)
	{
		this.delegate = delegate;
		this.id = id;

		this.setLayout(new BorderLayout());

		this.add(questionLabel, BorderLayout.WEST);
		questionLabel.setText(label);

		this.add(buttonContainer, BorderLayout.EAST);

		buttonContainer.add(yesButton);
		buttonGroup.add(yesButton);
		
		buttonContainer.add(noButton);
		buttonGroup.add(noButton);

		yesButton.addItemListener(
			new ItemListener()
			{
				public void itemStateChanged(ItemEvent e)
				{
					checked();
				}
			}
		);
		noButton.addItemListener(
			new ItemListener()
			{
				public void itemStateChanged(ItemEvent e)
				{
					checked();
				}
			}
		);
	}
	
	public void update(boolean value)
	{
		if(value)
			buttonGroup.setSelected(yesButton.getModel(), true);
		else
			buttonGroup.setSelected(noButton.getModel(), true);
	}

	private void checked()
	{
		delegate.answerChanged(this.id, buttonGroup.getSelection() == yesButton.getModel());
	}
}
