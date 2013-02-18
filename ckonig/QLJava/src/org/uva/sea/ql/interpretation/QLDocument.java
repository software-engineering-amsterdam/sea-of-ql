package org.uva.sea.ql.interpretation;

import java.util.Map;

import org.uva.sea.ql.ast.elements.IfStatement;
import org.uva.sea.ql.ast.elements.Question;

public interface QLDocument {

	public abstract Object getOutput();

	public abstract void setHeading(String content);

	public abstract void appendQuestion(Question question);

	public abstract void beginIf(IfStatement ifStatement);

	public abstract void endIf();

	public abstract void create();

}