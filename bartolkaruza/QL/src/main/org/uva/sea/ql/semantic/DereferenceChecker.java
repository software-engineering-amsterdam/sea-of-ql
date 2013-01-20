package org.uva.sea.ql.semantic;

import java.util.Iterator;
import java.util.Stack;

import org.uva.sea.ql.ast.ConditionalStatement;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.And;
import org.uva.sea.ql.ast.expr.Div;
import org.uva.sea.ql.ast.expr.Eq;
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
import org.uva.sea.ql.ast.expr.value.Bool;
import org.uva.sea.ql.ast.expr.value.Int;
import org.uva.sea.ql.ast.expr.value.Money;
import org.uva.sea.ql.ast.expr.value.TextString;
import org.uva.sea.ql.error.ErrorHandler;
import org.uva.sea.ql.error.QLError;
import org.uva.sea.ql.symbol.SymbolTable;
import org.uva.sea.ql.visitor.AbstractTreeWalker;

public class DereferenceChecker extends AbstractTreeWalker {

	private Statement currentStatement;
	private Stack<Statement> dependentOnStack = new Stack<Statement>();

	public DereferenceChecker() {

	}

	@Override
	public void visit(Ident node) {
		if(SymbolTable.getInstance().hasSymbol(node.getName())) {
			SymbolTable.getInstance().getSymbol(node.getName()).addEvaluationPoint(currentStatement);
		} else {
			ErrorHandler.getInstance().addError(new QLError("undeclared variable dereference: " + node.getName()));
		}
	}

	@Override
	public void visit(Question node) {
		currentStatement = node;
		Iterator<Statement> stackIterator = dependentOnStack.iterator();
		while (stackIterator.hasNext()) {
			SymbolTable.getInstance().getSymbol(node.getName()).addDependantOn(stackIterator.next());
		}
	}

	@Override
	public void visit(Bool node) {

	}

	@Override
	public void visit(Int node) {

	}

	@Override
	public void visit(Money node) {

	}

	@Override
	public void visit(TextString node) {

	}

	@Override
	protected void beforeForm(Form node) {

	}

	@Override
	protected void afterForm(Form node) {

	}

	@Override
	protected void beforeConditionalStatement(ConditionalStatement node) {
		currentStatement = node;
		dependentOnStack.push(node);
	}

	@Override
	protected void afterConditionalStatement(ConditionalStatement node) {
		dependentOnStack.pop();
	}

	@Override
	protected void beforeAdd(Add node) {

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

	}

	@Override
	protected void afterMul(Mul node) {

	}

	@Override
	protected void beforeNeg(Neg node) {

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

	}

	@Override
	protected void afterPos(Pos node) {

	}

	@Override
	protected void beforeSub(Sub node) {

	}

	@Override
	protected void afterSub(Sub node) {

	}

}
