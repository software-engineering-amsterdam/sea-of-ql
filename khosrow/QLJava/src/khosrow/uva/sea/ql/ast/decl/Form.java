package khosrow.uva.sea.ql.ast.decl;

import khosrow.uva.sea.ql.ast.ASTNode;
import khosrow.uva.sea.ql.ast.expr.Ident;
import khosrow.uva.sea.ql.ast.stmt.Stmts;

public class Form extends ASTNode{	
	private final Ident ident;
	private final Stmts stmts;

	public Form(Ident ident, Stmts stmts) {
		this.ident = ident;		
		this.stmts = stmts;
	}

	public Ident getIdent() {
		return ident;
	}

	public Stmts getStmts() {
		return stmts;
	}
}
