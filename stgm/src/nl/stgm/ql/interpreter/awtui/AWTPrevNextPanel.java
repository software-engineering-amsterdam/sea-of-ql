package nl.stgm.ql.interpreter.awtui;

import nl.stgm.ql.interpreter.*;

import java.awt.*;
import java.awt.event.*;

public class AWTPrevNextPanel extends Panel
{
	final PagedUIDelegate delegate;
	
	public AWTPrevNextPanel(final PagedUIDelegate delegate)
	{
		this.delegate = delegate;
		this.setLayout(new GridLayout(1,2,10,0));

		Button prevButton = new Button("Previous");
		prevButton.addActionListener(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					delegate.previousClicked();
				}
			}
		);
		this.add(prevButton, BorderLayout.SOUTH);

		Button nextButton = new Button("Next");
		nextButton.addActionListener(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					delegate.nextClicked();
				}
			}
		);
		this.add(nextButton, BorderLayout.SOUTH);
	}
}
