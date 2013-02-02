package khosrow.uva.sea.ql.ast.type;

public class QlError extends Type {
	private final String message;
	
	public QlError(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public boolean isCompatibleTo(Type t) {
		return false;
	}

}
