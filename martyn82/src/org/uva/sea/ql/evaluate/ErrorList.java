package org.uva.sea.ql.evaluate;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ErrorList implements Iterable<Error> {
	private final List<Error> errors;

	public ErrorList() {
		this.errors = new LinkedList<Error>();
	}

	public void addError( Error error ) {
		this.errors.add( error );
	}

	public int size() {
		return this.errors.size();
	}

	public void clear() {
		this.errors.clear();
	}

	@Override
	public Iterator<Error> iterator() {
		return this.errors.iterator();
	}
}
