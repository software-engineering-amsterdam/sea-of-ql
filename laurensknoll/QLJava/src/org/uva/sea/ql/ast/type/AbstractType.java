package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.IASTNode;
import org.uva.sea.ql.visitor.IType;

public abstract class AbstractType implements IASTNode {

	public abstract <T> T accept(IType<T> visitor);

}
