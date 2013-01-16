package org.uva.sea.ql.ast;

import java.util.ArrayList;
import org.uva.sea.ql.visitor.Visitor;

public class FormBlock extends FormElement {

	private final ArrayList<FormElement> formelements;

	public FormBlock(ArrayList<FormElement> formelements) {
		this.formelements = formelements;
	}

	public ArrayList<FormElement> getFormelements() {
		return formelements;
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub

	}
	
}
