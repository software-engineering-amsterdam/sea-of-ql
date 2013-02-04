package org.uva.sea.ql.ast;

import static julius.validation.Assertions.state;

import org.uva.sea.ql.ast.exp.Identifier;
import org.uva.sea.ql.ast.type.DataType;
import org.uva.sea.ql.ast.value.StringValue;

public class Question extends Statement {

	private final DataType dataType;
	private final Identifier identifier;
	private final StringValue questionText;

	/**
	 * 
	 * @param dataType
	 *            (not null)
	 * @param identifier
	 *            (not null)
	 * @param questionText
	 *            (not null)
	 */
	public Question(final DataType dataType, final Identifier identifier,
			final StringValue questionText) {

		this.dataType = dataType;
		this.identifier = identifier;
		this.questionText = questionText;

		state.assertNotNull(this.dataType, "Question.dataType");
		state.assertNotNull(this.identifier, "Question.identifier");
		state.assertNotNull(this.questionText, "Question.questionText");
	}

	public StringValue getQuestionText() {
		return questionText;
	}
}
