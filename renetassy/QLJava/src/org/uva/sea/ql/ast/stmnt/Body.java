<<<<<<< HEAD:renetassy/QLJava/src/org/uva/sea/ql/ast/Body.java
package org.uva.sea.ql.ast;

import java.util.List;

public class Body {
	
	private List<Statement> statements;
	
	public Body (List<Statement> statements) {
		this.statements=statements;
	}
	
}
=======
package org.uva.sea.ql.ast.stmnt;

import java.util.List;

public class Body extends Statement {
	
	private List<Statement> statements;
	
	public Body (List<Statement> statements) {
		this.statements=statements;
	}
	
}
>>>>>>> 483057f28359ecac2b999d94a928c0aaf01d2a6e:renetassy/QLJava/src/org/uva/sea/ql/ast/stmnt/Body.java
