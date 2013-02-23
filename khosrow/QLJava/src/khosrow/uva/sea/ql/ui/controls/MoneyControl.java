package khosrow.uva.sea.ql.ui.controls;

import khosrow.uva.sea.ql.values.MoneyVal;
import khosrow.uva.sea.ql.values.Value;

public class MoneyControl extends TextInputControl {

	@Override
	protected Control getControl() {
		return this;
	}

	@Override
	protected Value getValue() {		
		return new MoneyVal(Double.parseDouble(component.getText()));
	}

	@Override
	public <T> T accept(IControlVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
