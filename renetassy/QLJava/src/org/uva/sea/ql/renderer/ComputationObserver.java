package org.uva.sea.ql.renderer;

import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.Evaluator;
import org.uva.sea.ql.ast.stmnt.ComputedQuestion;
import org.uva.sea.ql.renderer.control.Control;
import org.uva.sea.ql.values.Value;

public class ComputationObserver implements Observer {
	
	private final ComputedQuestion computedQuestion;
	private final Control ctrl;
	private final State state;
	
	public ComputationObserver(ComputedQuestion computedQuestion, Control ctrl, State state) {

		this.computedQuestion = computedQuestion;
		this.ctrl = ctrl;
		this.state = state;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		
		System.out.println("apoel");
		
		Value v = Evaluator.eval(computedQuestion.getExpr(),state.getEnv());
		state.putValue(computedQuestion.getID().getName(), v);
		
		state.getObservables().get(computedQuestion.getID().getName()).notifyObservers();
		
		ctrl.setValue(v);
		
	}

}
