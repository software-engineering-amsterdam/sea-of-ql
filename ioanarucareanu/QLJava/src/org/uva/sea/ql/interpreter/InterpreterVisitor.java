package org.uva.sea.ql.interpreter;

import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.expr.rel.Eq;
import org.uva.sea.ql.ast.expr.rel.GEq;
import org.uva.sea.ql.ast.expr.rel.GT;
import org.uva.sea.ql.ast.expr.rel.LEq;
import org.uva.sea.ql.ast.expr.rel.LT;
import org.uva.sea.ql.ast.expr.rel.NEq;
import org.uva.sea.ql.ast.expr.value.BooleanVal;
import org.uva.sea.ql.ast.expr.value.IntegerVal;
import org.uva.sea.ql.ast.expr.value.UndefinedVal;
import org.uva.sea.ql.ast.expr.value.Val;
import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.And;
import org.uva.sea.ql.ast.expr.Div;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.Mul;
import org.uva.sea.ql.ast.expr.Not;
import org.uva.sea.ql.ast.expr.Or;
import org.uva.sea.ql.ast.expr.Sub;
import org.uva.sea.ql.ast.ql.ComputedQuestion;
import org.uva.sea.ql.ast.ql.ConditionalElseQuestion;
import org.uva.sea.ql.ast.ql.ConditionalQuestion;
import org.uva.sea.ql.ast.ql.QLForm;
import org.uva.sea.ql.ast.ql.Question;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.Block;
import org.uva.sea.ql.ast.ExpressionVisitor;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.StatementVisitor;
import org.uva.sea.ql.interpreter.controller.QuestionWithAnswer;
import org.uva.sea.ql.interpreter.controller.TypeValuePair;
import org.uva.sea.ql.semanticchecker.ReturnType;

public class InterpreterVisitor implements ExpressionVisitor, StatementVisitor {

	private final Map<Ident, TypeValuePair> symbolTypeValueTable;
	
	public InterpreterVisitor(Map<Ident, TypeValuePair> symbolTypeValueTable) {
		this.symbolTypeValueTable = symbolTypeValueTable;
	}
	
	@Override
	public ReturnType visit(Ident ident) {
		Val identifierValue = symbolTypeValueTable.get(ident).getValue();
		if (identifierValue != null) {
			return identifierValue;
		}
		return new UndefinedVal();
	}
	
	@Override
	public ReturnType visit(Add node) {
		Val leftVal = (Val) node.getLeftExpr().accept(this);
		Val rightVal = (Val) node.getRightExpr().accept(this);
		return leftVal.add(rightVal);
	}

	@Override
	public ReturnType visit(Sub node) {
		Val leftVal = (Val) node.getLeftExpr().accept(this);
		Val rightVal = (Val) node.getRightExpr().accept(this);
		return leftVal.substract(rightVal);
	}

	@Override
	public ReturnType visit(Mul node) {
		Val leftVal = (Val) node.getLeftExpr().accept(this);
		Val rightVal = (Val) node.getRightExpr().accept(this);
		return leftVal.multiplyBy(rightVal);
	}

	@Override
	public ReturnType visit(Div node) {
		Val leftVal = (Val) node.getLeftExpr().accept(this);
		Val rightVal = (Val) node.getRightExpr().accept(this);
		return leftVal.divideBy(rightVal);
	}

	@Override
	public ReturnType visit(Eq node) {
		Val leftVal = (Val) node.getLeftExpr().accept(this);
        Val rightVal = (Val) node.getRightExpr().accept(this);
        return leftVal.equalTo(rightVal);
	}

	@Override
	public ReturnType visit(NEq node) {
        Eq equalTo = new Eq(node.getLeftExpr(), node.getRightExpr());
        return (BooleanVal) equalTo.accept(this);
	}

	@Override
	public ReturnType visit(GEq node) {
		Val leftVal = (Val) node.getLeftExpr().accept(this);
		Val rightVal = (Val) node.getRightExpr().accept(this);
		return leftVal.greaterOrEqualTo(rightVal);
	}

	@Override
	public ReturnType visit(LEq node) {
		Val leftVal = (Val) node.getLeftExpr().accept(this);
		Val rightVal = (Val) node.getRightExpr().accept(this);
		return leftVal.lessOrEqualTo(rightVal);
	}

	@Override
	public ReturnType visit(GT node) {
		Val leftVal = (Val) node.getLeftExpr().accept(this);
		Val rightVal = (Val) node.getRightExpr().accept(this);
		return leftVal.greaterThan(rightVal);
	}

	@Override
	public ReturnType visit(LT node) {
		Val leftVal = (Val) node.getLeftExpr().accept(this);
		Val rightVal = (Val) node.getRightExpr().accept(this);
		return leftVal.lessThan(rightVal);
	}

	@Override
	public ReturnType visit(And node) {
		Val leftVal = (Val) node.getLeftExpr().accept(this);
		Val rightVal = (Val) node.getRightExpr().accept(this);
		return leftVal.and(rightVal);
	}

	@Override
	public ReturnType visit(Or node) {
		Val leftVal = (Val) node.getLeftExpr().accept(this);
		Val rightVal = (Val) node.getRightExpr().accept(this);
		return leftVal.or(rightVal);
	}

	@Override
	public ReturnType visit(Not node) {
		Val leftVal = (Val) node.getExpr().accept(this);
		return leftVal.not();
	}

	public Map<Ident, TypeValuePair> getSymbolTypeValueTable() {
		return symbolTypeValueTable;
	}

	@Override
	public ReturnType visit(BooleanVal node) {
		return node;
	}

	@Override
	public ReturnType visit(IntegerVal node) {
		return node;
	}

	private ReturnType visitBlockOfStatements(Block block) {
		EnabledQuestions enabledQuestions = new EnabledQuestions();
		List<Statement> itemsToVisit = block.getBlockElements();
		for (Statement item : itemsToVisit) {
			enabledQuestions.addAll((EnabledQuestions)item.accept(this));
		}
		return enabledQuestions;
	}
	
	@Override
	public ReturnType visit(QLForm form) {
		return visitBlockOfStatements(form.getBlockOfItems());
	}

	@Override
	public ReturnType visit(Question question) {
		EnabledQuestions enabledQuestions = new EnabledQuestions();
		Val answer = (Val) question.getId().accept(this);
		enabledQuestions.addQuestionWithAnswer(question, answer, true);
		return enabledQuestions;
	}

	@Override
	public ReturnType visit(ComputedQuestion question) {
		EnabledQuestions enabled = new EnabledQuestions();
		Expr computedExpr = question.getExpr();
		Val returnedValue = (Val) computedExpr.accept(this);
		if (!returnedValue.getClass().equals(UndefinedVal.class)) {
			enabled.addQuestionWithAnswer(question, returnedValue, false);
		}
		return enabled;
	}

	@Override
	public ReturnType visit(ConditionalQuestion question) {
		EnabledQuestions enabledQuestions = new EnabledQuestions();
		Expr condition = question.getCondition();
		Val result = (Val) condition.accept(this);
		if (!result.getClass().equals(UndefinedVal.class) && ((BooleanVal)result).getValue()) {
			enabledQuestions.addAll((EnabledQuestions)visitBlockOfStatements(question.getStatements()));
		}
		return enabledQuestions;
	}

	@Override
	public ReturnType visit(ConditionalElseQuestion question) {
		// TODO Auto-generated method stub
		return null;
	}
}