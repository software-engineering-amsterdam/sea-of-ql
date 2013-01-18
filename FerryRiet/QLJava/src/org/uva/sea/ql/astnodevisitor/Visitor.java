package org.uva.sea.ql.astnodevisitor;

import org.uva.sea.ql.ast.*;

public interface Visitor {
	void visit(Expr expr) ;
	void visit(BinExpr expr) ;
	void visit(UnExpr expr) ;
	void visit(QLProgram qlProgram) ;
	void visit(CompoundStatement compoundBlock) ;
	void visit(LineStatement lineStatement) ;
	void visit(ConditionalStatement conditionalStatement) ;
	void visit(TypeDescription typeDescription) ;
}
