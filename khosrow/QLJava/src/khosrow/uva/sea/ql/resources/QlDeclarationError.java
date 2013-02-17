package khosrow.uva.sea.ql.resources;

public class QlDeclarationError {
	private final String message;
	
	public QlDeclarationError(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
