package nl.stgm.ql.interpreter;

import java.awt.*;
import java.awt.event.*;

import nl.stgm.ql.data.*;
import nl.stgm.ql.inspectors.*;

public class AWTFormController implements ItemListener
{
	ApplicationController delegate;
	Panel panel;
	
	public AWTFormController(ApplicationController delegate, InterpreterForm form)
	{
		this.delegate = delegate;
		this.panel = new Panel();
		this.panel.setPreferredSize(new Dimension(800, 600));
		this.panel.setLayout(new GridLayout(6, 1));

		// test checkbox
		Checkbox b = new Checkbox("One");
		b.addItemListener(this);
		this.panel.add(b);
	}
	
	public Panel getPanel()
	{
		return this.panel;
	}
	
	public void itemStateChanged(ItemEvent e)
	{
		System.out.println("check!");
	}
}
