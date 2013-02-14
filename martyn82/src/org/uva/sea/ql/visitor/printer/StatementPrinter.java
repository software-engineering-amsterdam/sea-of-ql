package org.uva.sea.ql.visitor.printer;

import org.uva.sea.ql.ast.statement.Assignment;
import org.uva.sea.ql.ast.statement.FormDeclaration;
import org.uva.sea.ql.ast.statement.IfThen;
import org.uva.sea.ql.ast.statement.IfThenElse;
import org.uva.sea.ql.ast.statement.ComputedQuestion;
import org.uva.sea.ql.ast.statement.VariableQuestion;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.ast.statement.Statements;
import org.uva.sea.ql.ast.statement.VariableDeclaration;
import org.uva.sea.ql.visitor.StatementVisitor;

public class StatementPrinter implements StatementVisitor<String> {
	private static final String TPL_BLOCK_IFTHENELSE = "( IF %s THEN %s ELSE %s )";
	private static final String TPL_VARDECLARATION = "( VAR %s : %s )";
	private static final String TPL_ASSIGNMENT = "( VAR %s = %s )";
	private static final String TPL_FORMDECLARATION = "( FORM %s %s )";
	private static final String TPL_QUESTION = "( QUESTION %s %s )";

	private final ExpressionPrinter expressionVisitor;

	public StatementPrinter( ExpressionPrinter expressionVisitor ) {
		this.expressionVisitor = expressionVisitor;
	}

	@Override
	public String visit( IfThen node ) {
		return node.getBody().accept( this );
	}

	@Override
	public String visit( IfThenElse node ) {
		String condition = node.getCondition().accept( this.expressionVisitor );
		String then = node.getBody().accept( this );
		String elseBody = node.getElse().accept( this );

		return String.format( TPL_BLOCK_IFTHENELSE, condition, then, elseBody );
	}

	@Override
	public String visit( VariableDeclaration node ) {
		String identifier = node.getIdentifier().accept( this.expressionVisitor );
		String type = node.getType().getName();
		return String.format( TPL_VARDECLARATION, identifier, type );
	}

	@Override
	public String visit( Assignment node ) {
		String identifier = node.getIdentifier().accept( this.expressionVisitor );
		String expression = node.getExpression().accept( this.expressionVisitor );
		return String.format( TPL_ASSIGNMENT, identifier, expression );
	}

	@Override
	public String visit( FormDeclaration node ) {
		String label = node.getLabel();
		String body = node.getBody().accept( this );
		return String.format( TPL_FORMDECLARATION, label, body );
	}

	@Override
	public String visit( VariableQuestion node ) {
		String label = node.getLabel().accept( this.expressionVisitor );
		String body = node.getVarDeclaration().accept( this );
		return String.format( TPL_QUESTION, label, body );
	}

	@Override
	public String visit( ComputedQuestion node ) {
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
