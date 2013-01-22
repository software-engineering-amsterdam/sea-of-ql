package ast.types;

public class Error extends Type {
	@Override
	public boolean isCompatibleTo(Type t) {
		return false;
	}
}
