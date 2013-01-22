package org.uva.sea.ql.ast;

import org.antlr.runtime.Token;
import org.uva.sea.ql.astnodevisitor.Visitor;
import org.uva.sea.ql.astnodevisitor.VisitorResult;

public class LineStatement extends Statement {

	private final Token lineId;
	private final Token lineString;
	private final TypeDescription typeDescription;
	private final Expr initalizerExpr;

	public Expr getInitalizerExpr() {
		return initalizerExpr;
	}

	public LineStatement(Token lineId, Token lineString, TypeDescription ty,
			Expr initExpr) {
		this.lineId = lineId;
		this.lineString = lineString;
		typeDescription = ty;
		initalizerExpr = initExpr;
	}

	@Override
	public VisitorResult accept(Visitor visitor) {
		return visitor.visit(this);
	}

	public String getLineName() {
		return lineId.getText();
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

	public TypeDescription getTypeDescription() {
		return typeDescription;
	}
}
