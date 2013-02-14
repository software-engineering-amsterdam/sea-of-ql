package org.uva.sea.ql.visitor.typechecker;

import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.statement.Assignment;
import org.uva.sea.ql.ast.statement.FormDeclaration;
import org.uva.sea.ql.ast.statement.IfThen;
import org.uva.sea.ql.ast.statement.IfThenElse;
import org.uva.sea.ql.ast.statement.ComputedQuestion;
import org.uva.sea.ql.ast.statement.VariableQuestion;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.ast.statement.Statements;
import org.uva.sea.ql.ast.statement.VariableDeclaration;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.StatementVisitor;
import org.uva.sea.ql.visitor.evaluator.Environment;

public class TypeChecker extends AbstractTypeChecker implements StatementVisitor<Boolean> {
	private final ExpressionChecker expressionChecker;

	public static boolean typeCheck( Statement statement, Environment environment ) {
		TypeChecker checker = new TypeChecker( environment, new ExpressionChecker( environment ) );
		return statement.accept( checker );
	}

	private TypeChecker( Environment environment, ExpressionChecker expressionChecker ) {
		super( environment );
		this.expressionChecker = expressionChecker;
	}

	private Boolean checkCondition( Expression condition, Node node ) {
		if ( !condition.accept( this.expressionChecker ) ) {
			return false;
		}

		Type conditionType = this.typeOf( condition );

		if ( !conditionType.isCompatibleToBool() ) {
			this.addIncompatibleTypeError( node.toString(), "Boolean", conditionType.getName(), node );
			return false;
		}

		return true;
	}

	@Override
	public Boolean visit( IfThen node ) {
		if ( !this.checkCondition( node.getCondition(), node ) ) {
			return false;
		}

		return node.getBody().accept( this );
	}

	@Override
	public Boolean visit( IfThenElse node ) {
		if ( !this.checkCondition( node.getCondition(), node ) ) {
			return false;
		}

		if ( !node.getBody().accept( this ) ) {
			return false;
		}

		if ( !node.getElse().accept( this ) ) {
			return false;
		}

		return true;
	}

	@Override
	public Boolean visit( VariableDeclaration node ) {
		if ( this.environment.isDeclared( node.getIdentifier() ) ) {
			Type identType = this.environment.lookupType( node.getIdentifier() );
			Type declaredType = node.getType();

			if ( !identType.equals( declaredType ) ) {
				this.addAlreadyDeclaredError(
					node.getIdentifier().getName(),
					node
				);

				return false;
			}

			return true;
		}

		this.environment.declare( node.getIdentifier(), node.getType() );

		return true;
	}

	@Override
	public Boolean visit( Assignment node ) {
		if ( !this.environment.isDeclared( node.getIdentifier() ) ) {
			Type expressionType = this.typeOf( node.getExpression() );
			this.environment.declare( node.getIdentifier(), expressionType );
		}

		if ( !node.getIdentifier().accept( this.expressionChecker ) ) {
			return false;
		}

		if ( !node.getExpression().accept( this.expressionChecker ) ) {
			return false;
		}

		Type leftType = this.typeOf( node.getIdentifier() );
		Type rightType = this.typeOf( node.getExpression() );

		if ( !leftType.isCompatibleTo( rightType ) ) {
			this.addIncompatibleTypesError( node.toString(), leftType.getName(), rightType.getName(), node );
			return false;
		}

		return true;
	}

	@Override
	public Boolean visit( FormDeclaration node ) {
		return node.getBody().accept( this );
	}

	@Override
	public Boolean visit( VariableQuestion node ) {
		if ( !node.getLabel().accept( this.expressionChecker ) ) {
			return false;
		}

		return node.getVarDeclaration().accept( this );
	}

	@Override
	public Boolean visit( ComputedQuestion node ) {
		if ( !node.getLabel().accept( this.expressionChecker ) ) {
			return false;
		}

		return node.getAssignment().accept( this );
	}

	@Override
	public Boolean visit( Statements node ) {
		for ( Statement statement : node ) {
			if ( !statement.accept( this ) ) {
				return false;
			}
		}

		return true;
	}
}
