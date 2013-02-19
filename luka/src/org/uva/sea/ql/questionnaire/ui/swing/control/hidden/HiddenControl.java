package org.uva.sea.ql.questionnaire.ui.swing.control.hidden;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.nodes.values.Value;
import org.uva.sea.ql.questionnaire.State;
import org.uva.sea.ql.questionnaire.ui.swing.control.AbstractControl;

public class HiddenControl extends AbstractControl {

	//hidden control
	public HiddenControl(State state, Ident ident) {
		super(state, ident);

	}

	@Override
	public void setValue(Value value) {
		setChanged();
		this.state.putValue(this.ident, value);
		this.state.notify(ident);
	}

}
