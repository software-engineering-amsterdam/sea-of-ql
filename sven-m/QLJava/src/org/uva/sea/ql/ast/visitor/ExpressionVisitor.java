package org.uva.sea.ql.ast.visitor;

import org.uva.sea.ql.ast.expressions.Add;
import org.uva.sea.ql.ast.expressions.And;
import org.uva.sea.ql.ast.expressions.Bool;
import org.uva.sea.ql.ast.expressions.Div;
import org.uva.sea.ql.ast.expressions.Eq;
import org.uva.sea.ql.ast.expressions.GEq;
import org.uva.sea.ql.ast.expressions.GT;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.expressions.Int;
import org.uva.sea.ql.ast.expressions.LEq;
import org.uva.sea.ql.ast.expressions.LT;
import org.uva.sea.ql.ast.expressions.Mul;
import org.uva.sea.ql.ast.expressions.NEq;
import org.uva.sea.ql.ast.expressions.Neg;
import org.uva.sea.ql.ast.expressions.Not;
import org.uva.sea.ql.ast.expressions.Or;
import org.uva.sea.ql.ast.expressions.Pos;
import org.uva.sea.ql.ast.expressions.Str;
import org.uva.sea.ql.ast.expressions.Sub;

public interface ExpressionVisitor<T> {
	/* binary operators */
	T visit(Add ast);
	T visit(Mul ast);
	T visit(Div ast);
	T visit(Sub ast);
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
	T visit(Int ast);
	T visit(Str ast);
	T visit(Bool ast);
}
