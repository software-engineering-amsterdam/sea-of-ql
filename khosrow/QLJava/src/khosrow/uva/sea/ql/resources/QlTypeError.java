package khosrow.uva.sea.ql.resources;

import khosrow.uva.sea.ql.ast.type.Type;

public class QlTypeError extends Type {
	private final String message;
	
	public QlTypeError(String message) {
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
}
