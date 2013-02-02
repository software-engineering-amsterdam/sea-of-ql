package khosrow.uva.sea.ql.ast.type;

public class Int extends Numeric {
	
	@Override
	public boolean IsCompatibleTo(Type t) {
		return t.IsCompatibleToInt();
	}
}
