package org.uva.sea.ql.typechecker;

import org.uva.sea.ql.ast.expression.ArithmeticExpression;
import org.uva.sea.ql.ast.expression.ComparisonExpression;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.LogicalExpression;
import org.uva.sea.ql.ast.expression.UnaryExpression;
import org.uva.sea.ql.ast.expression.UnaryNumericExpression;
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
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.type.Undefined;
import org.uva.sea.ql.visitor.Environment;
import org.uva.sea.ql.visitor.IExpressionVisitor;

/**
 * Represents a type resolver for expression nodes.
 */
public class ExpressionTypeResolver extends TypeResolver implements IExpressionVisitor<Type> {
	/**
	 * Constructs a new Expression TypeResolver instance.
	 *
	 * @param environment
	 */
	public ExpressionTypeResolver( Environment environment ) {
		super( environment );
	}

	/**
	 * Visit arithmetic expression.
	 *
	 * @param node
	 *
	 * @return The type of the expression.
	 */
	private Type visitArithmetic( ArithmeticExpression node ) {
		return new org.uva.sea.ql.ast.type.Number();
	}

	/**
	 * Visit logical expression.
	 *
	 * @param node
	 *
	 * @return The type of the expression.
	 */
	private Type visitLogical( LogicalExpression node ) {
		return new org.uva.sea.ql.ast.type.Bool();
	}

	/**
	 * Visit comparison expression.
	 *
	 * @param node
	 *
	 * @return The type of the expression.
	 */
	private Type visitComparison( ComparisonExpression node ) {
		return new org.uva.sea.ql.ast.type.Bool();
	}

	/**
	 * Visit unary logical expression.
	 *
	 * @param node
	 *
	 * @return The type of the expression.
	 */
	private Type visitUnary( UnaryExpression node ) {
		return new org.uva.sea.ql.ast.type.Bool();
	}

	/**
	 * Visit unary numeric expression.
	 *
	 * @param node
	 *
	 * @return The type of the expression.
	 */
	private Type visitUnaryNumeric( UnaryNumericExpression node ) {
		return new org.uva.sea.ql.ast.type.Number();
	}

	@Override
	public Type visit( Int node ) {
		return new org.uva.sea.ql.ast.type.Int();
	}

	@Override
	public Type visit( Bool node ) {
		return new org.uva.sea.ql.ast.type.Bool();
	}

	@Override
	public Type visit( Money node ) {
		return new org.uva.sea.ql.ast.type.Money();
	}

	@Override
	public Type visit( Str node ) {
		return new org.uva.sea.ql.ast.type.Str();
	}

	@Override
	public Type visit( Ident node ) {
		if ( environment.isDeclared( node ) ) {
			return environment.lookupType( node );
		}

		return new Undefined();
	}

	@Override
	public Type visit( Add node ) {
		return this.visitArithmetic( node );
	}

	@Override
	public Type visit( Sub node ) {
		return this.visitArithmetic( node );
	}

	@Override
	public Type visit( Div node ) {
		return this.visitArithmetic( node );
	}

	@Override
	public Type visit( Mul node ) {
		return this.visitArithmetic( node );
	}

	@Override
	public Type visit( And node ) {
		return this.visitLogical( node );
	}

	@Override
	public Type visit( Or node ) {
		return this.visitLogical( node );
	}

	@Override
	public Type visit( Eq node ) {
		return this.visitComparison( node );
	}

	@Override
	public Type visit( GEq node ) {
		return this.visitComparison( node );
	}

	@Override
	public Type visit( GT node ) {
		return this.visitComparison( node );
	}

	@Override
	public Type visit( LEq node ) {
		return this.visitComparison( node );
	}

	@Override
	public Type visit( LT node ) {
		return this.visitComparison( node );
	}

	@Override
	public Type visit( NEq node ) {
		return this.visitComparison( node );
	}

	@Override
	public Type visit( Not node ) {
		return this.visitUnary( node );
	}

	@Override
	public Type visit( Pos node ) {
		return this.visitUnaryNumeric( node );
	}

	@Override
	public Type visit( Neg node ) {
		return this.visitUnaryNumeric( node );
	}
}
