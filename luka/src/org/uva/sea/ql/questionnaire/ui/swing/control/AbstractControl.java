package org.uva.sea.ql.questionnaire.ui.swing.control;

import java.util.Observable;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.nodes.values.Value;
import org.uva.sea.ql.questionnaire.State;

public abstract class AbstractControl extends Observable {

	protected State state;
	protected Ident ident;

	public AbstractControl(State state, Ident ident) {
		this.state = state;
		this.ident = ident;
	}

	public abstract void setValue(Value value);

}
