package org.uva.sea.ql.ast;

import java.util.List;
import org.uva.sea.ql.visitor.Visitor;

public class FormBlock implements FormElement{
	
	private final List<FormElement> formelements;
	
	public FormBlock(List<FormElement> formelements){
		this.formelements = formelements;
	}
	
	public List<FormElement> getFormelements() {
		return formelements;
	}
	
	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		
	}

	
}
