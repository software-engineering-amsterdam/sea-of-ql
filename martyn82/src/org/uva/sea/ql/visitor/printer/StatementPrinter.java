package org.uva.sea.ql.visitor.printer;

import java.io.OutputStream;

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

public class StatementPrinter extends PrintVisitor implements IStatementVisitor<Boolean> {
	/**
	 * Holds the expression visitor.
	 */
	private final ExpressionPrinter expressionVisitor;

	/**
	 * Constructs a new StatementPrinter instance.
	 *
	 * @param out
	 * @param expressionVisitor
	 */
	public StatementPrinter( OutputStream out, ExpressionPrinter expressionVisitor ) {
		super( out );
		this.expressionVisitor = expressionVisitor;
	}

	@Override
	public Boolean visit( Else node ) {
		indent();
		write( "ELSE" );

		level++;

		indent();
		node.getBody().accept( this );

		level--;

		return true;
	}

	@Override
	public Boolean visit( IfThenElse node ) {
		indent();
		write( "IF" );

		level++;

		indent();
		node.getCondition().accept( this.expressionVisitor );

		level--;

		indent();
		write( "THEN" );

		if ( node.hasIfBody() ) {
			level++;

			indent();
			node.getIfBody().accept( this );

			level--;
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

		level++;

		indent();
		node.getCondition().accept( this.expressionVisitor );

		level--;

		indent();
		write( "THEN" );

		level++;

		node.getBody().accept( this );

		level--;

		return true;
	}

	@Override
	public Boolean visit( VarDeclaration node ) {
		writeName( node );

		level++;

		indent();
		node.getIdent().accept( this.expressionVisitor );

		indent();
		write( node.getType().getClass().getSimpleName().toUpperCase() );

		level--;

		return true;
	}

	@Override
	public Boolean visit( Assignment node ) {
		writeName( node );

		level++;

		indent();
		node.getIdent().accept( this.expressionVisitor );

		indent();
		node.getExpression().accept( this.expressionVisitor );

		level--;

		return true;
	}

	@Override
	public Boolean visit( FormDeclaration node ) {
		writeName( node );

		level++;

		indent();
		node.getIdent().accept( this.expressionVisitor );

		indent();
		node.getStatements().accept( this );

		level--;

		return true;
	}

	@Override
	public Boolean visit( QuestionDeclaration node ) {
		indent();
		writeName( node );

		level++;

		indent();
		node.getName().accept( this.expressionVisitor );

		indent();
		node.getDeclaration().accept( this );

		level--;

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
