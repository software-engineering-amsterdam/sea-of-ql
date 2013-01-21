package org.uva.sea.ql.ast.answertype;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.visitor.AnswerTypeVisitor;

public abstract class AbstractAnswerType implements ASTNode {

	public abstract void accept(AnswerTypeVisitor visitor);

}
