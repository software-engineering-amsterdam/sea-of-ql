package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.FormNode;
import org.uva.sea.ql.ast.visitor.FormVisitor;

public abstract class FormElement implements FormNode {

	public abstract <T> T accept(FormVisitor<T> visitor);

}
