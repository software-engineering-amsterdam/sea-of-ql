package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.Primary;
import org.uva.sea.ql.ast.alg.Add;
import org.uva.sea.ql.ast.alg.And;
import org.uva.sea.ql.ast.alg.Bool;
import org.uva.sea.ql.ast.alg.Div;
import org.uva.sea.ql.ast.alg.Eq;
import org.uva.sea.ql.ast.alg.GEq;
import org.uva.sea.ql.ast.alg.GT;
import org.uva.sea.ql.ast.alg.Int;
import org.uva.sea.ql.ast.alg.LEq;
import org.uva.sea.ql.ast.alg.LT;
import org.uva.sea.ql.ast.alg.Money;
import org.uva.sea.ql.ast.alg.Mul;
import org.uva.sea.ql.ast.alg.NEq;
import org.uva.sea.ql.ast.alg.Neg;
import org.uva.sea.ql.ast.alg.Not;
import org.uva.sea.ql.ast.alg.Or;
import org.uva.sea.ql.ast.alg.Pos;
import org.uva.sea.ql.ast.alg.Str;
import org.uva.sea.ql.ast.alg.Sub;
import org.uva.sea.ql.ast.form.ObservableStatement;
import org.uva.sea.ql.gui.State;

public class ExprDependencyAnalyzer implements AlgebricElementVisitor<Void> {

	private final State state;
	private final ObservableStatement statement;

	public ExprDependencyAnalyzer(State state, ObservableStatement statement) {
		this.state = state;
		this.statement = statement;
	}

	@Override
	public Void visit(Ident ast) {
		this.state.putObservable(ast, this.statement);
		return null;
	}

	@Override
	public Void visit(Add add) {
		add.getLhs().accept(this);
		add.getRhs().accept(this);
		return null;
	}

	@Override
	public Void visit(And and) {
		return null;
	}

	@Override
	public Void visit(Div div) {
		div.getLhs().accept(this);
		div.getRhs().accept(this);
		return null;
	}

	@Override
	public Void visit(Eq eq) {
		return null;
	}

	@Override
	public Void visit(GEq geq) {
		return null;
	}

	@Override
	public Void visit(GT gt) {
		return null;
	}

	@Override
	public Void visit(Int val) {
		return null;
	}

	@Override
	public Void visit(LEq leq) {
		return null;
	}

	@Override
	public Void visit(LT lt) {
		return null;
	}

	@Override
	public Void visit(Mul mul) {
		mul.getLhs().accept(this);
		mul.getRhs().accept(this);
		return null;
	}

	@Override
	public Void visit(Neg neg) {
		return null;
	}

	@Override
	public Void visit(NEq neq) {
		return null;
	}

	@Override
	public Void visit(Not not) {
		return null;
	}

	@Override
	public Void visit(Or or) {
		return null;
	}

	@Override
	public Void visit(Pos pos) {
		return null;
	}

	@Override
	public Void visit(Sub sub) {
		sub.getLhs().accept(this);
		sub.getRhs().accept(this);
		return null;
	}

	@Override
	public Void visit(Primary ast) {
		return null;
	}

	@Override
	public Void visit(Bool bool) {
		return null;
	}

	@Override
	public Void visit(Str str) {
		return null;
	}

	@Override
	public Void visit(Money money) {
		return null;
	}

}
