package org.uva.sea.ql.form.gui.observers;

import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.form.gui.components.GUIControl;
import org.uva.sea.ql.form.gui.state.*;
import org.uva.sea.ql.form.output.visitor.QLEvalVisitor;
import org.uva.sea.ql.values.Value;

import org.uva.sea.ql.ast.nodes.statements.ComputedQuestion;

public class ComputedQuestionObserver implements Observer {
	private final GUIControl control;
	private final State state;
	private final ComputedQuestion computedQuestion;
	
	public ComputedQuestionObserver(GUIControl control, State state, ComputedQuestion computedQuestion){
		this.control = control;
		this.state = state;
		this.computedQuestion = computedQuestion;
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		Value value = computedQuestion.getExpr().accept(new QLEvalVisitor(state.getValueEnv()));
		state.putValue(computedQuestion.getIdent(), value);
		state.notify(computedQuestion.getIdent());
		control.setValue(value);
	}
}