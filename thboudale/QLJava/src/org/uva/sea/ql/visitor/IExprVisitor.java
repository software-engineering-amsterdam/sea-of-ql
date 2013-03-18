package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.expressions.BoolLiteral;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.expressions.IntLiteral;
import org.uva.sea.ql.ast.expressions.StrLiteral;
import org.uva.sea.ql.ast.expressions.binaryExpressions.Add;
import org.uva.sea.ql.ast.expressions.binaryExpressions.And;
import org.uva.sea.ql.ast.expressions.binaryExpressions.Div;
import org.uva.sea.ql.ast.expressions.binaryExpressions.Eq;
import org.uva.sea.ql.ast.expressions.binaryExpressions.GEq;
import org.uva.sea.ql.ast.expressions.binaryExpressions.GT;
import org.uva.sea.ql.ast.expressions.binaryExpressions.LEq;
import org.uva.sea.ql.ast.expressions.binaryExpressions.LT;
import org.uva.sea.ql.ast.expressions.binaryExpressions.Mul;
import org.uva.sea.ql.ast.expressions.binaryExpressions.NEq;
import org.uva.sea.ql.ast.expressions.binaryExpressions.Or;
import org.uva.sea.ql.ast.expressions.binaryExpressions.Sub;
import org.uva.sea.ql.ast.expressions.unaryExpressions.Neg;
import org.uva.sea.ql.ast.expressions.unaryExpressions.Not;
import org.uva.sea.ql.ast.expressions.unaryExpressions.Pos;

public interface IExprVisitor<T> {
	
	T visit(BoolLiteral ast);
	T visit(Ident ast);
	T visit(IntLiteral ast);
	T visit(StrLiteral ast);
	
	T visit(Add ast);
	T visit(And ast);
	T visit(Div ast);
	T visit(Eq ast);
	T visit(GEq ast);
	T visit(GT ast);
	T visit(LEq ast);
	T visit(LT ast);
	T visit(Mul ast);
	T visit(NEq ast);
	T visit(Or ast);
	T visit(Sub ast);
	
	T visit(Neg ast);
	T visit(Not ast);
	T visit(Pos ast);
}