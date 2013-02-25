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

class IdentifierFinder implements IExpressionVisitor<Void> {

	private HashSet<Identifier> identifiers;

	Set<Identifier> findDependencies(final Expression expression) {
		this.identifiers = new HashSet<Identifier>();
		expression.accept(this);
		return this.identifiers;
	}

	@Override
	public Void visit(final Addition element) {
		this.visitBinary(element);
		return null;
	}

	@Override
	public Void visit(final And element) {
		this.visitBinary(element);
		return null;
	}

	@Override
	public Void visit(final BooleanLiteral element) {
		return null;
	}

	@Override
	public Void visit(final Division element) {
		this.visitBinary(element);
		return null;
	}

	@Override
	public Void visit(final Equals element) {
		this.visitBinary(element);
		return null;
	}

	@Override
	public Void visit(final GreaterThan element) {
		this.visitBinary(element);
		return null;
	}

	@Override
	public Void visit(final GreaterThanOrEquals element) {
		this.visitBinary(element);
		return null;
	}

	@Override
	public Void visit(final Identifier element) {
		// Set removes duplicates since Identifier overrides
		// getHashCode and equals to match on name;
		this.identifiers.add(element);
		return null;
	}

	@Override
	public Void visit(final IntegerLiteral element) {
		return null;
	}

	@Override
	public Void visit(final LessThan element) {
		this.visitBinary(element);
		return null;
	}

	@Override
	public Void visit(final LessThanOrEquals element) {
		this.visitBinary(element);
		return null;
	}

	@Override
	public Void visit(final MoneyLiteral element) {
		return null;
	}

	@Override
	public Void visit(final Multiplication element) {
		this.visitBinary(element);
		return null;
	}

	@Override
	public Void visit(final NotEquals element) {
		this.visitBinary(element);
		return null;
	}

	@Override
	public Void visit(final Or element) {
		this.visitBinary(element);
		return null;
	}

	@Override
	public Void visit(final StringLiteral element) {
		return null;
	}

	@Override
	public Void visit(final Subtraction element) {
		this.visitBinary(element);
		return null;
	}

	@Override
	public Void visit(final UnaryMinus element) {
		this.visitUnary(element);
		return null;
	}

	@Override
	public Void visit(final UnaryNot element) {
		this.visitUnary(element);
		return null;
	}

	@Override
	public Void visit(final UnaryPlus element) {
		this.visitUnary(element);
		return null;
	}

	@Override
	public Void visit(final Xor element) {
		this.visitBinary(element);
		return null;
	}

	private void visitBinary(final Binary element) {
		element.getLeft().accept(this);
		element.getRight().accept(this);

	}

	private Void visitUnary(final Unary element) {
		element.getOperand().accept(this);
		return null;
	}
}
