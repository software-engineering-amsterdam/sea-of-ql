package khosrow.uva.sea.ql.ast.type;

import khosrow.uva.sea.ql.values.Value;

public class Numeric extends Type {
	
	@Override
	public Value initialize() {
		throw new  UnsupportedOperationException();
	}

	@Override
	public boolean isCompatibleTo(Type t) {		
		return t.isCompatibleToNumeric();
	}
	
	@Override 
	public boolean isCompatibleToNumeric() {
		return true;
	}
	
	@Override 
	public boolean isCompatibleToInt() {
		return true;
	}
	
	@Override 
	public boolean isCompatibleToMoney() {
		return true;
	}

}
