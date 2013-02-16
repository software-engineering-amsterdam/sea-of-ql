package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.literal.*;
import org.uva.sea.ql.ast.operators.logical.*;
import org.uva.sea.ql.ast.operators.numeric.*;
import org.uva.sea.ql.ast.operators.relational.*;

public interface ExpressionVisitor<T> {

	T visit(Add ast);
	T visit(And ast);
	T visit(BooleanLiteral ast);
	T visit(Div ast);
	T visit(Eq ast);
	T visit(GEq ast);
	T visit(GT ast);
	T visit(Identifier ast);
	T visit(IntegerLiteral ast);
	T visit(LEq ast);
	T visit(LT ast);
	T visit(Mul ast);
	T visit(Neg ast);
	T visit(NEq ast);
	T visit(Not ast);
	T visit(Or ast);
	T visit(Pos ast);
	T visit(StringLiteral ast);
	T visit(Sub ast);
	
}
