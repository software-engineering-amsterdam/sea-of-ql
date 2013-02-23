package org.uva.sea.ql.visitor;

import java.util.Iterator;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.CompoundStatement;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.IfElseStatement;
import org.uva.sea.ql.ast.IfStatement;
import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.expression.binary.Add;
import org.uva.sea.ql.ast.expression.binary.And;
import org.uva.sea.ql.ast.expression.binary.Div;
import org.uva.sea.ql.ast.expression.binary.Eq;
import org.uva.sea.ql.ast.expression.binary.GEq;
import org.uva.sea.ql.ast.expression.binary.GT;
import org.uva.sea.ql.ast.expression.binary.LEq;
import org.uva.sea.ql.ast.expression.binary.LT;
import org.uva.sea.ql.ast.expression.binary.Mul;
import org.uva.sea.ql.ast.expression.binary.NEq;
import org.uva.sea.ql.ast.expression.binary.Or;
import org.uva.sea.ql.ast.expression.binary.Sub;
import org.uva.sea.ql.ast.expression.literal.Literal;
import org.uva.sea.ql.ast.expression.unary.Neg;
import org.uva.sea.ql.ast.expression.unary.Not;
import org.uva.sea.ql.ast.expression.unary.Pos;

public class PrintVisitor implements ASTVisitor {

	int level = 0;

	public void inc() {
		level++;
	}

	public void dec() {
		level--;
	}

	public void print(String s) {

		for (int i = 0; i < level; i++) {
			System.out.print(' ');
		}
		System.out.print(s);
		System.out.print('\n');
	}

	private void internalVisit(ASTNode node) {
		this.print(node.getClass().getName());
	}

	@Override
	public void visit(Form form) {
		this.internalVisit(form);
		inc();
		form.getCompoundStatement().accept(this);
		dec();
	}

	@Override
	public void visit(CompoundStatement statement) {
		this.internalVisit(statement);

		inc();
		Iterator<Statement> it = statement.getStatementIterator();
		while(it.hasNext()){
			it.next().accept(this);
		}
		dec();
	}

	@Override
	public void visit(Question question) {
		this.internalVisit(question);
	}

	@Override
	public void visit(IfStatement statement) {
		this.internalVisit(statement);

		inc();
		statement.getExpression().accept(this);
		dec();
		statement.getStatement().accept(this);
	}

	@Override
	public void visit(Identifier ident) {
		this.internalVisit(ident);
	}

	@Override
	public void visit(Literal literal) {
		this.internalVisit(literal);
	}

	@Override
	public void visit(IfElseStatement statement) {
		this.internalVisit(statement);

		inc();
		statement.getExpression().accept(this);
		dec();
		statement.getStatement().accept(this);
		statement.getElseStatement().accept(this);

	}

	@Override
	public void visit(Add expression) {
		this.internalVisit(expression);

		inc();
		expression.getLhs().accept(this);
		expression.getRhs().accept(this);
		dec();

	}

	@Override
	public void visit(Div expression) {
		this.internalVisit(expression);

		inc();
		expression.getLhs().accept(this);
		expression.getRhs().accept(this);
		dec();
	}

	@Override
	public void visit(Mul expression) {
		this.internalVisit(expression);

		inc();
		expression.getLhs().accept(this);
		expression.getRhs().accept(this);
		dec();
	}

	@Override
	public void visit(Sub expression) {
		this.internalVisit(expression);

		inc();
		expression.getLhs().accept(this);
		expression.getRhs().accept(this);
		dec();
	}

	@Override
	public void visit(And expression) {
		this.internalVisit(expression);

		inc();
		expression.getLhs().accept(this);
		expression.getRhs().accept(this);
		dec();
	}

	@Override
	public void visit(Eq expression) {
		this.internalVisit(expression);

		inc();
		expression.getLhs().accept(this);
		expression.getRhs().accept(this);
		dec();
	}

	@Override
	public void visit(GEq expression) {
		this.internalVisit(expression);

		inc();
		expression.getLhs().accept(this);
		expression.getRhs().accept(this);
		dec();
	}

	@Override
	public void visit(LEq expression) {
		this.internalVisit(expression);

		inc();
		expression.getLhs().accept(this);
		expression.getRhs().accept(this);
		dec();
	}

	@Override
	public void visit(LT expression) {
		this.internalVisit(expression);

		inc();
		expression.getLhs().accept(this);
		expression.getRhs().accept(this);
		dec();
	}

	@Override
	public void visit(NEq expression) {
		this.internalVisit(expression);

		inc();
		expression.getLhs().accept(this);
		expression.getRhs().accept(this);
		dec();
	}
	
	@Override
	public void visit(GT expression) {
		this.internalVisit(expression);

		inc();
		expression.getLhs().accept(this);
		expression.getRhs().accept(this);
		dec();
	}

	@Override
	public void visit(Or expression) {
		this.internalVisit(expression);

		inc();
		expression.getLhs().accept(this);
		expression.getRhs().accept(this);
		dec();
	}

	@Override
	public void visit(Neg expression) {
		this.internalVisit(expression);

		inc();
		expression.getExpr().accept(this);
		dec();
	}

	@Override
	public void visit(Pos expression) {
		this.internalVisit(expression);

		inc();
		expression.getExpr().accept(this);
		dec();
	}

	@Override
	public void visit(Not expression) {
		this.internalVisit(expression);

		inc();
		expression.getExpr().accept(this);
		dec();
	}

}
