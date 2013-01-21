package org.uva.sea.ql.parser;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.CompoundStatement;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.IfStatement;
import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.ast.expression.BinaryExpr;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.Literal;
import org.uva.sea.ql.ast.expression.UnaryExpr;

public class BasicVisitor implements ASTVisitor {
	
	int level = 0;

	public void inc(){
		level ++;
	}
	
	public void dec(){
		level --;
	}
	
	public void print(String s){

		for(int i = 0; i < level; i++){
			System.out.print(' ');
		}
		System.out.print(s);
		System.out.print('\n');
	}

	private void internalVisit(ASTNode node) {
		System.out.print(node.getClass().getName());
		System.out.print('\n');
		
	}

	@Override
	public void visit(Form form) {
		this.internalVisit(form);
	}
	
	@Override
	public void visit(CompoundStatement statement) {
		this.internalVisit(statement);
	}

	@Override
	public void visit(Question question) {
		this.internalVisit(question);
	}

	@Override
	public void visit(IfStatement statement) {
		this.internalVisit(statement);
	}

	@Override
	public void visit(BinaryExpr expression) {
		this.internalVisit(expression);
	}

	@Override
	public void visit(UnaryExpr expression) {
		this.internalVisit(expression);
	}

	@Override
	public void visit(Ident ident) {
		this.internalVisit(ident);
	}

	@Override
	public void visit(Literal literal) {
		this.internalVisit(literal);
	}
	
}
