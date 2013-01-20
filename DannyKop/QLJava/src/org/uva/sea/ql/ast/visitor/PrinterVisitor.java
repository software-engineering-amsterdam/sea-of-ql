package org.uva.sea.ql.ast.visitor;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Ident;

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

}
