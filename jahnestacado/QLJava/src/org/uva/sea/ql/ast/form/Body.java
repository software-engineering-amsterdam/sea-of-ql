<<<<<<< HEAD
package org.uva.sea.ql.ast.form;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.visitor.ASTNodeVisitor;

public  class Body extends ASTNode {
    
	private final List<Element> body = new ArrayList<Element>();
	
	
	public List<Element> getBody(){
		return body;
	}
	
	public void addElement(Element bodyElement){
		body.add(bodyElement);
	}


	@Override
	public void accept(ASTNodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
		
	}

}
=======
package org.uva.sea.ql.ast.form;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.visitor.checkers.ElementChecker;

public  class Body extends QLProgram {
    
	private final List<BodyElement> body = new ArrayList<BodyElement>();


	public List<BodyElement> getBodyElement(){
		return body;
	}
	
	public void addElement(BodyElement bodyElement){
		body.add(bodyElement);
	}

	@Override
	public void accept(ElementChecker qlElement) {
			qlElement.visit(this);
	}


	

}
>>>>>>> 483057f28359ecac2b999d94a928c0aaf01d2a6e
