package org.uva.sea.ql.visitor.eval.ui;

import java.awt.LayoutManager;

import javax.swing.JPanel;

import org.uva.sea.ql.visitor.eval.Environment;

public class Panel extends JPanel {

	private static final long serialVersionUID = 4659697811101808530L;
	private final Environment environment;

	public Panel(Environment environment) {
		super();
		this.environment = environment;
	}

	public Panel(LayoutManager layoutManager, Environment environment) {
		super(layoutManager);
		this.environment = environment;
	}

	public Environment getEnvironment() {
		return this.environment;
	}

	public void setVisible(boolean isVisible) {
		super.setVisible(isVisible);
		this.environment.setVisible(isVisible);
	}

}
