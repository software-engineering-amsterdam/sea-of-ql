package org.uva.sea.ql.ast.form;

import java.util.List;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.interfaces.IVisitor;
import org.uva.sea.ql.util.Stack;

public class Body extends FormElement{
	
	private List<FormElement> nodes;
	
	
	public Body(List<FormElement> nodes){
		this.nodes = nodes;
	}
	
	
	public List<FormElement> getNodes(){
		return nodes;
	}
	
	
	public void accept(IVisitor visitor, Stack stack) throws Exception {
		visitor.visit(this, stack);
	}
	
}
