package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.IASTNode;
import org.uva.sea.ql.visitor.IForm;

public abstract class AbstractForm implements IASTNode {

	public abstract <T> T accept(IForm<T> visitor);

}
