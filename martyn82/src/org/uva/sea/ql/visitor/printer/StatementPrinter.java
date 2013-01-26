package org.uva.sea.ql.visitor.printer;

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
import org.uva.sea.ql.visitor.IStatementVisitor;

/**
 * Represents a pretty printer for statement nodes.
 */
public class StatementPrinter extends PrintVisitor implements IStatementVisitor<Boolean> {
	/**
	 * Holds the expression visitor.
	 */
	private final ExpressionPrinter expressionVisitor;

	/**
	 * Constructs a new StatementPrinter instance.
	 *
	 * @param context
	 * @param expressionVisitor
	 */
	public StatementPrinter( PrintContext context, ExpressionPrinter expressionVisitor ) {
		super( context );
		this.expressionVisitor = expressionVisitor;
	}

	@Override
	public Boolean visit( Else node ) {
		indent();
		write( "ELSE" );

		increaseLevel();

		indent();
		node.getBody().accept( this );

		decreaseLevel();

		return true;
	}

	@Override
	public Boolean visit( IfThenElse node ) {
		indent();
		write( "IF" );

		increaseLevel();

		indent();
		node.getCondition().accept( this.expressionVisitor );

		decreaseLevel();

		indent();
		write( "THEN" );

		if ( node.hasIfBody() ) {
			increaseLevel();

			indent();
			node.getIfBody().accept( this );

			decreaseLevel();
		}

		if ( node.hasElseIfs() ) {
			node.getElseIfs().accept( this );
		}

		if ( node.hasElse() ) {
			node.getElse().accept( this );
		}

		return true;
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
		indent();
		write( "ELSEIF" );

		increaseLevel();

		indent();
		node.getCondition().accept( this.expressionVisitor );

		decreaseLevel();

		indent();
		write( "THEN" );

		increaseLevel();

		node.getBody().accept( this );

		decreaseLevel();

		return true;
	}

	@Override
	public Boolean visit( VarDeclaration node ) {
		writeName( node );

		increaseLevel();

		indent();
		node.getIdent().accept( this.expressionVisitor );

		indent();
		write( node.getType().getClass().getSimpleName().toUpperCase() );

		decreaseLevel();

		return true;
	}

	@Override
	public Boolean visit( Assignment node ) {
		writeName( node );

		increaseLevel();

		indent();
		node.getIdent().accept( this.expressionVisitor );

		indent();
		node.getExpression().accept( this.expressionVisitor );

		decreaseLevel();

		return true;
	}

	@Override
	public Boolean visit( FormDeclaration node ) {
		writeName( node );

		increaseLevel();

		indent();
		node.getIdent().accept( this.expressionVisitor );

		indent();
		node.getStatements().accept( this );

		decreaseLevel();

		return true;
	}

	@Override
	public Boolean visit( QuestionDeclaration node ) {
		indent();
		writeName( node );

		increaseLevel();

		indent();
		node.getName().accept( this.expressionVisitor );

		indent();
		node.getDeclaration().accept( this );

		decreaseLevel();

		return true;
	}

	@Override
	public Boolean visit( Statements node ) {
		for ( Statement statement : node ) {
			statement.accept( this );
		}

		return true;
	}
}
