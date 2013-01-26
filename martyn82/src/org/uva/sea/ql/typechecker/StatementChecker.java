package org.uva.sea.ql.typechecker;

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
import org.uva.sea.ql.eval.Environment;
import org.uva.sea.ql.eval.Error;
import org.uva.sea.ql.visitor.IStatementVisitor;

/**
 * Represents a type checker for statement nodes.
 */
public class StatementChecker extends TypeCheckVisitor implements IStatementVisitor<Boolean> {
	/**
	 * Holds the expression checker.
	 */
	private final ExpressionChecker expressionVisitor;

	/**
	 * Holds the expression type resolver.
	 */
	private final ExpressionTypeResolver resolver;

	/**
	 * Constructs a new Statement checker.
	 *
	 * @param environment
	 * @param expressionVisitor
	 */
	public StatementChecker( Environment environment, ExpressionChecker expressionVisitor ) {
		super( environment );
		this.expressionVisitor = expressionVisitor;
		this.resolver = this.getResolver();
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

		if ( !( node.getCondition().accept( resolver ) instanceof org.uva.sea.ql.ast.type.Bool ) ) {
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

		if ( !( node.getCondition().accept( resolver ) instanceof org.uva.sea.ql.ast.type.Bool ) ) {
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

			Type leftType = node.getIdent().accept( resolver );
			Type rightType = node.getExpression().accept( resolver );

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

		getEnvironment().declareVariable( node.getIdent(), node.getExpression().accept( resolver ) );
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
