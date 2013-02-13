package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.expression.IdentifierExpression;
import org.uva.sea.ql.ast.expression.binary.arithmetic.AddExpression;
import org.uva.sea.ql.ast.expression.binary.arithmetic.DivideExpression;
import org.uva.sea.ql.ast.expression.binary.arithmetic.MultiplyExpression;
import org.uva.sea.ql.ast.expression.binary.arithmetic.SubtractExpression;
import org.uva.sea.ql.ast.expression.binary.comparison.EqualExpression;
import org.uva.sea.ql.ast.expression.binary.comparison.GreaterThanExpression;
import org.uva.sea.ql.ast.expression.binary.comparison.GreaterThanOrEqualExpression;
import org.uva.sea.ql.ast.expression.binary.comparison.LesserThanExpression;
import org.uva.sea.ql.ast.expression.binary.comparison.LesserThanOrEqualExpression;
import org.uva.sea.ql.ast.expression.binary.comparison.NotEqualExpression;
import org.uva.sea.ql.ast.expression.binary.logical.AndExpression;
import org.uva.sea.ql.ast.expression.binary.logical.OrExpression;
import org.uva.sea.ql.ast.expression.literal.BooleanLiteral;
import org.uva.sea.ql.ast.expression.literal.IntegerLiteral;
import org.uva.sea.ql.ast.expression.literal.MoneyLiteral;
import org.uva.sea.ql.ast.expression.literal.StringLiteral;
import org.uva.sea.ql.ast.expression.unary.logical.NotExpression;
import org.uva.sea.ql.ast.expression.unary.numeric.NegativeExpression;
import org.uva.sea.ql.ast.expression.unary.numeric.PositiveExpression;

public interface ExpressionVisitor<T> {

	// Arithmetic expressions

	T visit( AddExpression node );
	T visit( SubtractExpression node );
	T visit( DivideExpression node );
	T visit( MultiplyExpression node );

	// Binary Logical expressions

	T visit( AndExpression node );
	T visit( OrExpression node );

	// Comparison expressions

	T visit( EqualExpression node );
	T visit( GreaterThanOrEqualExpression node );
	T visit( GreaterThanExpression node );
	T visit( LesserThanOrEqualExpression node );
	T visit( LesserThanExpression node );
	T visit( NotEqualExpression node );

	// Unary logical expressions

	T visit( NotExpression node );

	// Unary numeric expressions

	T visit( PositiveExpression node );
	T visit( NegativeExpression node );

	// Literal expressions

	T visit( IntegerLiteral node );
	T visit( BooleanLiteral node );
	T visit( MoneyLiteral node );
	T visit( StringLiteral node );

	// Identifier expression

	T visit( IdentifierExpression node );
}
