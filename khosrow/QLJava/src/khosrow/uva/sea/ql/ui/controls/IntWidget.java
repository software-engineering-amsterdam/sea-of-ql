package khosrow.uva.sea.ql.ui.controls;

import khosrow.uva.sea.ql.values.IntVal;
import khosrow.uva.sea.ql.values.Value;

public class IntWidget extends TextInputControl {

	@Override
	protected Control getControl() {		
		return this;
	}

	@Override
	protected Value getValue() {
		return new IntVal(Integer.parseInt(component.getText()));
	}

	@Override
	public <T> T accept(IControlVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
