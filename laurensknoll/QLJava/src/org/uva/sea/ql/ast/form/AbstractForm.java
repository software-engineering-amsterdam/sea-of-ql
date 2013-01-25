package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.visitor.Form;

public abstract class AbstractForm implements ASTNode {

	public abstract <T> T accept(Form<T> visitor);

}
