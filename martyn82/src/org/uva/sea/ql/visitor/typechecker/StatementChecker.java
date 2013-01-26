package org.uva.sea.ql.visitor.typechecker;

import org.uva.sea.ql.ast.statement.Assignment;
import org.uva.sea.ql.ast.statement.Else;
import org.uva.sea.ql.ast.statement.ElseIf;
import org.uva.sea.ql.ast.statement.ElseIfs;
import org.uva.sea.ql.ast.statement.FormDeclaration;
import org.uva.sea.ql.ast.statement.IfThenElse;
import org.uva.sea.ql.ast.statement.QuestionDeclaration;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.ast.statement.Statements;
import org.uva.sea.ql.ast.statement.VarDeclaration;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.eval.Error;
import org.uva.sea.ql.visitor.IStatementVisitor;

public class StatementChecker extends NodeTypeChecker implements IStatementVisitor<Boolean> {
	/**
	 * Holds the expression checker.
	 */
	private final ExpressionChecker expressionVisitor;

	/**
	 * Constructs a new Statement checker.
	 *
	 * @param expressionVisitor
	 */
	public StatementChecker( ExpressionChecker expressionVisitor ) {
		super( expressionVisitor.getEnvironment() );
		this.expressionVisitor = expressionVisitor;
	}

	@Override
	public Boolean visit( Else node ) {
		return node.getBody().accept( this );
	}

	@Override
	public Boolean visit( ElseIfs node ) {
		for ( ElseIf elseIf : node ) {
			elseIf.accept( this );
		}

		return true;
	}

	@Override
	public Boolean visit( ElseIf node ) {
		if ( !node.getCondition().accept( this.expressionVisitor ) ) {
			return false;
		}

		if ( !( node.getCondition().typeOf( getEnvironment().getTypes() ) instanceof org.uva.sea.ql.ast.type.Bool ) ) {
			getEnvironment().addError(
				new Error( "Condition of an ELSE-IF block should evaluate to Boolean.", node )
			);
			return false;
		}

		return node.getBody().accept( this );
	}

	@Override
	public Boolean visit( IfThenElse node ) {
		if ( !node.getCondition().accept( this.expressionVisitor ) ) {
			return false;
		}

		if ( !( node.getCondition().typeOf( getEnvironment().getTypes() ) instanceof org.uva.sea.ql.ast.type.Bool ) ) {
			getEnvironment().addError(
				new Error( "Condition of an IF block should evaluate to Boolean.", node )
			);
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
		if ( getEnvironment().isDeclared( node.getIdent() ) ) {
			getEnvironment().addError(
				new Error(
					String.format(
						"The variable %s is already declared elsewhere.",
						node.getIdent().getName()
					),
					node
				)
			);
			return false;
		}

		getEnvironment().declareVariable( node.getIdent(), node.getType() );
		return true;
	}

	@Override
	public Boolean visit( Assignment node ) {
		if ( !node.getExpression().accept( this.expressionVisitor ) ) {
			return false;
		}

		if ( getEnvironment().isDeclared( node.getIdent() ) ) {
			if ( !node.getIdent().accept( this.expressionVisitor ) ) {
				return false;
			}

			Type leftType = node.getIdent().typeOf( getEnvironment().getTypes() );
			Type rightType = node.getExpression().typeOf( getEnvironment().getTypes() );

			if ( !checkBothSame( leftType, rightType ) ) {
				getEnvironment().addError(
					new Error(
						String.format(
							"Type mismatch: cannot convert from %s to %s.",
							leftType.getClass().getSimpleName(),
							rightType.getClass().getSimpleName()
						),
						node
					)
				);
				return false;
			}
		}

		getEnvironment().declareVariable( node.getIdent(), node.getExpression().typeOf( getEnvironment().getTypes() ) );
		return true;
	}

	@Override
	public Boolean visit( FormDeclaration node ) {
		return node.getStatements().accept( this );
	}

	@Override
	public Boolean visit( QuestionDeclaration node ) {
		if ( !node.getName().accept( this.expressionVisitor ) ) {
			return false;
		}

		return node.getDeclaration().accept( this );
	}

	@Override
	public Boolean visit( Statements node ) {
		boolean valid = true;

		for ( Statement statement : node ) {
			valid = statement.accept( this );

			if ( !valid ) {
				return false;
			}
		}

		return valid;
	}
}
