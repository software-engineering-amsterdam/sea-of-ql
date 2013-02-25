package org.uva.sea.ql.visitor.eval.ui;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import org.uva.sea.ql.ast.expr.atom.Ident;
import org.uva.sea.ql.visitor.eval.Environment;
import org.uva.sea.ql.visitor.eval.ui.statement.Panel;
import org.uva.sea.ql.visitor.eval.value.AbstractValue;

public class Application extends Observable implements Observer {

	private final JFrame window;
	private final Environment environment;

	public Application(Ident id) {
		this.window = new JFrame(id.getName());
		this.window.setVisible(true);
		this.window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		this.environment = new Environment();
		this.environment.addObserver(this);
	}

	public Environment getEnvironment() {
		return this.environment;
	}

	public Data getData() {
		Map<Ident, AbstractValue> values = this.environment.getValues();
		Data data = new Data(values);

		this.constructData(data, environment);

		return data;
	}

	private void constructData(Data parent, Environment environment) {
		for (Environment child : environment.getChildren()) {
			Data data = parent.createChild(child.getValues());
			this.constructData(data, child);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		this.setChanged();
		this.notifyObservers();
	}

	public void addScrollablePanel(Panel panel) {
		JScrollPane scrollable = new JScrollPane(panel);
		this.window.add(scrollable);
		this.window.pack();
	}

}
