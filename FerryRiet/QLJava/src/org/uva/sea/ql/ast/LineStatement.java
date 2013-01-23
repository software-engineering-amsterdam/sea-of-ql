package org.uva.sea.ql.ast;

import org.antlr.runtime.Token;
import org.uva.sea.ql.ast.nodevisitor.Visitor;
import org.uva.sea.ql.ast.nodevisitor.VisitorResult;
import org.uva.sea.ql.ast.types.TypeDescription;

public class LineStatement extends Statement {

	private final Ident lineId;
	private final Token lineString;
	private final TypeDescription typeDescription;
	private final Expr initalizerExpr;

	public Expr getInitalizerExpr() {
		return initalizerExpr;
	}

	public LineStatement(Ident ident, Token lineString, TypeDescription ty,
			Expr initExpr) {
		this.lineId = ident;
		this.lineString = lineString;
		typeDescription = ty;
		initalizerExpr = initExpr;
	}

	@Override
	public VisitorResult accept(Visitor visitor) {
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

	public TypeDescription getTypeDescription() {
		return typeDescription;
	}
}
