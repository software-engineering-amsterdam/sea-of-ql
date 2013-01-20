package org.uva.sea.ql.visitor.eval;

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
import org.uva.sea.ql.ast.statement.VarDeclaration;
import org.uva.sea.ql.evaluate.Context;
import org.uva.sea.ql.evaluate.Value;
import org.uva.sea.ql.evaluate.value.Boolean;
import org.uva.sea.ql.evaluate.value.Integer;
import org.uva.sea.ql.evaluate.value.Money;
import org.uva.sea.ql.evaluate.value.Number;
import org.uva.sea.ql.visitor.INodeVisitor;

/**
 * Represents a type checker visitor.
 */
public class TypeChecker implements INodeVisitor {

	@Override
	public Value visit( ArithmeticExpression node, Context context ) {
		Value left = node.getLhs().accept( this, context );
		Value right = node.getRhs().accept( this, context );

		if ( !( left instanceof Number && right instanceof Number ) ) {
			context.addError(
				String.format(
					"Both sides of the %s-expression must be a Number type.",
					node.getClass().getSimpleName().toUpperCase()
				)
			);
			return null;
		}
		else if ( left.getClass() == Money.class || right.getClass() == Money.class ) {
			return new Money();
		}
		else {
			return new Integer();
		}
	}

	@Override
	public Value visit( LogicalExpression node, Context context ) {
		Value left = node.getLhs().accept( this, context );
		Value right = node.getRhs().accept( this, context );

		if ( left.getClass() != Boolean.class || right.getClass() != Boolean.class ) {
			context.addError(
				String.format(
					"Both sides of the %s-expression must be of type Boolean.",
					node.getClass().getSimpleName().toUpperCase()
				)
			);
			return null;
		}

		return new Boolean();
	}

	@Override
	public Value visit( ComparisonExpression node, Context context ) {
		Value left = node.getLhs().accept( this, context );
		Value right = node.getRhs().accept( this, context );

		/*
		 * This type is only valid if left and right hand side of comparison are both of the same (sub)type.
		 * So, check for either:
		 * - Left and right hand side of comparison are both a Number type (Integer or Money).
		 *   or
		 * - Left and right hand side of comparison are both of the same (sub)type.
		 */

		if (
			!( left instanceof Number && right instanceof Number )
			&&
			!( left.getClass().isInstance( right ) || right.getClass().isInstance( left ) )
		) {
			context.addError(
				String.format(
					"Both sides of the comparison must be of the same (sub)type.",
					node.getClass().getSimpleName().toUpperCase()
				)
			);

			return null;
		}
		else {
			return new Boolean();
		}
	}

	@Override
	public Value visit( UnaryExpression node, Context context ) {
		Value expression = node.getExpression().accept( this, context );

		if ( expression.getClass() != Boolean.class ) {
			context.addError( "Expression must be a Boolean type." );
			return null;
		}
		else {
			return new Boolean();
		}
	}

	@Override
	public Value visit( UnaryNumericExpression node, Context context ) {
		Value expression = node.getExpression().accept( this, context );

		if ( !( expression instanceof org.uva.sea.ql.evaluate.value.Number ) ) {
			context.addError( "Expression must be a Number type." );
			return null;
		}
		else if ( expression.getClass() == Integer.class ) {
			return new Integer();
		}
		else if ( expression.getClass() == Money.class ) {
			return new Money();
		}

		return null;
	}

	@Override
	public Value visit( org.uva.sea.ql.ast.expression.value.Int node, Context context ) {
		return new org.uva.sea.ql.evaluate.value.Integer();
	}

	@Override
	public Value visit( org.uva.sea.ql.ast.expression.value.Bool node, Context context ) {
		return new org.uva.sea.ql.evaluate.value.Boolean();
	}

	@Override
	public Value visit( org.uva.sea.ql.ast.expression.value.Money node, Context context ) {
		return new org.uva.sea.ql.evaluate.value.Money();
	}

	@Override
	public Value visit( org.uva.sea.ql.ast.expression.value.Str node, Context context ) {
		return new org.uva.sea.ql.evaluate.value.String();
	}

	@Override
	public Value visit( Ident node, Context context ) {
		Value ident = null;

		try {
			ident = context.find( node );
		}
		catch ( RuntimeException e ) {
			context.addError( e.getMessage() );
			return null;
		}

		return ident;
	}

	@Override
	public Value visit( IfThenElse node, Context context ) {
		Value condition = node.getCondition().accept( this, context );

		if ( !( condition instanceof Boolean ) ) {
			context.addError( "Condition of an IF block should evaluate to Boolean." );
			return null;
		}

		if ( node.getIfThen() != null ) {
			node.getIfThen().accept( this, context );
		}

		if ( node.getIfElse() != null ) {
			node.getIfElse().accept( this, context );
		}

		return condition;
	}

	@Override
	public Value visit( VarDeclaration node, Context context ) {
		if ( context.isDeclared( node.getIdent() ) ) {
			context.addError(
				String.format(
					"The variable %s is already declared elsewhere.",
					node.getIdent().getName()
				)
			);
			return null;
		}

		context.declareVariable( node.getIdent(), node.getType().accept( this, context ) );

		return null;
	}

	@Override
	public Value visit( Assignment node, Context context ) {
		Value value = node.getExpression().accept( this, context );

		if ( context.isDeclared( node.getIdent() ) ) {
			Value ident = node.getIdent().accept( this, context );

			if ( ident.getClass() != value.getClass() ) {
				context.addError(
					String.format(
						"Type mismatch: cannot convert from %s to %s.",
						ident.getClass().getSimpleName(),
						value.getClass().getSimpleName()
					)
				);
				return null;
			}
		}

		context.declareVariable( node.getIdent(), value );

		return value;
	}

	@Override
	public Value visit( FormDeclaration node, Context context ) {
		node.getStatements().accept( this, context );
		return new org.uva.sea.ql.evaluate.value.Boolean();
	}

	@Override
	public Value visit( QuestionDeclaration node, Context context ) {
		node.getName().accept( this, context );
		return node.getDeclaration().accept( this, context );
	}

	@Override
	public Value visit( org.uva.sea.ql.ast.type.Bool node, Context context ) {
		return new org.uva.sea.ql.evaluate.value.Boolean();
	}

	@Override
	public Value visit( org.uva.sea.ql.ast.type.Int node, Context context ) {
		return new org.uva.sea.ql.evaluate.value.Integer();
	}

	@Override
	public Value visit( org.uva.sea.ql.ast.type.Str node, Context context ) {
		return new org.uva.sea.ql.evaluate.value.String();
	}

	@Override
	public Value visit( org.uva.sea.ql.ast.type.Money node, Context context ) {
		return new org.uva.sea.ql.evaluate.value.Money();
	}
}
