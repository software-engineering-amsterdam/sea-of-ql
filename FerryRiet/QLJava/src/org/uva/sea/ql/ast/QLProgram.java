package org.uva.sea.ql.ast;

import org.antlr.runtime.Token;
import org.uva.sea.ql.astnodevisitor.Visitor;

public class QLProgram implements ASTNode {
	private Token  token ;
	private CompoundStatement compoundStatement;

	public QLProgram(Token token, Statement c) {
		this.token = token ;
		compoundStatement = (CompoundStatement) c;
	}
	public String getProgramName() {
		return token.getText() ;
	}
	public CompoundStatement getCompound() {
		return compoundStatement;
	}
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this) ;
	}
}
