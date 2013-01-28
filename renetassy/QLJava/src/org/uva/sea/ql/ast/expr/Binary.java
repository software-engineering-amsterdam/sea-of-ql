<<<<<<< HEAD:renetassy/QLJava/src/org/uva/sea/ql/ast/Binary.java
package org.uva.sea.ql.ast;

public class Binary extends Expr {
	
	private Expr lhs;
	private Expr rhs;
	
	public Binary (Expr lhs, Expr rhs) {
		this.lhs=lhs;
		this.rhs=rhs;
	}
	
	protected Expr getLeft() {	
		return lhs;
	}
	
	protected Expr getRight() {
		return rhs;
	}
}
=======
package org.uva.sea.ql.ast.expr;

public class Binary extends Expr {
	
	private Expr lhs;
	private Expr rhs;
	
	public Binary (Expr lhs, Expr rhs) {
		this.lhs=lhs;
		this.rhs=rhs;
	}
	
	protected Expr getLeft() {	
		return lhs;
	}
	
	protected Expr getRight() {
		return rhs;
	}
}
>>>>>>> 483057f28359ecac2b999d94a928c0aaf01d2a6e:renetassy/QLJava/src/org/uva/sea/ql/ast/expr/Binary.java
