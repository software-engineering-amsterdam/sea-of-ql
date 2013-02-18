package org.uva.sea.ql.visitor.eval.observer;

import java.util.HashSet;
import java.util.Set;

import org.uva.sea.ql.ast.expr.atom.Ident;

public class DependencySet {
	private final Set<Ident> dependencies;

	public DependencySet() {
		this.dependencies = new HashSet<Ident>();
	}

	public DependencySet(Ident ident) {
		this();

		this.dependencies.add(ident);
	}

	public Set<Ident> getDependencies() {
		return this.dependencies;
	}

	public void addDependency(Ident ident) {
		if (!this.dependencies.contains(ident)) {
			this.dependencies.add(ident);
		}
	}

	public DependencySet addAll(DependencySet set) {
		for (Ident ident : set.getDependencies()) {
			this.addDependency(ident);
		}

		return this;
	}
}
