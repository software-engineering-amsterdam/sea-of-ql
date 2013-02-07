package org.uva.sea.ql.visitor.printer;

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
import org.uva.sea.ql.visitor.StatementVisitor;

/**
 * Represents a pretty printer for statement nodes.
 */
public class StatementWalker implements StatementVisitor<String> {
	private static final String TPL_BLOCK_IFTHENELSE = "( IF %s THEN %s %s ELSE %s )";
	private static final String TPL_BLOCK_ELSEIF = "( ELSEIF %s THEN %s )";
	private static final String TPL_VARDECLARATION = "( VAR %s : %s )";
	private static final String TPL_ASSIGNMENT = "( VAR %s = %s )";
	private static final String TPL_FORMDECLARATION = "( FORM %s %s )";
	private static final String TPL_QUESTION = "( QUESTION %s %s )";

	/**
	 * Holds the expression visitor.
	 */
	private final ExpressionWalker expressionVisitor;

	/**
	 * Constructs a new StatementPrinter instance.
	 *
	 * @param expressionVisitor
	 */
	public StatementWalker( ExpressionWalker expressionVisitor ) {
		this.expressionVisitor = expressionVisitor;
	}

	@Override
	public String visit( Else node ) {
		return node.getBody().accept( this );
	}

	@Override
	public String visit( IfThenElse node ) {
		String condition = node.getCondition().accept( this.expressionVisitor );
		String then = node.hasIfBody() ? node.getIfBody().accept( this ) : "";
		String elseIfs = node.hasElseIfs() ? node.getElseIfs().accept( this ) : "";
		String elseBody = node.hasElse() ? node.getElse().accept( this ) : "";
		return String.format( TPL_BLOCK_IFTHENELSE, condition, then, elseIfs, elseBody );
	}

	@Override
	public String visit( ElseIfs node ) {
		StringBuilder sb = new StringBuilder();

		for ( ElseIf elseIf : node ) {
			sb.append( elseIf.accept( this ) );
		}

		return sb.toString();
	}

	@Override
	public String visit( ElseIf node ) {
		String condition = node.getCondition().accept( this.expressionVisitor );
		String body = node.getBody().accept( this );
		return String.format( TPL_BLOCK_ELSEIF, condition, body );
	}

	@Override
	public String visit( VarDeclaration node ) {
		String identifier = node.getIdent().accept( this.expressionVisitor );
		String type = node.getType().toString();
		return String.format( TPL_VARDECLARATION, identifier, type );
	}

	@Override
	public String visit( Assignment node ) {
		String identifier = node.getIdent().accept( this.expressionVisitor );
		String expression = node.getExpression().accept( this.expressionVisitor );
		return String.format( TPL_ASSIGNMENT, identifier, expression );
	}

	@Override
	public String visit( FormDeclaration node ) {
		String identifier = node.getIdent().accept( this.expressionVisitor );
		String body = node.getStatements().accept( this );
		return String.format( TPL_FORMDECLARATION, identifier, body );
	}

	@Override
	public String visit( QuestionVar node ) {
		String label = node.getLabel().accept( this.expressionVisitor );
		String body = node.getVarDeclaration().accept( this );
		return String.format( TPL_QUESTION, label, body );
	}

	@Override
	public String visit( QuestionComputed node ) {
		String label = node.getLabel().accept( this.expressionVisitor );
		String body = node.getAssignment().accept( this );
		return String.format( TPL_QUESTION, label, body );
	}

	@Override
	public String visit( Statements node ) {
		StringBuilder sb = new StringBuilder();

		for ( Statement statement : node ) {
			sb.append( statement.accept( this ) );
		}

		return sb.toString();
	}
}
