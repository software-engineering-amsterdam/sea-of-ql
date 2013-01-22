package ast.types;

public class Ident extends Type {

	@Override
	public boolean isCompatibleTo(Type t) {
		return false;
	}
}
