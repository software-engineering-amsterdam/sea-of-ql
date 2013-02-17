package org.uva.sea.ql.lead;

import static julius.validation.Assertions.state;

import java.util.HashMap;
import java.util.Map;

import julius.utilities.collection.MultiHashMap;
import julius.utilities.collection.MultiMap;

import org.uva.sea.ql.ast.exp.Expression;
import org.uva.sea.ql.ast.exp.Identifier;
import org.uva.sea.ql.ast.stm.Computed;
import org.uva.sea.ql.ast.stm.Question;

/**
 * Model holds the state. At the same time query and command methods are available.
 * 
 * A {@link ModelChangeListener} can be added to get notified on certain expressions.
 */
public class Model {

	private final Map<Identifier, Computed> computeds = new HashMap<Identifier, Computed>();
	private final Map<Identifier, Question> qustions = new HashMap<Identifier, Question>();
	private final MultiMap<Expression<?>, ModelChangeListener> listeners = new MultiHashMap<Expression<?>, ModelChangeListener>();

	public Model() {
		super();
	}

	/**
	 * 
	 * @param expression
	 *            (not null)
	 * @return (maybe null)
	 */
	public Computed getComputed(final Expression<?> expression) {
		state.assertNotNull(expression, "expression");
		return computeds.get(expression);
	}

	/**
	 * Registers the new computed and removes any questions.
	 * 
	 * @param computed
	 *            not null
	 */
	public void registerComputed(final Computed computed) {
		state.assertNotNull(computed, "computed");
		qustions.remove(computed.getIdentifier());
		computeds.put(computed.getIdentifier(), computed);

		notifyListeners(computed.getIdentifier());
		LogPrinter.debugInfo("Computed registered : " + computed);
	}

	/**
	 * 
	 * @param question
	 *            not null
	 */
	public void registerQuestion(final Question question) {
		state.assertNotNull(question, "question");
		computeds.remove(question.getIdentifier());
		qustions.put(question.getIdentifier(), question);

		notifyListeners(question.getIdentifier());
	}

	/**
	 * 
	 * @param expression
	 *            (not null)
	 * @param listener
	 *            (not null)
	 */
	public void addListener(final Expression<?> expression,
			final ModelChangeListener listener) {
		listeners.addForKey(expression, listener);
	}

	/**
	 * 
	 * @param listener
	 */
	public void removeListener(final ModelChangeListener listener) {
		listeners.remove(listener);
	}

	private void notifyListeners(final Expression<?> expression) {
		for (ModelChangeListener listener : listeners.getOrEmpty(expression)) {
			listener.changed(expression);
		}
	}
}
