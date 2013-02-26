package khosrow.uva.sea.ql.ui.controls;

import java.awt.Color;

import khosrow.uva.sea.ql.values.IntVal;
import khosrow.uva.sea.ql.values.MoneyVal;

public class InputVerifier implements IControlVisitor<Boolean> {

	private InputVerifier(){};
	
	public static Boolean Verify(Control control){
		InputVerifier verifier = new InputVerifier();
		return control.accept(verifier);
	}
	
	@Override
	public Boolean visit(IntControl widget) {
		if(IntVal.tryParse(widget.getInput()) == null){
			widget.setBorder(Color.red);
			return false;
		}
		widget.setBorder(Color.green);
		return true;
	}

	@Override
	public Boolean visit(MoneyControl widget) {
		if(MoneyVal.tryParse(widget.getInput()) == null){
			widget.setBorder(Color.red);
			return false;
		}
		widget.setBorder(Color.green);
		return true;
	}

	@Override
	public Boolean visit(StringControl widget) {
		widget.setBorder(Color.green);
		return true;
	}

	@Override
	public Boolean visit(BoolControl widget) {
		return true;
	}

}
