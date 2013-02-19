package khosrow.uva.sea.ql.ast.decl;

import khosrow.uva.sea.ql.ast.ASTNode;
import khosrow.uva.sea.ql.ast.expr.Ident;
import khosrow.uva.sea.ql.ast.stmt.Stmts;

public class Form extends ASTNode{	
	private final Ident name;
	private final Stmts stmts;

	public Form(Ident name, Stmts stmts) {
		this.name = name;		
		this.stmts = stmts;
	}

	public Ident getName() {
		return name;
	}

	public Stmts getStmts() {
		return stmts;
	}
}
