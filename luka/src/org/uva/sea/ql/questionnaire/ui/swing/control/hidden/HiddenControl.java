package org.uva.sea.ql.questionnaire.ui.swing.control.hidden;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.nodes.values.Value;
import org.uva.sea.ql.questionnaire.state.State;
import org.uva.sea.ql.questionnaire.ui.swing.control.AbstractControl;

public class HiddenControl extends AbstractControl {

	public HiddenControl(State state,Ident ident) {
		super(state, ident);

	}

	@Override
	public void setValue(Value value) {
		System.err.println("setting value for hiddenControl:"+value.getValue().toString());
		setChanged();
		state.putValue(this.ident, value);
		state.notify(ident);
	}

}
