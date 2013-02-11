package org.uva.sea.ql.ast;

abstract public class Node {
	@Override
	public String toString() {
		return this.getClass().getSimpleName().toUpperCase();
	}
}
