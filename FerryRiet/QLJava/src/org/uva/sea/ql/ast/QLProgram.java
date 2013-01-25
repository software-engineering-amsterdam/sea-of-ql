package org.uva.sea.ql.ast;

import org.antlr.runtime.Token;
import org.uva.sea.ql.ast.nodevisitor.Visitor;
import org.uva.sea.ql.ast.nodevisitor.VisitorResult;

public class QLProgram implements ASTNode {
	private Token token;
	private CompoundStatement compoundStatement;

	public QLProgram(Token token, Statement c) {
		this.token = token;
		compoundStatement = (CompoundStatement) c;
	}

	public String getProgramName() {
		return token.getText();
	}

	public CompoundStatement getCompound() {
		return compoundStatement;
	}

	@Override
	public VisitorResult accept(Visitor visitor) {
		return visitor.visit(this);
	}
}
