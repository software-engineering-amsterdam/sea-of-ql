package org.uva.sea.ql.visitorTypeChecking;

import java.util.ArrayList;
import java.util.List;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.expressions.binary.Add;
import org.uva.sea.ql.ast.expressions.binary.And;
import org.uva.sea.ql.ast.expressions.binary.BinExpr;
import org.uva.sea.ql.ast.expressions.binary.Div;
import org.uva.sea.ql.ast.expressions.binary.Eq;
import org.uva.sea.ql.ast.expressions.binary.GEq;
import org.uva.sea.ql.ast.expressions.binary.GT;
import org.uva.sea.ql.ast.expressions.binary.LEq;
import org.uva.sea.ql.ast.expressions.binary.LT;
import org.uva.sea.ql.ast.expressions.binary.Mul;
import org.uva.sea.ql.ast.expressions.binary.NEq;
import org.uva.sea.ql.ast.expressions.binary.Or;
import org.uva.sea.ql.ast.expressions.binary.Sub;
import org.uva.sea.ql.ast.expressions.unary.Neg;
import org.uva.sea.ql.ast.expressions.unary.Not;
import org.uva.sea.ql.ast.expressions.unary.Pos;
import org.uva.sea.ql.ast.expressions.unary.UnaryExpr;
import org.uva.sea.ql.ast.form.Computation;
import org.uva.sea.ql.ast.form.Condition;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.FormElement;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.SymbolTable;
import org.uva.sea.ql.visitor.Visitor;
import org.uva.sea.ql.visitor.messages.Error;
import org.uva.sea.ql.visitor.messages.Message;
import org.uva.sea.ql.visitor.messages.Warning;

public class SemanticVisitor implements Visitor<Boolean> {
	
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
	public Boolean visit(Form f){
		for(FormElement fe : f.getElements()){
			fe.accept(this);
		}
		return true;
	}
	@Override
	public Boolean visit(FormElement fe) {
		return true;
	}
	@Override
	public Boolean visit(Question q) {
		if(!st.addToTable(q.getIdentifier(), q.getType())){
			errors.add(new Error("identifier of the question already exists"
							+ q.getIdentifier().getName() + ")")); 
		}
		return true;
	}
	@Override
	public Boolean visit(Computation c) {
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
		return true;
	}
	@Override
	public Boolean visit(Condition c) {		
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
		return true;
	}
	@Override
	public Boolean visit(Ident i) {
		if(!st.hasIdentifier(i)){
			errors.add(new Error("identifier does not exist (" + i.getName() + ")"));
		} 
		return true;
	}
	@Override
	public Boolean visit(BinExpr b) {
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
		return true;
	}
	@Override
	public Boolean visit(UnaryExpr u) {
		u.getArgument().accept(this);
		if(!u.typeOf(st).isCompatibleTo(u.getArgument().typeOf(st))){
			errors.add(new Error("argument for unaryexpr does not belong to the argument type"));
		}
		return true;
	}
	@Override
	public Boolean visit(Expr e) {
		return true;
	}
	@Override
	public Boolean visit(Type t){
		return true;
	}
	@Override
	public Boolean visit(Add a) {
		return true;
	}
	@Override
	public Boolean visit(And a) {
		return true;
	}
	@Override
	public Boolean visit(Div d) {
		return true;
	}
	@Override
	public Boolean visit(Mul m) {
		return true;
	}
	@Override
	public Boolean visit(Or o) {
		return true;
	}
	@Override
	public Boolean visit(Sub s) {
		return true;
	}
	@Override
	public Boolean visit(Eq e) {
		return true;
	}
	@Override
	public Boolean visit(GEq g) {
		return true;
	}
	@Override
	public Boolean visit(GT g) {
		return true;
	}
	@Override
	public Boolean visit(LEq l) {
		return true;
	}
	@Override
	public Boolean visit(LT l) {
		return true;
	}
	@Override
	public Boolean visit(NEq n) {
		return true;
	}
	@Override
	public Boolean visit(Neg n) {
		return true;
	}
	@Override
	public Boolean visit(Not n) {
		return true;
	}
	@Override
	public Boolean visit(Pos p) {
		return true;
	}
}
