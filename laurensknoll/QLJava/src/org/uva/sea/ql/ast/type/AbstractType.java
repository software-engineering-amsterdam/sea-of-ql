package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.visitor.Type;

public abstract class AbstractType implements ASTNode {

	public abstract <T> T accept(Type<T> visitor);

}
