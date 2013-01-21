package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.types.QLString;
import org.uva.sea.ql.ast.types.Type;

public class Question extends FormElement {

	public Question(Ident id, QLString label, Type type) {
		super(id, label, type);
	}
	
}
