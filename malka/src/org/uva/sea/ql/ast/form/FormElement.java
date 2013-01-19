package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.types.QLString;

public class FormElement {
	protected Ident id;
	protected QLString label;
	protected Type type;
	
	public FormElement(Ident id,  QLString label, Type type) {
		this.id    = id;
		this.label = label;
		this.type  = type;
	}
}
