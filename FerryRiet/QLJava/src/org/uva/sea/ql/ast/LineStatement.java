package org.uva.sea.ql.ast;

import org.antlr.runtime.Token;
import org.uva.sea.ql.ast.literals.Result;
import org.uva.sea.ql.ast.operators.Expr;
import org.uva.sea.ql.ast.operators.Ident;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitor.Visitor;

public class LineStatement extends Statement {

	private final Ident lineId;
	private final Token lineString;
	private final Type typeDescription;
	private final Expr initalizerExpr;

	public Expr getInitalizerExpr() {
		return initalizerExpr;
	}

	public LineStatement(Ident ident, Token lineString, Type ty,
			Expr initExpr) {
		this.lineId = ident;
		this.lineString = lineString;
		typeDescription = ty;
		initalizerExpr = initExpr;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	public String getLineName() {
		return lineId.getName();
	}

	public Ident getLineId() {
		return lineId;
	}

	public int getLine() {
		return lineId.getLine();
	}

	public int getCharPositionInLine() {
		return lineId.getCharPositionInLine();
	}

	public String getDisplayText() {
		return lineString.getText();
	}

	public Type getTypeDescription() {
		return typeDescription;
	}

	public Result getTypeContainer() {
		return typeDescription.getTypeContainer();
	}
}
