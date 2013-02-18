package org.uva.sea.ql.ast.statements;

import java.util.Map;

import org.antlr.runtime.Token;
import org.uva.sea.ql.ast.operatorresults.Result;
import org.uva.sea.ql.ast.operators.Expr;
import org.uva.sea.ql.ast.operators.Ident;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitor.Visitor;

public class LineStatement extends Statement {

	private final Ident lineId;
	private final Token lineString;
	private final Type lineTypeDescription;
	private final Expr lineInitalizerExpr;

	public Expr getInitalizerExpr() {
		return lineInitalizerExpr;
	}

	public LineStatement(Ident ident, Token lineStr, Type ty, Expr initExpr) {
		lineId = ident;
		lineString = lineStr;
		lineTypeDescription = ty;
		lineInitalizerExpr = initExpr;
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
		return lineTypeDescription;
	}

	public Result getTypeContainer() {
		return lineTypeDescription.getTypeContainer();
	}

	public Type getInitalizerExprType(Map<String, Statement> symbolMap) {
		return lineInitalizerExpr.typeOf(symbolMap);
	}
}
