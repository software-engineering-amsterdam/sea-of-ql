package org.uva.sea.ql.ast.visitor;

import org.uva.sea.ql.ast.expression.Add;
import org.uva.sea.ql.ast.expression.And;
import org.uva.sea.ql.ast.expression.BoolLiteral;
import org.uva.sea.ql.ast.expression.Div;
import org.uva.sea.ql.ast.expression.Eq;
import org.uva.sea.ql.ast.expression.GEq;
import org.uva.sea.ql.ast.expression.GT;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.IntLiteral;
import org.uva.sea.ql.ast.expression.LEq;
import org.uva.sea.ql.ast.expression.LT;
import org.uva.sea.ql.ast.expression.Mul;
import org.uva.sea.ql.ast.expression.NEq;
import org.uva.sea.ql.ast.expression.Neg;
import org.uva.sea.ql.ast.expression.Not;
import org.uva.sea.ql.ast.expression.Or;
import org.uva.sea.ql.ast.expression.Pos;
import org.uva.sea.ql.ast.expression.StrLiteral;
import org.uva.sea.ql.ast.expression.Sub;

public interface ExpressionVisitor<T> {
	/* binary operators */
	T visit(Add ast);
	T visit(Sub ast);
	T visit(Mul ast);
	T visit(Div ast);
	T visit(And ast);
	T visit(Or ast);
	T visit(LT ast);
	T visit(LEq ast);
	T visit(Eq ast);
	T visit(NEq ast);
	T visit(GEq ast);
	T visit(GT ast);
	
	/* unary operators */
	T visit(Pos ast);
	T visit(Neg ast);
	T visit(Not ast);
	
	/* leaf nodes */
	T visit(Ident ast);
	T visit(IntLiteral ast);
	T visit(StrLiteral ast);
	T visit(BoolLiteral ast);
}
