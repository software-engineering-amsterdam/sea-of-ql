package org.uva.sea.ql.visitor;

import java.util.Iterator;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.expression.Add;
import org.uva.sea.ql.ast.expression.And;
import org.uva.sea.ql.ast.expression.Div;
import org.uva.sea.ql.ast.expression.Eq;
import org.uva.sea.ql.ast.expression.ExpressionVisitor;
import org.uva.sea.ql.ast.expression.GEq;
import org.uva.sea.ql.ast.expression.GT;
import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.expression.LEq;
import org.uva.sea.ql.ast.expression.LT;
import org.uva.sea.ql.ast.expression.Mul;
import org.uva.sea.ql.ast.expression.NEq;
import org.uva.sea.ql.ast.expression.Neg;
import org.uva.sea.ql.ast.expression.Not;
import org.uva.sea.ql.ast.expression.Or;
import org.uva.sea.ql.ast.expression.Pos;
import org.uva.sea.ql.ast.expression.Sub;
import org.uva.sea.ql.ast.expression.literal.BooleanLiteral;
import org.uva.sea.ql.ast.expression.literal.IntLiteral;
import org.uva.sea.ql.ast.expression.literal.TextLiteral;
import org.uva.sea.ql.ast.statement.CompoundStatement;
import org.uva.sea.ql.ast.statement.Form;
import org.uva.sea.ql.ast.statement.IfElseStatement;
import org.uva.sea.ql.ast.statement.IfStatement;
import org.uva.sea.ql.ast.statement.Label;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.ast.statement.StatementVisitor;

public class PrintVisitor implements StatementVisitor<Void>, ExpressionVisitor<Void> {

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
	public Void visit(Form form) {
		this.internalVisit(form);
		inc();
		form.getCompoundStatement().accept(this);
		dec();
		
		return null;
	}

	@Override
	public Void visit(CompoundStatement statement) {
		this.internalVisit(statement);

		inc();
		Iterator<Statement> it = statement.getStatementIterator();
		while(it.hasNext()){
			it.next().accept(this);
		}
		dec();
		
		return null;
	}

	@Override
	public Void visit(Question question) {
		this.internalVisit(question);
		
		return null;
	}
	
	@Override
	public Void visit(Label label) {
		this.internalVisit(label);
		return null;
	}

	@Override
	public Void visit(IfStatement statement) {
		this.internalVisit(statement);

		inc();
		statement.getExpression().accept(this);
		dec();
		statement.getStatement().accept(this);
		
		return null;
	}

	@Override
	public Void visit(Identifier ident) {
		this.internalVisit(ident);
		
		return null;
	}

	@Override
	public Void visit(BooleanLiteral literal) {
		this.internalVisit(literal);
		
		return null;
	}

	@Override
	public Void visit(IntLiteral literal) {
		this.internalVisit(literal);
		
		return null;
	}

	@Override
	public Void visit(TextLiteral literal) {
		this.internalVisit(literal);
		
		return null;
	}

	@Override
	public Void visit(IfElseStatement statement) {
		this.internalVisit(statement);

		inc();
		statement.getExpression().accept(this);
		dec();
		statement.getStatement().accept(this);
		statement.getElseStatement().accept(this);

		return null;
	}

	@Override
	public Void visit(Add expression) {
		this.internalVisit(expression);

		inc();
		expression.getLhs().accept(this);
		expression.getRhs().accept(this);
		dec();
		
		return null;
	}

	@Override
	public Void visit(Div expression) {
		this.internalVisit(expression);

		inc();
		expression.getLhs().accept(this);
		expression.getRhs().accept(this);
		dec();
		
		return null;
	}

	@Override
	public Void visit(Mul expression) {
		this.internalVisit(expression);

		inc();
		expression.getLhs().accept(this);
		expression.getRhs().accept(this);
		dec();
		
		return null;
	}

	@Override
	public Void visit(Sub expression) {
		this.internalVisit(expression);

		inc();
		expression.getLhs().accept(this);
		expression.getRhs().accept(this);
		dec();
		
		return null;
	}

	@Override
	public Void visit(And expression) {
		this.internalVisit(expression);

		inc();
		expression.getLhs().accept(this);
		expression.getRhs().accept(this);
		dec();
		
		return null;
	}

	@Override
	public Void visit(Eq expression) {
		this.internalVisit(expression);

		inc();
		expression.getLhs().accept(this);
		expression.getRhs().accept(this);
		dec();
		
		return null;
	}

	@Override
	public Void visit(GEq expression) {
		this.internalVisit(expression);

		inc();
		expression.getLhs().accept(this);
		expression.getRhs().accept(this);
		dec();
		
		return null;
	}

	@Override
	public Void visit(LEq expression) {
		this.internalVisit(expression);

		inc();
		expression.getLhs().accept(this);
		expression.getRhs().accept(this);
		dec();
		
		return null;
	}

	@Override
	public Void visit(LT expression) {
		this.internalVisit(expression);

		inc();
		expression.getLhs().accept(this);
		expression.getRhs().accept(this);
		dec();
		
		return null;
	}

	@Override
	public Void visit(NEq expression) {
		this.internalVisit(expression);

		inc();
		expression.getLhs().accept(this);
		expression.getRhs().accept(this);
		dec();
		
		return null;
	}
	
	@Override
	public Void visit(GT expression) {
		this.internalVisit(expression);

		inc();
		expression.getLhs().accept(this);
		expression.getRhs().accept(this);
		dec();
		
		return null;
	}

	@Override
	public Void visit(Or expression) {
		this.internalVisit(expression);

		inc();
		expression.getLhs().accept(this);
		expression.getRhs().accept(this);
		dec();
		
		return null;
	}

	@Override
	public Void visit(Neg expression) {
		this.internalVisit(expression);

		inc();
		expression.getExpr().accept(this);
		dec();
		
		return null;
	}

	@Override
	public Void visit(Pos expression) {
		this.internalVisit(expression);

		inc();
		expression.getExpr().accept(this);
		dec();
		
		return null;
	}

	@Override
	public Void visit(Not expression) {
		this.internalVisit(expression);

		inc();
		expression.getExpr().accept(this);
		dec();
		
		return null;
	}

}
