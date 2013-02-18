package ast.type;

import ast.Type;

public class Message extends Type {
	private final String message;

	public Message(String message) {
		this.message = message;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return null;
	}

	@Override
	public boolean isCompatibleTo(Type t) {
		return false;
	}

	public String getMessage() {
		return message;
	}
}
