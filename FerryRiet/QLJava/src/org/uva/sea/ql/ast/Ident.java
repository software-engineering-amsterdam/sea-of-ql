package org.uva.sea.ql.ast;

import java.util.HashMap;

import org.antlr.runtime.Token;
import org.uva.sea.ql.ast.nodevisitor.Visitor;
import org.uva.sea.ql.ast.nodevisitor.VisitorResult;
import org.uva.sea.ql.ast.operators.ExpressionResult;
import org.uva.sea.ql.ast.types.ErrorType;
import org.uva.sea.ql.ast.types.TypeDescription;

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
	public VisitorResult accept(Visitor visitor) {
		return visitor.visit(this);
	}

	@Override
	public TypeDescription typeOf(HashMap<String, Statement> typeEnv) {
		LineStatement line = (LineStatement) typeEnv.get(this.getName());
		if (line != null) {
			return line.getTypeDescription();
		}
		return new ErrorType();
	}

	@Override
	public ExpressionResult eval(HashMap<String, ExpressionResult> symbolMap) {
		return symbolMap.get(this.getName());
	}
}
