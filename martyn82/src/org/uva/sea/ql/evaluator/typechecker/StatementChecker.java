package org.uva.sea.ql.evaluator.typechecker;

import org.uva.sea.ql.ast.statement.Assignment;
import org.uva.sea.ql.ast.statement.Else;
import org.uva.sea.ql.ast.statement.ElseIf;
import org.uva.sea.ql.ast.statement.ElseIfs;
import org.uva.sea.ql.ast.statement.FormDeclaration;
import org.uva.sea.ql.ast.statement.IfThenElse;
import org.uva.sea.ql.ast.statement.QuestionComputed;
import org.uva.sea.ql.ast.statement.QuestionVar;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.ast.statement.Statements;
import org.uva.sea.ql.ast.statement.VarDeclaration;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.evaluator.Environment;
import org.uva.sea.ql.visitor.IStatementVisitor;

/**
 * Represents a type checker for statement nodes.
 */
public class StatementChecker extends TypeCheckVisitor implements IStatementVisitor<Boolean> {

	/**
	 * Holds the expression checker.
	 */
	private final ExpressionChecker expressionChecker;

	/**
	 * Constructs a new Statement checker.
	 *
	 * @param environment
	 * @param expressionChecker
	 */
	public StatementChecker( Environment environment, ExpressionChecker expressionChecker ) {
		super( environment );
		this.expressionChecker = expressionChecker;
	}

	@Override
	public Boolean visit( Else node ) {
		return node.getBody().accept( this );
	}

	@Override
	public Boolean visit( ElseIfs node ) {
		for ( ElseIf elseIf : node ) {
			if ( !elseIf.accept( this ) ) {
				return false;
			}
		}

		return true;
	}

	@Override
	public Boolean visit( ElseIf node ) {
		if ( !node.getCondition().accept( this.expressionChecker ) ) {
			return false;
		}

		Type conditionType = node.getCondition().accept( this.resolver );

		if ( !conditionType.isCompatibleToBool() ) {
			this.addIncompatibleTypeError( node.toString(), "Boolean", conditionType.toString(), node );
			return false;
		}

		return node.getBody().accept( this );
	}

	@Override
	public Boolean visit( IfThenElse node ) {
		if ( !node.getCondition().accept( this.expressionChecker ) ) {
			return false;
		}

		Type conditionType = node.getCondition().accept( this.resolver );

		if ( !conditionType.isCompatibleToBool() ) {
			this.addIncompatibleTypeError( node.toString(), "Boolean", conditionType.toString(), node );
			return false;
		}

		if ( node.hasIfBody() ) {
			if ( !node.getIfBody().accept( this ) ) {
				return false;
			}
		}

		if ( node.hasElseIfs() ) {
			if ( !node.getElseIfs().accept( this ) ) {
				return false;
			}
		}

		if ( node.hasElse() ) {
			if ( !node.getElse().accept( this ) ) {
				return false;
			}
		}

		return true;
	}

	@Override
	public Boolean visit( VarDeclaration node ) {
		/*
		 * If the identifier is already declared, then check if types are compliant.
		 *     If types are not compliant, report error.
		 *     If types are compliant, report success.
		 *
		 * If the identifier is not declared, then declare it and initialize its type.
		 */

		if ( this.environment.isDeclared( node.getIdent() ) ) {
			Type identType = this.environment.lookupType( node.getIdent() );
			Type declaredType = node.getType();

			if ( identType.getClass() != declaredType.getClass() ) {
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
			this.addIncompatibleTypesError( node.toString(), leftType.toString(), rightType.toString(), node );
			return false;
		}

		return true;
	}

	@Override
	public Boolean visit( FormDeclaration node ) {
		return node.getStatements().accept( this );
	}

	@Override
	public Boolean visit( QuestionVar node ) {
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
