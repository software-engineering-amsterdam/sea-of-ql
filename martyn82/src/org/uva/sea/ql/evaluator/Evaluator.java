package org.uva.sea.ql.evaluator;

import org.uva.sea.ql.ast.expression.Expression;
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
import org.uva.sea.ql.evaluator.environment.ValueEnvironment;
import org.uva.sea.ql.value.BooleanValue;
import org.uva.sea.ql.value.IntegerValue;
import org.uva.sea.ql.value.MoneyValue;
import org.uva.sea.ql.value.StringValue;
import org.uva.sea.ql.value.Value;
import org.uva.sea.ql.visitor.ExpressionVisitor;

class Evaluator implements ExpressionVisitor<Value> {
	private final ValueEnvironment environment;

	private Evaluator( ValueEnvironment environment ) {
		this.environment = environment;
	}

	public static Value evaluate( Expression node, ValueEnvironment environment ) {
		return node.accept( new Evaluator( environment ) );
	}

	@Override
	public Value visit( AddExpression node ) {
		Value left = node.getLhs().accept( this );
		Value right = node.getRhs().accept( this );
		return left.add( right );
	}

	@Override
	public Value visit( SubtractExpression node ) {
		Value left = node.getLhs().accept( this );
		Value right = node.getRhs().accept( this );
		return left.subtract( right );
	}

	@Override
	public Value visit( DivideExpression node ) {
		Value left = node.getLhs().accept( this );
		Value right = node.getRhs().accept( this );
		return left.divide( right );
	}

	@Override
	public Value visit( MultiplyExpression node ) {
		Value left = node.getLhs().accept( this );
		Value right = node.getRhs().accept( this );
		return left.multiply( right );
	}

	@Override
	public Value visit( AndExpression node ) {
		Value left = node.getLhs().accept( this );
		Value right = node.getRhs().accept( this );
		return left.and( right );
	}

	@Override
	public Value visit( OrExpression node ) {
		Value left = node.getLhs().accept( this );
		Value right = node.getRhs().accept( this );
		return left.or( right );
	}

	@Override
	public Value visit( EqualExpression node ) {
		Value left = node.getLhs().accept( this );
		Value right = node.getRhs().accept( this );
		return left.equalTo( right );
	}

	@Override
	public Value visit( GreaterThanOrEqualExpression node ) {
		Value left = node.getLhs().accept( this );
		Value right = node.getRhs().accept( this );
		return left.greaterThanOrEquals( right );
	}

	@Override
	public Value visit( GreaterThanExpression node ) {
		Value left = node.getLhs().accept( this );
		Value right = node.getRhs().accept( this );
		return left.greaterThan( right );
	}

	@Override
	public Value visit( LesserThanOrEqualExpression node ) {
		Value left = node.getLhs().accept( this );
		Value right = node.getRhs().accept( this );
		return left.lesserThanOrEquals( right );
	}

	@Override
	public Value visit( LesserThanExpression node ) {
		Value left = node.getLhs().accept( this );
		Value right = node.getRhs().accept( this );
		return left.lesserThan( right );
	}

	@Override
	public Value visit( NotEqualExpression node ) {
		Value left = node.getLhs().accept( this );
		Value right = node.getRhs().accept( this );
		return left.notEqualTo( right );
	}

	@Override
	public Value visit( NotExpression node ) {
		Value value = node.getExpression().accept( this );
		return value.not();
	}

	@Override
	public Value visit( PositiveExpression node ) {
		Value value = node.getExpression().accept( this );
		return value.positive();
	}

	@Override
	public Value visit( NegativeExpression node ) {
		Value value = node.getExpression().accept( this );
		return value.negative();
	}

	@Override
	public Value visit( IntegerLiteral node ) {
		return new IntegerValue( node.getValue() );
	}

	@Override
	public Value visit( BooleanLiteral node ) {
		return new BooleanValue( node.getValue() );
	}

	@Override
	public Value visit( MoneyLiteral node ) {
		return new MoneyValue( node.getValue() );
	}

	@Override
	public Value visit( StringLiteral node ) {
		return new StringValue( node.getValue() );
	}

	@Override
	public Value visit( IdentifierExpression node ) {
		return this.environment.lookup( node );
	}
}
