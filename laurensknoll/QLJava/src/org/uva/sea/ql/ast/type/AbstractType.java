package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.visitor.AnswerTypeVisitor;

public abstract class AbstractType implements ASTNode {

	public abstract void accept(AnswerTypeVisitor<?> visitor);

}
