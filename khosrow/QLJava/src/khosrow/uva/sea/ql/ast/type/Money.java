package khosrow.uva.sea.ql.ast.type;

public class Money extends Numeric{
	
	@Override
	public boolean IsCompatibleTo(Type t) {
		return t.IsCompatibleToMoney();
	}
}
