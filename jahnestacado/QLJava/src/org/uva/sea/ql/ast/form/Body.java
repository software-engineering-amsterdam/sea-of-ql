package org.uva.sea.ql.ast.form;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.ASTNode;

public  class Body extends ASTNode {
    
	private final List<Element> body = new ArrayList<Element>();


	public List<Element> getBody(){
		return body;
	}
	
	public void addElement(Element bodyElement){
		body.add(bodyElement);
	}


	

}
