package org.uva.sea.ql.ast.operators;

import java.util.Map;

import org.antlr.runtime.Token;
import org.uva.sea.ql.ast.operatorresults.Result;
import org.uva.sea.ql.ast.statements.LineStatement;
import org.uva.sea.ql.ast.statements.Statement;
import org.uva.sea.ql.ast.types.ErrorType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitor.Visitor;

public class Ident extends Expr {
	private final Token token;

	public Ident(Token token) {
		this.token = token;
	}

	public String getName() {
		return token.getText();
	}

	public int getLine() {
		return token.getLine();
	}

	public int getCharPositionInLine() {
		return token.getCharPositionInLine();
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type typeOf(Map<String, Statement> typeEnv) {
		LineStatement line = (LineStatement) typeEnv.get(this.getName());
		if (line != null) {
			return line.getTypeDescription();
		}
		return new ErrorType();
	}

	@Override
	public Result eval(Map<String, Result> symbolMap) {
		return symbolMap.get(this.getName());
	}
}
