package org.uva.sea.ql.symbol;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.ast.expr.type.Type;

public class Symbol {

	private final Question declarationPoint;
	private final Type type;
	private List<Symbol> dependantOn = new ArrayList<Symbol>();
	
	public Symbol(Question declarationPoint, Type type) {
		this.declarationPoint = declarationPoint;
		this.type = type;
	}

	public Question getDeclarationPoint() {
		return declarationPoint;
	}

	public List<Symbol> getDependantOn() {
		return this.dependantOn;
	}

	public void addDependantOn(List<Symbol> dependantOn) {
		for(Symbol symbol : dependantOn) {
			this.dependantOn.add(symbol);
		}
	}

	public Type getType() {
		return type;
	}

}
