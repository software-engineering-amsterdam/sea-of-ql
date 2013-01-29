package org.uva.sea.ql.visitor.print;

public class Environment {

	private final String indent;
	private final Environment parent;

	public Environment() {
		this.parent = null;
		this.indent = "";
	}

	public Environment(Environment env) {
		if (env == null) {
			throw new IllegalArgumentException("Environment is required");
		}

		this.parent = env;
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
