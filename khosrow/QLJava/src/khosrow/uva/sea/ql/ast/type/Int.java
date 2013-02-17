package khosrow.uva.sea.ql.ast.type;

import khosrow.uva.sea.ql.values.IntVal;
import khosrow.uva.sea.ql.values.Value;

public class Int extends Numeric {
	
	@Override
	public Value initialize() {
		return new IntVal(0);
	}
	
	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToInt();
	}
}
