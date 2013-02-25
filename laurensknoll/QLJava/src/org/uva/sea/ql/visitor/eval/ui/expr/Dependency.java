package org.uva.sea.ql.visitor.eval.ui.expr;

import org.uva.sea.ql.ast.expr.atom.Ident;
import org.uva.sea.ql.ast.expr.binary.AbstractBinary;
import org.uva.sea.ql.ast.expr.binary.Add;
import org.uva.sea.ql.ast.expr.binary.And;
import org.uva.sea.ql.ast.expr.binary.Div;
import org.uva.sea.ql.ast.expr.binary.Eq;
import org.uva.sea.ql.ast.expr.binary.GEq;
import org.uva.sea.ql.ast.expr.binary.GT;
import org.uva.sea.ql.ast.expr.binary.LEq;
import org.uva.sea.ql.ast.expr.binary.LT;
import org.uva.sea.ql.ast.expr.binary.Mul;
import org.uva.sea.ql.ast.expr.binary.NEq;
import org.uva.sea.ql.ast.expr.binary.Or;
import org.uva.sea.ql.ast.expr.binary.Sub;
import org.uva.sea.ql.ast.expr.unary.Neg;
import org.uva.sea.ql.ast.expr.unary.Not;
import org.uva.sea.ql.ast.expr.unary.Pos;
import org.uva.sea.ql.visitor.IExpression;

public class Dependency implements IExpression<DependencySet> {

	private DependencySet getDependencies(AbstractBinary expr) {
		DependencySet left = expr.getLeftHandSide().accept(this);
		DependencySet right = expr.getRightHandSide().accept(this);

		return left.addAll(right);
	}

	@Override
	public DependencySet visit(Add add) {
		return this.getDependencies(add);
	}

	@Override
	public DependencySet visit(And and) {
		return this.getDependencies(and);
	}

	@Override
	public DependencySet visit(Div div) {
		return this.getDependencies(div);
	}

	@Override
	public DependencySet visit(Eq eq) {
		return this.getDependencies(eq);
	}

	@Override
	public DependencySet visit(GEq geq) {
		return this.getDependencies(geq);
	}

	@Override
	public DependencySet visit(GT gt) {
		return this.getDependencies(gt);
	}

	@Override
	public DependencySet visit(LEq leq) {
		return this.getDependencies(leq);
	}

	@Override
	public DependencySet visit(LT lt) {
		return this.getDependencies(lt);
	}

	@Override
	public DependencySet visit(Mul mul) {
		return this.getDependencies(mul);
	}

	@Override
	public DependencySet visit(Neg neg) {
		return neg.getExpression().accept(this);
	}

	@Override
	public DependencySet visit(NEq neq) {
		return this.getDependencies(neq);
	}

	@Override
	public DependencySet visit(Not not) {
		return not.getExpression().accept(this);
	}

	@Override
	public DependencySet visit(Or or) {
		return this.getDependencies(or);
	}

	@Override
	public DependencySet visit(Pos pos) {
		return pos.getExpression().accept(this);
	}

	@Override
	public DependencySet visit(Sub sub) {
		return this.getDependencies(sub);
	}

	@Override
	public DependencySet visit(org.uva.sea.ql.ast.expr.atom.Bool bool) {
		return new DependencySet();
	}

	@Override
	public DependencySet visit(Ident ident) {
		return new DependencySet(ident);
	}

	@Override
	public DependencySet visit(org.uva.sea.ql.ast.expr.atom.Int intType) {
		return new DependencySet();
	}

	@Override
	public DependencySet visit(org.uva.sea.ql.ast.expr.atom.Money money) {
		return new DependencySet();
	}

	@Override
	public DependencySet visit(org.uva.sea.ql.ast.expr.atom.String string) {
		return new DependencySet();
	}

}
