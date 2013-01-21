package org.uva.sea.ql.symbol;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.ast.expr.grouping.Expr;
import org.uva.sea.ql.ast.expr.type.Type;

public class Symbol {

	private final Question declarationPoint;
	private final Expr variable;
	private final Type type;
	private List<Symbol> dependantOn = new ArrayList<Symbol>();

	public Symbol(Question declarationPoint, Expr variable, SymbolTable holder) {
		this.declarationPoint = declarationPoint;
		this.variable = variable;
		this.type = variable.typeOf(holder);
	}
	
	public Symbol(Question declarationPoint, Type type) {
		this.declarationPoint = declarationPoint;
		this.variable = type.getMatchingNode(declarationPoint.getLineNumber());
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

	public Expr getVariable() {
		return variable;
	}

	public Type getType() {
		return type;
	}

}
