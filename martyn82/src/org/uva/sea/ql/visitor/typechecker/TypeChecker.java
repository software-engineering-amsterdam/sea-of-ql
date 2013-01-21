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
import org.uva.sea.ql.eval.Context;
import org.uva.sea.ql.visitor.INodeVisitor;

/**
 * Represents a type checker visitor.
 */
public class TypeChecker implements INodeVisitor<Boolean> {

	@Override
	public Boolean visit( ArithmeticExpression node, Context context ) {
		boolean checkLeft = node.getLhs().accept( this, context );
		boolean checkRight = node.getRhs().accept( this, context );

		if ( !( checkLeft && checkRight ) ) {
			return false;
		}

//		Type leftType = typeOf( node.getLhs() );
//		Type rightType = typeOf( node.getRhs() );
//
//		if ( !checkBothNumber() ) {
//			context.addError(
//				String.format(
//					"Both sides of the %s-expression must be a Number type.",
//					node.getClass().getSimpleName().toUpperCase()
//				)
//			);
//			return false;
//		}

		return true;
	}

	@Override
	public Boolean visit( LogicalExpression node, Context context ) {
		boolean checkLeft = node.getLhs().accept( this, context );
		boolean checkRight = node.getRhs().accept( this, context );

		if ( !( checkLeft && checkRight ) ) {
			return false;
		}

//		if ( !checkBothBoolean( left, right ) ) {
//			context.addError(
//				String.format(
//					"Both sides of the %s-expression must be of type Boolean.",
//					node.getClass().getSimpleName().toUpperCase()
//				)
//			);
//			return false;
//		}

		return true;
	}

	@Override
	public Boolean visit( ComparisonExpression node, Context context ) {
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

//		if ( !checkBothNumber( left, right ) && !checkBothSame( left, right ) ) {
//			context.addError(
//				String.format(
//					"Both sides of the comparison must be of the same (sub)type.",
//					node.getClass().getSimpleName().toUpperCase()
//				)
//			);
//			return false;
//		}

		return true;
	}

	@Override
	public Boolean visit( UnaryExpression node, Context context ) {
		if ( !node.getExpression().accept( this, context ) ) {
			return false;
		}

//		if ( !checkIsBoolean( expression ) ) {
//			context.addError( "Expression must be a Boolean type." );
//			return null;
//		}

		return true;
	}

	@Override
	public Boolean visit( UnaryNumericExpression node, Context context ) {
		if ( !node.getExpression().accept( this, context ) ) {
			return false;
		}

//		if ( !checkIsNumber( expression ) ) {
//			context.addError( "Expression must be a Number type." );
//			return null;
//		}
//		else if ( checkIsInteger( expression ) ) {
//			return initializeType( DataType.INTEGER );
//		}
//		else if ( checkIsMoney( expression ) ) {
//			return initializeType( DataType.MONEY );
//		}

		return true;
	}

	@Override
	public Boolean visit( org.uva.sea.ql.ast.expression.literal.Int node, Context context ) {
		return true;
	}

	@Override
	public Boolean visit( org.uva.sea.ql.ast.expression.literal.Bool node, Context context ) {
		return true;
	}

	@Override
	public Boolean visit( org.uva.sea.ql.ast.expression.literal.Money node, Context context ) {
		return true;
	}

	@Override
	public Boolean visit( org.uva.sea.ql.ast.expression.literal.Str node, Context context ) {
		return true;
	}

	@Override
	public Boolean visit( Ident node, Context context ) {
		if ( !context.isDeclared( node ) ) {
			context.addError( "Undefined variable: " + node.getName() );
			return false;
		}

		return true;
	}

	@Override
	public Boolean visit( IfThenElse node, Context context ) {
		if ( !node.getCondition().accept( this, context ) ) {
			return false;
		}

//		if ( !checkIsBoolean( condition ) ) {
//			context.addError( "Condition of an IF block should evaluate to Boolean." );
//			return null;
//		}

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
	public Boolean visit( VarDeclaration node, Context context ) {
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
	public Boolean visit( Assignment node, Context context ) {
		if ( !node.getExpression().accept( this, context ) ) {
			return false;
		}

//		boolean value = node.getExpression().accept( this, context );
//
//		if ( context.isDeclared( node.getIdent() ) ) {
//			Boolean ident = node.getIdent().accept( this, context );
//
//			if ( value == null ) {
//				return null;
//			}
//			else if ( !checkBothSame( ident, value ) ) {
//				context.addError(
//					String.format(
//						"Type mismatch: cannot convert from %s to %s.",
//						ident.getClass().getSimpleName(),
//						value.getClass().getSimpleName()
//					)
//				);
//				return null;
//			}
//		}
//
//		context.declareVariable( node.getIdent(), value );

		return true;
	}

	@Override
	public Boolean visit( FormDeclaration node, Context context ) {
		return node.getStatements().accept( this, context );
	}

	@Override
	public Boolean visit( QuestionDeclaration node, Context context ) {
		if ( !node.getName().accept( this, context ) ) {
			return false;
		}

		return node.getDeclaration().accept( this, context );
	}

	@Override
	public Boolean visit( Statements node, Context context ) {
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
	public Boolean visit( Bool node, Context context ) {
		return true;
	}

	@Override
	public Boolean visit( Int node, Context context ) {
		return true;
	}

	@Override
	public Boolean visit( Str node, Context context ) {
		return true;
	}

	@Override
	public Boolean visit( org.uva.sea.ql.ast.type.Money node, Context context ) {
		return true;
	}

	@Override
	public Boolean visit( org.uva.sea.ql.ast.type.Number node, Context context ) {
		return true;
	}
}
