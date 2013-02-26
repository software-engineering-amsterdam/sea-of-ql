package eu.karuza.ql.visitor.impl;


import eu.karuza.ql.ast.ASTNode;
import eu.karuza.ql.ast.expr.Add;
import eu.karuza.ql.ast.expr.And;
import eu.karuza.ql.ast.expr.Div;
import eu.karuza.ql.ast.expr.Eq;
import eu.karuza.ql.ast.expr.GEq;
import eu.karuza.ql.ast.expr.GT;
import eu.karuza.ql.ast.expr.LEq;
import eu.karuza.ql.ast.expr.LT;
import eu.karuza.ql.ast.expr.Mul;
import eu.karuza.ql.ast.expr.NEq;
import eu.karuza.ql.ast.expr.Neg;
import eu.karuza.ql.ast.expr.Not;
import eu.karuza.ql.ast.expr.Or;
import eu.karuza.ql.ast.expr.Pos;
import eu.karuza.ql.ast.expr.Sub;
import eu.karuza.ql.ast.value.Bool;
import eu.karuza.ql.ast.value.Ident;
import eu.karuza.ql.ast.value.Int;
import eu.karuza.ql.ast.value.Money;
import eu.karuza.ql.ast.value.Text;
import eu.karuza.ql.visitor.ExpressionVisitor;

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
