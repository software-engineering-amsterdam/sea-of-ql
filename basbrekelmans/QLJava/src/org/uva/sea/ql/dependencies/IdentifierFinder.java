package org.uva.sea.ql.dependencies;

import java.util.HashSet;
import java.util.Set;

import org.uva.sea.ql.ast.expressions.Addition;
import org.uva.sea.ql.ast.expressions.And;
import org.uva.sea.ql.ast.expressions.Binary;
import org.uva.sea.ql.ast.expressions.BooleanLiteral;
import org.uva.sea.ql.ast.expressions.Division;
import org.uva.sea.ql.ast.expressions.Equals;
import org.uva.sea.ql.ast.expressions.Expression;
import org.uva.sea.ql.ast.expressions.GreaterThan;
import org.uva.sea.ql.ast.expressions.GreaterThanOrEquals;
import org.uva.sea.ql.ast.expressions.Identifier;
import org.uva.sea.ql.ast.expressions.IntegerLiteral;
import org.uva.sea.ql.ast.expressions.LessThan;
import org.uva.sea.ql.ast.expressions.LessThanOrEquals;
import org.uva.sea.ql.ast.expressions.MoneyLiteral;
import org.uva.sea.ql.ast.expressions.Multiplication;
import org.uva.sea.ql.ast.expressions.NotEquals;
import org.uva.sea.ql.ast.expressions.Or;
import org.uva.sea.ql.ast.expressions.StringLiteral;
import org.uva.sea.ql.ast.expressions.Subtraction;
import org.uva.sea.ql.ast.expressions.Unary;
import org.uva.sea.ql.ast.expressions.UnaryMinus;
import org.uva.sea.ql.ast.expressions.UnaryNot;
import org.uva.sea.ql.ast.expressions.UnaryPlus;
import org.uva.sea.ql.ast.expressions.Xor;
import org.uva.sea.ql.visitor.IExpressionVisitor;

class IdentifierFinder implements IExpressionVisitor<Set<Identifier>> {

	Set<Identifier> getDependency(final Expression expression) {
		return expression.accept(this);
	}

	@Override
	public Set<Identifier> visit(final Addition element) {
		return this.visitBinary(element);
	}

	@Override
	public Set<Identifier> visit(final And element) {
		return this.visitBinary(element);
	}

	@Override
	public Set<Identifier> visit(final BooleanLiteral element) {
		return null;
	}

	@Override
	public Set<Identifier> visit(final Division element) {
		return this.visitBinary(element);
	}

	@Override
	public Set<Identifier> visit(final Equals element) {
		return this.visitBinary(element);
	}

	@Override
	public Set<Identifier> visit(final GreaterThan element) {
		return this.visitBinary(element);
	}

	@Override
	public Set<Identifier> visit(final GreaterThanOrEquals element) {
		return this.visitBinary(element);
	}

	@Override
	public Set<Identifier> visit(final Identifier element) {
		// Set removes duplicates since Identifier overrides
		// getHashCode and equals to match on name;
		final Set<Identifier> result = new HashSet<Identifier>();
		result.add(element);
		return result;
	}

	@Override
	public Set<Identifier> visit(final IntegerLiteral element) {
		return null;
	}

	@Override
	public Set<Identifier> visit(final LessThan element) {
		return this.visitBinary(element);
	}

	@Override
	public Set<Identifier> visit(final LessThanOrEquals element) {
		return this.visitBinary(element);
	}

	@Override
	public Set<Identifier> visit(final MoneyLiteral element) {
		return null;
	}

	@Override
	public Set<Identifier> visit(final Multiplication element) {
		return this.visitBinary(element);
	}

	@Override
	public Set<Identifier> visit(final NotEquals element) {
		return this.visitBinary(element);
	}

	@Override
	public Set<Identifier> visit(final Or element) {
		return this.visitBinary(element);
	}

	@Override
	public Set<Identifier> visit(final StringLiteral element) {
		return null;
	}

	@Override
	public Set<Identifier> visit(final Subtraction element) {
		return this.visitBinary(element);
	}

	@Override
	public Set<Identifier> visit(final UnaryMinus element) {
		return this.visitUnary(element);
	}

	@Override
	public Set<Identifier> visit(final UnaryNot element) {
		return this.visitUnary(element);
	}

	@Override
	public Set<Identifier> visit(final UnaryPlus element) {
		return this.visitUnary(element);
	}

	@Override
	public Set<Identifier> visit(final Xor element) {
		return this.visitBinary(element);
	}

	private Set<Identifier> visitBinary(final Binary element) {
		final Set<Identifier> left = element.getLeft().accept(this);
		final Set<Identifier> right = element.getRight().accept(this);
		if (left == null) {
			return right;
		} else if (right == null) {
			return left;
		} else {
			left.addAll(right);
			return left;
		}
	}

	private Set<Identifier> visitUnary(final Unary element) {
		return element.getOperand().accept(this);
	}
}
