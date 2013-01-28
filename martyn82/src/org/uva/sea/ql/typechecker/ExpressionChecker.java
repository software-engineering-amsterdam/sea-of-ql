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
import org.uva.sea.ql.ast.type.Type;
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
	private Boolean visit( ArithmeticExpression node ) {
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
	public Boolean visit( LogicalExpression node ) {
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
	public Boolean visit( ComparisonExpression node ) {
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
					"Both sides of the comparison must be of the same (sub)type.",
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
	public Boolean visit( UnaryExpression node ) {
		if ( !node.getExpression().accept( this ) ) {
			return false;
		}

		Type nodeType = node.accept( resolver );

		if ( !nodeType.isCompatibleToBool() ) {
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
	public Boolean visit( UnaryNumericExpression node ) {
		if ( !node.getExpression().accept( this ) ) {
			return false;
		}

		Type nodeType = node.accept( resolver );

		if ( !nodeType.isCompatibleToNumber() ) {
			addError( "Expression must be a Number type.", node );
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
		if ( node.accept( resolver ) instanceof org.uva.sea.ql.ast.type.Error ) {
			addError( "Undefined variable: " + node.getName(), node );
			return false;
		}

		return true;
	}

	@Override
	public Boolean visit( Add node ) {
		return this.visit( (ArithmeticExpression) node );
	}

	@Override
	public Boolean visit( Sub node ) {
		return this.visit( (ArithmeticExpression) node );
	}

	@Override
	public Boolean visit( Div node ) {
		return this.visit( (ArithmeticExpression) node );
	}

	@Override
	public Boolean visit( Mul node ) {
		return this.visit( (ArithmeticExpression) node );
	}

	@Override
	public Boolean visit( And node ) {
		return this.visit( (LogicalExpression) node );
	}

	@Override
	public Boolean visit( Or node ) {
		return this.visit( (LogicalExpression) node );
	}

	@Override
	public Boolean visit( Eq node ) {
		return this.visit( (ComparisonExpression) node );
	}

	@Override
	public Boolean visit( GEq node ) {
		return this.visit( (ComparisonExpression) node );
	}

	@Override
	public Boolean visit( GT node ) {
		return this.visit( (ComparisonExpression) node );
	}

	@Override
	public Boolean visit( LEq node ) {
		return this.visit( (ComparisonExpression) node );
	}

	@Override
	public Boolean visit( LT node ) {
		return this.visit( (ComparisonExpression) node );
	}

	@Override
	public Boolean visit( NEq node ) {
		return this.visit( (ComparisonExpression) node );
	}

	@Override
	public Boolean visit( Not node ) {
		return this.visit( (UnaryExpression) node );
	}

	@Override
	public Boolean visit( Pos node ) {
		return this.visit( (UnaryNumericExpression) node );
	}

	@Override
	public Boolean visit( Neg node ) {
		return this.visit( (UnaryNumericExpression) node );
	}
}
