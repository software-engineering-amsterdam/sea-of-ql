package eu.karuza.ql.symbol;

import java.util.ArrayList;
import java.util.List;


import eu.karuza.ql.ast.Question;
import eu.karuza.ql.ast.expr.grouping.Expr;
import eu.karuza.ql.ast.expr.type.Type;

public class Symbol {

	private final Question declarationPoint;
	private final Expr expr;
	private List<Symbol> dependantOn = new ArrayList<Symbol>();
	
	public Symbol(Question declarationPoint, Expr expr) {
		this.declarationPoint = declarationPoint;
		this.expr = expr;
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

	public Expr getExpr() {
		return expr;
	}
	
	public Type getType(SymbolTable table) {
		return expr.typeOf(table);
	}

}
