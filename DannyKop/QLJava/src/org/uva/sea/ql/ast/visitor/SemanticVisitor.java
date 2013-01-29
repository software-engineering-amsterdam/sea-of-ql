package org.uva.sea.ql.ast.visitor;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expressions.binary.*;
import org.uva.sea.ql.ast.expressions.unary.*;
import org.uva.sea.ql.ast.form.*;

public class SemanticVisitor implements Visitor {
	
	private SymbolTable st = new SymbolTable();
	private StringBuilder result = new StringBuilder();

	/**
	 * getResult
	 * @return result
	 */
	public StringBuilder getResult(){
		return this.result;
	}
	/**
	 * Elements, nodes
	 */
	@Override
	public void visit(Form f){
		for(FormElement fe : f.getElements()){
			fe.accept(this);
		}
	}
	@Override
	public void visit(FormElement fe) {
	}
	@Override
	public void visit(Question q) {
		if(!st.addToTable(q.getIdent(), q.getType(st))){
			result.append("Error in question: identifier of the question already exists (id:"
							+ q.getIdent().getName()+" && question:"
							+ q.getQuestion().getValue() + ")\n");
		}
	}
	@Override
	public void visit(Computation c) {
		if(st.hasIdentifier(c.getIdent())){
			result.append("Error in computation: identifier (" + c.getIdent().getName() + ") does already exists\n");
		}
		st.addToTable(c.getIdent(),	c.getType(st));
		
		c.getArgument().accept(this);
		
		Expr type = c.getType(st);
		if(!type.isCompatibleWithInt() || !type.isCompatibleWithMoney()){
			result.append("Error in computation: computation is only for numerics\n");
		}
		type = c.getArgument();
		if(!type.isCompatibleWithInt() || !type.isCompatibleWithMoney()){
			result.append("Error in computation: computation is only for numerics\n");
		}
	}
	@Override
	public void visit(Condition c) {		
		c.getIf().accept(this);
		if(c.getIfElements().isEmpty()){
			result.append("Warning in if/else: if statement has no elements\n");
		}
		for(FormElement fe : c.getIfElements()){
			fe.accept(this);
		}
	}
	@Override
	public void visit(Ident i) {
		if(!st.hasIdentifier(i)){
			result.append("Error with identifier: identifier does not exist\n") ;
		} 
	}
	@Override
	public void visit(BinExpr b) {	
		b.getLeft().accept(this);
		b.getRight().accept(this);
		
		if(!b.getLeft().getType(st).isCompatibleTo(b.getRight().getType(st))){
			result.append("Error with binexpr: incompatible types used\n");
		} 
		if(!b.getType(st).isCompatibleTo(b.getLeft().getType(st))){
			result.append("Error with binexpr: incompatible types used for this operator\n");
		}
	}
	@Override
	public void visit(UnaryExpr u) {			
		if(!u.getArgument().getType(st).isCompatibleTo(u.getType(st))){
			result.append("Error with unaryexpr: type of argument not compatible with unary expression\n");
		}
	}
	@Override
	public void visit(Expr e) {		
	}
}
