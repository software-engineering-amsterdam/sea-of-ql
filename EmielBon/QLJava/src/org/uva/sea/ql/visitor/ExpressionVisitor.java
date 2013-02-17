package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.literal.*;
import org.uva.sea.ql.ast.operators.logical.*;
import org.uva.sea.ql.ast.operators.numeric.*;
import org.uva.sea.ql.ast.operators.relational.*;

public interface ExpressionVisitor<T> {

	// Numeric operators
	T visit(Add ast);
	T visit(Div ast);
	T visit(Mul ast);
	T visit(Neg ast);
	T visit(Pos ast);
	T visit(Sub ast);
	
	// Logical operators
	T visit(And ast);
	T visit(Not ast);
	T visit(Or ast);
	
	// Relational operators
	T visit(Eq ast);
	T visit(GEq ast);
	T visit(GT ast);
	T visit(LEq ast);
	T visit(LT ast);
	T visit(NEq ast);
	
	// Identifier
	T visit(Identifier ast);
	
	// Literals
	T visit(BooleanLiteral ast);
	T visit(IntegerLiteral ast);
	T visit(StringLiteral ast);
	
}
