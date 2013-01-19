package org.uva.sea.ql.utility;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.ConditionalStatement;
import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.expr.grouping.Expr;

public class Symbol {
	
	private final Question declarationPoint;
	private final Expr variable;
	private List<Statement> evaluationPoints = new ArrayList<Statement>();
	private List<ConditionalStatement> dependantOn = new ArrayList<ConditionalStatement>();
	
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
	
	public List<ConditionalStatement> getDependantOn() {
		return this.dependantOn;
	}
	
	public void addEvaluationPoint(Statement evaluationPoint) {
		this.evaluationPoints.add(evaluationPoint);
	}
	
	public void addDependantOn(ConditionalStatement dependantOn) {
		this.dependantOn.add(dependantOn);
	}
	
	public Expr getVariable() {
		return variable;
	}
	
}
