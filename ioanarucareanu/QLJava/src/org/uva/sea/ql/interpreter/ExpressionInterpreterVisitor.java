package org.uva.sea.ql.interpreter;

import java.util.Map;

import org.uva.sea.ql.ast.expr.rel.Eq;
import org.uva.sea.ql.ast.expr.rel.GEq;
import org.uva.sea.ql.ast.expr.rel.GT;
import org.uva.sea.ql.ast.expr.rel.LEq;
import org.uva.sea.ql.ast.expr.rel.LT;
import org.uva.sea.ql.ast.expr.rel.NEq;
import org.uva.sea.ql.ast.expr.value.BooleanVal;
import org.uva.sea.ql.ast.expr.value.IntegerVal;
import org.uva.sea.ql.ast.expr.value.Val;
import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.And;
import org.uva.sea.ql.ast.expr.Div;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.Mul;
import org.uva.sea.ql.ast.expr.Not;
import org.uva.sea.ql.ast.expr.Or;
import org.uva.sea.ql.ast.expr.Sub;
import org.uva.sea.ql.ast.type.IntegerType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.ExpressionVisitor;
import org.uva.sea.ql.interpreter.controller.Pair;
import org.uva.sea.ql.semanticchecker.ReturnType;
import org.uva.sea.ql.semanticchecker.ReturnTypeHolder;

public class ExpressionInterpreterVisitor implements ExpressionVisitor {

	private final Map<Ident, Pair<Type, Val>> symbolTypeValueTable;
	
	public ExpressionInterpreterVisitor(Map<Ident, Pair<Type, Val>> symbolTypeValueTable) {
		this.symbolTypeValueTable = symbolTypeValueTable;
	}
	
	@Override
	public ReturnType visit(Ident ident) {
		Val identifierValue = symbolTypeValueTable.get(ident).getRight();
		if (identifierValue != null) {
			return identifierValue;
		}
		return symbolTypeValueTable.get(ident).getLeft().createValOfType();
	}
	
	@Override
	public ReturnType visit(Add node) {
		IntegerVal leftVal = (IntegerVal) node.getLeftExpr().accept(this);
		if (!leftVal.isDefined()) {
			return leftVal;
		}	
		IntegerVal rightVal = (IntegerVal) node.getRightExpr().accept(this);
		if (!rightVal.isDefined()) {
			return rightVal;
		}
		return leftVal.add(rightVal);
	}

	@Override
	public ReturnType visit(Sub node) {
		IntegerVal leftVal = (IntegerVal) node.getLeftExpr().accept(this);
		if (!leftVal.isDefined()) {
			return leftVal;
		}
		IntegerVal rightVal = (IntegerVal) node.getRightExpr().accept(this);
		if (!rightVal.isDefined()) {
			return rightVal;
		}
		return leftVal.substract(rightVal);
	}

	@Override
	public ReturnType visit(Mul node) {
		IntegerVal leftVal = (IntegerVal) node.getLeftExpr().accept(this);
		if (!leftVal.isDefined()) {
			return leftVal;
		}
		IntegerVal rightVal = (IntegerVal) node.getRightExpr().accept(this);
		if (!rightVal.isDefined()) {
			return rightVal;
		}
		return leftVal.multiplyBy(rightVal);
	}

	@Override
	public ReturnType visit(Div node) {
		IntegerVal leftVal = (IntegerVal) node.getLeftExpr().accept(this);
		if (!leftVal.isDefined()) {
			return leftVal;
		}
		IntegerVal rightVal = (IntegerVal) node.getRightExpr().accept(this);
		if (!rightVal.isDefined()) {
			return rightVal;
		}
		return leftVal.divideBy(rightVal);
	}

	@Override
	public ReturnType visit(Eq node) {
		Val leftVal = (Val) node.getLeftExpr().accept(this);
		if (!leftVal.isDefined()) {
			return leftVal;
		}
        Val rightVal = (Val) node.getRightExpr().accept(this);
        if (!rightVal.isDefined()) {
			return rightVal;
		}
        if(leftVal instanceof BooleanVal && rightVal instanceof BooleanVal) {
        	return ((BooleanVal)leftVal).equalTo((BooleanVal)rightVal);
        }
        if(leftVal instanceof IntegerVal && rightVal instanceof IntegerVal)
            return ((IntegerVal)leftVal).equalTo((IntegerVal)rightVal);
        return new BooleanVal(false);
	}

	@Override
	public ReturnType visit(NEq node) {
        Eq equalTo = new Eq(node.getLeftExpr(), node.getRightExpr());
        return (BooleanVal) equalTo.accept(this);
	}

	@Override
	public ReturnType visit(GEq node) {
		IntegerVal leftVal = (IntegerVal) node.getLeftExpr().accept(this);
		if (!leftVal.isDefined()) {
			return leftVal;
		}
		IntegerVal rightVal = (IntegerVal) node.getRightExpr().accept(this);
		if (!rightVal.isDefined()) {
			return rightVal;
		}
		return leftVal.greaterOrEqualTo(rightVal);
	}

	@Override
	public ReturnType visit(LEq node) {
		IntegerVal leftVal = (IntegerVal) node.getLeftExpr().accept(this);
		if (!leftVal.isDefined()) {
			return leftVal;
		}
		IntegerVal rightVal = (IntegerVal) node.getRightExpr().accept(this);
		if (!rightVal.isDefined()) {
			return rightVal;
		}
		return leftVal.lessOrEqualTo(rightVal);
	}

	@Override
	public ReturnType visit(GT node) {
		IntegerVal leftVal = (IntegerVal) node.getLeftExpr().accept(this);
		if (!leftVal.isDefined()) {
			return leftVal;
		}
		IntegerVal rightVal = (IntegerVal) node.getRightExpr().accept(this);
		if (!rightVal.isDefined()) {
			return rightVal;
		}
		return leftVal.greaterThan(rightVal);
	}

	@Override
	public ReturnType visit(LT node) {
		IntegerVal leftVal = (IntegerVal) node.getLeftExpr().accept(this);
		if (!leftVal.isDefined()) {
			return leftVal;
		}
		IntegerVal rightVal = (IntegerVal) node.getRightExpr().accept(this);
		if (!rightVal.isDefined()) {
			return rightVal;
		}
		return leftVal.lessThan(rightVal);
	}

	@Override
	public ReturnType visit(And node) {
		BooleanVal leftVal = (BooleanVal) node.getLeftExpr().accept(this);
		if (!leftVal.isDefined()) {
			return leftVal;
		}
		BooleanVal rightVal = (BooleanVal) node.getRightExpr().accept(this);
		if (!rightVal.isDefined()) {
			return rightVal;
		}
		return leftVal.and(rightVal);
	}

	@Override
	public ReturnType visit(Or node) {
		BooleanVal leftVal = (BooleanVal) node.getLeftExpr().accept(this);
		if (!leftVal.isDefined()) {
			return leftVal;
		}
		BooleanVal rightVal = (BooleanVal) node.getRightExpr().accept(this);
		if (!rightVal.isDefined()) {
			return rightVal;
		}
		return leftVal.or(rightVal);
	}

	@Override
	public ReturnType visit(Not node) {
		BooleanVal leftVal = (BooleanVal) node.getExpr().accept(this);
		if (!leftVal.isDefined()) {
			return leftVal;
		}
		return leftVal.not();
	}

	public Map<Ident, Pair<Type, Val>> getSymbolTypeValueTable() {
		return symbolTypeValueTable;
	}

	@Override
	public ReturnType visit(BooleanVal node) {
		node.setDefined(true);
		return node;
	}

	@Override
	public ReturnType visit(IntegerVal node) {
		node.setDefined(true);
		return node;
	}
}