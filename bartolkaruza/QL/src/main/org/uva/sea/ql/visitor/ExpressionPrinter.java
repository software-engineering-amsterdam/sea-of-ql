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
import org.uva.sea.ql.ast.expr.value.Text;

public class ExpressionPrinter implements ExpressionVisitor<Void> {

	@Override
	public Void visit(Ident node) {
		printNodeName(node);
		return null;
	}

	@Override
	public Void visit(Add node) {
		printNodeName(node);
		node.getLhs().accept(this);
		node.getRhs().accept(this);
		return null;
	}

	@Override
	public Void visit(And node) {
		printNodeName(node);
		node.getLhs().accept(this);
		node.getRhs().accept(this);
		return null;
	}

	@Override
	public Void visit(Div node) {
		printNodeName(node);
		node.getLhs().accept(this);
		node.getRhs().accept(this);
		return null;
	}

	@Override
	public Void visit(Eq node) {
		printNodeName(node);
		node.getLhs().accept(this);
		node.getRhs().accept(this);
		return null;
	}

	@Override
	public Void visit(GEq node) {
		printNodeName(node);
		node.getLhs().accept(this);
		node.getRhs().accept(this);
		return null;
	}

	@Override
	public Void visit(GT node) {
		printNodeName(node);
		node.getLhs().accept(this);
		node.getRhs().accept(this);
		return null;
	}

	@Override
	public Void visit(LEq node) {
		printNodeName(node);
		node.getLhs().accept(this);
		node.getRhs().accept(this);
		return null;
	}

	@Override
	public Void visit(LT node) {
		printNodeName(node);
		node.getLhs().accept(this);
		node.getRhs().accept(this);
		return null;
	}

	@Override
	public Void visit(Mul node) {
		printNodeName(node);
		node.getLhs().accept(this);
		node.getRhs().accept(this);
		return null;
	}

	@Override
	public Void visit(Neg node) {
		printNodeName(node);
		node.getRhs().accept(this);
		return null;
	}

	@Override
	public Void visit(NEq node) {
		printNodeName(node);
		node.getLhs().accept(this);
		node.getRhs().accept(this);
		return null;
	}

	@Override
	public Void visit(Not node) {
		printNodeName(node);
		node.getRhs().accept(this);
		return null;
	}

	@Override
	public Void visit(Or node) {
		printNodeName(node);
		node.getLhs().accept(this);
		node.getRhs().accept(this);
		return null;
	}

	@Override
	public Void visit(Pos node) {
		printNodeName(node);
		node.getRhs().accept(this);
		return null;
	}

	@Override
	public Void visit(Sub node) {
		printNodeName(node);
		node.getLhs().accept(this);
		node.getRhs().accept(this);
		return null;
	}

	@Override
	public Void visit(Bool node) {
		printNodeName(node);
		return null;
	}

	@Override
	public Void visit(Int node) {
		printNodeName(node);
		return null;
	}

	@Override
	public Void visit(Money node) {
		printNodeName(node);
		return null;
	}

	@Override
	public Void visit(Text node) {
		printNodeName(node);
		return null;
	}
	
	private Void printNodeName(ASTNode node) {
		System.out.println("at expression: " + node.getClass().getName());
		return null;
	}

}
