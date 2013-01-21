package org.uva.sea.ql.ast.visitor;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expressions.binary.BinExpr;
import org.uva.sea.ql.ast.expressions.unary.UnaryExpr;
import org.uva.sea.ql.ast.form.*;


public class PrinterVisitor implements Visitor {

	/**
	 * Constructor
	 */
	public PrinterVisitor() {
	}
	
	/**
	 * visit()
	 * @param expr
	 */
	@Override
	public void visit(Expr expr) {
	
		// First testing
		if(expr.getClass() == Ident.class){
			System.out.println(((Ident)expr).getName());
		} else {
			System.out.println("Geen Ident (" + expr.getClass().getName() + ")");
		}
	}

	@Override
	public void visit(FormElement fe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Question q) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Computation c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Condition c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(BinExpr b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(UnaryExpr u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Form f) {
		// TODO Auto-generated method stub
		
	}
	

}
