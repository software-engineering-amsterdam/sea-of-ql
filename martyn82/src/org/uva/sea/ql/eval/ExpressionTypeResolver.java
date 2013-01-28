package org.uva.sea.ql.eval;

import org.uva.sea.ql.ast.expression.ArithmeticExpression;
import org.uva.sea.ql.ast.expression.ComparisonExpression;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.LogicalExpression;
import org.uva.sea.ql.ast.expression.UnaryExpression;
import org.uva.sea.ql.ast.expression.UnaryNumericExpression;
import org.uva.sea.ql.ast.expression.literal.Bool;
import org.uva.sea.ql.ast.expression.literal.Int;
import org.uva.sea.ql.ast.expression.literal.Money;
import org.uva.sea.ql.ast.expression.literal.Str;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.IExpressionVisitor;

public class ExpressionTypeResolver extends NodeTypeResolver implements IExpressionVisitor<Type> {
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

	@Override
	public Type visit( ArithmeticExpression node ) {
		return new org.uva.sea.ql.ast.type.Number();
	}

	@Override
	public Type visit( LogicalExpression node ) {
		return new org.uva.sea.ql.ast.type.Bool();
	}

	@Override
	public Type visit( ComparisonExpression node ) {
		return new org.uva.sea.ql.ast.type.Bool();
	}

	@Override
	public Type visit( UnaryExpression node ) {
		return new org.uva.sea.ql.ast.type.Bool();
	}

	@Override
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
}
