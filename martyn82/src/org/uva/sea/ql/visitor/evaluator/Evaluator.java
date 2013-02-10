package org.uva.sea.ql.visitor.evaluator;

import org.uva.sea.ql.ast.expression.Expression;
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
import org.uva.sea.ql.ast.expression.logical.And;
import org.uva.sea.ql.ast.expression.logical.Or;
import org.uva.sea.ql.ast.expression.unary.Neg;
import org.uva.sea.ql.ast.expression.unary.Not;
import org.uva.sea.ql.ast.expression.unary.Pos;
import org.uva.sea.ql.visitor.ExpressionVisitor;
import org.uva.sea.ql.visitor.evaluator.value.BooleanValue;
import org.uva.sea.ql.visitor.evaluator.value.IntegerValue;
import org.uva.sea.ql.visitor.evaluator.value.MoneyValue;
import org.uva.sea.ql.visitor.evaluator.value.StringValue;
import org.uva.sea.ql.visitor.evaluator.value.Value;

/**
 * Evaluator for expression nodes.
 */
public class Evaluator implements ExpressionVisitor<Value> {
	/**
	 * Holds the environment.
	 */
	private final Environment environment;

	/**
	 * Constructs a new ExpressionEvaluator.
	 *
	 * @param environment
	 */
	private Evaluator( Environment environment ) {
		this.environment = environment;
	}

	public static Value evaluate( Expression node, Environment environment ) {
		return node.accept( new Evaluator( environment ) );
	}

	@Override
	public Value visit( Add node ) {
		Value left = node.getLhs().accept( this );
		Value right = node.getRhs().accept( this );
		return left.add( right );
	}

	@Override
	public Value visit( Sub node ) {
		Value left = node.getLhs().accept( this );
		Value right = node.getRhs().accept( this );
		return left.sub( right );
	}

	@Override
	public Value visit( Div node ) {
		Value left = node.getLhs().accept( this );
		Value right = node.getRhs().accept( this );
		return left.div( right );
	}

	@Override
	public Value visit( Mul node ) {
		Value left = node.getLhs().accept( this );
		Value right = node.getRhs().accept( this );
		return left.mul( right );
	}

	@Override
	public Value visit( And node ) {
		Value left = node.getLhs().accept( this );
		Value right = node.getRhs().accept( this );
		return left.and( right );
	}

	@Override
	public Value visit( Or node ) {
		Value left = node.getLhs().accept( this );
		Value right = node.getRhs().accept( this );
		return left.or( right );
	}

	@Override
	public Value visit( Eq node ) {
		Value left = node.getLhs().accept( this );
		Value right = node.getRhs().accept( this );
		return left.eq( right );
	}

	@Override
	public Value visit( GEq node ) {
		Value left = node.getLhs().accept( this );
		Value right = node.getRhs().accept( this );
		return left.geq( right );
	}

	@Override
	public Value visit( GT node ) {
		Value left = node.getLhs().accept( this );
		Value right = node.getRhs().accept( this );
		return left.gt( right );
	}

	@Override
	public Value visit( LEq node ) {
		Value left = node.getLhs().accept( this );
		Value right = node.getRhs().accept( this );
		return left.leq( right );
	}

	@Override
	public Value visit( LT node ) {
		Value left = node.getLhs().accept( this );
		Value right = node.getRhs().accept( this );
		return left.lt( right );
	}

	@Override
	public Value visit( NEq node ) {
		Value left = node.getLhs().accept( this );
		Value right = node.getRhs().accept( this );
		return left.neq( right );
	}

	@Override
	public Value visit( Not node ) {
		Value value = node.getExpression().accept( this );
		return value.not();
	}

	@Override
	public Value visit( Pos node ) {
		Value value = node.getExpression().accept( this );
		return value.pos();
	}

	@Override
	public Value visit( Neg node ) {
		Value value = node.getExpression().accept( this );
		return value.neg();
	}

	@Override
	public Value visit( org.uva.sea.ql.ast.expression.literal.Int node ) {
		return new IntegerValue( node.getValue() );
	}

	@Override
	public Value visit( org.uva.sea.ql.ast.expression.literal.Bool node ) {
		return new BooleanValue( node.getValue() );
	}

	@Override
	public Value visit( org.uva.sea.ql.ast.expression.literal.Money node ) {
		return new MoneyValue( node.getValue() );
	}

	@Override
	public Value visit( org.uva.sea.ql.ast.expression.literal.Str node ) {
		return new StringValue( node.getValue() );
	}

	@Override
	public Value visit( Ident node ) {
		return this.environment.lookup( node );
	}
}
