package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.interfaces.IVisitor;
import org.uva.sea.ql.util.Stack;

public class Form extends FormElement {

	private String sName;
	private Expr pBody;
	
	
	public Form(String sName, Expr pBody){
		this.sName = sName;
		this.pBody = pBody;
	}
	
	
	public Expr getBody(){
		return pBody;
	}
	
	
	public String getName(){
		return sName;
	}
	
	
	public void accept(IVisitor visitor, Stack stack) throws Exception {
		visitor.visit(this, stack);
	}
}
