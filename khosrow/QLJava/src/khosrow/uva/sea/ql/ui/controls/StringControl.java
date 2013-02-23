package khosrow.uva.sea.ql.ui.controls;

import khosrow.uva.sea.ql.values.StrVal;
import khosrow.uva.sea.ql.values.Value;

public class StringControl extends TextInputControl {

	@Override
	protected Control getControl() {
		return this;
	}

	@Override
	protected Value getValue() {
		return new StrVal(component.getText());
	}

	@Override
	public <T> T accept(IControlVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
