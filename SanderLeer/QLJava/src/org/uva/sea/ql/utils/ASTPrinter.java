package org.uva.sea.ql.utils;

import java.io.PrintStream;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.datatype.*;
import org.uva.sea.ql.ast.expression.*;
import org.uva.sea.ql.ast.expression.binary.*;
import org.uva.sea.ql.ast.expression.literal.*;
import org.uva.sea.ql.ast.expression.unary.*;
import org.uva.sea.ql.ast.statement.*;

public class ASTPrinter implements Visitor<Void> {
	private StringBuilder sb = new StringBuilder();
	private int ident;

	private ASTPrinter() {
	}

	private void print(String s) {
		if (sb.length() > 0) {
			sb.append("\n");
		}
		for (int i = 0; i < (ident *2); i++) {
			sb.append(" ");
		}
		sb.append(s);
	}

	public static void print(ASTNode ast, PrintStream out) {
		ASTPrinter astPrinter = new ASTPrinter();
		ast.accept(astPrinter);
		out.println(astPrinter.toString());
	}

	@Override
	public String toString() {
		return sb.toString();
	}
	
	@Override
	public Void visit(Pos node) {
		print("+ (pos)");
		ident++;
		node.getOperand().accept(this);
		ident--;
		return null;
	}

	@Override
	public Void visit(Neg node) {
		print("- (neg)");
		ident++;
		node.getOperand().accept(this);
		ident--;
		return null;
	}

	@Override
	public Void visit(Not node) {
		print("! (not)");
		ident++;
		node.getOperand().accept(this);
		ident--;
		return null;
	}

	@Override
	public Void visit(Mul node) {
		print("* (mul)");
		ident++;
		node.getLhs().accept(this);
		node.getRhs().accept(this);
		ident--;
		return null;
	}

	@Override
	public Void visit(Div node) {
		print("/ (div)");
		ident++;
		node.getLhs().accept(this);
		node.getRhs().accept(this);
		ident--;
		return null;
	}

	@Override
	public Void visit(Add node) {
		print("+ (add)");
		ident++;
		node.getLhs().accept(this);
		node.getRhs().accept(this);
		ident--;
		return null;
	}

	@Override
	public Void visit(Sub node) {
		print("- (sub)");
		ident++;
		node.getLhs().accept(this);
		node.getRhs().accept(this);
		ident--;
		return null;
	}

	@Override
	public Void visit(Eq node) {
		print("== (eq)");
		ident++;
		node.getLhs().accept(this);
		node.getRhs().accept(this);
		ident--;
		return null;
	}

	@Override
	public Void visit(NEq node) {
		print("!= (neq)");
		ident++;
		node.getLhs().accept(this);
		node.getRhs().accept(this);
		ident--;
		return null;
	}

	@Override
	public Void visit(GT node) {
		print("> (gt)");
		ident++;
		node.getLhs().accept(this);
		node.getRhs().accept(this);
		ident--;
		return null;
	}

	@Override
	public Void visit(LT node) {
		print("< (lt)");
		ident++;
		node.getLhs().accept(this);
		node.getRhs().accept(this);
		ident--;
		return null;
	}

	@Override
	public Void visit(GEq node) {
		print(">= (geq)");
		ident++;
		node.getLhs().accept(this);
		node.getRhs().accept(this);
		ident--;
		return null;
	}

	@Override
	public Void visit(LEq node) {
		print("<= (leq)");
		ident++;
		node.getLhs().accept(this);
		node.getRhs().accept(this);
		ident--;
		return null;
	}

	@Override
	public Void visit(And node) {
		print("&& (and)");
		ident++;
		node.getLhs().accept(this);
		node.getRhs().accept(this);
		ident--;
		return null;
	}

	@Override
	public Void visit(Or node) {
		print("|| (or)");
		ident++;
		node.getLhs().accept(this);
		node.getRhs().accept(this);
		ident--;
		return null;
	}

	@Override
	public Void visit(Identifier node) {
		print(node.getName() + " (identifier)");
		return null;
	}

	@Override
	public Void visit(IntegerLiteral node) {
		print(Integer.toString(node.getValue()) + " (integer literal)");
		return null;
	}

	@Override
	public Void visit(BooleanLiteral node) {
		print((node.getValue() ? "true" : "false") + " (boolean literal)");
		return null;
	}

	@Override
	public Void visit(StringLiteral node) {
		print("\"" + node.getValue() + "\" (string literal)");
		return null;
	}

	@Override
	public Void visit(IntegerType node) {
		print("(integer type)");
		return null;
	}

	@Override
	public Void visit(StringType node) {
		print("(string type)");
		return null;
	}

	@Override
	public Void visit(BooleanType node) {
		print("(boolean type)");
		return null;
	}

	@Override
	public Void visit(Form node) {
		print("(form)");
		ident++;
		node.getIdentifier().accept(this);
		node.getStatements().accept(this);
		ident--;
		return null;
	}

	@Override
	public Void visit(StatementList node) {
		print("(statementlist)");
		ident++;
		print(node.getList().size() + " statements in list");
		for (ASTNode e : node.getList()) {
			e.accept(this);
		}
		ident--;
		return null;
	}

	@Override
	public Void visit(Question node) {
		print("(question)");
		ident++;
		node.getIdentifier().accept(this);
		node.getLabel().accept(this);
		node.getDatatype().accept(this);
		ident--;
		return null;
	}

	@Override
	public Void visit(ComputedQuestion node) {
		print("(computed question)");
		ident++;
		node.getIdentifier().accept(this);
		node.getLabel().accept(this);
		node.getDatatype().accept(this);
		node.getExpression().accept(this);
		ident--;
		return null;
	}

	@Override
	public Void visit(IfStatement node) {
		print("(if)");
		ident++;
		node.getExpression().accept(this);
		node.getStatements().accept(this);
		ident--;
		return null;
	}
}
