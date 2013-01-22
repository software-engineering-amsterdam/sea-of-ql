package ast.types;

public class Message extends Type {
	@Override
	public boolean isCompatibleTo(Type t) {
		return false;
	}
}
