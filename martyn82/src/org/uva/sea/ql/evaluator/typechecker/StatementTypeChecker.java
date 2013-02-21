package org.uva.sea.ql.evaluator.typechecker;

import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.statement.Assignment;
import org.uva.sea.ql.ast.statement.ComputedQuestion;
import org.uva.sea.ql.ast.statement.FormDeclaration;
import org.uva.sea.ql.ast.statement.IfThen;
import org.uva.sea.ql.ast.statement.IfThenElse;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.ast.statement.Statements;
import org.uva.sea.ql.ast.statement.VariableDeclaration;
import org.uva.sea.ql.ast.statement.VariableQuestion;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.evaluator.environment.TypeEnvironment;
import org.uva.sea.ql.visitor.StatementVisitor;

class StatementTypeChecker implements StatementVisitor<Boolean> {
	private final TypeCheckerHelper helper;
	private final TypeEnvironment environment;
	private final ExpressionTypeChecker expressionChecker;

	public StatementTypeChecker( TypeEnvironment environment ) {
		this( environment, new ExpressionTypeChecker( environment ) );
	}

	public StatementTypeChecker( TypeEnvironment environment, ExpressionTypeChecker expressionChecker ) {
		this.environment = environment;
		this.expressionChecker = expressionChecker;
		this.helper = new TypeCheckerHelper( this.environment );
	}

	private Type typeOf( Expression expression ) {
		return this.helper.typeOf( expression );
	}

	private Boolean checkCondition( Expression condition, Node node ) {
		if ( !condition.accept( this.expressionChecker ) ) {
			return false;
		}

		Type conditionType = this.typeOf( condition );

		if ( !conditionType.isCompatibleToBool() ) {
			this.helper.addIncompatibleTypeError( node.toString(), "Boolean", conditionType.getName(), node );
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
			Type identType = this.environment.lookup( node.getIdentifier() );
			Type declaredType = node.getType();

			if ( !identType.equals( declaredType ) ) {
				this.helper.addAlreadyDeclaredError(
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
			this.helper.addIncompatibleTypesError( node.toString(), leftType.getName(), rightType.getName(), node );
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
