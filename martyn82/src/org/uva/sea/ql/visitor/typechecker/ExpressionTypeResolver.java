package org.uva.sea.ql.visitor.typechecker;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.IdentifierExpression;
import org.uva.sea.ql.ast.expression.binary.arithmetic.AddExpression;
import org.uva.sea.ql.ast.expression.binary.arithmetic.ArithmeticExpression;
import org.uva.sea.ql.ast.expression.binary.arithmetic.DivideExpression;
import org.uva.sea.ql.ast.expression.binary.arithmetic.MultiplyExpression;
import org.uva.sea.ql.ast.expression.binary.arithmetic.SubtractExpression;
import org.uva.sea.ql.ast.expression.binary.comparison.ComparisonExpression;
import org.uva.sea.ql.ast.expression.binary.comparison.EqualExpression;
import org.uva.sea.ql.ast.expression.binary.comparison.GreaterThanExpression;
import org.uva.sea.ql.ast.expression.binary.comparison.GreaterThanOrEqualExpression;
import org.uva.sea.ql.ast.expression.binary.comparison.LesserThanExpression;
import org.uva.sea.ql.ast.expression.binary.comparison.LesserThanOrEqualExpression;
import org.uva.sea.ql.ast.expression.binary.comparison.NotEqualExpression;
import org.uva.sea.ql.ast.expression.binary.logical.AndExpression;
import org.uva.sea.ql.ast.expression.binary.logical.LogicalExpression;
import org.uva.sea.ql.ast.expression.binary.logical.OrExpression;
import org.uva.sea.ql.ast.expression.literal.BooleanLiteral;
import org.uva.sea.ql.ast.expression.literal.IntegerLiteral;
import org.uva.sea.ql.ast.expression.literal.MoneyLiteral;
import org.uva.sea.ql.ast.expression.literal.StringLiteral;
import org.uva.sea.ql.ast.expression.unary.logical.NotExpression;
import org.uva.sea.ql.ast.expression.unary.logical.UnaryLogicalExpression;
import org.uva.sea.ql.ast.expression.unary.numeric.NegativeExpression;
import org.uva.sea.ql.ast.expression.unary.numeric.PositiveExpression;
import org.uva.sea.ql.ast.expression.unary.numeric.UnaryNumericExpression;
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

	public static Type typeOf( Expression expression, Environment environment ) {
		ExpressionTypeResolver resolver = new ExpressionTypeResolver( environment );
		return expression.accept( resolver );
	}

	private ExpressionTypeResolver( Environment environment ) {
		this.environment = environment;
	}

	private Type visitArithmeticExpression( ArithmeticExpression node ) {
		return NumberType.NUMBER;
	}

	private Type visitLogicalExpression( LogicalExpression node ) {
		return BooleanType.BOOLEAN;
	}

	private Type visitComparisonExpression( ComparisonExpression node ) {
		return BooleanType.BOOLEAN;
	}

	private Type visitUnaryLogicalExpression( UnaryLogicalExpression node ) {
		return BooleanType.BOOLEAN;
	}

	private Type visitUnaryNumericExpression( UnaryNumericExpression node ) {
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

		return UndefinedType.UNDEFINED;
	}

	@Override
	public Type visit( AddExpression node ) {
		return this.visitArithmeticExpression( node );
	}

	@Override
	public Type visit( SubtractExpression node ) {
		return this.visitArithmeticExpression( node );
	}

	@Override
	public Type visit( DivideExpression node ) {
		return this.visitArithmeticExpression( node );
	}

	@Override
	public Type visit( MultiplyExpression node ) {
		return this.visitArithmeticExpression( node );
	}

	@Override
	public Type visit( AndExpression node ) {
		return this.visitLogicalExpression( node );
	}

	@Override
	public Type visit( OrExpression node ) {
		return this.visitLogicalExpression( node );
	}

	@Override
	public Type visit( EqualExpression node ) {
		return this.visitComparisonExpression( node );
	}

	@Override
	public Type visit( GreaterThanOrEqualExpression node ) {
		return this.visitComparisonExpression( node );
	}

	@Override
	public Type visit( GreaterThanExpression node ) {
		return this.visitComparisonExpression( node );
	}

	@Override
	public Type visit( LesserThanOrEqualExpression node ) {
		return this.visitComparisonExpression( node );
	}

	@Override
	public Type visit( LesserThanExpression node ) {
		return this.visitComparisonExpression( node );
	}

	@Override
	public Type visit( NotEqualExpression node ) {
		return this.visitComparisonExpression( node );
	}

	@Override
	public Type visit( NotExpression node ) {
		return this.visitUnaryLogicalExpression( node );
	}

	@Override
	public Type visit( PositiveExpression node ) {
		return this.visitUnaryNumericExpression( node );
	}

	@Override
	public Type visit( NegativeExpression node ) {
		return this.visitUnaryNumericExpression( node );
	}
}
