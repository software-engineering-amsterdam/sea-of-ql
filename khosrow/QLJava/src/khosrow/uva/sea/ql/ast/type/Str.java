package khosrow.uva.sea.ql.ast.type;

import khosrow.uva.sea.ql.values.StrVal;
import khosrow.uva.sea.ql.values.Value;

public class Str extends Type {

	@Override
	public Value initialize() {
		return new StrVal("");
	}
	@Override
	public boolean isCompatibleTo(Type t) {		
		return t.isCompatibleToStr();
	}
	
	@Override
	public boolean isCompatibleToStr() {
		return true;
	}
}