package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ICodeLocationInformation;

/**
 * Abstract implementation of a binary expression. Provides basic implementation
 * and constructor for a left/right binary expression node.
 */
public abstract class Binary extends Expression {

	private final Expression left;
	private final Expression right;

	Binary(final ICodeLocationInformation codeLocation, final Expression left,
			final Expression right) {
		super(codeLocation);
		this.left = left;
		this.right = right;
	}

	public Expression getLeft() {
		return this.left;
	}

	public Expression getRight() {
		return this.right;
	}
}
