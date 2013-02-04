package org.uva.sea.ql.parser.visitors.checkexpr;

import org.uva.sea.ql.ast.expressions.binary.bool.And;
import org.uva.sea.ql.ast.expressions.binary.bool.Eq;
import org.uva.sea.ql.ast.expressions.binary.bool.GEq;
import org.uva.sea.ql.ast.expressions.binary.bool.GT;
import org.uva.sea.ql.ast.expressions.binary.bool.LEq;
import org.uva.sea.ql.ast.expressions.binary.bool.LT;
import org.uva.sea.ql.ast.expressions.binary.bool.NEq;
import org.uva.sea.ql.ast.expressions.binary.bool.Or;
import org.uva.sea.ql.ast.expressions.binary.numeric.Add;
import org.uva.sea.ql.ast.expressions.binary.numeric.Div;
import org.uva.sea.ql.ast.expressions.binary.numeric.Mul;
import org.uva.sea.ql.ast.expressions.binary.numeric.Sub;
import org.uva.sea.ql.ast.expressions.literal.Bool;
import org.uva.sea.ql.ast.expressions.literal.Ident;
import org.uva.sea.ql.ast.expressions.literal.Int;
import org.uva.sea.ql.ast.expressions.unary.Neg;
import org.uva.sea.ql.ast.expressions.unary.Not;
import org.uva.sea.ql.ast.expressions.unary.Pos;

public interface Visitor<T> {
	
	T visit(Add ast);
	T visit(And ast);
	T visit(Div ast);
	T visit(Eq ast);
	T visit(GEq ast);
	T visit(GT ast);
	T visit(Ident ast);
	T visit(Int ast);
	T visit(LEq ast);
	T visit(LT ast);
	T visit(Mul ast);
	T visit(Neg ast);
	T visit(NEq ast);
	T visit(Not ast);
	T visit(Or ast);
	T visit(Pos ast);
	T visit(Sub ast);
	T visit(Bool ast);
	
}