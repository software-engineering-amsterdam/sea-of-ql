package org.uva.sea.ql.ast;

public interface ASTNodeVisitor {
	void visit(Pos node);
	void visit(Neg node);
	void visit(Not node);
	void visit(Mul node);
	void visit(Div node);
	void visit(Add node);
	void visit(Sub node);
	void visit(Eq node);
	void visit(NEq node);
	void visit(GT node);
	void visit(LT node);
	void visit(GEq node);
	void visit(LEq node);
	void visit(And node);
	void visit(Or node);
	void visit(Ident node);
	void visit(Int node);
	void visit(Bool node);
}
