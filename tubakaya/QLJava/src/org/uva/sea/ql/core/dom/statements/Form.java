package org.uva.sea.ql.core.dom.statements;

import java.util.List;
import org.uva.sea.ql.core.dom.Statement;
import org.uva.sea.ql.core.dom.StatementVisitor;

public class Form extends Statement{

	protected List<FormElement> elements;

	public Form(List<FormElement> elements) {
		this.elements = elements;
	}

	@Override
	public void accept(StatementVisitor visitor) {
		visitor.visit(this);
	}
}
