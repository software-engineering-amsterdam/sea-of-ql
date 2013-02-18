package org.uva.sea.ql.core.dom.operators;

import org.uva.sea.ql.core.dom.Expression;

public abstract class ConditionalOperator extends Expression {
		
		private final Expression lhs;
		private final Expression rhs;

		public ConditionalOperator(Expression lhs, Expression rhs) {
			this.lhs = lhs;
			this.rhs = rhs;
		}
}
