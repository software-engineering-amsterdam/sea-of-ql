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
import org.uva.sea.ql.ast.expression.logical.And;
import org.uva.sea.ql.ast.expression.logical.Or;
import org.uva.sea.ql.ast.expression.unary.Neg;
import org.uva.sea.ql.ast.expression.unary.Not;
import org.uva.sea.ql.ast.expression.unary.Pos;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.type.Undefined;
import org.uva.sea.ql.eval.Environment;
import org.uva.sea.ql.visitor.IExpressionVisitor;

/**
 * Represents a type checker for Expression nodes.
 */
public class ExpressionChecker extends TypeCheckVisitor implements IExpressionVisitor<Boolean> {
	/**
	 * Holds the expression type resolver.
	 */
	private final ExpressionTypeResolver resolver;

	/**
	 * Constructs a new ExpressionChecker.
	 *
	 * @param environment
	 */
	public ExpressionChecker( Environment environment ) {
		super( environment );
		this.resolver = getResolver();
	}

	/**
	 * Visit an arithmetic expression.
	 *
	 * @param node
	 *
	 * @return True if types are compliant.
	 */
	private Boolean visitArithmetic( ArithmeticExpression node ) {
		boolean checkLeft = node.getLhs().accept( this );
		boolean checkRight = node.getRhs().accept( this );

		if ( !( checkLeft && checkRight ) ) {
			return false;
		}

		Type leftType = node.getLhs().accept( resolver );
		Type rightType = node.getRhs().accept( resolver );

		if ( !( leftType.isCompatibleToNumber() && rightType.isCompatibleToNumber() ) ) {
			addError(
				String.format(
					"Both sides of the %s-expression must be a Number type.",
					node.getClass().getSimpleName().toUpperCase()
				),
				node
			);

			return false;
		}

		return true;
	}

	/**
	 * Visit a logical expression.
	 *
	 * @param node
	 *
	 * @return True if types are compliant.
	 */
	private Boolean visitLogical( LogicalExpression node ) {
		boolean checkLeft = node.getLhs().accept( this );
		boolean checkRight = node.getRhs().accept( this );

		if ( !( checkLeft && checkRight ) ) {
			return false;
		}

		Type leftType = node.getLhs().accept( resolver );
		Type rightType = node.getRhs().accept( resolver );

		if ( !( leftType.isCompatibleToBool() && rightType.isCompatibleToBool() ) ) {
			addError(
				String.format(
					"Both sides of the %s-expression must be of type Boolean.",
					node.getClass().getSimpleName().toUpperCase()
				),
				node
			);

			return false;
		}

		return true;
	}

	/**
	 * Visit a comparison expression.
	 *
	 * @param node
	 *
	 * @return True if types are compliant.
	 */
	private Boolean visitComparison( ComparisonExpression node ) {
		boolean checkLeft = node.getLhs().accept( this );
		boolean checkRight = node.getRhs().accept( this );

		if ( !( checkLeft && checkRight ) ) {
			return false;
		}

		Type leftType = node.getLhs().accept( resolver );
		Type rightType = node.getRhs().accept( resolver );

		if ( !( leftType.isCompatibleToNumber() && rightType.isCompatibleToNumber() ) ) {
			addError(
				String.format(
					"Both sides of the comparison must be a Number.",
					node.getClass().getSimpleName().toUpperCase()
				),
				node
			);

			return false;
		}

		return true;
	}

	/**
	 * Visit a unary logical expression.
	 *
	 * @param node
	 *
	 * @return True if type is compliant.
	 */
	private Boolean visitUnary( UnaryExpression node ) {
		if ( !node.getExpression().accept( this ) ) {
			return false;
		}

		Type expressionType = node.getExpression().accept( resolver );

		if ( !expressionType.isCompatibleToBool() ) {
			addError( "Expression must be a Boolean type.", node );
			return false;
		}

		return true;
	}

	/**
	 * Visit a unary numeric expression.
	 *
	 * @param node
	 *
	 * @return True if type is compliant.
	 */
	private Boolean visitUnaryNumeric( UnaryNumericExpression node ) {
		if ( !node.getExpression().accept( this ) ) {
			return false;
		}

		Type expressionType = node.getExpression().accept( resolver );

		if ( !expressionType.isCompatibleToNumber() ) {
			addError( "Expression must be a Number type.", node );
			return false;
		}

		return true;
	}

	/**
	 * Visit an equals/not-equals expression.
	 *
	 * @param node
	 *
	 * @return True if types are compliant.
	 */
	private Boolean visitEqNEq( ComparisonExpression node ) {
		boolean checkLeft = node.getLhs().accept( this );
		boolean checkRight = node.getRhs().accept( this );

		if ( !( checkLeft && checkRight ) ) {
			return false;
		}

		Type leftType = node.getLhs().accept( resolver );
		Type rightType = node.getRhs().accept( resolver );

		if ( !leftType.isCompatibleTo( rightType ) ) {
			addError(
				String.format(
					"Both sides of the comparison must be of the same type.",
					node.getClass().getSimpleName().toUpperCase()
				),
				node
			);

			return false;
		}

		return true;
	}

	@Override
	public Boolean visit( org.uva.sea.ql.ast.expression.literal.Int node ) {
		return node.accept( resolver ).isCompatibleToInt();
	}

	@Override
	public Boolean visit( org.uva.sea.ql.ast.expression.literal.Bool node ) {
		return node.accept( resolver ).isCompatibleToBool();
	}

	@Override
	public Boolean visit( org.uva.sea.ql.ast.expression.literal.Money node ) {
		return node.accept( resolver ).isCompatibleToMoney();
	}

	@Override
	public Boolean visit( org.uva.sea.ql.ast.expression.literal.Str node ) {
		return node.accept( resolver ).isCompatibleToStr();
	}

	@Override
	public Boolean visit( Ident node ) {
		if ( node.accept( resolver ) instanceof Undefined ) {
			addError( "Undefined variable: " + node.getName(), node );
			return false;
		}

		return true;
	}

	@Override
	public Boolean visit( Add node ) {
		return this.visitArithmetic( node );
	}

	@Override
	public Boolean visit( Sub node ) {
		return this.visitArithmetic( node );
	}

	@Override
	public Boolean visit( Div node ) {
		return this.visitArithmetic( node );
	}

	@Override
	public Boolean visit( Mul node ) {
		return this.visitArithmetic( node );
	}

	@Override
	public Boolean visit( And node ) {
		return this.visitLogical( node );
	}

	@Override
	public Boolean visit( Or node ) {
		return this.visitLogical( node );
	}

	@Override
	public Boolean visit( Eq node ) {
		return this.visitEqNEq( node );
	}

	@Override
	public Boolean visit( GEq node ) {
		return this.visitComparison( node );
	}

	@Override
	public Boolean visit( GT node ) {
		return this.visitComparison( node );
	}

	@Override
	public Boolean visit( LEq node ) {
		return this.visitComparison( node );
	}

	@Override
	public Boolean visit( LT node ) {
		return this.visitComparison( node );
	}

	@Override
	public Boolean visit( NEq node ) {
		return this.visitEqNEq( node );
	}

	@Override
	public Boolean visit( Not node ) {
		return this.visitUnary( node );
	}

	@Override
	public Boolean visit( Pos node ) {
		return this.visitUnaryNumeric( node );
	}

	@Override
	public Boolean visit( Neg node ) {
		return this.visitUnaryNumeric( node );
	}
}
