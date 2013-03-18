package org.uva.sea.ql.visitor.ui.widgets;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.uva.sea.ql.value.Value;

public abstract class Widget extends JPanel{
	
	private static final long serialVersionUID = 2829680059832940319L;

	public Widget(final String description) {
		super();
		
		this.setLayout(new GridBagLayout());
		final GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		c.anchor = GridBagConstraints.WEST;
		this.add(new JLabel(description), c);
		
		c.gridx = 1;
		c.gridy = 0;
		c.weightx = 0;
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.HORIZONTAL;
		this.add(this.createInputComponent(), c);
	}
	
	protected abstract Component createInputComponent();
	
	public abstract Value getValue();

}
