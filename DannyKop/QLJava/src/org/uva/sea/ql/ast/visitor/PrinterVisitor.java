package org.uva.sea.ql.ast.visitor;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expressions.binary.BinExpr;
import org.uva.sea.ql.ast.expressions.unary.UnaryExpr;
import org.uva.sea.ql.ast.form.*;

public class PrinterVisitor implements Visitor {
	
	private StringBuilder result = new StringBuilder();
	private int depth = 0;
	
	/**
	 * Constructor
	 */
	public PrinterVisitor() {
	}
	
	public StringBuilder getResult(){ 
		return this.result; 
	}
	/**
	 * generateTabs()
	 */
	private void generateTabs(){
		for(int i = 0; i < this.depth + 1; i++){
			result.append("\t");
		}
	}

	@Override
	public void visit(Form f) {
		result.append("form: " + f.getIdent().getName() + "{ \n");
		for(FormElement e : f.getElements()){
			e.accept(this);
		}	
		result.append("}");
	}

	/**
	 * Elements, nodes
	 */
	
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
	public void visit(Ident i) {
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
	public void visit(Expr e) {
		// TODO Auto-generated method stub
		
	}

	}
