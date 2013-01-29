package org.uva.sea.ql.dependencies;

import java.util.HashSet;
import java.util.Set;

import org.uva.sea.ql.ast.IExpressionVisitor;
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
import org.uva.sea.ql.ast.expressions.UnaryMinus;
import org.uva.sea.ql.ast.expressions.UnaryNot;
import org.uva.sea.ql.ast.expressions.UnaryPlus;
import org.uva.sea.ql.ast.expressions.Xor;

public class IdentifierFinder implements IExpressionVisitor<Set<Identifier>> {

	@Override
	public Set<Identifier> visit(Addition element) {
		return visitBinary(element);
	}

	@Override
	public Set<Identifier> visit(Division element) {
		return visitBinary(element);
	}

	@Override
	public Set<Identifier> visit(Multiplication element) {
		return visitBinary(element);
	}

	@Override
	public Set<Identifier> visit(Subtraction element) {
		return visitBinary(element);
	}

	@Override
	public Set<Identifier> visit(Equals element) {
		return visitBinary(element);
	}

	@Override
	public Set<Identifier> visit(GreaterThan element) {
		return visitBinary(element);
	}

	@Override
	public Set<Identifier> visit(GreaterThanOrEquals element) {
		return visitBinary(element);
	}

	@Override
	public Set<Identifier> visit(LessThan element) {
		return visitBinary(element);
	}

	@Override
	public Set<Identifier> visit(LessThanOrEquals element) {
		return visitBinary(element);
	}

	@Override
	public Set<Identifier> visit(NotEquals element) {
		return visitBinary(element);
	}

	@Override
	public Set<Identifier> visit(And element) {
		return visitBinary(element);
	}

	@Override
	public Set<Identifier> visit(Or element) {
		return visitBinary(element);
	}

	@Override
	public Set<Identifier> visit(Xor element) {
		return visitBinary(element);
	}

	@Override
	public Set<Identifier> visit(BooleanLiteral element) {
		return null;
	}

	@Override
	public Set<Identifier> visit(IntegerLiteral element) {
		return null;
	}

	@Override
	public Set<Identifier> visit(MoneyLiteral element) {
		return null;
	}

	@Override
	public Set<Identifier> visit(StringLiteral element) {
		return null;
	}

	@Override
	public Set<Identifier> visit(Identifier element) {
		// Set removes duplicates since Identifier overrides
		// getHashCode and equals to match on name;
		Set<Identifier> result = new HashSet<Identifier>();
		result.add(element);
		return result;
	}

	@Override
	public Set<Identifier> visit(UnaryNot element) {
		return element.getOperand().accept(this);
	}

	@Override
	public Set<Identifier> visit(UnaryMinus element) {
		return element.getOperand().accept(this);
	}

	@Override
	public Set<Identifier> visit(UnaryPlus element) {
		return element.getOperand().accept(this);
	}
	

	private Set<Identifier> visitBinary(Binary element) {
		Set<Identifier> left = element.getLeft().accept(this);
		Set<Identifier> right = element.getRight().accept(this);
		if (left == null) {
			return right;
		} else if (right == null) {
			return left;
		} else {
			left.addAll(right);
			return left;
		}
 	}

	public Set<Identifier> getDependency(Expression expression) {
		return expression.accept(this);
	}
}
