package org.uva.sea.ql.semanticchecker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.Div;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.Mul;
import org.uva.sea.ql.ast.expr.Sub;
import org.uva.sea.ql.ast.ql.ComputedQuestion;
import org.uva.sea.ql.ast.ql.ConditionalElseQuestion;
import org.uva.sea.ql.ast.ql.QLForm;
import org.uva.sea.ql.ast.ql.QLItem;
import org.uva.sea.ql.ast.ql.Question;
import org.uva.sea.ql.ast.ql.SimpleConditionalQuestion;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.type.TypeFactory;
import org.uva.sea.ql.ast.expr.rel.Eq;
import org.uva.sea.ql.ast.expr.rel.GEq;
import org.uva.sea.ql.ast.expr.rel.GT;
import org.uva.sea.ql.ast.expr.rel.LEq;
import org.uva.sea.ql.ast.expr.rel.LT;
import org.uva.sea.ql.ast.expr.rel.NEq;

public class SemanticVisitor implements QLItemSemanticVisitor, ExpressionSemanticVisitor {

	private final Map<Ident, Type> symbolTable = new HashMap<Ident, Type>();
	private final ValidationErrors validationErrors = new ValidationErrors();

	public void start(QLForm form) {

		form.accept(form, this);
	}	

	public void visit(QLForm form) {

		List<QLItem> itemsToVisit = form.getBlockOfItems().getBlockElements();
		for (QLItem item : itemsToVisit) {
			item.accept(item, this);
		}
	}

	@Override
	public void visit(Question question) {


	}

	@Override
	public void visit(ComputedQuestion question) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(SimpleConditionalQuestion question) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(ConditionalElseQuestion question) {
		// TODO Auto-generated method stub

	}

	@Override
	public Type visit(Add node) {
		ExpressionTypeValidatorUtil.checkBinaryExprMembersAreInt(node, this, validationErrors);
		return TypeFactory.getIntType();
	}

	@Override
	public Type visit(Sub node) {
		ExpressionTypeValidatorUtil.checkBinaryExprMembersAreInt(node, this, validationErrors);
		return TypeFactory.getIntType();
	}

	@Override
	public Type visit(Mul node) {
		ExpressionTypeValidatorUtil.checkBinaryExprMembersAreInt(node, this, validationErrors);
		return TypeFactory.getIntType();
	}

	@Override
	public Type visit(Div node) {
		ExpressionTypeValidatorUtil.checkBinaryExprMembersAreInt(node, this, validationErrors);
		return TypeFactory.getIntType();
	}

	@Override
	public Type visit(Eq node) {
		ExpressionTypeValidatorUtil.checkBinaryExprMembersShareSameType(node, this, validationErrors);
		return TypeFactory.getBoolType();
	}

	@Override
	public Type visit(NEq node) {
		ExpressionTypeValidatorUtil.checkBinaryExprMembersShareSameType(node, this, validationErrors);
		return TypeFactory.getBoolType();
	}

	@Override
	public Type visit(GEq node) {
		ExpressionTypeValidatorUtil.checkBinaryExprMembersShareSameNumericType(node, this, validationErrors);
		return TypeFactory.getBoolType();
	}

	@Override
	public Type visit(LEq node) {
		ExpressionTypeValidatorUtil.checkBinaryExprMembersShareSameNumericType(node, this, validationErrors);
		return TypeFactory.getBoolType();
	}

	@Override
	public Type visit(GT node) {
		ExpressionTypeValidatorUtil.checkBinaryExprMembersShareSameNumericType(node, this, validationErrors);
		return TypeFactory.getBoolType();
	}

	@Override
	public Type visit(LT node) {
		ExpressionTypeValidatorUtil.checkBinaryExprMembersShareSameNumericType(node, this, validationErrors);
		return TypeFactory.getBoolType();
	}

	@Override
	public Type visit(Ident ident) {
		// TODO Auto-generated method stub
		return null;
	}


}
