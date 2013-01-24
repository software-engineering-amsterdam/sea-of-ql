package org.uva.sea.ql.visitor.typechecker;

import org.uva.sea.ql.ast.expression.ArithmeticExpression;
import org.uva.sea.ql.ast.expression.ComparisonExpression;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.LogicalExpression;
import org.uva.sea.ql.ast.expression.UnaryExpression;
import org.uva.sea.ql.ast.expression.UnaryNumericExpression;
import org.uva.sea.ql.ast.statement.Assignment;
import org.uva.sea.ql.ast.statement.FormDeclaration;
import org.uva.sea.ql.ast.statement.IfThenElse;
import org.uva.sea.ql.ast.statement.QuestionDeclaration;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.ast.statement.Statements;
import org.uva.sea.ql.ast.statement.VarDeclaration;
import org.uva.sea.ql.ast.type.Bool;
import org.uva.sea.ql.ast.type.Int;
import org.uva.sea.ql.ast.type.Str;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.eval.Environment;
import org.uva.sea.ql.visitor.NodeVisitor;

/**
 * Represents a type checker visitor.
 */
public class TypeChecker extends NodeVisitor<Boolean> {
	private boolean checkBothNumber( Type one, Type two ) {
		return (
			one instanceof org.uva.sea.ql.ast.type.Number
			&& two instanceof org.uva.sea.ql.ast.type.Number
		);
	}

	private boolean checkBothBoolean( Type one, Type two ) {
		return (
			one instanceof org.uva.sea.ql.ast.type.Bool
			&& two instanceof org.uva.sea.ql.ast.type.Bool
		);
	}

	private boolean checkBothSame( Type one, Type two ) {
		return one.getClass() == two.getClass();
	}

	@Override
	public Boolean visit( ArithmeticExpression node, Environment context ) {
		boolean checkLeft = node.getLhs().accept( this, context );
		boolean checkRight = node.getRhs().accept( this, context );

		if ( !( checkLeft && checkRight ) ) {
			return false;
		}

		Type leftType = node.getLhs().typeOf( context.getTypes() );
		Type rightType = node.getRhs().typeOf( context.getTypes() );

		if ( !checkBothNumber( leftType, rightType ) ) {
			context.addError(
				String.format(
					"Both sides of the %s-expression must be a Number type.",
					node.getClass().getSimpleName().toUpperCase()
				)
			);
			return false;
		}

		return true;
	}

	@Override
	public Boolean visit( LogicalExpression node, Environment context ) {
		boolean checkLeft = node.getLhs().accept( this, context );
		boolean checkRight = node.getRhs().accept( this, context );

		if ( !( checkLeft && checkRight ) ) {
			return false;
		}

		Type leftType = node.getLhs().typeOf( context.getTypes() );
		Type rightType = node.getRhs().typeOf( context.getTypes() );

		if ( !checkBothBoolean( leftType, rightType ) ) {
			context.addError(
				String.format(
					"Both sides of the %s-expression must be of type Boolean.",
					node.getClass().getSimpleName().toUpperCase()
				)
			);
			return false;
		}

		return true;
	}

	@Override
	public Boolean visit( ComparisonExpression node, Environment context ) {
		boolean checkLeft = node.getLhs().accept( this, context );
		boolean checkRight = node.getRhs().accept( this, context );

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

		 Type leftType = node.getLhs().typeOf( context.getTypes() );
		 Type rightType = node.getRhs().typeOf( context.getTypes() );

		if ( !checkBothNumber( leftType, rightType ) && !checkBothSame( leftType, rightType ) ) {
			context.addError(
				String.format(
					"Both sides of the comparison must be of the same (sub)type.",
					node.getClass().getSimpleName().toUpperCase()
				)
			);
			return false;
		}

		return true;
	}

	@Override
	public Boolean visit( UnaryExpression node, Environment context ) {
		if ( !node.getExpression().accept( this, context ) ) {
			return false;
		}

		if ( !( node.typeOf( context.getTypes() ) instanceof org.uva.sea.ql.ast.type.Bool ) ) {
			context.addError( "Expression must be a Boolean type." );
			return false;
		}

		return true;
	}

	@Override
	public Boolean visit( UnaryNumericExpression node, Environment context ) {
		if ( !node.getExpression().accept( this, context ) ) {
			return false;
		}

		if ( !( node.typeOf( context.getTypes() ) instanceof org.uva.sea.ql.ast.type.Number ) ) {
			context.addError( "Expression must be a Number type." );
			return false;
		}

		return true;
	}

	@Override
	public Boolean visit( org.uva.sea.ql.ast.expression.literal.Int node, Environment context ) {
		return true;
	}

	@Override
	public Boolean visit( org.uva.sea.ql.ast.expression.literal.Bool node, Environment context ) {
		return true;
	}

	@Override
	public Boolean visit( org.uva.sea.ql.ast.expression.literal.Money node, Environment context ) {
		return true;
	}

	@Override
	public Boolean visit( org.uva.sea.ql.ast.expression.literal.Str node, Environment context ) {
		return true;
	}

	@Override
	public Boolean visit( Ident node, Environment context ) {
		if ( !context.isDeclared( node ) ) {
			context.addError( "Undefined variable: " + node.getName() );
			return false;
		}

		return true;
	}

	@Override
	public Boolean visit( IfThenElse node, Environment context ) {
		if ( !node.getCondition().accept( this, context ) ) {
			return false;
		}

		if ( !( node.getCondition().typeOf( context.getTypes() ) instanceof org.uva.sea.ql.ast.type.Bool ) ) {
			context.addError( "Condition of an IF block should evaluate to Boolean." );
			return false;
		}

		if ( node.getIfThen() != null ) {
			if ( !node.getIfThen().accept( this, context ) ) {
				return false;
			}
		}

		if ( node.getIfElse() != null ) {
			if ( !node.getIfElse().accept( this, context ) ) {
				return false;
			}
		}

		return true;
	}

	@Override
	public Boolean visit( VarDeclaration node, Environment context ) {
		if ( context.isDeclared( node.getIdent() ) ) {
			context.addError(
				String.format(
					"The variable %s is already declared elsewhere.",
					node.getIdent().getName()
				)
			);
			return false;
		}

		context.declareVariable( node.getIdent(), node.getType() );
		return true;
	}

	@Override
	public Boolean visit( Assignment node, Environment context ) {
		if ( !node.getExpression().accept( this, context ) ) {
			return false;
		}

		if ( context.isDeclared( node.getIdent() ) ) {
			if ( !node.getIdent().accept( this, context ) ) {
				return false;
			}

			Type leftType = node.getIdent().typeOf( context.getTypes() );
			Type rightType = node.getExpression().typeOf( context.getTypes() );

			if ( !checkBothSame( leftType, rightType ) ) {
				context.addError(
					String.format(
						"Type mismatch: cannot convert from %s to %s.",
						leftType.getClass().getSimpleName(),
						rightType.getClass().getSimpleName()
					)
				);
				return false;
			}
		}

		context.declareVariable( node.getIdent(), node.getExpression().typeOf( context.getTypes() ) );
		return true;
	}

	@Override
	public Boolean visit( FormDeclaration node, Environment context ) {
		return node.getStatements().accept( this, context );
	}

	@Override
	public Boolean visit( QuestionDeclaration node, Environment context ) {
		if ( !node.getName().accept( this, context ) ) {
			return false;
		}

		return node.getDeclaration().accept( this, context );
	}

	@Override
	public Boolean visit( Statements node, Environment context ) {
		boolean valid = true;

		for ( Statement statement : node ) {
			valid = statement.accept( this, context );

			if ( !valid ) {
				return false;
			}
		}

		return valid;
	}

	@Override
	public Boolean visit( Bool node, Environment context ) {
		return true;
	}

	@Override
	public Boolean visit( Int node, Environment context ) {
		return true;
	}

	@Override
	public Boolean visit( Str node, Environment context ) {
		return true;
	}

	@Override
	public Boolean visit( org.uva.sea.ql.ast.type.Money node, Environment context ) {
		return true;
	}

	@Override
	public Boolean visit( org.uva.sea.ql.ast.type.Number node, Environment context ) {
		return true;
	}
}
