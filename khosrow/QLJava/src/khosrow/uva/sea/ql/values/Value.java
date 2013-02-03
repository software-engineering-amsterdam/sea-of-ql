package khosrow.uva.sea.ql.values;

public abstract class Value<T> {
	private final T value;
	
	public Value(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}
}
