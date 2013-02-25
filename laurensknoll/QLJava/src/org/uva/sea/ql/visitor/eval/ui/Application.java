package org.uva.sea.ql.visitor.eval.ui;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import org.uva.sea.ql.ast.expr.atom.Ident;
import org.uva.sea.ql.visitor.eval.Environment;
import org.uva.sea.ql.visitor.eval.FormData;
import org.uva.sea.ql.visitor.eval.value.AbstractValue;

public class Application extends Observable implements Observer {

	private final JFrame gui;
	private final Environment environment;

	public Application(Ident id) {
		this.gui = new JFrame(id.getName());
		this.gui.setVisible(true);
		this.gui.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		this.environment = new Environment();
		this.environment.addObserver(this);
	}

	public Environment getEnvironment() {
		return this.environment;
	}

	public FormData getFormData() {
		Map<Ident, AbstractValue> values = this.environment.getValues();
		FormData data = new FormData(values);

		this.constructFormData(data, environment);

		return data;
	}

	public void constructFormData(FormData parent, Environment environment) {
		for (Environment child : environment.getChildren()) {
			FormData data = parent.getChildFormData(child.getValues());
			this.constructFormData(data, child);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		// Persist results
		this.setChanged();
		this.notifyObservers();
	}

	public void addScrollablePanel(Panel panel) {
		JScrollPane scrollable = new JScrollPane(panel);
		this.gui.add(scrollable);
		this.gui.pack();
	}

}
