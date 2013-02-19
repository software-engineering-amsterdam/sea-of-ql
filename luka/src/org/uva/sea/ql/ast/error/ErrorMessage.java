package org.uva.sea.ql.ast.error;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.stat.Stat;

public class ErrorMessage {

	private final String errorMessage;
	private Expr expression;
	private Stat statement;

	public ErrorMessage(Expr ex, String message) {
		this.expression = ex;
		this.errorMessage = message;
	}

	public ErrorMessage(Stat stat, String message) {
		this.statement = stat;
		this.errorMessage = message;
	}

	public String getErrorMeesage() {
		String errorSource = (this.expression != null) ? "Expr: "
				+ this.expression.toString() : "Stat: "
				+ this.statement.toString();
		return "Error: '" + this.errorMessage + "' in " + errorSource;
	}

	@Override
	public String toString() {
		String errorSource = (this.expression != null) ? this.expression
				.toString() : this.statement.toString();
		return this.errorMessage + "' in " + errorSource;

	}
}
