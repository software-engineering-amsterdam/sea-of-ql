package org.uva.sea.ql.ast.statements;

import org.antlr.runtime.Token;
import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.visitor.Visitor;

public class QLProgram implements ASTNode {
	private Token token;
	private CompoundStatement compoundStatement;

	public QLProgram(Token tok, Statement c) {
		token = tok;
		compoundStatement = (CompoundStatement) c;
	}

	public String getProgramName() {
		return token.getText();
	}

	public CompoundStatement getCompound() {
		return compoundStatement;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
