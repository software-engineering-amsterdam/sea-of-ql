package nl.stgm.ql.interpreter;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import nl.stgm.ql.data.*;
import nl.stgm.ql.inspectors.*;

public class AWTPrevNextPanel extends Panel implements ActionListener
{
	InterpreterApplication delegate;
	
	public AWTPrevNextPanel(InterpreterApplication delegate)
	{
		this.delegate = delegate;
		this.setLayout(new GridLayout(1,2,10,0));

		Button prevButton = new Button("Previous");
		prevButton.addActionListener(this);
		this.add(prevButton, BorderLayout.SOUTH);

		Button nextButton = new Button("Next");
		nextButton.addActionListener(this);
		this.add(nextButton, BorderLayout.SOUTH);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		switch(e.getActionCommand())
		{
			case "Previous":
				delegate.previousClicked();
				break;
			case "Next":
				delegate.nextClicked();
				break;
		}
	}
}
