package org.uva.sea.ql.interpreter;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.eval.BooleanValue;
import org.uva.sea.ql.eval.Eval;
import org.uva.sea.ql.eval.Value;

public class ConditionObserver implements Observer {

	private final Expression condition;
	private final State state;
	private final JPanel tru;
	private final JPanel fls;
	
	public ConditionObserver(Expression condition, State state, JPanel tru, JPanel fls) {
		this.condition = condition;
		this.state = state;
		this.tru = tru;
		this.fls = fls;
	}
	
	public void update(Observable o, Object arg) {
		Value value = condition.accept(new Eval(state.getEnvironment()));
		boolean visible = value.isDefined() && ((BooleanValue)value).getValue();
		tru.setVisible(visible);
		if (fls != null) {
			fls.setVisible(!visible);
		}
	}

}
