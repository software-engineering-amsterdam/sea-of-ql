package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.types.QLString;
import org.uva.sea.ql.ast.types.Type;

public class FormText extends FormElement {

	protected Expr calculation;
	
	public FormText(Ident id, QLString label, Type type, Expr calculation) {
		super(id, label, type);
		this.calculation = calculation;
	}
	
}
