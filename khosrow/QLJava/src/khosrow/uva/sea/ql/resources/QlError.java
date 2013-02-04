package khosrow.uva.sea.ql.resources;

import khosrow.uva.sea.ql.ast.type.Type;
import khosrow.uva.sea.ql.values.IValue;

public class QlError extends Type implements IValue {
	private final String message;
	
	public QlError(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public boolean isCompatibleTo(Type t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int compareTo(IValue value) {
		// TODO Auto-generated method stub
		return 0;
	}
}
