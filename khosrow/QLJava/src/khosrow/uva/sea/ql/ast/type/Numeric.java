package khosrow.uva.sea.ql.ast.type;

import khosrow.uva.sea.ql.values.MoneyVal;
import khosrow.uva.sea.ql.values.Value;
import khosrow.uva.sea.ql.visitor.ITypeVisitor;

public class Numeric extends Type {
	
	@Override
	public <T> T accept(ITypeVisitor<T> visitor){
		throw new  UnsupportedOperationException();
	}
	
	@Override
	public Value initialize() {
		return new MoneyVal(0);
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
