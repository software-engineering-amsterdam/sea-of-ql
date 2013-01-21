package org.uva.sea.ql.ast;

import org.antlr.runtime.Token;
import org.uva.sea.ql.astnodevisitor.Visitor;
import org.uva.sea.ql.astnodevisitor.VisitorResult;

public class Ident extends Expr {
	private final Token token;

	public Ident(Token token) {
		super(new LookUpType());
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
	public VisitorResult accept(Visitor astNodeVisitor) {
		// TODO Auto-generated method stub
		return null;
	}

}
