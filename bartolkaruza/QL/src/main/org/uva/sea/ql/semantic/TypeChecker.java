package org.uva.sea.ql.semantic;

import org.uva.sea.ql.ast.ConditionalStatement;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.And;
import org.uva.sea.ql.ast.expr.Div;
import org.uva.sea.ql.ast.expr.Eq;
import org.uva.sea.ql.ast.expr.GEq;
import org.uva.sea.ql.ast.expr.GT;
import org.uva.sea.ql.ast.expr.LEq;
import org.uva.sea.ql.ast.expr.LT;
import org.uva.sea.ql.ast.expr.Mul;
import org.uva.sea.ql.ast.expr.NEq;
import org.uva.sea.ql.ast.expr.Neg;
import org.uva.sea.ql.ast.expr.Not;
import org.uva.sea.ql.ast.expr.Or;
import org.uva.sea.ql.ast.expr.Pos;
import org.uva.sea.ql.ast.expr.Sub;
import org.uva.sea.ql.ast.expr.value.Bool;
import org.uva.sea.ql.ast.expr.value.Ident;
import org.uva.sea.ql.ast.expr.value.Int;
import org.uva.sea.ql.ast.expr.value.Money;
import org.uva.sea.ql.ast.expr.value.TextString;
import org.uva.sea.ql.error.ErrorHandler;
import org.uva.sea.ql.error.QLError;
import org.uva.sea.ql.symbol.SymbolTable;
import org.uva.sea.ql.typeutil.BooleanUtility;
import org.uva.sea.ql.typeutil.NumberUtility;
import org.uva.sea.ql.typeutil.StringUtility;
import org.uva.sea.ql.visitor.AbstractTreeWalker;

public class TypeChecker extends AbstractTreeWalker {

	private static final String ADD = "+";
	private static final String AND = "&&";
	private static final String DIV = "/";
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
	
	private SymbolTable table;
	private ErrorHandler handler;
	
	public TypeChecker(SymbolTable table, ErrorHandler handler) {
		this.table = table;
		this.handler = handler;
	}

	@Override
	protected void atQuestion(Question node) {
		
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
		if (!BooleanUtility.isNodeBoolean(node.getExpression())) {
			QLError error = new QLError("Invalid non-boolean expression in conditional statement, at: " + node.getLineNumber());
			handler.addError(error);
		}
	}

	@Override
	protected void afterConditionalStatement(ConditionalStatement node) {

	}

	/**
	 * Checks to see if the add operation is on two numbers or on two text
	 * strings
	 */
	@Override
	protected void beforeAdd(Add node) {
		if (!NumberUtility.areNodesNumbers(node) && !(StringUtility.isNodeString(node.getLhs()) && StringUtility.isNodeString(node.getRhs()))) {
			handler.reportOperationTypeError(ADD);
		}
	}

	@Override
	protected void afterAdd(Add node) {

	}

	@Override
	protected void beforeAnd(And node) {
		if (!BooleanUtility.areNodesBoolean(node)) {
			handler.reportOperationTypeError(AND);
		}
	}

	@Override
	protected void afterAnd(And node) {

	}

	@Override
	protected void beforeDiv(Div node) {
		if (!NumberUtility.areNodesNumbers(node)) {
			handler.reportOperationTypeError(DIV);
		}
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
		if (!NumberUtility.areNodesNumbers(node)) {
			handler.reportOperationTypeError(GEQ);
		}
	}

	@Override
	protected void afterGEq(GEq node) {

	}

	@Override
	protected void beforeGT(GT node) {
		if (!NumberUtility.areNodesNumbers(node)) {
			handler.reportOperationTypeError(GT);
		}
	}

	@Override
	protected void afterGT(GT node) {

	}

	@Override
	protected void beforeLEq(LEq node) {
		if (!NumberUtility.areNodesNumbers(node)) {
			handler.reportOperationTypeError(LEQ);
		}
	}

	@Override
	protected void afterLEq(LEq node) {

	}

	@Override
	protected void beforeLT(LT node) {
		if (!NumberUtility.areNodesNumbers(node)) {
			handler.reportOperationTypeError(LT);
		}
	}

	@Override
	protected void afterLT(LT node) {

	}

	@Override
	protected void beforeMul(Mul node) {
		if (!NumberUtility.areNodesNumbers(node)) {
			handler.reportOperationTypeError(MUL);
		}
	}

	@Override
	protected void afterMul(Mul node) {

	}

	@Override
	protected void beforeNeg(Neg node) {
		if (!NumberUtility.areNodesNumbers(node)) {
			handler.reportOperationTypeError(NEG);
		}
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
		if (!BooleanUtility.areNodesBoolean(node)) {
			handler.reportOperationTypeError(NOT);
		}
	}

	@Override
	protected void afterNot(Not node) {

	}

	@Override
	protected void beforeOr(Or node) {
		if (!BooleanUtility.areNodesBoolean(node)) {
			handler.reportOperationTypeError(OR);
		}
	}

	@Override
	protected void afterOr(Or node) {

	}

	@Override
	protected void beforePos(Pos node) {
		if (!NumberUtility.areNodesNumbers(node)) {
			handler.reportOperationTypeError(POS);
		}
	}

	@Override
	protected void afterPos(Pos node) {

	}

	@Override
	protected void beforeSub(Sub node) {
		if (!NumberUtility.areNodesNumbers(node)) {
			handler.reportOperationTypeError(SUB);
		}
	}

	@Override
	protected void afterSub(Sub node) {

	}

	@Override
	public void visit(Bool node) {

	}

	@Override
	public void visit(Money node) {

	}

	@Override
	public void visit(TextString node) {

	}

}
