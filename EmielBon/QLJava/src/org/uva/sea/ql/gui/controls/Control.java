package org.uva.sea.ql.gui.controls;

import java.util.Observable;
import javax.swing.JComponent;

import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.eval.Value;
import org.uva.sea.ql.gui.State;

public abstract class Control extends Observable {

	private final State state;
	private final Identifier identifier;
	
	protected Control(Identifier identifier, State state) {
		this.identifier = identifier;
		this.state = state;
	}
	
	public Value getValue() {
		return state.getEnvironment().getValue(identifier);
	}
	
	public State getState() {
		return state;
	}
	
	public Identifier getIdentifier() {
		return identifier;
	}
	
	public abstract void setValue(Value value);
	public abstract JComponent getUIComponent();
	public abstract void setEnabled(boolean enable);
}
