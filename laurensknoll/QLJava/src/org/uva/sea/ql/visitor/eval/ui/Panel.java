package org.uva.sea.ql.visitor.eval.ui;

import java.awt.Component;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import org.uva.sea.ql.visitor.eval.Environment;

public class Panel extends Observable implements Observer {

	private final JPanel panel;
	private final Environment environment;

	public Panel(JPanel panel, Environment environment) {
		this.panel = panel;
		this.environment = environment;
		this.environment.addObserver(this);
	}

	public JPanel getPanel() {
		return this.panel;
	}

	public Environment getEnvironment() {
		return this.environment;
	}

	public void addPanel(Panel panel) {
		this.panel.add(panel.getPanel());
	}

	public void addComponent(Component component) {
		this.panel.add(component);
	}

	public void setVisible(boolean isVisible) {
		this.panel.setVisible(isVisible);
		this.environment.setVisible(isVisible);
	}

	@Override
	public void update(Observable o, Object arg) {
		this.setChanged();
		this.notifyObservers();
	}

}
