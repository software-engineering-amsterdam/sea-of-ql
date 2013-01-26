package org.uva.sea.ql.visitor.typechecker;

import org.uva.sea.ql.ast.expression.ArithmeticExpression;
import org.uva.sea.ql.ast.expression.ComparisonExpression;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.LogicalExpression;
import org.uva.sea.ql.ast.expression.UnaryExpression;
import org.uva.sea.ql.ast.expression.UnaryNumericExpression;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.eval.Error;
import org.uva.sea.ql.visitor.IExpressionVisitor;

public class ExpressionChecker extends NodeTypeChecker implements IExpressionVisitor<Boolean> {
	@Override
	public Boolean visit( ArithmeticExpression node ) {
		boolean checkLeft = node.getLhs().accept( this );
		boolean checkRight = node.getRhs().accept( this );

		if ( !( checkLeft && checkRight ) ) {
			return false;
		}

		// TODO replace them with visiting resolver
		Type leftType = node.getLhs().typeOf( getEnvironment().getTypes() ); //node.getLhs().accept( resolver );
		Type rightType = node.getRhs().typeOf( getEnvironment().getTypes() ); //node.getRhs().accept( resolver );

		if ( !checkBothNumber( leftType, rightType ) ) {
			getEnvironment().addError(
				new Error(
					String.format(
						"Both sides of the %s-expression must be a Number type.",
						node.getClass().getSimpleName().toUpperCase()
					),
					node
				)
			);
			return false;
		}

		return true;
	}

	@Override
	public Boolean visit( LogicalExpression node ) {
		boolean checkLeft = node.getLhs().accept( this );
		boolean checkRight = node.getRhs().accept( this );

		if ( !( checkLeft && checkRight ) ) {
			return false;
		}

		Type leftType = node.getLhs().typeOf( getEnvironment().getTypes() );
		Type rightType = node.getRhs().typeOf( getEnvironment().getTypes() );

		if ( !checkBothBoolean( leftType, rightType ) ) {
			getEnvironment().addError(
				new Error(
					String.format(
						"Both sides of the %s-expression must be of type Boolean.",
						node.getClass().getSimpleName().toUpperCase()
					),
					node
				)
			);
			return false;
		}

		return true;
	}

	@Override
	public Boolean visit( ComparisonExpression node ) {
		boolean checkLeft = node.getLhs().accept( this );
		boolean checkRight = node.getRhs().accept( this );

		if ( !( checkLeft && checkRight ) ) {
			return false;
		}

		/*
		 * This type is only valid if left and right hand side of comparison are both of the same (sub)type.
		 * So, check for either:
		 * - Left and right hand side of comparison are both a Number type (Integer or Money).
		 *   or
		 * - Left and right hand side of comparison are both of the same (sub)type.
		 */

		 Type leftType = node.getLhs().typeOf( getEnvironment().getTypes() );
		 Type rightType = node.getRhs().typeOf( getEnvironment().getTypes() );

		if ( !checkBothNumber( leftType, rightType ) && !checkBothSame( leftType, rightType ) ) {
			getEnvironment().addError(
				new Error(
					String.format(
						"Both sides of the comparison must be of the same (sub)type.",
						node.getClass().getSimpleName().toUpperCase()
					),
					node
				)
			);
			return false;
		}

		return true;
	}

	@Override
	public Boolean visit( UnaryExpression node ) {
		if ( !node.getExpression().accept( this ) ) {
			return false;
		}

		if ( !( node.typeOf( getEnvironment().getTypes() ) instanceof org.uva.sea.ql.ast.type.Bool ) ) {
			getEnvironment().addError(
				new Error( "Expression must be a Boolean type.", node )
			);
			return false;
		}

		return true;
	}

	@Override
	public Boolean visit( UnaryNumericExpression node ) {
		if ( !node.getExpression().accept( this ) ) {
			return false;
		}

		if ( !( node.typeOf( getEnvironment().getTypes() ) instanceof org.uva.sea.ql.ast.type.Number ) ) {
			getEnvironment().addError(
				new Error( "Expression must be a Number type.", node )
			);
			return false;
		}

		return true;
	}

	@Override
	public Boolean visit( org.uva.sea.ql.ast.expression.literal.Int node ) {
		return true;
	}

	@Override
	public Boolean visit( org.uva.sea.ql.ast.expression.literal.Bool node ) {
		return true;
	}

	@Override
	public Boolean visit( org.uva.sea.ql.ast.expression.literal.Money node ) {
		return true;
	}

	@Override
	public Boolean visit( org.uva.sea.ql.ast.expression.literal.Str node ) {
		return true;
	}

	@Override
	public Boolean visit( Ident node ) {
		if ( !getEnvironment().isDeclared( node ) ) {
			getEnvironment().addError(
				new Error( "Undefined variable: " + node.getName(), node )
			);
			return false;
		}

		return true;
	}
}
