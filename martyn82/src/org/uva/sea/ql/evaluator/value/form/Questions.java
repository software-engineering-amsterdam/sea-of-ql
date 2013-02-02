package org.uva.sea.ql.evaluator.value.form;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents a set of questions.
 */
public class Questions implements Iterable<Question> {
	private final List<Question> questions;

	public Questions( Questions questions, Question question ) {
		this( question );
		this.questions.addAll( questions.questions );
	}

	public Questions( Question question ) {
		this();
		this.questions.add( question );
	}

	public Questions() {
		this.questions = new LinkedList<Question>();
	}

	public void add( Question question ) {
		this.questions.add( question );
	}

	@Override
	public Iterator<Question> iterator() {
		return this.questions.iterator();
	}
}
