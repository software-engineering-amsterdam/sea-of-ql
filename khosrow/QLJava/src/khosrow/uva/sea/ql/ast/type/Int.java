package khosrow.uva.sea.ql.ast.type;

public class Int extends Numeric {
	
	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToInt();
	}
}
