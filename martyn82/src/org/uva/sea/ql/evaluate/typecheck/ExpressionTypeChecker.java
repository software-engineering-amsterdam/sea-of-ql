package org.uva.sea.ql.evaluate.typecheck;

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
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.type.UndefinedType;
import org.uva.sea.ql.evaluate.Error;
import org.uva.sea.ql.visitor.ExpressionVisitor;

class ExpressionTypeChecker implements ExpressionVisitor<Boolean> {
	private final TypeEnvironment environment;

	public ExpressionTypeChecker( TypeEnvironment environment ) {
		this.environment = environment;
	}

	private Type typeOf( Expression expression ) {
		return ExpressionTypeResolver.typeOf( expression, this.environment );
	}

	private void addError( Error error ) {
		this.environment.addError( error );
	}

	private Boolean visitArithmeticExpression( ArithmeticExpression node ) {
		boolean checkLeft = node.getLhs().accept( this );
		boolean checkRight = node.getRhs().accept( this );

		if ( !( checkLeft && checkRight ) ) {
			return false;
		}

		Type leftType = this.typeOf( node.getLhs() );
		Type rightType = this.typeOf( node.getRhs() );

		if ( !( leftType.isCompatibleToNumber() && rightType.isCompatibleToNumber() ) ) {
			this.addError(
				TypeErrorFactory.createIncompatibleTypesError(
					node.toString(),
					"Number",
					String.format( "%s and %s", leftType.getName(), rightType.getName() ),
					node
				)
			);
			return false;
		}

		return true;
	}

	private Boolean visitLogicalExpression( LogicalExpression node ) {
		boolean checkLeft = node.getLhs().accept( this );
		boolean checkRight = node.getRhs().accept( this );

		if ( !( checkLeft && checkRight ) ) {
			return false;
		}

		Type leftType = this.typeOf( node.getLhs() );
		Type rightType = this.typeOf( node.getRhs() );

		if ( !( leftType.isCompatibleToBool() && rightType.isCompatibleToBool() ) ) {
			this.addError(
				TypeErrorFactory.createIncompatibleTypesError(
					node.toString(),
					"Boolean",
					String.format( "%s and %s", leftType.getName(), rightType.getName() ),
					node
				)
			);
			return false;
		}

		return true;
	}

	private Boolean visitComparisonExpression( ComparisonExpression node ) {
		boolean checkLeft = node.getLhs().accept( this );
		boolean checkRight = node.getRhs().accept( this );

		if ( !( checkLeft && checkRight ) ) {
			return false;
		}

		Type leftType = this.typeOf( node.getLhs() );
		Type rightType = this.typeOf( node.getRhs() );

		if ( !( leftType.isCompatibleToNumber() && rightType.isCompatibleToNumber() ) ) {
			this.addError(
				TypeErrorFactory.createIncompatibleTypesError(
					node.toString(),
					"Number",
					String.format( "%s and %s", leftType.getName(), rightType.getName() ),
					node
				)
			);
			return false;
		}

		return true;
	}

	private Boolean visitUnaryLogicalExpression( UnaryLogicalExpression node ) {
		if ( !node.getExpression().accept( this ) ) {
			return false;
		}

		Type expressionType = this.typeOf( node.getExpression() );

		if ( !expressionType.isCompatibleToBool() ) {
			this.addError(
				TypeErrorFactory.createIncompatibleTypeError(
					node.toString(), "Boolean.", expressionType.getName(), node
				)
			);
			return false;
		}

		return true;
	}

	private Boolean visitUnaryNumericExpression( UnaryNumericExpression node ) {
		if ( !node.getExpression().accept( this ) ) {
			return false;
		}

		Type expressionType = this.typeOf( node.getExpression() );

		if ( !expressionType.isCompatibleToNumber() ) {
			this.addError(
				TypeErrorFactory.createIncompatibleTypeError(
					node.toString(), "Number.", expressionType.getName(), node
				)
			);
			return false;
		}

		return true;
	}

	private Boolean visitEqualsOrNotEqualsExpression( ComparisonExpression node ) {
		boolean checkLeft = node.getLhs().accept( this );
		boolean checkRight = node.getRhs().accept( this );

		if ( !( checkLeft && checkRight ) ) {
			return false;
		}

		Type leftType = this.typeOf( node.getLhs() );
		Type rightType = this.typeOf( node.getRhs() );

		if ( !leftType.isCompatibleTo( rightType ) ) {
			this.addError(
				TypeErrorFactory.createIncompatibleTypesError(
					node.toString(),
					"same",
					String.format( "%s and %s", leftType.getName(), rightType.getName() ),
					node
				)
			);
			return false;
		}

		return true;
	}

	@Override
	public Boolean visit( IntegerLiteral node ) {
		return this.typeOf( node ).isCompatibleToInt();
	}

	@Override
	public Boolean visit( BooleanLiteral node ) {
		return this.typeOf( node ).isCompatibleToBool();
	}

	@Override
	public Boolean visit( MoneyLiteral node ) {
		return this.typeOf( node ).isCompatibleToMoney();
	}

	@Override
	public Boolean visit( StringLiteral node ) {
		return this.typeOf( node ).isCompatibleToStr();
	}

	@Override
	public Boolean visit( IdentifierExpression node ) {
		Type identifierType = this.typeOf( node );

		if ( identifierType.equals( UndefinedType.UNDEFINED ) ) {
			this.addError(
				TypeErrorFactory.createUndefinedError( node.getName(), node )
			);
			return false;
		}

		return true;
	}

	@Override
	public Boolean visit( AddExpression node ) {
		return this.visitArithmeticExpression( node );
	}

	@Override
	public Boolean visit( SubtractExpression node ) {
		return this.visitArithmeticExpression( node );
	}

	@Override
	public Boolean visit( DivideExpression node ) {
		return this.visitArithmeticExpression( node );
	}

	@Override
	public Boolean visit( MultiplyExpression node ) {
		return this.visitArithmeticExpression( node );
	}

	@Override
	public Boolean visit( AndExpression node ) {
		return this.visitLogicalExpression( node );
	}

	@Override
	public Boolean visit( OrExpression node ) {
		return this.visitLogicalExpression( node );
	}

	@Override
	public Boolean visit( EqualExpression node ) {
		return this.visitEqualsOrNotEqualsExpression( node );
	}

	@Override
	public Boolean visit( GreaterThanOrEqualExpression node ) {
		return this.visitComparisonExpression( node );
	}

	@Override
	public Boolean visit( GreaterThanExpression node ) {
		return this.visitComparisonExpression( node );
	}

	@Override
	public Boolean visit( LesserThanOrEqualExpression node ) {
		return this.visitComparisonExpression( node );
	}

	@Override
	public Boolean visit( LesserThanExpression node ) {
		return this.visitComparisonExpression( node );
	}

	@Override
	public Boolean visit( NotEqualExpression node ) {
		return this.visitEqualsOrNotEqualsExpression( node );
	}

	@Override
	public Boolean visit( NotExpression node ) {
		return this.visitUnaryLogicalExpression( node );
	}

	@Override
	public Boolean visit( PositiveExpression node ) {
		return this.visitUnaryNumericExpression( node );
	}

	@Override
	public Boolean visit( NegativeExpression node ) {
		return this.visitUnaryNumericExpression( node );
	}
}
