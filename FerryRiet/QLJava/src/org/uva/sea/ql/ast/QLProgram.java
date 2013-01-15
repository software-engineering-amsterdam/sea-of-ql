package org.uva.sea.ql.ast;

import org.antlr.runtime.Token;
import org.uva.sea.ql.astvisitor.ASTNodeVisitor;

public class QLProgram implements ASTNode {
	private String programName;
	private CompoundStatement compound;

	public QLProgram(Token tk, Statement c) {
		programName = tk.getText();
		compound = (CompoundStatement) c;
	}
	public String getProgramName() {
		return programName;
	}
	public CompoundStatement getCompound() {
		return compound;
	}
	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this) ;
	}
}
