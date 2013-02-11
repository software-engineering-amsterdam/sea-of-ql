package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.arithmetic.Add;
import org.uva.sea.ql.ast.expression.arithmetic.Div;
import org.uva.sea.ql.ast.expression.arithmetic.Mul;
import org.uva.sea.ql.ast.expression.arithmetic.Sub;
import org.uva.sea.ql.ast.expression.comparison.Eq;
import org.uva.sea.ql.ast.expression.comparison.GEq;
import org.uva.sea.ql.ast.expression.comparison.GT;
import org.uva.sea.ql.ast.expression.comparison.LEq;
import org.uva.sea.ql.ast.expression.comparison.LT;
import org.uva.sea.ql.ast.expression.comparison.NEq;
import org.uva.sea.ql.ast.expression.literal.Bool;
import org.uva.sea.ql.ast.expression.literal.Int;
import org.uva.sea.ql.ast.expression.literal.Money;
import org.uva.sea.ql.ast.expression.literal.Str;
import org.uva.sea.ql.ast.expression.logical.And;
import org.uva.sea.ql.ast.expression.logical.Or;
import org.uva.sea.ql.ast.expression.unary.Neg;
import org.uva.sea.ql.ast.expression.unary.Not;
import org.uva.sea.ql.ast.expression.unary.Pos;

public interface ExpressionVisitor<T> {

	// Arithmetic expressions

	T visit( Add node );
	T visit( Sub node );
	T visit( Div node );
	T visit( Mul node );

	// Binary Logical expressions

	T visit( And node );
	T visit( Or node );

	// Comparison expressions

	T visit( Eq node );
	T visit( GEq node );
	T visit( GT node );
	T visit( LEq node );
	T visit( LT node );
	T visit( NEq node );

	// Unary logical expressions

	T visit( Not node );

	// Unary numeric expressions

	T visit( Pos node );
	T visit( Neg node );

	// Literal expressions

	T visit( Int node );
	T visit( Bool node );
	T visit( Money node );
	T visit( Str node );
	T visit( Ident node );
}
