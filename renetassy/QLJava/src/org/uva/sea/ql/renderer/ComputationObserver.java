package org.uva.sea.ql.renderer;

import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.statements.ComputedQuestion;
import org.uva.sea.ql.evaluation.Evaluator;
import org.uva.sea.ql.evaluation.values.Value;
import org.uva.sea.ql.renderer.control.Control;


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
		
		Value v = Evaluator.eval(computedQuestion.getExpr(),state.getEnv());
		state.putValue(computedQuestion.getID().getName(), v);
		
		
		
		//state.getObservables().get(computedQuestion.getID().getName()).notifyObservers();
		
		state.notify(computedQuestion.getID().getName());
		
		ctrl.setValue(v);
		
		
		 
		
		System.out.println("update computation" + computedQuestion.getID().getName() );
		
	}

}
