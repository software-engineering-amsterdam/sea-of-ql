package org.uva.sea.ql.semanticchecker;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.uva.sea.ql.ast.Block;
import org.uva.sea.ql.ast.ExpressionVisitor;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.StatementVisitor;
import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.And;
import org.uva.sea.ql.ast.expr.Div;
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
import org.uva.sea.ql.ast.expr.rel.Eq;
import org.uva.sea.ql.ast.expr.rel.GEq;
import org.uva.sea.ql.ast.expr.rel.GT;
import org.uva.sea.ql.ast.expr.rel.LEq;
import org.uva.sea.ql.ast.expr.rel.LT;
import org.uva.sea.ql.ast.expr.rel.NEq;
import org.uva.sea.ql.ast.expr.value.BooleanVal;
import org.uva.sea.ql.ast.expr.value.IntegerVal;

public class SemanticVisitor implements StatementVisitor, ExpressionVisitor {

	private final Map<Ident, Type> symbolTable = new HashMap<Ident, Type>();
	private final Set<String> questionLabels = new HashSet<String>();
	private final ValidationReport validationReport = new ValidationReport();

	public ValidationReport start(QLForm form) {

		form.accept(this);
		return validationReport;
	}
	
	private void visitBlockOfQLItems(Block block) {
		List<Statement> itemsToVisit = block.getBlockElements();
		for (Statement item : itemsToVisit) {
			item.accept(this);
		}
	}

	private boolean tryAddSymbol(Ident ident, Type type) {
		if (symbolTable.containsKey(ident)) {
			validationReport.addError("Duplicate local identifier: " + ident);
			return false;
		}
		symbolTable.put(ident, type);
		return true;
	}
	
	private boolean tryAddLabel(String label) {
		if (questionLabels.contains(label)) {
			validationReport.addWarning("Duplicate question label: " + label);
			return false;
		}
		return true;
	}

	public void visit(QLForm form) {
		visitBlockOfQLItems(form.getBlockOfItems());
	}

	@Override
	public void visit(Question question) {
		tryAddSymbol(question.getId(), question.getType());
		tryAddLabel(question.getLabel());
	}

	@Override
	public void visit(ComputedQuestion question) {
		tryAddSymbol(question.getId(), question.getType());
		tryAddLabel(question.getLabel());
		ExpressionTypeValidatorUtil.checkExprIsOfType(question.getExpr(), question.getType(), this, validationReport);
	}

	@Override
	public void visit(ConditionalQuestion question) {
		ExpressionTypeValidatorUtil.checkConditionalExpr(question.getCondition(), this, validationReport);
		visitBlockOfQLItems(question.getStatements());
	}

	@Override
	public void visit(ConditionalElseQuestion question) {
		ExpressionTypeValidatorUtil.checkConditionalExpr(question.getCondition(), this, validationReport);
		visitBlockOfQLItems(question.getStatements());
		visitBlockOfQLItems(question.getElseStatements());
	}

	@Override
	public Type visit(Add node) {
		ExpressionTypeValidatorUtil.checkBinaryExprMembersAreInt(node, this, validationReport);
		return ReturnTypeHolder.getIntType();
	}

	@Override
	public Type visit(Sub node) {
		ExpressionTypeValidatorUtil.checkBinaryExprMembersAreInt(node, this, validationReport);
		return ReturnTypeHolder.getIntType();
	}

	@Override
	public Type visit(Mul node) {
		ExpressionTypeValidatorUtil.checkBinaryExprMembersAreInt(node, this, validationReport);
		return ReturnTypeHolder.getIntType();
	}

	@Override
	public Type visit(Div node) {
		ExpressionTypeValidatorUtil.checkBinaryExprMembersAreInt(node, this, validationReport);
		return ReturnTypeHolder.getIntType();
	}

	@Override
	public Type visit(Eq node) {
		ExpressionTypeValidatorUtil.checkBinaryExprMembersShareSameType(node, this, validationReport);
		return ReturnTypeHolder.getBoolType();
	}

	@Override
	public Type visit(NEq node) {
		ExpressionTypeValidatorUtil.checkBinaryExprMembersShareSameType(node, this, validationReport);
		return ReturnTypeHolder.getBoolType();
	}

	@Override
	public Type visit(GEq node) {
		ExpressionTypeValidatorUtil.checkBinaryExprMembersShareSameNumericType(node, this, validationReport);
		return ReturnTypeHolder.getBoolType();
	}

	@Override
	public Type visit(LEq node) {
		ExpressionTypeValidatorUtil.checkBinaryExprMembersShareSameNumericType(node, this, validationReport);
		return ReturnTypeHolder.getBoolType();
	}

	@Override
	public Type visit(GT node) {
		ExpressionTypeValidatorUtil.checkBinaryExprMembersShareSameNumericType(node, this, validationReport);
		return ReturnTypeHolder.getBoolType();
	}

	@Override
	public Type visit(LT node) {
		ExpressionTypeValidatorUtil.checkBinaryExprMembersShareSameNumericType(node, this, validationReport);
		return ReturnTypeHolder.getBoolType();
	}

	@Override
	public ReturnType visit(Ident ident) {
		if (symbolTable.containsKey(ident)) {
			return symbolTable.get(ident);
		}
		validationReport.addError("Identifier " + ident + " undefined");
		return new VoidType();
	}

	@Override
	public Type visit(And node) {
		ExpressionTypeValidatorUtil.checkBinaryExprMembersShareGivenType(ReturnTypeHolder.getBoolType(), node, this, validationReport);
		return ReturnTypeHolder.getBoolType();
	}

	@Override
	public Type visit(Or node) {
		ExpressionTypeValidatorUtil.checkBinaryExprMembersShareGivenType(ReturnTypeHolder.getBoolType(), node, this, validationReport);
		return ReturnTypeHolder.getBoolType();
	}

	@Override
	public ReturnType visit(Not node) {
		ExpressionTypeValidatorUtil.checkExprIsOfType(node, ReturnTypeHolder.getBoolType(), this, validationReport);
		return ReturnTypeHolder.getBoolType();
	}

	public Map<Ident, Type> getSymbolTable() {
		return symbolTable;
	}

	@Override
	public ReturnType visit(BooleanVal node) {
		
		return ReturnTypeHolder.getBoolType();
	}

	@Override
	public ReturnType visit(IntegerVal node) {
		
		return ReturnTypeHolder.getIntType();
	}
}
