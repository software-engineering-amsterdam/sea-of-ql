package org.uva.sea.ql.interpretation;

import org.uva.sea.ql.ast.elements.IfStatement;
import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.ast.literals.StringLiteral;

public interface QLDocument {

	public abstract Object getOutput();

	public abstract void setHeading(StringLiteral content);

	public abstract void appendQuestion(Question question);

	public abstract void beginIf(IfStatement ifStatement);

	public abstract void endIf();

	public abstract void create();

}