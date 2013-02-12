package org.uva.sea.ql.visitor.typechecker;

import org.uva.sea.ql.ast.expression.ArithmeticExpression;
import org.uva.sea.ql.ast.expression.ComparisonExpression;
import org.uva.sea.ql.ast.expression.IdentifierExpression;
import org.uva.sea.ql.ast.expression.LogicalExpression;
import org.uva.sea.ql.ast.expression.UnaryExpression;
import org.uva.sea.ql.ast.expression.UnaryNumericExpression;
import org.uva.sea.ql.ast.expression.arithmetic.AddExpression;
import org.uva.sea.ql.ast.expression.arithmetic.DivideExpression;
import org.uva.sea.ql.ast.expression.arithmetic.MultiplyExpression;
import org.uva.sea.ql.ast.expression.arithmetic.SubtractExpression;
import org.uva.sea.ql.ast.expression.comparison.EqualExpression;
import org.uva.sea.ql.ast.expression.comparison.GreaterThanOrEqualExpression;
import org.uva.sea.ql.ast.expression.comparison.GreaterThanExpression;
import org.uva.sea.ql.ast.expression.comparison.LesserThanOrEqualExpression;
import org.uva.sea.ql.ast.expression.comparison.LesserThanExpression;
import org.uva.sea.ql.ast.expression.comparison.NotEqualExpression;
import org.uva.sea.ql.ast.expression.literal.BooleanLiteral;
import org.uva.sea.ql.ast.expression.literal.IntegerLiteral;
import org.uva.sea.ql.ast.expression.literal.MoneyLiteral;
import org.uva.sea.ql.ast.expression.literal.StringLiteral;
import org.uva.sea.ql.ast.expression.logical.AndExpression;
import org.uva.sea.ql.ast.expression.logical.OrExpression;
import org.uva.sea.ql.ast.expression.unary.NegativeExpression;
import org.uva.sea.ql.ast.expression.unary.NotExpression;
import org.uva.sea.ql.ast.expression.unary.PositiveExpression;
import org.uva.sea.ql.ast.type.BooleanType;
import org.uva.sea.ql.ast.type.IntegerType;
import org.uva.sea.ql.ast.type.MoneyType;
import org.uva.sea.ql.ast.type.NumberType;
import org.uva.sea.ql.ast.type.StringType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.type.UndefinedType;
import org.uva.sea.ql.visitor.ExpressionVisitor;
import org.uva.sea.ql.visitor.evaluator.Environment;

public class ExpressionTypeResolver implements ExpressionVisitor<Type> {
	private final Environment environment;

	public ExpressionTypeResolver( Environment environment ) {
		this.environment = environment;
	}

	private Type visitArithmetic( ArithmeticExpression node ) {
		return NumberType.NUMBER;
	}

	private Type visitLogical( LogicalExpression node ) {
		return BooleanType.BOOLEAN;
	}

	private Type visitComparison( ComparisonExpression node ) {
		return BooleanType.BOOLEAN;
	}

	private Type visitUnary( UnaryExpression node ) {
		return BooleanType.BOOLEAN;
	}

	private Type visitUnaryNumeric( UnaryNumericExpression node ) {
		return NumberType.NUMBER;
	}

	@Override
	public Type visit( IntegerLiteral node ) {
		return IntegerType.INTEGER;
	}

	@Override
	public Type visit( BooleanLiteral node ) {
		return BooleanType.BOOLEAN;
	}

	@Override
	public Type visit( MoneyLiteral node ) {
		return MoneyType.MONEY;
	}

	@Override
	public Type visit( StringLiteral node ) {
		return StringType.STRING;
	}

	@Override
	public Type visit( IdentifierExpression node ) {
		if ( this.environment.isDeclared( node ) ) {
			return this.environment.lookupType( node );
		}

		return new UndefinedType();
	}

	@Override
	public Type visit( AddExpression node ) {
		return this.visitArithmetic( node );
	}

	@Override
	public Type visit( SubtractExpression node ) {
		return this.visitArithmetic( node );
	}

	@Override
	public Type visit( DivideExpression node ) {
		return this.visitArithmetic( node );
	}

	@Override
	public Type visit( MultiplyExpression node ) {
		return this.visitArithmetic( node );
	}

	@Override
	public Type visit( AndExpression node ) {
		return this.visitLogical( node );
	}

	@Override
	public Type visit( OrExpression node ) {
		return this.visitLogical( node );
	}

	@Override
	public Type visit( EqualExpression node ) {
		return this.visitComparison( node );
	}

	@Override
	public Type visit( GreaterThanOrEqualExpression node ) {
		return this.visitComparison( node );
	}

	@Override
	public Type visit( GreaterThanExpression node ) {
		return this.visitComparison( node );
	}

	@Override
	public Type visit( LesserThanOrEqualExpression node ) {
		return this.visitComparison( node );
	}

	@Override
	public Type visit( LesserThanExpression node ) {
		return this.visitComparison( node );
	}

	@Override
	public Type visit( NotEqualExpression node ) {
		return this.visitComparison( node );
	}

	@Override
	public Type visit( NotExpression node ) {
		return this.visitUnary( node );
	}

	@Override
	public Type visit( PositiveExpression node ) {
		return this.visitUnaryNumeric( node );
	}

	@Override
	public Type visit( NegativeExpression node ) {
		return this.visitUnaryNumeric( node );
	}
}
