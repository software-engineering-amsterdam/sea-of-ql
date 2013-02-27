package khosrow.uva.sea.ql.ui;

import java.util.Observable;
import java.util.Observer;

import khosrow.uva.sea.ql.ast.stmt.Label;
import khosrow.uva.sea.ql.ui.controls.Control;
import khosrow.uva.sea.ql.values.Value;
import khosrow.uva.sea.ql.visitor.eval.ExprEvaluator;

public class ComputedObserver implements Observer {	
	private final Label stmt;
	private final State state;
	private final Control control;
	
	public ComputedObserver(Label stmt, State state, Control control) {
		this.stmt = stmt;
		this.state = state;
		this.control = control;		
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		Value value = ExprEvaluator.Evaluate(stmt.getExpr(), state.getEnv());
		state.assignValue(stmt.getIdent(), value);
		control.setValue(value);		
	}

}
