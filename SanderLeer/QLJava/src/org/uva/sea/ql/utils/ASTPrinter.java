package org.uva.sea.ql.utils;

import org.uva.sea.ql.ast.*;

// Argghhhh, Java only seems to accept static (early-binding) method overloading. This language sucks!
public class ASTPrinter implements ASTNodeVisitor {
	private StringBuilder sb = new StringBuilder();
	private int ident;

	private void print(String s) {
		if (sb.length() > 0) {
			sb.append("\n");
		}
		for (int i = 0; i < (ident *2); i++) {
			sb.append(" ");
		}
		sb.append(s);
	}

	@Override
	public String toString() {
		return sb.toString();
	}
	
	@Override
	public void visit(Pos node) {
		print("+ (pos)");
		ident++;
		node.getExpr().accept(this);
		ident--;
	}

	@Override
	public void visit(Neg node) {
		print("- (neg)");
		ident++;
		node.getExpr().accept(this);
		ident--;
	}

	@Override
	public void visit(Not node) {
		print("! (not)");
		ident++;
		node.getExpr().accept(this);
		ident--;
	}

	@Override
	public void visit(Mul node) {
		print("* (mul)");
		ident++;
		node.getLhs().accept(this);
		node.getRhs().accept(this);
		ident--;
	}

	@Override
	public void visit(Div node) {
		print("/ (div)");
		ident++;
		node.getLhs().accept(this);
		node.getRhs().accept(this);
		ident--;
	}

	@Override
	public void visit(Add node) {
		print("+ (add)");
		ident++;
		node.getLhs().accept(this);
		node.getRhs().accept(this);
		ident--;
	}

	@Override
	public void visit(Sub node) {
		print("- (sub)");
		ident++;
		node.getLhs().accept(this);
		node.getRhs().accept(this);
		ident--;
	}

	@Override
	public void visit(Eq node) {
		print("= (eq)");
		ident++;
		node.getLhs().accept(this);
		node.getRhs().accept(this);
		ident--;
	}

	@Override
	public void visit(NEq node) {
		print("!= (neq)");
		ident++;
		node.getLhs().accept(this);
		node.getRhs().accept(this);
		ident--;
	}

	@Override
	public void visit(GT node) {
		print("> (gt)");
		ident++;
		node.getLhs().accept(this);
		node.getRhs().accept(this);
		ident--;
	}

	@Override
	public void visit(LT node) {
		print("< (lt)");
		ident++;
		node.getLhs().accept(this);
		node.getRhs().accept(this);
		ident--;
	}

	@Override
	public void visit(GEq node) {
		print(">= (geq)");
		ident++;
		node.getLhs().accept(this);
		node.getRhs().accept(this);
		ident--;
	}

	@Override
	public void visit(LEq node) {
		print("<= (leq)");
		ident++;
		node.getLhs().accept(this);
		node.getRhs().accept(this);
		ident--;
	}

	@Override
	public void visit(And node) {
		print("&& (and)");
		ident++;
		node.getLhs().accept(this);
		node.getRhs().accept(this);
		ident--;
	}

	@Override
	public void visit(Or node) {
		print("|| (or)");
		ident++;
		node.getLhs().accept(this);
		node.getRhs().accept(this);
		ident--;
	}

	@Override
	public void visit(Ident node) {
		print(node.getName() + " (ident)");
	}

	@Override
	public void visit(Int node) {
		print(Integer.toString(node.getValue()) + " (int)");
	}

	@Override
	public void visit(Bool node) {
		print((node.getValue() ? "true" : "false") + " (bool)");
	}
}
