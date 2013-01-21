package org.uva.sea.ql.utils;

import org.uva.sea.ql.ast.*;

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
		print("== (eq)");
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
	public void visit(Identifier node) {
		print(node.getName() + " (identifier)");
	}

	@Override
	public void visit(IntegerValue node) {
		print(Integer.toString(node.getValue()) + " (integer)");
	}

	@Override
	public void visit(BooleanValue node) {
		print((node.getValue() ? "true" : "false") + " (boolean)");
	}

	@Override
	public void visit(StringValue node) {
		print("\"" + node.getValue() + "\" (string)");
	}

	@Override
	public void visit(IntegerType node) {
		print("(integer type)");
	}

	@Override
	public void visit(StringType node) {
		print("(string type)");
	}

	@Override
	public void visit(BooleanType node) {
		print("(boolean type)");
	}

	@Override
	public void visit(Form node) {
		print("(form)");
		ident++;
		node.getIdentifier().accept(this);
		node.getStatements().accept(this);
		ident--;
	}

	@Override
	public void visit(StatementList node) {
		print("(statement list)");
		ident++;
		print(node.getList().size() + " statements in list");
		for (ASTNode e : node.getList()) {
			e.accept(this);
		}
		ident--;
	}

	@Override
	public void visit(Question node) {
		print("(question)");
		ident++;
		node.getIdentifier().accept(this);
		node.getLabel().accept(this);
		node.getDatatype().accept(this);
		ident--;
	}

	@Override
	public void visit(ComputedQuestion node) {
		print("(computed question)");
		ident++;
		node.getIdentifier().accept(this);
		node.getLabel().accept(this);
		node.getDatatype().accept(this);
		node.getExpression().accept(this);
		ident--;
	}

	@Override
	public void visit(IfStmt node) {
		print("(if)");
		ident++;
		node.getExpression().accept(this);
		node.getStatements().accept(this);
		ident--;
	}

}