package khosrow.uva.sea.ql.resources;

import khosrow.uva.sea.ql.values.Value;

public class QlValueError extends Value {	
	private final String message;
	
	public QlValueError(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public int compareTo(Value value) {
		throw new UnsupportedOperationException();
	}
}
