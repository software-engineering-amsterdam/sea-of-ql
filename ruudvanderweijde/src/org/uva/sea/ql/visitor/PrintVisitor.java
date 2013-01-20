package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.expr.binary.Binary;
import org.uva.sea.ql.ast.expr.primary.Bool;
import org.uva.sea.ql.ast.expr.primary.Ident;
import org.uva.sea.ql.ast.expr.primary.Int;
import org.uva.sea.ql.ast.expr.primary.StringLiteral;
import org.uva.sea.ql.ast.expr.unary.Unary;
import org.uva.sea.ql.ast.stmt.IfThenElse;
import org.uva.sea.ql.ast.stmt.Question;
import org.uva.sea.ql.ast.type.Type;

public class PrintVisitor implements Visitor {

	@Override
	public void visit(Form form) {
		System.out.println("Visit Form " +
				"\t id: " + form.getId().getName() +
				"\t Statement count: " + form.getStatements().size()
				);
	}
	
	@Override
	public void visit(IfThenElse ifThenElse) {
		System.out.println("Visit IfThenElse " + 
				"\t condition type: " + ifThenElse.getCondition().getClass() +
				"\t ifBlock count: " + ifThenElse.getIfBlock().size() +
				"\t elseBlock count: " + ifThenElse.getElseBlock().size()
				);
	}
	
	@Override
	public void visit(Question question) {
		System.out.println("Visit Question " + 
				"\t id: " + question.getId().getName() +
				"\t label: " + question.getLabel() +
				"\t type: " + question.getType().getClass()
				);
	}
	
	@Override
	public void visit(Type type) {
		System.out.println("Visit Type " + 
				"\t type: " + type.getClass()				
				);
	}

	@Override
	public void visit(Unary unary) {
		System.out.println("Visit Unary class: " +
				"\t class:" + unary.getClass());
	}
	
	@Override
	public void visit(Binary binary) {
		System.out.println("Visit Binary: " +
				"\t class:" + binary.getClass());
	}

	@Override
	public void visit(Ident ident) {
		System.out.println("Visit Ident " +
				"\t name: " + ident.getName());
	}

	@Override
	public void visit(Bool bool) {
		System.out.println("Visit Bool " +
				"\t value: " + bool.getValue());
	}

	@Override
	public void visit(Int integer) {
		System.out.println("Visit Int " +
				"\t value: " + integer.getValue());
	}

	@Override
	public void visit(StringLiteral stringLiteral) {
		System.out.println("Visit StringLiteral " +
				"\t value: " + stringLiteral.getValue());	
	}

}
