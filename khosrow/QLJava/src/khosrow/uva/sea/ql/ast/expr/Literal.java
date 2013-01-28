package khosrow.uva.sea.ql.ast.expr;

public abstract class Literal<T> extends Expr{
	private final T value;
	
	public Literal(T value)
	{
		this.value = value;
	}

	public T getValue() {
		return value;
	}
}
