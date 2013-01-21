package org.uva.sea.ql.astnodevisitor;

import org.uva.sea.ql.ast.*;

public interface Visitor {
	VisitorResult visit(Expr expr) ;
	VisitorResult visit(BinExpr expr) ;
	VisitorResult visit(UnExpr expr) ;
	VisitorResult visit(QLProgram qlProgram) ;
	VisitorResult visit(CompoundStatement compoundBlock) ;
	VisitorResult visit(LineStatement lineStatement) ;
	VisitorResult visit(ConditionalStatement conditionalStatement) ;
	VisitorResult visit(TypeDescription typeDescription) ;
}
