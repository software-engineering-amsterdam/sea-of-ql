package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ICodeLocationInformation;
import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.visitor.IExpressionVisitor;

/**
 * Base class for expressions. Ability to determine/infer result type.
 */
public abstract class Expression extends Node {

	Expression(final ICodeLocationInformation codeLocation) {
		super(codeLocation);
	}

	public abstract <T> T accept(IExpressionVisitor<T> visitor);
}
