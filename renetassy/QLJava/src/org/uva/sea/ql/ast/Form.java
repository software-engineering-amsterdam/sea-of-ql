<<<<<<< HEAD
package org.uva.sea.ql.ast;

public class Form implements ASTNode {
	
	private Ident id;
	private Body content;

	public Form (Ident id, Body content) {
		
		this.id=id;
		this.content=content;	
	}
}
=======
package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.stmnt.Body;

public class Form implements ASTNode {
	
	private Ident id;
	private Body content;

	public Form (Ident id, Body content) {
		
		this.id=id;
		this.content=content;	
	}
}
>>>>>>> 483057f28359ecac2b999d94a928c0aaf01d2a6e
