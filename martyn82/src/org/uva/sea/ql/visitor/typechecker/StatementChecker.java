package org.uva.sea.ql.visitor.typechecker;

import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.statement.Assignment;
import org.uva.sea.ql.ast.statement.FormDeclaration;
import org.uva.sea.ql.ast.statement.IfThen;
import org.uva.sea.ql.ast.statement.IfThenElse;
import org.uva.sea.ql.ast.statement.QuestionComputed;
import org.uva.sea.ql.ast.statement.QuestionVariable;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.ast.statement.Statements;
import org.uva.sea.ql.ast.statement.VarDeclaration;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.StatementVisitor;
import org.uva.sea.ql.visitor.evaluator.Environment;

public class StatementChecker extends TypeCheckVisitor implements StatementVisitor<Boolean> {
	private final ExpressionChecker expressionChecker;

	public StatementChecker( Environment environment, ExpressionChecker expressionChecker ) {
		super( environment );
		this.expressionChecker = expressionChecker;
	}

	private Boolean checkCondition( Expression condition, Node node ) {
		if ( !condition.accept( this.expressionChecker ) ) {
			return false;
		}

		Type conditionType = condition.accept( this.resolver );

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
	public Boolean visit( VarDeclaration node ) {
		if ( this.environment.isDeclared( node.getIdent() ) ) {
			Type identType = this.environment.lookupType( node.getIdent() );
			Type declaredType = node.getType();

			if ( !identType.equals( declaredType ) ) {
				this.addAlreadyDeclaredError(
					node.getIdent().getName(),
					node
				);

				return false;
			}

			return true;
		}

		this.environment.declare( node.getIdent(), node.getType() );

		return true;
	}

	@Override
	public Boolean visit( Assignment node ) {
		if ( !this.environment.isDeclared( node.getIdent() ) ) {
			Type expressionType = node.getExpression().accept( this.resolver );
			this.environment.declare( node.getIdent(), expressionType );
		}

		if ( !node.getIdent().accept( this.expressionChecker ) ) {
			return false;
		}

		if ( !node.getExpression().accept( this.expressionChecker ) ) {
			return false;
		}

		Type leftType = node.getIdent().accept( this.resolver );
		Type rightType = node.getExpression().accept( this.resolver );

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
	public Boolean visit( QuestionVariable node ) {
		if ( !node.getLabel().accept( this.expressionChecker ) ) {
			return false;
		}

		return node.getVarDeclaration().accept( this );
	}

	@Override
	public Boolean visit( QuestionComputed node ) {
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
