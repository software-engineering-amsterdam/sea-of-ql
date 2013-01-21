package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.ConditionalStatement;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.And;
import org.uva.sea.ql.ast.expr.Div;
import org.uva.sea.ql.ast.expr.Eq;
import org.uva.sea.ql.ast.expr.GEq;
import org.uva.sea.ql.ast.expr.GT;
import org.uva.sea.ql.ast.expr.LEq;
import org.uva.sea.ql.ast.expr.LT;
import org.uva.sea.ql.ast.expr.Mul;
import org.uva.sea.ql.ast.expr.NEq;
import org.uva.sea.ql.ast.expr.Neg;
import org.uva.sea.ql.ast.expr.Not;
import org.uva.sea.ql.ast.expr.Or;
import org.uva.sea.ql.ast.expr.Pos;
import org.uva.sea.ql.ast.expr.Sub;
import org.uva.sea.ql.ast.expr.grouping.Expr;

/**
 * Abstract tree walker that gives implementing visitors a default left
 * recursive traversal for all nodes. Special visitor logic can be implemented
 * before or after child node traversal by implementing the corresponding
 * abstract methods For leaf nodes the default visit methods can be used
 * 
 * @author bartol
 * 
 */
public abstract class AbstractTreeWalker implements NodeVisitor {

	@Override
	public void visit(Form node) {
		beforeForm(node);
		for (Statement statement : node.getStatements()) {
			if (statement != null) {
				statement.accept(this);
			}
		}
		afterForm(node);
	}

	protected abstract void beforeForm(Form node);

	protected abstract void afterForm(Form node);

	public void visit(Question node) {
		node.getExpression().accept(this);
		atQuestion(node);
	};

	protected abstract void atQuestion(Question node);

	@Override
	public void visit(ConditionalStatement node) {
		beforeConditionalStatement(node);
		node.getExpression().accept(this);
		for (Statement statement : node.getStatements()) {
			if (statement != null) {
				statement.accept(this);
			}
		}
		afterConditionalStatement(node);
	}

	protected abstract void beforeConditionalStatement(ConditionalStatement node);

	protected abstract void afterConditionalStatement(ConditionalStatement node);

	@Override
	public void visit(Add node) {
		beforeAdd(node);
		acceptTwoSidedExpressionChildren(node);
		afterAdd(node);
	}

	protected abstract void beforeAdd(Add node);

	protected abstract void afterAdd(Add node);

	@Override
	public void visit(And node) {
		beforeAnd(node);
		acceptTwoSidedExpressionChildren(node);
		afterAnd(node);
	}

	protected abstract void beforeAnd(And node);

	protected abstract void afterAnd(And node);

	@Override
	public void visit(Div node) {
		beforeDiv(node);
		acceptTwoSidedExpressionChildren(node);
		afterDiv(node);
	}

	protected abstract void beforeDiv(Div node);

	protected abstract void afterDiv(Div node);

	@Override
	public void visit(Eq node) {
		beforeEq(node);
		acceptTwoSidedExpressionChildren(node);
		afterEq(node);
	}

	protected abstract void beforeEq(Eq node);

	protected abstract void afterEq(Eq node);

	@Override
	public void visit(GEq node) {
		beforeGEq(node);
		acceptTwoSidedExpressionChildren(node);
		afterGEq(node);
	}

	protected abstract void beforeGEq(GEq node);

	protected abstract void afterGEq(GEq node);

	@Override
	public void visit(GT node) {
		beforeGT(node);
		acceptTwoSidedExpressionChildren(node);
		afterGT(node);
	}

	protected abstract void beforeGT(GT node);

	protected abstract void afterGT(GT node);

	@Override
	public void visit(LEq node) {
		beforeLEq(node);
		acceptTwoSidedExpressionChildren(node);
		afterLEq(node);
	}

	protected abstract void beforeLEq(LEq node);

	protected abstract void afterLEq(LEq node);

	@Override
	public void visit(LT node) {
		beforeLT(node);
		acceptTwoSidedExpressionChildren(node);
		afterLT(node);
	}

	protected abstract void beforeLT(LT node);

	protected abstract void afterLT(LT node);

	@Override
	public void visit(Mul node) {
		beforeMul(node);
		acceptTwoSidedExpressionChildren(node);
		afterMul(node);
	}

	protected abstract void beforeMul(Mul node);

	protected abstract void afterMul(Mul node);

	@Override
	public void visit(Neg node) {
		beforeNeg(node);
		acceptOneSidedExpressionChildren(node);
		afterNeg(node);
	}

	protected abstract void beforeNeg(Neg node);

	protected abstract void afterNeg(Neg node);

	@Override
	public void visit(NEq node) {
		beforeNEq(node);
		acceptTwoSidedExpressionChildren(node);
		afterNEq(node);
	}

	protected abstract void beforeNEq(NEq node);

	protected abstract void afterNEq(NEq node);

	@Override
	public void visit(Not node) {
		beforeNot(node);
		acceptOneSidedExpressionChildren(node);
		afterNot(node);
	}

	protected abstract void beforeNot(Not node);

	protected abstract void afterNot(Not node);

	@Override
	public void visit(Or node) {
		beforeOr(node);
		acceptTwoSidedExpressionChildren(node);
		afterOr(node);
	}

	protected abstract void beforeOr(Or node);

	protected abstract void afterOr(Or node);

	@Override
	public void visit(Pos node) {
		beforePos(node);
		acceptOneSidedExpressionChildren(node);
		afterPos(node);
	}

	protected abstract void beforePos(Pos node);

	protected abstract void afterPos(Pos node);

	@Override
	public void visit(Sub node) {
		beforeSub(node);
		acceptTwoSidedExpressionChildren(node);
		afterSub(node);
	}

	protected abstract void beforeSub(Sub node);

	protected abstract void afterSub(Sub node);

	private void acceptTwoSidedExpressionChildren(Expr node) {
		node.getLhs().accept(this);
		node.getRhs().accept(this);
	}

	private void acceptOneSidedExpressionChildren(Expr node) {
		node.getLhs().accept(this);
	}

}
