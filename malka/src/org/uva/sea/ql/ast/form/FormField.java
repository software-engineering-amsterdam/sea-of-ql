package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.expression.string.StringPrimitive;
import org.uva.sea.ql.ast.type.Type;

public class FormField extends ASTNode implements IFormElement {
	protected Identifier id;
	protected StringPrimitive label;
	protected Type type;
	
	public FormField(Identifier id,  StringPrimitive label, Type type) {
		this.id    = id;
		this.label = label;
		this.type  = type;
	}
}
