package khosrow.uva.sea.ql.ast.type;

public class Numeric extends Type {

	@Override
	public boolean IsCompatibleTo(Type t) {		
		return t.IsCompatibleToNumeric();
	}
	
	@Override 
	public boolean IsCompatibleToNumeric() {
		return true;
	}
	
	@Override 
	public boolean IsCompatibleToInt() {
		return true;
	}
	
	@Override 
	public boolean IsCompatibleToMoney() {
		return true;
	}

}
