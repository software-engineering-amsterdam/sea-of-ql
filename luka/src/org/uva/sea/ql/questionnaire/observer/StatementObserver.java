package org.uva.sea.ql.questionnaire.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.And;
import org.uva.sea.ql.ast.expr.Div;
import org.uva.sea.ql.ast.expr.Eq;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.GEq;
import org.uva.sea.ql.ast.expr.GT;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.LEq;
import org.uva.sea.ql.ast.expr.LT;
import org.uva.sea.ql.ast.expr.Mul;
import org.uva.sea.ql.ast.expr.NEq;
import org.uva.sea.ql.ast.expr.Neg;
import org.uva.sea.ql.ast.expr.Not;
import org.uva.sea.ql.ast.expr.Or;
import org.uva.sea.ql.ast.expr.Pos;
import org.uva.sea.ql.ast.expr.Sub;
import org.uva.sea.ql.ast.nodes.values.Bool;
import org.uva.sea.ql.ast.nodes.values.Doub;
import org.uva.sea.ql.ast.nodes.values.Int;
import org.uva.sea.ql.ast.nodes.values.Money;
import org.uva.sea.ql.ast.nodes.values.Str;
import org.uva.sea.ql.ast.visitor.Visitor;
import org.uva.sea.ql.questionnaire.State;

public abstract class StatementObserver implements Observer, Visitor<Expr> {
	
	protected final List<Ident> dependencies;
	protected final State state;
	protected final Expr expr;

	//base class for observer
	public StatementObserver(State state, Expr expr) {
		this.state = state;
		this.expr = expr;
		dependencies = new ArrayList<Ident>();
	}

	protected void addDependency(Ident ident) {
		this.dependencies.add(ident);
	}

	@Override
	public abstract void update(Observable o, Object arg);

	public void evaluateDependencies() {
		this.expr.accept(this);

		for (Ident ident : this.dependencies) {
			this.state.addObserver(ident, this);
		}

	}

	@Override
	public Expr visit(Ident ident) {
		addDependency(ident);
		return ident;
	}

	@Override
	public Expr visit(Bool bool) {
		return bool;
	}

	@Override
	public Expr visit(Doub doub) {
		return doub;
	}

	@Override
	public Expr visit(Str bool) {

		return bool;
	}

	@Override
	public Expr visit(Money bool) {

		return bool;
	}

	@Override
	public Expr visit(Int ast) {

		return ast;
	}

	@Override
	public Expr visit(Add ast) {
		ast.getLhs().accept(this);
		ast.getRhs().accept(this);
		return ast;
	}

	@Override
	public Expr visit(And ast) {
		ast.getLhs().accept(this);
		ast.getRhs().accept(this);
		return ast;
	}

	@Override
	public Expr visit(Div ast) {
		ast.getLhs().accept(this);
		ast.getRhs().accept(this);
		return ast;
	}

	@Override
	public Expr visit(Eq ast) {
		ast.getLhs().accept(this);
		ast.getRhs().accept(this);
		return ast;
	}

	@Override
	public Expr visit(GEq ast) {
		ast.getLhs().accept(this);
		ast.getRhs().accept(this);
		return ast;
	}

	@Override
	public Expr visit(GT ast) {
		ast.getLhs().accept(this);
		ast.getRhs().accept(this);
		return ast;
	}

	@Override
	public Expr visit(LEq ast) {
		ast.getLhs().accept(this);
		ast.getRhs().accept(this);
		return ast;
	}

	@Override
	public Expr visit(LT ast) {
		ast.getLhs().accept(this);
		ast.getRhs().accept(this);
		return ast;
	}

	@Override
	public Expr visit(Mul ast) {
		ast.getLhs().accept(this);
		ast.getRhs().accept(this);
		return ast;
	}

	@Override
	public Expr visit(Neg ast) {
		ast.getExpr().accept(this);
		// ast.getRhs().accept(this);
		return ast;
	}

	@Override
	public Expr visit(NEq ast) {
		ast.getLhs().accept(this);
		ast.getRhs().accept(this);
		return ast;
	}

	@Override
	public Expr visit(Not ast) {
		ast.getExpr().accept(this);

		return ast;
	}

	@Override
	public Expr visit(Or ast) {
		ast.getLhs().accept(this);
		ast.getRhs().accept(this);
		return ast;
	}

	@Override
	public Expr visit(Pos ast) {
		ast.getExpr().accept(this);
		return ast;
	}

	@Override
	public Expr visit(Sub ast) {
		ast.getLhs().accept(this);
		ast.getRhs().accept(this);
		return ast;
	}

}
