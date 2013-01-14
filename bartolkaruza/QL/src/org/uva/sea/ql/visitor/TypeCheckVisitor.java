package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.ConditionalStatement;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.And;
import org.uva.sea.ql.ast.expr.Div;
import org.uva.sea.ql.ast.expr.Eq;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.GEq;
import org.uva.sea.ql.ast.expr.GT;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.Int;
import org.uva.sea.ql.ast.expr.LEq;
import org.uva.sea.ql.ast.expr.LT;
import org.uva.sea.ql.ast.expr.Mul;
import org.uva.sea.ql.ast.expr.NEq;
import org.uva.sea.ql.ast.expr.Neg;
import org.uva.sea.ql.ast.expr.Not;
import org.uva.sea.ql.ast.expr.Or;
import org.uva.sea.ql.ast.expr.Pos;
import org.uva.sea.ql.ast.expr.Sub;
import org.uva.sea.ql.ast.value.Bool;
import org.uva.sea.ql.ast.value.TextString;
import org.uva.sea.ql.ast.value.Value;
import org.uva.sea.ql.utility.ErrorHandler;
import org.uva.sea.ql.utility.QLError;
import org.uva.sea.ql.utility.SymbolTable;
import org.uva.sea.ql.utility.TypeUtility;

public class TypeCheckVisitor extends LeftRecursiveVisitor {

	private static final String ADD = "+";
	private static final String AND = "&&";
	private static final String DIV = "/";
	private static final String EQ = "==";
	private static final String GEQ = ">=";
	private static final String GT = ">";
	private static final String LEQ = "<=";
	private static final String LT = "<";
	private static final String MUL = "*";
	private static final String NEG = "--";
	private static final String NOT = "!";
	private static final String OR = "||";
	private static final String POS = "++";
	private static final String SUB = "-";

	@Override
	public void visit(Question node) {

	}

	@Override
	public void visit(Ident node) {

	}

	@Override
	public void visit(Int node) {

	}

	@Override
	protected void beforeForm(Form node) {

	}

	@Override
	protected void afterForm(Form node) {

	}

	@Override
	protected void beforeConditionalStatement(ConditionalStatement node) {
		if (!TypeUtility.isValidCondition(node.getExpression()) && !(node.getExpression() instanceof Ident)) {
			ErrorHandler.getInstance().addError(new QLError("Invalid type in statement at line: " + node.getLineNumber()));
		} else if(node.getExpression() instanceof Ident) {
			if(!checkIdentIsBoolean((Ident) node.getExpression())) {
				ErrorHandler.getInstance().addError(new QLError("Invalid identifier type at line: " + node.getLineNumber()));
			}
		}
	}

	@Override
	protected void afterConditionalStatement(ConditionalStatement node) {

	}

	@Override
	protected void beforeAdd(Add node) {
		checkNumber(node.getLhs(), ADD);
		checkNumber(node.getRhs(), ADD);
	}

	

	@Override
	protected void afterAdd(Add node) {

	}

	@Override
	protected void beforeAnd(And node) {

	}

	@Override
	protected void afterAnd(And node) {

	}

	@Override
	protected void beforeDiv(Div node) {
		checkNumber(node.getLhs(), DIV);
		checkNumber(node.getRhs(), DIV);
	}

	@Override
	protected void afterDiv(Div node) {

	}

	@Override
	protected void beforeEq(Eq node) {

	}

	@Override
	protected void afterEq(Eq node) {

	}

	@Override
	protected void beforeGEq(GEq node) {

	}

	@Override
	protected void afterGEq(GEq node) {

	}

	@Override
	protected void beforeGT(GT node) {

	}

	@Override
	protected void afterGT(GT node) {

	}

	@Override
	protected void beforeLEq(LEq node) {

	}

	@Override
	protected void afterLEq(LEq node) {

	}

	@Override
	protected void beforeLT(LT node) {

	}

	@Override
	protected void afterLT(LT node) {

	}

	@Override
	protected void beforeMul(Mul node) {
		checkNumber(node.getLhs(), MUL);
		checkNumber(node.getRhs(), MUL);
	}

	@Override
	protected void afterMul(Mul node) {

	}

	@Override
	protected void beforeNeg(Neg node) {
		checkNumber(node.getLhs(), NEG);
		checkNumber(node.getRhs(), NEG);
	}

	@Override
	protected void afterNeg(Neg node) {

	}

	@Override
	protected void beforeNEq(NEq node) {

	}

	@Override
	protected void afterNEq(NEq node) {

	}

	@Override
	protected void beforeNot(Not node) {

	}

	@Override
	protected void afterNot(Not node) {

	}

	@Override
	protected void beforeOr(Or node) {

	}

	@Override
	protected void afterOr(Or node) {

	}

	@Override
	protected void beforePos(Pos node) {
		checkNumber(node.getLhs(), POS);
		checkNumber(node.getRhs(), POS);
	}

	@Override
	protected void afterPos(Pos node) {

	}

	@Override
	protected void beforeSub(Sub node) {
		checkNumber(node.getLhs(), SUB);
		checkNumber(node.getRhs(), SUB);
	}

	@Override
	protected void afterSub(Sub node) {

	}
	
	private void checkNumber(Expr node, String operation) {
		if (node instanceof Ident && !checkIdentIsNumber((Ident) node)) {
			reportOperationTypeError(getValue((Ident) node), operation);
		} else if (TypeUtility.isValidCondition(node)) {
			reportOperationMustBeNumberError(operation);
		}
	}
	
	private boolean checkIdentIsBoolean(Ident node) {
		Value value = getValue(node);
		if (value instanceof Bool) {
			return true;
		} else {
			return false;
		}
	}

	private boolean checkIdentIsNumber(Ident node) {
		Value value = getValue(node);
		if (value instanceof TextString || value instanceof Bool) {
			return false;
		} else {
			return true;
		}
	}

	private Value getValue(Ident node) {
		return SymbolTable.getInstance().getSymbol(((Ident) node.getLhs()).getName());
	}

	private void reportOperationTypeError(Value value, String operation) {
		ErrorHandler.getInstance().addError(new QLError("Unsupported operation\"" + operation + "\"on type: " + value.getClass()));
	}

	private static void reportOperationMustBeNumberError(String operation) {
		ErrorHandler.getInstance().addError(new QLError("operation \"" + operation + "\" not allowed on boolean type"));
	}
}
