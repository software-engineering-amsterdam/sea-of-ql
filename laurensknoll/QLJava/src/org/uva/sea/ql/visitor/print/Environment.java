package org.uva.sea.ql.visitor.print;

public class Environment {

	private final String indent;
	private final Environment parent;

	public Environment() {
		this.parent = null;
		this.indent = "";
	}

	public Environment(Environment environment) {
		if (environment == null) {
			throw new IllegalArgumentException(
					"Use constructor without arguments for a new Environment.");
		}

		this.parent = environment;
		this.indent = "  ";
	}

	public Environment getParent() {
		return this.parent;
	}

	public String getIndent() {
		if (this.parent != null) {
			return String.format("%s%s", this.parent.getIndent(), this.indent);
		} else {
			return this.indent;
		}
	}

}
