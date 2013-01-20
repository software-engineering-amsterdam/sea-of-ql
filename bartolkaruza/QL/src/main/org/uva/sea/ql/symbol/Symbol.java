package org.uva.sea.ql.symbol;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.expr.grouping.Expr;

public class Symbol {

	private final Question declarationPoint;
	private final Expr variable;
	private List<Statement> evaluationPoints = new ArrayList<Statement>();
	private List<Statement> dependantOn = new ArrayList<Statement>();

	public Symbol(Question declarationPoint, Expr variable) {
		this.declarationPoint = declarationPoint;
		this.variable = variable;
	}

	public Question getDeclarationPoint() {
		return declarationPoint;
	}

	public List<Statement> getEvaluationPoints() {
		return evaluationPoints;
	}

	public List<Statement> getDependantOn() {
		return this.dependantOn;
	}

	public void addEvaluationPoint(Statement evaluationPoint) {
		this.evaluationPoints.add(evaluationPoint);
	}

	public void addDependantOn(Statement dependantOn) {
		this.dependantOn.add(dependantOn);
	}

	public Expr getVariable() {
		return variable;
	}

}
