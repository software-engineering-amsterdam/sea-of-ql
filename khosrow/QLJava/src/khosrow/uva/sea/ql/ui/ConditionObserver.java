package khosrow.uva.sea.ql.ui;

import java.util.Observable;
import java.util.Observer;

import khosrow.uva.sea.ql.ast.expr.Expr;
import khosrow.uva.sea.ql.ui.controls.Control;
import khosrow.uva.sea.ql.values.BoolVal;
import khosrow.uva.sea.ql.values.Value;
import khosrow.uva.sea.ql.visitor.eval.ExprEvaluator;

public class ConditionObserver implements Observer {
	private final Expr cond;
	private final State state;
	private final Control control;
	
	public ConditionObserver(Expr cond, State state, Control control) {
		this.cond = cond;
		this.state = state;
		this.control = control;		
	}
	
	@Override
	public void update(Observable o, Object arg) {
		Value value = ExprEvaluator.Evaluate(cond, state.getEnv());
		boolean isVisible = ((BoolVal)value).getValue();
		control.setVisible(isVisible);
	}

}
