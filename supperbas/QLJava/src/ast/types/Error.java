package ast.types;

public class Error<T> extends Type {
	private final T ast;
	private final String str;

	public Error(T ast, String str) {
		this.ast = ast;
		this.str = str;
	}

	public Error(T ast) {
		this.ast = ast;
	}

	@Override
	public boolean isCompatibleTo(Type t) {
		return false;
	}
}
