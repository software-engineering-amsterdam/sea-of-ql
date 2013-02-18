package org.uva.sea.ql.questionnaire.ui.swing.control;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Observable;

import javax.swing.JPanel;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.nodes.values.Value;
import org.uva.sea.ql.questionnaire.state.State;

public abstract class Control extends Observable {

	protected boolean isChangeable;
	protected JPanel controlPanel;
	protected Ident ident;
	protected State state;

	public Control(State state) {
		this.controlPanel = new JPanel(new FlowLayout());
		controlPanel.setPreferredSize(new Dimension(350,40));
		this.state = state;
	}

	public abstract void setIsChangeable(boolean changeable);

	public abstract void setValue(Value value);

	public abstract void initEventListener(Ident ident, State state);

	public JPanel getControlElement() {
		return this.controlPanel;
	}

}
