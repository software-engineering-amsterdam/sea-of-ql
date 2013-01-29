package org.uva.sea.ql.typechecker;

import org.uva.sea.ql.ast.expression.Add;
import org.uva.sea.ql.ast.expression.And;
import org.uva.sea.ql.ast.expression.ArithmeticExpression;
import org.uva.sea.ql.ast.expression.ComparisonExpression;
import org.uva.sea.ql.ast.expression.Div;
import org.uva.sea.ql.ast.expression.Eq;
import org.uva.sea.ql.ast.expression.GEq;
import org.uva.sea.ql.ast.expression.GT;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.LEq;
import org.uva.sea.ql.ast.expression.LT;
import org.uva.sea.ql.ast.expression.LogicalExpression;
import org.uva.sea.ql.ast.expression.Mul;
import org.uva.sea.ql.ast.expression.NEq;
import org.uva.sea.ql.ast.expression.Neg;
import org.uva.sea.ql.ast.expression.Not;
import org.uva.sea.ql.ast.expression.Or;
import org.uva.sea.ql.ast.expression.Pos;
import org.uva.sea.ql.ast.expression.Sub;
import org.uva.sea.ql.ast.expression.UnaryExpression;
import org.uva.sea.ql.ast.expression.UnaryNumericExpression;
import org.uva.sea.ql.ast.expression.literal.Bool;
import org.uva.sea.ql.ast.expression.literal.Int;
import org.uva.sea.ql.ast.expression.literal.Money;
import org.uva.sea.ql.ast.expression.literal.Str;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.eval.Environment;
import org.uva.sea.ql.visitor.IExpressionVisitor;

/**
 * Represents a type resolver for expression nodes.
 */
public class ExpressionTypeResolver extends TypeResolver implements IExpressionVisitor<Type> {
	/**
	 * Holds the environment.
	 */
	private final Environment environment;

	/**
	 * Constructs a new Expression TypeResolver instance.
	 *
	 * @param environment
	 */
	public ExpressionTypeResolver( Environment environment ) {
		this.environment = environment;
	}

	/**
	 * Visit arithmetic expression.
	 *
	 * @param node
	 *
	 * @return The type of the expression.
	 */
	public Type visit( ArithmeticExpression node ) {
		return new org.uva.sea.ql.ast.type.Number();
	}

	/**
	 * Visit logical expression.
	 *
	 * @param node
	 *
	 * @return The type of the expression.
	 */
	public Type visit( LogicalExpression node ) {
		return new org.uva.sea.ql.ast.type.Bool();
	}

	/**
	 * Visit comparison expression.
	 *
	 * @param node
	 *
	 * @return The type of the expression.
	 */
	public Type visit( ComparisonExpression node ) {
		return new org.uva.sea.ql.ast.type.Bool();
	}

	/**
	 * Visit unary logical expression.
	 *
	 * @param node
	 *
	 * @return The type of the expression.
	 */
	public Type visit( UnaryExpression node ) {
		return new org.uva.sea.ql.ast.type.Bool();
	}

	/**
	 * Visit unary numeric expression.
	 *
	 * @param node
	 *
	 * @return The type of the expression.
	 */
	public Type visit( UnaryNumericExpression node ) {
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

		return new org.uva.sea.ql.ast.type.Error();
	}

	@Override
	public Type visit( Add node ) {
		return this.visit( (ArithmeticExpression) node );
	}

	@Override
	public Type visit( Sub node ) {
		return this.visit( (ArithmeticExpression) node );
	}

	@Override
	public Type visit( Div node ) {
		return this.visit( (ArithmeticExpression) node );
	}

	@Override
	public Type visit( Mul node ) {
		return this.visit( (ArithmeticExpression) node );
	}

	@Override
	public Type visit( And node ) {
		return this.visit( (LogicalExpression) node );
	}

	@Override
	public Type visit( Or node ) {
		return this.visit( (LogicalExpression) node );
	}

	@Override
	public Type visit( Eq node ) {
		return this.visit( (ComparisonExpression) node );
	}

	@Override
	public Type visit( GEq node ) {
		return this.visit( (ComparisonExpression) node );
	}

	@Override
	public Type visit( GT node ) {
		return this.visit( (ComparisonExpression) node );
	}

	@Override
	public Type visit( LEq node ) {
		return this.visit( (ComparisonExpression) node );
	}

	@Override
	public Type visit( LT node ) {
		return this.visit( (ComparisonExpression) node );
	}

	@Override
	public Type visit( NEq node ) {
		return this.visit( (ComparisonExpression) node );
	}

	@Override
	public Type visit( Not node ) {
		return this.visit( (UnaryExpression) node );
	}

	@Override
	public Type visit( Pos node ) {
		return this.visit( (UnaryNumericExpression) node );
	}

	@Override
	public Type visit( Neg node ) {
		return this.visit( (UnaryNumericExpression) node );
	}
}
