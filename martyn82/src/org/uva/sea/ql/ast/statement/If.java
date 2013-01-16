package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.visitor.Visitor;

/**
 * Represents an IF-THEN statement block.
 */
public class If extends Statement {
	/**
	 * Holds the condition of the statement.
	 */
	private final Expression condition;
	
	/**
	 * Holds the if body.
	 */
	private final ASTNode ifThen;
	
	/**
	 * Holds the else body.
	 */
	private final Statements ifElse;
	
	/**
	 * Constructs a new IF-statement.
	 * 
	 * @param condition The expression condition.
	 * @param ifThen The if-body.
	 * @param ifElse The else-body.
	 */
	public If( Expression condition, ASTNode ifThen, Statements ifElse ) {
		this.condition = condition;
		this.ifThen = ifThen;
		this.ifElse = ifElse;
	}
	
	public If( Expression condition, ASTNode ifThen ) {
		this( condition, ifThen, null );
	}
	
	public If( Expression condition ) {
		this( condition, null, null );
	}
	
	public Expression getCondition() {
		return this.condition;
	}
	
	public ASTNode getIfThen() {
		return this.ifThen;
	}
	
	public Statements getIfElse() {
		return this.ifElse;
	}

	@Override
	public void accept( Visitor visitor ) {
		visitor.visit( this );
	}
}
