package org.uva.sea.ql.generation;

import java.util.List;

import org.uva.sea.ql.ast.elements.IfStatement;
import org.uva.sea.ql.ast.elements.Question;

public interface DocumentBuilder {

	public abstract String getOutput();

	public abstract void setHeading(String content);

	public abstract void appendQuestion(Question question);

	public abstract void beginIf(IfStatement ifStatement);

	public abstract void endIf();

	public abstract void create(List<IfStatement> ifStatements,
			List<Question> questions);

}