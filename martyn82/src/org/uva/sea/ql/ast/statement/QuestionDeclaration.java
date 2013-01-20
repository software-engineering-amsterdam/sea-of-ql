package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.expression.literal.Str;
import org.uva.sea.ql.eval.Context;
import org.uva.sea.ql.eval.value.Value;
import org.uva.sea.ql.visitor.INodeVisitor;

/**
 * Represents a question declaration.
 */
public class QuestionDeclaration extends Statement {
	/**
	 * Holds the name node.
	 */
	private final Str name;

	/**
	 * Holds the declaration node.
	 */
	private final Statement statement;

	/**
	 * Constructs a new question declaration node.
	 *
	 * @param name
	 * @param declaration
	 */
	public QuestionDeclaration( Str name, VarDeclaration declaration ) {
		this.name = name;
		this.statement = declaration;
	}

	/**
	 * Constructs a new question declaration.
	 *
	 * @param name
	 * @param assignment
	 */
	public QuestionDeclaration( Str name, Assignment assignment ) {
		this.name = name;
		this.statement = assignment;
	}

	/**
	 * Retrieves the name node.
	 *
	 * @return Name AST node.
	 */
	public Str getName() {
		return this.name;
	}

	/**
	 * Retrieves the declaration node.
	 *
	 * @return Declaration AST node.
	 */
	public Statement getDeclaration() {
		return this.statement;
	}

	@Override
	public Value<?> accept( INodeVisitor visitor, Context context ) {
		return visitor.visit( this, context );
	}
}
