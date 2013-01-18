package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.interfaces.IVisitor;
import org.uva.sea.ql.util.Stack;

public class Form extends FormElement {

	private String name;
	private FormElement body;
	
	
	public Form(String sName, FormElement body){
		this.name = sName;
		this.body = body;
	}
	
	
	public FormElement getBody(){
		return body;
	}
	
	
	public String getName(){
		return name;
	}
	
	
	public void accept(IVisitor visitor, Stack stack) throws Exception {
		visitor.visit(this, stack);
	}
}
