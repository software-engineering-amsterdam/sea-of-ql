package org.uva.sea.ql.visitor.ui.widgets;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class BaseWidget extends JPanel {
	
	private static final long serialVersionUID = 2829680059832940319L;

	public BaseWidget(String description) {
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
		c.anchor = GridBagConstraints.EAST;
		c.fill = GridBagConstraints.HORIZONTAL;
		this.add(this.getControlComponent(), c);
	}
	
	protected abstract Component getControlComponent();

}
