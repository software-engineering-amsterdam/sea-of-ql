package org.uva.sea.ql.visitor;

import java.util.Map;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.types.Type;

public abstract class IForm implements ASTNode {

	public abstract Type typeOf(Map<Ident, Type> typeEnv);

	public abstract <T> T accept(FormElementVisitor<T> visitor);

}
