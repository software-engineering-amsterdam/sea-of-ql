package org.uva.sea.ql.visitor.typechecker;

import org.uva.sea.ql.ast.DataType;
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
import org.uva.sea.ql.eval.Context;
import org.uva.sea.ql.eval.TypeInitializer;
import org.uva.sea.ql.eval.value.Boolean;
import org.uva.sea.ql.eval.value.Integer;
import org.uva.sea.ql.eval.value.Money;
import org.uva.sea.ql.eval.value.Number;
import org.uva.sea.ql.eval.value.Value;
import org.uva.sea.ql.visitor.INodeVisitor;

/**
 * Represents a type checker visitor.
 */
public class TypeChecker implements INodeVisitor {
	/**
	 * Initializes a value of the given type.
	 *
	 * @param type
	 *
	 * @return The initialized value.
	 */
	private Value<?> initializeType( DataType type ) {
		return TypeInitializer.init( type );
	}

	private Value<?> initializeType( Type type ) {
		return null;
	}

	/**
	 * Checks whether both values are of the same type.
	 *
	 * @param value1
	 * @param value2
	 *
	 * @return True if they are of the same type, false otherwise.
	 */
	private boolean checkBothSame( Value<?> value1, Value<?> value2 ) {
		return ( value1.getClass() == value2.getClass() );
	}

	/**
	 * Checks whether both values are numeric.
	 *
	 * @param value1
	 * @param value2
	 *
	 * @return True if both are numeric, false otherwise.
	 */
	private boolean checkBothNumber( Value<?> value1, Value<?> value2 ) {
		return ( value1 instanceof Number && value2 instanceof Number );
	}

	/**
	 * Checks whether one of both values is of type money.
	 *
	 * @param value1
	 * @param value2
	 *
	 * @return True if one is money, false if none of them is.
	 */
	private boolean checkEitherMoney( Value<?> value1, Value<?> value2 ) {
		return ( value1.getClass() == Money.class || value2.getClass() == Money.class );
	}

	/**
	 * Checks whether both values are of type boolean.
	 *
	 * @param value1
	 * @param value2
	 *
	 * @return True if both are boolean, false otherwise.
	 */
	private boolean checkBothBoolean( Value<?> value1, Value<?> value2 ) {
		return ( value1.getClass() == Boolean.class && value2.getClass() == Boolean.class );
	}

	/**
	 * Checks whether both values are of type integer.
	 *
	 * @param value1
	 * @param value2
	 *
	 * @return True if both are integer, false otherwise.
	 */
	@SuppressWarnings( "unused" ) // method added for consistency reasons
	private boolean checkBothInteger( Value<?> value1, Value<?> value2 ) {
		return ( value1.getClass() == Integer.class && value2.getClass() == Integer.class );
	}

	/**
	 * Checks whether both values are of type string.
	 *
	 * @param value1
	 * @param value2
	 *
	 * @return True if both are string, false otherwise.
	 */
	@SuppressWarnings( "unused" ) // method added for consistency reasons
	private boolean checkBothString( Value<?> value1, Value<?> value2 ) {
		return (
			value1.getClass() == org.uva.sea.ql.eval.value.String.class
			&& value2.getClass() == org.uva.sea.ql.eval.value.String.class
		);
	}

	/**
	 * Checks whether the given value is of type boolean.
	 *
	 * @param value
	 *
	 * @return True if value is boolean, false otherwise.
	 */
	private boolean checkIsBoolean( Value<?> value ) {
		return value.getClass() == Boolean.class;
	}

	/**
	 * Checks whether the given value is numeric.
	 *
	 * @param value
	 *
	 * @return True if the value is a number, false otherwise.
	 */
	private boolean checkIsNumber( Value<?> value ) {
		return value instanceof Number;
	}

	/**
	 * Checks whether the given value is a string.
	 *
	 * @param value
	 *
	 * @return True if the value is a string, false otherwise.
	 */
	@SuppressWarnings( "unused" ) // method added for consistency reasons
	private boolean checkIsString( Value<?> value ) {
		return value.getClass() == org.uva.sea.ql.eval.value.String.class;
	}

	/**
	 * Checks whether the given value is an integer.
	 *
	 * @param value
	 *
	 * @return True if the value is an integer, false otherwise.
	 */
	private boolean checkIsInteger( Value<?> value ) {
		return value.getClass() == org.uva.sea.ql.eval.value.Integer.class;
	}

	/**
	 * Checks whether the given value is of type money.
	 *
	 * @param value
	 *
	 * @return True if the value is money, false otherwise.
	 */
	private boolean checkIsMoney( Value<?> value ) {
		return value.getClass() == org.uva.sea.ql.eval.value.Money.class;
	}

	@Override
	public Value<?> visit( ArithmeticExpression node, Context context ) {
		Value<?> left = node.getLhs().accept( this, context );
		Value<?> right = node.getRhs().accept( this, context );

		if ( !checkBothNumber( left, right ) ) {
			context.addError(
				String.format(
					"Both sides of the %s-expression must be a Number type.",
					node.getClass().getSimpleName().toUpperCase()
				)
			);
			return null;
		}
		else if ( checkEitherMoney( left, right ) ) {
			return initializeType( DataType.MONEY );
		}
		else {
			return initializeType( DataType.INTEGER );
		}
	}

	@Override
	public Value<?> visit( LogicalExpression node, Context context ) {
		Value<?> left = node.getLhs().accept( this, context );
		Value<?> right = node.getRhs().accept( this, context );

		if ( !checkBothBoolean( left, right ) ) {
			context.addError(
				String.format(
					"Both sides of the %s-expression must be of type Boolean.",
					node.getClass().getSimpleName().toUpperCase()
				)
			);
			return null;
		}

		return initializeType( DataType.BOOLEAN );
	}

	@Override
	public Value<?> visit( ComparisonExpression node, Context context ) {
		Value<?> left = node.getLhs().accept( this, context );
		Value<?> right = node.getRhs().accept( this, context );

		/*
		 * This type is only valid if left and right hand side of comparison are both of the same (sub)type.
		 * So, check for either:
		 * - Left and right hand side of comparison are both a Number type (Integer or Money).
		 *   or
		 * - Left and right hand side of comparison are both of the same (sub)type.
		 */

		if ( !checkBothNumber( left, right ) && !checkBothSame( left, right ) ) {
			context.addError(
				String.format(
					"Both sides of the comparison must be of the same (sub)type.",
					node.getClass().getSimpleName().toUpperCase()
				)
			);

			return null;
		}
		else {
			return initializeType( DataType.BOOLEAN );
		}
	}

	@Override
	public Value<?> visit( UnaryExpression node, Context context ) {
		Value<?> expression = node.getExpression().accept( this, context );

		if ( !checkIsBoolean( expression ) ) {
			context.addError( "Expression must be a Boolean type." );
			return null;
		}
		else {
			return initializeType( DataType.BOOLEAN );
		}
	}

	@Override
	public Value<?> visit( UnaryNumericExpression node, Context context ) {
		Value<?> expression = node.getExpression().accept( this, context );

		if ( !checkIsNumber( expression ) ) {
			context.addError( "Expression must be a Number type." );
			return null;
		}
		else if ( checkIsInteger( expression ) ) {
			return initializeType( DataType.INTEGER );
		}
		else if ( checkIsMoney( expression ) ) {
			return initializeType( DataType.MONEY );
		}

		return null;
	}

	@Override
	public Value<?> visit( org.uva.sea.ql.ast.expression.literal.Int node, Context context ) {
		return initializeType( DataType.INTEGER );
	}

	@Override
	public Value<?> visit( org.uva.sea.ql.ast.expression.literal.Bool node, Context context ) {
		return initializeType( DataType.BOOLEAN );
	}

	@Override
	public Value<?> visit( org.uva.sea.ql.ast.expression.literal.Money node, Context context ) {
		return initializeType( DataType.MONEY );
	}

	@Override
	public Value<?> visit( org.uva.sea.ql.ast.expression.literal.Str node, Context context ) {
		return initializeType( DataType.STRING );
	}

	@Override
	public Value<?> visit( Ident node, Context context ) {
		if ( !context.isDeclared( node ) ) {
			context.addError( "Undefined variable: " + node.getName() );
			return null;
		}

		return context.find( node );
	}

	@Override
	public Value<?> visit( IfThenElse node, Context context ) {
		Value<?> condition = node.getCondition().accept( this, context );

		if ( !checkIsBoolean( condition ) ) {
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
	public Value<?> visit( VarDeclaration node, Context context ) {
		if ( context.isDeclared( node.getIdent() ) ) {
			context.addError(
				String.format(
					"The variable %s is already declared elsewhere.",
					node.getIdent().getName()
				)
			);
			return null;
		}

		Value<?> value = initializeType( node.getType() );
		context.declareVariable( node.getIdent(), value );

		return value;
	}

	@Override
	public Value<?> visit( Assignment node, Context context ) {
		Value<?> value = node.getExpression().accept( this, context );

		if ( context.isDeclared( node.getIdent() ) ) {
			Value<?> ident = node.getIdent().accept( this, context );

			if ( value == null ) {
				return null;
			}
			else if ( !checkBothSame( ident, value ) ) {
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
	public Value<?> visit( FormDeclaration node, Context context ) {
		node.getStatements().accept( this, context );
		return initializeType( DataType.BOOLEAN );
	}

	@Override
	public Value<?> visit( QuestionDeclaration node, Context context ) {
		node.getName().accept( this, context );
		return node.getDeclaration().accept( this, context );
	}

	@Override
	public Value<?> visit( Statements node, Context context ) {
		for ( Statement statement : node ) {
			statement.accept( this, context );
		}

		return initializeType( DataType.BOOLEAN );
	}

	@Override
	public Value<?> visit( Bool node, Context context ) {
		return initializeType( DataType.BOOLEAN );
	}

	@Override
	public Value<?> visit( Int node, Context context ) {
		return initializeType( DataType.INTEGER );
	}

	@Override
	public Value<?> visit( Str node, Context context ) {
		return initializeType( DataType.STRING );
	}

	@Override
	public Value<?> visit( org.uva.sea.ql.ast.type.Money node, Context context ) {
		return initializeType( DataType.MONEY );
	}

	@Override
	public Value<?> visit( org.uva.sea.ql.ast.type.Number node, Context context ) {
		return initializeType( DataType.INTEGER );
	}
}
