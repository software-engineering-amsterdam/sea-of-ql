package org.uva.sea.ql.ui.observing;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.interpreter.BoolVal;
import org.uva.sea.ql.interpreter.Env;
import org.uva.sea.ql.ui.components.BaseComponent;

public class ConditionObserver implements Observer {

	private final Expr condition;
	private final Env env;
	private final List<BaseComponent> conditionFalse;
	private final List<BaseComponent> conditionTrue;
	
	
	public ConditionObserver(Expr condition, List<BaseComponent> conditionFalse, List<BaseComponent> conditionTrue,  Env env) {
		this.condition = condition;
		this.env = env;
		this.conditionFalse = conditionFalse;
		this.conditionTrue = conditionTrue;
		//Call update to show initial state. 
		update(null, null);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		BoolVal val = (BoolVal)condition.eval(env);
		for(BaseComponent component : conditionTrue) {
			component.setVisible(val.getValue());
		}

		for(BaseComponent component : conditionFalse) {
			component.setVisible(!val.getValue());
		}
	}

}
