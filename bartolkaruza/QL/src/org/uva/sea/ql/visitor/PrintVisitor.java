package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.ConditionalStatement;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.And;
import org.uva.sea.ql.ast.expr.Div;
import org.uva.sea.ql.ast.expr.Eq;
import org.uva.sea.ql.ast.expr.GEq;
import org.uva.sea.ql.ast.expr.GT;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.LEq;
import org.uva.sea.ql.ast.expr.LT;
import org.uva.sea.ql.ast.expr.Mul;
import org.uva.sea.ql.ast.expr.NEq;
import org.uva.sea.ql.ast.expr.Neg;
import org.uva.sea.ql.ast.expr.Not;
import org.uva.sea.ql.ast.expr.Or;
import org.uva.sea.ql.ast.expr.Pos;
import org.uva.sea.ql.ast.expr.Sub;
import org.uva.sea.ql.ast.expr.value.Bool;
import org.uva.sea.ql.ast.expr.value.Int;
import org.uva.sea.ql.ast.expr.value.Money;
import org.uva.sea.ql.ast.expr.value.TextString;

public class PrintVisitor extends LeftRecursiveVisitor {

	@Override
	public void visit(Ident node) {
		printNodeClassNameBefore(node);
		printNodeClassNameAfter(node);
	}

	@Override
	public void visit(Int node) {
		printNodeClassNameBefore(node);
		printNodeClassNameAfter(node);
	}

	@Override
	public void visit(Question node) {
		printNodeClassNameBefore(node);
		printNodeClassNameAfter(node);
	}

	@Override
	protected void beforeForm(Form node) {
		printNodeClassNameBefore(node);
	}

	@Override
	protected void afterForm(Form node) {
		printNodeClassNameAfter(node);
	}

	@Override
	protected void beforeConditionalStatement(ConditionalStatement node) {
		printNodeClassNameBefore(node);
	}

	@Override
	protected void afterConditionalStatement(ConditionalStatement node) {
		printNodeClassNameAfter(node);
	}

	@Override
	protected void beforeAdd(Add node) {
		printNodeClassNameBefore(node);
	}

	@Override
	protected void afterAdd(Add node) {
		printNodeClassNameAfter(node);
	}

	@Override
	protected void beforeAnd(And node) {
		printNodeClassNameBefore(node);
	}

	@Override
	protected void afterAnd(And node) {
		printNodeClassNameAfter(node);
	}

	@Override
	protected void beforeDiv(Div node) {
		printNodeClassNameBefore(node);
	}

	@Override
	protected void afterDiv(Div node) {
		printNodeClassNameAfter(node);
	}

	@Override
	protected void beforeEq(Eq node) {
		printNodeClassNameBefore(node);
	}

	@Override
	protected void afterEq(Eq node) {
		printNodeClassNameAfter(node);
	}

	@Override
	protected void beforeGEq(GEq node) {
		printNodeClassNameBefore(node);
	}

	@Override
	protected void afterGEq(GEq node) {
		printNodeClassNameAfter(node);
	}

	@Override
	protected void beforeGT(GT node) {
		printNodeClassNameBefore(node);
	}

	@Override
	protected void afterGT(GT node) {
		printNodeClassNameAfter(node);
	}

	@Override
	protected void beforeLEq(LEq node) {
		printNodeClassNameBefore(node);
	}

	@Override
	protected void afterLEq(LEq node) {
		printNodeClassNameAfter(node);
	}

	@Override
	protected void beforeLT(LT node) {
		printNodeClassNameBefore(node);
	}

	@Override
	protected void afterLT(LT node) {
		printNodeClassNameAfter(node);
	}

	@Override
	protected void beforeMul(Mul node) {
		printNodeClassNameBefore(node);
	}

	@Override
	protected void afterMul(Mul node) {
		printNodeClassNameAfter(node);
	}

	@Override
	protected void beforeNeg(Neg node) {
		printNodeClassNameBefore(node);
	}

	@Override
	protected void afterNeg(Neg node) {
		printNodeClassNameAfter(node);
	}

	@Override
	protected void beforeNEq(NEq node) {
		printNodeClassNameBefore(node);
	}

	@Override
	protected void afterNEq(NEq node) {
		printNodeClassNameAfter(node);
	}

	@Override
	protected void beforeNot(Not node) {
		printNodeClassNameBefore(node);
	}

	@Override
	protected void afterNot(Not node) {
		printNodeClassNameAfter(node);
	}

	@Override
	protected void beforeOr(Or node) {
		printNodeClassNameBefore(node);
	}

	@Override
	protected void afterOr(Or node) {
		printNodeClassNameAfter(node);
	}

	@Override
	protected void beforePos(Pos node) {
		printNodeClassNameBefore(node);
	}

	@Override
	protected void afterPos(Pos node) {
		printNodeClassNameAfter(node);
	}

	@Override
	protected void beforeSub(Sub node) {
		printNodeClassNameBefore(node);
	}

	@Override
	protected void afterSub(Sub node) {
		printNodeClassNameAfter(node);
	}
	
	private void printNodeClassNameBefore(ASTNode node) {
		System.out.println("At start of node: " + node.getClass().getName());
	}
	
	private void printNodeClassNameAfter(ASTNode node) {
		System.out.println("After node: " + node.getClass().getName());
	}

	@Override
	public void visit(Bool node) {
		System.out.println("At start of node: " + node.getClass().getName());
		System.out.println("After node: " + node.getClass().getName());
	}

	@Override
	public void visit(Money node) {
		System.out.println("At start of node: " + node.getClass().getName());
		System.out.println("After node: " + node.getClass().getName());
	}

	@Override
	public void visit(TextString node) {
		System.out.println("At start of node: " + node.getClass().getName());
		System.out.println("After node: " + node.getClass().getName());
	}

}
