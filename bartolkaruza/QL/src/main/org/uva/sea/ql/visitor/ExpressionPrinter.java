package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.ASTNode;
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
import org.uva.sea.ql.ast.expr.value.Bool;
import org.uva.sea.ql.ast.expr.value.Ident;
import org.uva.sea.ql.ast.expr.value.Int;
import org.uva.sea.ql.ast.expr.value.Money;
import org.uva.sea.ql.ast.expr.value.TextString;

public class ExpressionPrinter implements ExpressionVisitor {

	@Override
	public void visit(Ident node) {
		printNodeName(node);
	}

	@Override
	public void visit(Add node) {
		printNodeName(node);
		node.getLhs().accept(this);
		node.getRhs().accept(this);
	}

	@Override
	public void visit(And node) {
		printNodeName(node);
		node.getLhs().accept(this);
		node.getRhs().accept(this);
	}

	@Override
	public void visit(Div node) {
		printNodeName(node);
		node.getLhs().accept(this);
		node.getRhs().accept(this);
	}

	@Override
	public void visit(Eq node) {
		printNodeName(node);
		node.getLhs().accept(this);
		node.getRhs().accept(this);
	}

	@Override
	public void visit(GEq node) {
		printNodeName(node);
		node.getLhs().accept(this);
		node.getRhs().accept(this);
	}

	@Override
	public void visit(GT node) {
		printNodeName(node);
		node.getLhs().accept(this);
		node.getRhs().accept(this);
	}

	@Override
	public void visit(LEq node) {
		printNodeName(node);
		node.getLhs().accept(this);
		node.getRhs().accept(this);
	}

	@Override
	public void visit(LT node) {
		printNodeName(node);
		node.getLhs().accept(this);
		node.getRhs().accept(this);
	}

	@Override
	public void visit(Mul node) {
		printNodeName(node);
		node.getLhs().accept(this);
		node.getRhs().accept(this);
	}

	@Override
	public void visit(Neg node) {
		printNodeName(node);
		node.getRhs().accept(this);
	}

	@Override
	public void visit(NEq node) {
		printNodeName(node);
		node.getLhs().accept(this);
		node.getRhs().accept(this);
	}

	@Override
	public void visit(Not node) {
		printNodeName(node);
		node.getRhs().accept(this);
	}

	@Override
	public void visit(Or node) {
		printNodeName(node);
		node.getLhs().accept(this);
		node.getRhs().accept(this);
	}

	@Override
	public void visit(Pos node) {
		printNodeName(node);
		node.getRhs().accept(this);
	}

	@Override
	public void visit(Sub node) {
		printNodeName(node);
		node.getLhs().accept(this);
		node.getRhs().accept(this);
	}

	@Override
	public void visit(Bool node) {
		printNodeName(node);
	}

	@Override
	public void visit(Int node) {
		printNodeName(node);
	}

	@Override
	public void visit(Money node) {
		printNodeName(node);
	}

	@Override
	public void visit(TextString node) {
		printNodeName(node);
	}
	
	private void printNodeName(ASTNode node) {
		System.out.println("at expression: " + node.getClass().getName());
	}

}
