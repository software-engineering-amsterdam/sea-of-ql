package org.uva.sea.ql.ast;

import org.antlr.runtime.Token;
import org.uva.sea.ql.astnodevisitor.Visitor;

public class LineStatement extends Statement {

	private final Token lineId;
	private final Token lineString;
	private final TypeDescription typeDescription;

	public LineStatement(Token lineId, Token lineString, TypeDescription ty) {
		this.lineId = lineId;
		this.lineString = lineString;
		typeDescription = ty;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
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
