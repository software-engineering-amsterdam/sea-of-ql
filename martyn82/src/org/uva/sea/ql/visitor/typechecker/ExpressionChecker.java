package org.uva.sea.ql.visitor.typechecker;

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
import org.uva.sea.ql.ast.expression.unary.UnaryExpression;
import org.uva.sea.ql.ast.expression.unary.logical.NotExpression;
import org.uva.sea.ql.ast.expression.unary.numeric.NegativeExpression;
import org.uva.sea.ql.ast.expression.unary.numeric.PositiveExpression;
import org.uva.sea.ql.ast.expression.unary.numeric.UnaryNumericExpression;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.type.UndefinedType;
import org.uva.sea.ql.visitor.ExpressionVisitor;
import org.uva.sea.ql.visitor.evaluator.Environment;

public class ExpressionChecker extends TypeCheckVisitor implements ExpressionVisitor<Boolean> {

	public ExpressionChecker( Environment environment ) {
		super( environment );
	}

	private Boolean visitArithmetic( ArithmeticExpression node ) {
		boolean checkLeft = node.getLhs().accept( this );
		boolean checkRight = node.getRhs().accept( this );

		if ( !( checkLeft && checkRight ) ) {
			return false;
		}

		Type leftType = node.getLhs().accept( this.resolver );
		Type rightType = node.getRhs().accept( this.resolver );

		if ( !( leftType.isCompatibleToNumber() && rightType.isCompatibleToNumber() ) ) {
			this.addIncompatibleTypesError(
				node.toString(),
				"Number",
				String.format( "%s and %s", leftType.getName(), rightType.getName() ),
				node
			);
			return false;
		}

		return true;
	}

	private Boolean visitLogical( LogicalExpression node ) {
		boolean checkLeft = node.getLhs().accept( this );
		boolean checkRight = node.getRhs().accept( this );

		if ( !( checkLeft && checkRight ) ) {
			return false;
		}

		Type leftType = node.getLhs().accept( this.resolver );
		Type rightType = node.getRhs().accept( this.resolver );

		if ( !( leftType.isCompatibleToBool() && rightType.isCompatibleToBool() ) ) {
			this.addIncompatibleTypesError(
				node.toString(),
				"Boolean",
				String.format( "%s and %s", leftType.getName(), rightType.getName() ),
				node
			);
			return false;
		}

		return true;
	}

	private Boolean visitComparison( ComparisonExpression node ) {
		boolean checkLeft = node.getLhs().accept( this );
		boolean checkRight = node.getRhs().accept( this );

		if ( !( checkLeft && checkRight ) ) {
			return false;
		}

		Type leftType = node.getLhs().accept( this.resolver );
		Type rightType = node.getRhs().accept( this.resolver );

		if ( !( leftType.isCompatibleToNumber() && rightType.isCompatibleToNumber() ) ) {
			this.addIncompatibleTypesError(
				node.toString(),
				"Number",
				String.format( "%s and %s", leftType.getName(), rightType.getName() ),
				node
			);
			return false;
		}

		return true;
	}

	private Boolean visitUnary( UnaryExpression node ) {
		if ( !node.getExpression().accept( this ) ) {
			return false;
		}

		Type expressionType = node.getExpression().accept( this.resolver );

		if ( !expressionType.isCompatibleToBool() ) {
			this.addIncompatibleTypeError(
				node.toString(), "Boolean.", expressionType.getName(), node
			);
			return false;
		}

		return true;
	}

	private Boolean visitUnaryNumeric( UnaryNumericExpression node ) {
		if ( !node.getExpression().accept( this ) ) {
			return false;
		}

		Type expressionType = node.getExpression().accept( this.resolver );

		if ( !expressionType.isCompatibleToNumber() ) {
			this.addIncompatibleTypeError(
				node.toString(), "Number.", expressionType.getName(), node
			);
			return false;
		}

		return true;
	}

	private Boolean visitEqNEq( ComparisonExpression node ) {
		boolean checkLeft = node.getLhs().accept( this );
		boolean checkRight = node.getRhs().accept( this );

		if ( !( checkLeft && checkRight ) ) {
			return false;
		}

		Type leftType = node.getLhs().accept( this.resolver );
		Type rightType = node.getRhs().accept( this.resolver );

		if ( !leftType.isCompatibleTo( rightType ) ) {
			this.addIncompatibleTypesError(
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
		return node.accept( this.resolver ).isCompatibleToInt();
	}

	@Override
	public Boolean visit( org.uva.sea.ql.ast.expression.literal.BooleanLiteral node ) {
		return node.accept( this.resolver ).isCompatibleToBool();
	}

	@Override
	public Boolean visit( org.uva.sea.ql.ast.expression.literal.MoneyLiteral node ) {
		return node.accept( this.resolver ).isCompatibleToMoney();
	}

	@Override
	public Boolean visit( org.uva.sea.ql.ast.expression.literal.StringLiteral node ) {
		return node.accept( this.resolver ).isCompatibleToStr();
	}

	@Override
	public Boolean visit( IdentifierExpression node ) {
		if ( node.accept( this.resolver ).getClass() == UndefinedType.class ) {
			this.addUndefinedError( node.getName(), node );
			return false;
		}

		return true;
	}

	@Override
	public Boolean visit( AddExpression node ) {
		return this.visitArithmetic( node );
	}

	@Override
	public Boolean visit( SubtractExpression node ) {
		return this.visitArithmetic( node );
	}

	@Override
	public Boolean visit( DivideExpression node ) {
		return this.visitArithmetic( node );
	}

	@Override
	public Boolean visit( MultiplyExpression node ) {
		return this.visitArithmetic( node );
	}

	@Override
	public Boolean visit( AndExpression node ) {
		return this.visitLogical( node );
	}

	@Override
	public Boolean visit( OrExpression node ) {
		return this.visitLogical( node );
	}

	@Override
	public Boolean visit( EqualExpression node ) {
		return this.visitEqNEq( node );
	}

	@Override
	public Boolean visit( GreaterThanOrEqualExpression node ) {
		return this.visitComparison( node );
	}

	@Override
	public Boolean visit( GreaterThanExpression node ) {
		return this.visitComparison( node );
	}

	@Override
	public Boolean visit( LesserThanOrEqualExpression node ) {
		return this.visitComparison( node );
	}

	@Override
	public Boolean visit( LesserThanExpression node ) {
		return this.visitComparison( node );
	}

	@Override
	public Boolean visit( NotEqualExpression node ) {
		return this.visitEqNEq( node );
	}

	@Override
	public Boolean visit( NotExpression node ) {
		return this.visitUnary( node );
	}

	@Override
	public Boolean visit( PositiveExpression node ) {
		return this.visitUnaryNumeric( node );
	}

	@Override
	public Boolean visit( NegativeExpression node ) {
		return this.visitUnaryNumeric( node );
	}
}
