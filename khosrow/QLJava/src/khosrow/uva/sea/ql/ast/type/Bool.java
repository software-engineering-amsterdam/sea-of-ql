package khosrow.uva.sea.ql.ast.type;

import khosrow.uva.sea.ql.values.BoolVal;
import khosrow.uva.sea.ql.values.Value;


public class Bool extends Type {

	@Override
	public Value initialize() {
		return new BoolVal(false);
	}
	
	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToBool();
	}
	
	@Override
	public boolean isCompatibleToBool() {
		return true;
	}
}
