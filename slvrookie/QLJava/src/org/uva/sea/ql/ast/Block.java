package org.uva.sea.ql.ast;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.visitor.TypeChecker;

public class Block extends FormElement {

	private final List<FormElement> block = new ArrayList<FormElement>();

	public void addElement(FormElement formElement) {
		block.add(formElement);
	}

	public List<FormElement> getBlock() {
		return block;
	}

	@Override
	public void accept(TypeChecker visitor) {
		visitor.visit(this);

	}

}
