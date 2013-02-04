package khosrow.uva.sea.ql.ast.type;


public class Bool extends Type {

	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToBool();
	}
	
	@Override
	public boolean isCompatibleToBool() {
		return true;
	}
}
