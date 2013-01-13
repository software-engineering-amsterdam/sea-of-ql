package org.uva.sea.ql.ast;

import org.antlr.runtime.Token;
import org.uva.sea.ql.astvisitor.ASTNodeVisitor;

public class QLProgram implements ASTNode {
	public String programName;
	public CompoundBlock compound;

	public QLProgram(Token tk, CompoundBlock c) {
		programName = tk.getText();
		compound = c;
	}
	@Override
	public void eval() {
		System.out.println("form: " + programName) ;
		compound.eval() ;
	}
	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this) ;
	}
}
