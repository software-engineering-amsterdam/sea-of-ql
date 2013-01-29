package ast.type;

public class Money extends Numeric {
	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToMoney();
	}
}
