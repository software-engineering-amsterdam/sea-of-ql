package org.uva.sea.ql.ast.visitor;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expressions.binary.*;
import org.uva.sea.ql.ast.expressions.unary.*;
import org.uva.sea.ql.ast.form.*;
import org.uva.sea.ql.ast.visitor.messages.*;
import org.uva.sea.ql.ast.visitor.messages.Error;

public class SemanticVisitor implements Visitor {
	
	private SymbolTable st = new SymbolTable();
	private List<Message> errors = new ArrayList<Message>();

	/**
	 * getResult
	 * @return result
	 */
	public List<Message> getErrors(){
		return this.errors;
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
			errors.add(new Error("identifier of the question already exists"
							+ q.getIdent().getName()+" && question:"
							+ q.getQuestion().getValue() + ")"));
		}
	}
	@Override
	public void visit(Computation c) {
		if(st.hasIdentifier(c.getIdent())){
			errors.add(new Error("Error in computation: identifier (" + c.getIdent().getName() + ") does already exists"));
		}
		st.addToTable(c.getIdent(),	c.getType(st));
		
		c.getArgument().accept(this);
		
		Expr type = c.getType(st);
		if(!type.isCompatibleWithInt() || !type.isCompatibleWithMoney()){
			errors.add(new Error("computation is only for numerics"));
		}
		type = c.getArgument();
		if(!type.isCompatibleWithInt() || !type.isCompatibleWithMoney()){
			errors.add(new Error("computation is only for numerics"));
		}
	}
	@Override
	public void visit(Condition c) {		
		c.getIf().accept(this);
		if(c.getIfElements().isEmpty()){
			errors.add(new Warning("if statement has no elements"));
		}
		for(FormElement fe : c.getIfElements()){
			fe.accept(this);
		}
	}
	@Override
	public void visit(Ident i) {
		if(!st.hasIdentifier(i)){
			errors.add(new Error("identifier does not exist (" + i.getName() + ")"));
		} 
	}
	@Override
	public void visit(BinExpr b) {	
		b.getLeft().accept(this);
		b.getRight().accept(this);
		
		if(!b.getLeft().getType(st).isCompatibleTo(b.getRight().getType(st))){
			errors.add(new Error("incompatible types used in binExpr"));
		} 
		if(!b.getType(st).isCompatibleTo(b.getLeft().getType(st))){
			errors.add(new Error("incompatible types used for this operator in the binExpr"));
		}
	}
	@Override
	public void visit(UnaryExpr u) {			
		if(!u.getArgument().getType(st).isCompatibleTo(u.getType(st))){
			errors.add(new Error("argument for unaryexpr does not belong to the expression type"));
		}
	}
	@Override
	public void visit(Expr e) {		
	}
}
