package org.uva.sea.ql.evaluate.render;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.uva.sea.ql.ast.expression.IdentifierExpression;

class DependencySet implements Iterable<IdentifierExpression> {
	private final Set<IdentifierExpression> dependencies;

	public DependencySet() {
		this.dependencies = new HashSet<IdentifierExpression>();
	}

	public void add( IdentifierExpression identifier ) {
		this.dependencies.add( identifier );
	}

	@Override
	public Iterator<IdentifierExpression> iterator() {
		return this.dependencies.iterator();
	}
}
