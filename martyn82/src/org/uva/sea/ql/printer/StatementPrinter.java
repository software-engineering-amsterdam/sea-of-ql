package org.uva.sea.ql.printer;

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
		this.indent();
		this.write( "ELSE" );

		this.increaseLevel();

		this.indent();
		node.getBody().accept( this );

		this.decreaseLevel();

		return true;
	}

	@Override
	public Boolean visit( IfThenElse node ) {
		this.indent();
		this.write( "IF" );

		this.increaseLevel();

		this.indent();
		node.getCondition().accept( this.expressionVisitor );

		this.decreaseLevel();

		this.indent();
		this.write( "THEN" );

		if ( node.hasIfBody() ) {
			this.increaseLevel();

			this.indent();
			node.getIfBody().accept( this );

			this.decreaseLevel();
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
		this.indent();
		this.write( "ELSEIF" );

		this.increaseLevel();

		this.indent();
		node.getCondition().accept( this.expressionVisitor );

		this.decreaseLevel();

		this.indent();
		this.write( "THEN" );

		this.increaseLevel();

		node.getBody().accept( this );

		this.decreaseLevel();

		return true;
	}

	@Override
	public Boolean visit( VarDeclaration node ) {
		this.writeName( node );

		this.increaseLevel();

		this.indent();
		node.getIdent().accept( this.expressionVisitor );

		this.indent();
		this.write( node.getType().getClass().getSimpleName().toUpperCase() );

		this.decreaseLevel();

		return true;
	}

	@Override
	public Boolean visit( Assignment node ) {
		this.writeName( node );

		this.increaseLevel();

		this.indent();
		node.getIdent().accept( this.expressionVisitor );

		this.indent();
		node.getExpression().accept( this.expressionVisitor );

		this.decreaseLevel();

		return true;
	}

	@Override
	public Boolean visit( FormDeclaration node ) {
		this.writeName( node );

		this.increaseLevel();

		this.indent();
		node.getIdent().accept( this.expressionVisitor );

		this.indent();
		node.getStatements().accept( this );

		this.decreaseLevel();

		return true;
	}

	@Override
	public Boolean visit( QuestionDeclaration node ) {
		this.indent();
		this.writeName( node );

		this.increaseLevel();

		this.indent();
		node.getName().accept( this.expressionVisitor );

		this.indent();
		node.getDeclaration().accept( this );

		this.decreaseLevel();

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
