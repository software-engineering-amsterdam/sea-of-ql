package org.uva.sea.ql.visitor;

import java.util.Map;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.types.Type;

public interface IForm extends ASTNode {

	public Type typeOf(Map<Ident, Type> typeEnv);

	public <T> T accept(FormElementVisitor<T> visitor);

}
