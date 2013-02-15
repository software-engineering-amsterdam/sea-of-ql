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
import org.uva.sea.ql.ast.expression.unary.logical.NotExpression;
import org.uva.sea.ql.ast.expression.unary.logical.UnaryLogicalExpression;
import org.uva.sea.ql.ast.expression.unary.numeric.NegativeExpression;
import org.uva.sea.ql.ast.expression.unary.numeric.PositiveExpression;
import org.uva.sea.ql.ast.expression.unary.numeric.UnaryNumericExpression;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.type.UndefinedType;
import org.uva.sea.ql.visitor.ExpressionVisitor;
import org.uva.sea.ql.visitor.evaluator.Environment;

class ExpressionTypeChecker implements ExpressionVisitor<Boolean> {
	private final TypeCheckerHelper helper;
	private final Environment environment;

	public ExpressionTypeChecker( Environment environment ) {
		this.environment = environment;
		this.helper = new TypeCheckerHelper( this.environment );
	}

	private Type typeOf( Expression expression ) {
		return this.helper.typeOf( expression );
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
			this.helper.addIncompatibleTypesError(
				node.toString(),
				"Number",
				String.format( "%s and %s", leftType.getName(), rightType.getName() ),
				node
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
			this.helper.addIncompatibleTypesError(
				node.toString(),
				"Boolean",
				String.format( "%s and %s", leftType.getName(), rightType.getName() ),
				node
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
			this.helper.addIncompatibleTypesError(
				node.toString(),
				"Number",
				String.format( "%s and %s", leftType.getName(), rightType.getName() ),
				node
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
			this.helper.addIncompatibleTypeError(
				node.toString(), "Boolean.", expressionType.getName(), node
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
			this.helper.addIncompatibleTypeError(
				node.toString(), "Number.", expressionType.getName(), node
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
			this.helper.addIncompatibleTypesError(
				node.toString(),
				"same",
				String.format( "%s and %s", leftType.getName(), rightType.getName() ),
				node
			);
			return false;
		}

		return true;
	}

	@Override
	public Boolean visit( org.uva.sea.ql.ast.expression.literal.IntegerLiteral node ) {
		return this.typeOf( node ).isCompatibleToInt();
	}

	@Override
	public Boolean visit( org.uva.sea.ql.ast.expression.literal.BooleanLiteral node ) {
		return this.typeOf( node ).isCompatibleToBool();
	}

	@Override
	public Boolean visit( org.uva.sea.ql.ast.expression.literal.MoneyLiteral node ) {
		return this.typeOf( node ).isCompatibleToMoney();
	}

	@Override
	public Boolean visit( org.uva.sea.ql.ast.expression.literal.StringLiteral node ) {
		return this.typeOf( node ).isCompatibleToStr();
	}

	@Override
	public Boolean visit( IdentifierExpression node ) {
		Type identifierType = this.typeOf( node );

		if ( identifierType.equals( UndefinedType.UNDEFINED ) ) {
			this.helper.addUndefinedError( node.getName(), node );
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
