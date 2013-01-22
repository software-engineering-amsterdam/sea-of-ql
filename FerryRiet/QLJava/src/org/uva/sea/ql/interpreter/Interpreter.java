package org.uva.sea.ql.interpreter;

import org.uva.sea.ql.ast.BinExpr;
import org.uva.sea.ql.ast.BooleanLiteral;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.IntLiteral;
import org.uva.sea.ql.ast.StringLiteral;
import org.uva.sea.ql.ast.UnExpr;
import org.uva.sea.ql.ast.operators.Add;
import org.uva.sea.ql.ast.operators.And;
import org.uva.sea.ql.ast.operators.Div;
import org.uva.sea.ql.ast.operators.Eq;
import org.uva.sea.ql.ast.operators.GEq;
import org.uva.sea.ql.ast.operators.GT;
import org.uva.sea.ql.ast.operators.LEq;
import org.uva.sea.ql.ast.operators.LT;
import org.uva.sea.ql.ast.operators.Mul;
import org.uva.sea.ql.ast.operators.NEq;
import org.uva.sea.ql.ast.operators.Neg;
import org.uva.sea.ql.ast.operators.Not;
import org.uva.sea.ql.ast.operators.Or;
import org.uva.sea.ql.ast.operators.Pos;
import org.uva.sea.ql.ast.operators.Sub;

public class Interpreter {

	public Expr eval(BinExpr expr) {
		Expr result = null;
		return result;
	}

	public Expr eval(Ident expr) {

		Expr result = null;
		return result;
	}

	public Expr eval(IntLiteral expr) {
		return expr;
	}

	public Expr eval(StringLiteral expr) {

		Expr result = null;
		return result;
	}

	public Expr eval(BooleanLiteral expr) {

		Expr result = null;
		return result;
	}

	public Expr eval(Add expr) {
		Expr leftExp = expr.getExprLeftHand() ;
		Expr rightExp = expr.getExprRightHand() ;
		
		IntLiteral result = (IntLiteral) eval(leftExp);
		IntLiteral r2 = (IntLiteral) eval(rightExp);

		return new IntLiteral(((IntLiteral) result).getValue()
				+ ((IntLiteral) r2).getValue());
	}

	public Expr eval(Mul expr) {
		IntLiteral result = (IntLiteral) eval(expr.getExprLeftHand());
		IntLiteral r2 = (IntLiteral) eval(expr.getExprRightHand());

		return new IntLiteral(((IntLiteral) result).getValue()
				* ((IntLiteral) r2).getValue());
	}

	public Expr eval(Div expr) {
		IntLiteral result = (IntLiteral) eval(expr.getExprLeftHand());
		IntLiteral r2 = (IntLiteral) eval(expr.getExprRightHand());

		return new IntLiteral(((IntLiteral) result).getValue()
				/ ((IntLiteral) r2).getValue());
	}

	public Expr eval(Sub expr) {
		IntLiteral result = (IntLiteral) eval(expr.getExprLeftHand());
		IntLiteral r2 = (IntLiteral) eval(expr.getExprRightHand());

		return new IntLiteral(((IntLiteral) result).getValue()
				- ((IntLiteral) r2).getValue());
	}

	public Expr eval(And expr) {

		Expr result = null;
		return result;
	}

	public Expr eval(Or expr) {
		Expr result = null;
		return result;
	}

	public Expr eval(Eq expr) {

		Expr result = null;
		return result;
	}

	public Expr eval(GT expr) {
		Expr result = null;
		return result;
	}

	public Expr eval(LT expr) {
		Expr result = null;
		return result;
	}

	public Expr eval(LEq expr) {
		Expr result = null;
		return result;
	}

	public Expr eval(NEq expr) {
		Expr result = null;
		return result;
	}

	public Expr eval(GEq expr) {
		Expr result = null;
		return result;
	}

	public Expr eval(UnExpr expr) {
		Expr result = null;
		return result;
	}

	public Expr eval(Not expr) {
		Expr result = null;
		return result;
	}

	public Expr eval(Neg expr) {
		Expr result = null;
		return result;
	}

	public Expr eval(Pos expr) {
		Expr result = null;
		return result;
	}

	public Expr eval(Expr expr) {
		Expr result = null;
		return result;
	}

}
