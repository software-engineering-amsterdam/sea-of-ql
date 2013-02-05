package org.uva.sea.ql.ast.elements;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.expressions.BinaryExpr;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.interfaces.ReturnsBoolOperands;
import org.uva.sea.ql.ast.interfaces.ReturnsMathOperands;

public class Ident extends Expr implements ReturnsMathOperands,
		ReturnsBoolOperands {

	private final String name;

	public Ident(String id) {
		this.name = id;
	}

	public final String getName() {
		return this.name;
	}
	public static List<Ident> getIdents(Expr e) {
		final List<Ident> idents = new ArrayList<>();
		if (e.getClass().equals(Ident.class)) {
			idents.add((Ident) e);
		}
		if (e instanceof BinaryExpr) {
			final BinaryExpr b = (BinaryExpr) e;
			idents.addAll(getIdents(b.getLeft()));
			idents.addAll(getIdents(b.getRight()));
		}
		return idents;
	}

}
