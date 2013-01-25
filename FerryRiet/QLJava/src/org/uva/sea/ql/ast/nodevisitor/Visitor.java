package org.uva.sea.ql.ast.nodevisitor;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.operators.Add;
import org.uva.sea.ql.ast.operators.And;
import org.uva.sea.ql.ast.operators.Div;
import org.uva.sea.ql.ast.operators.Eq;
import org.uva.sea.ql.ast.operators.GEq;
import org.uva.sea.ql.ast.operators.GT;
import org.uva.sea.ql.ast.operators.LEq;
import org.uva.sea.ql.ast.operators.LT;
import org.uva.sea.ql.ast.operators.Mul;
import org.uva.sea.ql.ast.operators.NEq;
import org.uva.sea.ql.ast.operators.Neg;
import org.uva.sea.ql.ast.operators.Not;
import org.uva.sea.ql.ast.operators.Or;
import org.uva.sea.ql.ast.operators.Pos;
import org.uva.sea.ql.ast.operators.Sub;
import org.uva.sea.ql.ast.types.TypeDescription;

public interface Visitor {
	VisitorResult visit(Expr expr);

	VisitorResult visit(BinExpr expr);

	VisitorResult visit(Ident expr);

	VisitorResult visit(IntLiteral expr);

	VisitorResult visit(StringLiteral expr);

	VisitorResult visit(BooleanLiteral expr);

	VisitorResult visit(Add expr);

	VisitorResult visit(Mul expr);

	VisitorResult visit(Div expr);

	VisitorResult visit(Sub expr);

	VisitorResult visit(And expr);

	VisitorResult visit(Or expr);

	VisitorResult visit(Eq expr);

	VisitorResult visit(GT expr);

	VisitorResult visit(LT expr);

	VisitorResult visit(LEq expr);

	VisitorResult visit(NEq expr);

	VisitorResult visit(GEq expr);

	VisitorResult visit(UnExpr expr);

	VisitorResult visit(Not expr);

	VisitorResult visit(Neg expr);

	VisitorResult visit(Pos expr);

	VisitorResult visit(QLProgram qlProgram);

	VisitorResult visit(CompoundStatement compoundBlock);

	VisitorResult visit(LineStatement lineStatement);

	VisitorResult visit(ConditionalStatement conditionalStatement);

	VisitorResult visit(TypeDescription typeDescription);
}
