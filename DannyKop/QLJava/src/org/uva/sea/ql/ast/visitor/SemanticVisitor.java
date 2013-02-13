package org.uva.sea.ql.ast.visitor;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.expressions.binary.BinExpr;
import org.uva.sea.ql.ast.expressions.unary.UnaryExpr;
import org.uva.sea.ql.ast.form.Computation;
import org.uva.sea.ql.ast.form.Condition;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.FormElement;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitor.messages.Error;
import org.uva.sea.ql.ast.visitor.messages.Message;
import org.uva.sea.ql.ast.visitor.messages.Warning;

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
	 * hasErrors
	 * @return boolean - true if error exist, false otherwise
	 */
	public boolean hasErrors(){
		return this.errors.size() != 0;
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
		if(!st.addToTable(q.getIdentifier(), q.getType())){
			errors.add(new Error("identifier of the question already exists"
							+ q.getIdentifier().getName() +" && question:"
							+ q.getQuestion() + ")")); // THIS RULE MUST BE MODIFIED!
		}
	}
	@Override
	public void visit(Computation c) {
		if(st.hasIdentifier(c.getIdentifier())){
			errors.add(new Error("Error in computation: identifier (" + c.getIdentifier().getName() + ") does already exists"));
		}
		st.addToTable(c.getIdentifier(), c.getType());
		
		c.getArgument().accept(this);
		
		Type computationType = c.getType();
		if(!computationType.isCompatibleWithInt()){
			errors.add(new Error("computation is only for numerics"));
		}
		computationType = c.getArgument().typeOf(st);
		if(!computationType.isCompatibleWithInt()){
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
		if(c.hasElse()){
			for(FormElement fe : c.getElseElements()){
				fe.accept(this);
			}
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
		
		Type leftType = b.getLeft().typeOf(st);
		Type rightType = b.getRight().typeOf(st);
		
		if(!leftType.isCompatibleTo(rightType)){
			errors.add(new Error("incompatible types used in binExpr"));
		}
		if(!leftType.isCompatibleTo(b.typeOf(st))){
			errors.add(new Error("incompatible types used for this operator in the binExpr"));
		}
	}
	@Override
	public void visit(UnaryExpr u) {
		u.getArgument().accept(this);
		if(!u.typeOf(st).isCompatibleTo(u.getArgument().typeOf(st))){
			errors.add(new Error("argument for unaryexpr does not belong to the argument type"));
		}
	}
	@Override
	public void visit(Expr e) {		
	}
	@Override
	public void visit(Type t){
		
	}
}
