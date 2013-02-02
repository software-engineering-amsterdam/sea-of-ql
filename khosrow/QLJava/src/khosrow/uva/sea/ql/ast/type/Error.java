package khosrow.uva.sea.ql.ast.type;

public class Error extends Type {
	private final String message;
	
	public Error(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public boolean IsCompatibleTo(Type t) {
		return false;
	}

}
