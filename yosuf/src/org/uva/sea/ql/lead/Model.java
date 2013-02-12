package org.uva.sea.ql.lead;

import static julius.validation.Assertions.state;

import java.util.HashMap;
import java.util.Map;

import org.uva.sea.ql.ast.exp.Identifier;
import org.uva.sea.ql.ast.stm.Computed;
import org.uva.sea.ql.ast.stm.Question;

public class Model {

	private final Map<Identifier, Computed> computedStatements = new HashMap<Identifier, Computed>();

	private final Map<Identifier, Question> qustions = new HashMap<Identifier, Question>();

	public Model() {

	}

	public Computed getValue(final Identifier identifier) {
		return computedStatements.get(identifier);
	}

	/**
	 * 
	 * @param computed
	 *            not null
	 */
	public void registerComputed(final Computed computed) {

		// TODO should any questions be removed first?
		state.assertNotNull(computed, "computed");
		computedStatements.put(computed.getIdentifier(), computed);
	}

	/**
	 * 
	 * @param question
	 *            not null
	 */
	public void registerQuestion(final Question question) {
		state.assertNotNull(question, "question");
		qustions.put(question.getIdentifier(), question);
	}

}
