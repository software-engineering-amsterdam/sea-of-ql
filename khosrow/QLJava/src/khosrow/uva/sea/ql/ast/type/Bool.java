package khosrow.uva.sea.ql.ast.type;


public class Bool extends Type {

	@Override
	public boolean IsCompatibleTo(Type t) {
		return t.IsCompatibleToBool();
	}
	
	@Override
	public boolean IsCompatibleToBool() {
		return true;
	}
}
