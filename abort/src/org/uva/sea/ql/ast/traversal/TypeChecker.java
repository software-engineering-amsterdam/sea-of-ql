package org.uva.sea.ql.ast.traversal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.uva.sea.ql.ast.base.Node;
import org.uva.sea.ql.ast.conditionals.IfThen;
import org.uva.sea.ql.ast.conditionals.IfThenElse;
import org.uva.sea.ql.ast.form.Computation;
import org.uva.sea.ql.ast.form.Element;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.ast.operators.base.BinaryOperator;
import org.uva.sea.ql.ast.operators.base.UnaryOperator;
import org.uva.sea.ql.ast.operators.binary.Add;
import org.uva.sea.ql.ast.operators.binary.And;
import org.uva.sea.ql.ast.operators.binary.Div;
import org.uva.sea.ql.ast.operators.binary.Eq;
import org.uva.sea.ql.ast.operators.binary.GEq;
import org.uva.sea.ql.ast.operators.binary.GT;
import org.uva.sea.ql.ast.operators.binary.LEq;
import org.uva.sea.ql.ast.operators.binary.LT;
import org.uva.sea.ql.ast.operators.binary.Mul;
import org.uva.sea.ql.ast.operators.binary.NEq;
import org.uva.sea.ql.ast.operators.binary.Or;
import org.uva.sea.ql.ast.operators.binary.Sub;
import org.uva.sea.ql.ast.operators.unary.Neg;
import org.uva.sea.ql.ast.operators.unary.Not;
import org.uva.sea.ql.ast.operators.unary.Pos;
import org.uva.sea.ql.ast.traversal.base.IVisitable;
import org.uva.sea.ql.ast.traversal.base.IVisitor;
import org.uva.sea.ql.ast.types.Bool;
import org.uva.sea.ql.ast.types.DataType;
import org.uva.sea.ql.ast.types.Int;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.ast.types.StringLiteral;

import sun.tools.tree.AddExpression;

// TODO: use observer pattern to store errors
public class TypeChecker implements IVisitor {
	private List<String> errors = new ArrayList<String>();
	private List<String> log = new ArrayList<String>();
	private TypeContainer resultTypes = new TypeContainer(); 
	//sprivate Set<String> labels = new HashSet<E>();

	@Override
	public void visit(final And and) {
		// TODO: remove duplicate code of And and Or
		final Class<? extends Node> leftHandSide = getLeftHandSideResultType(and);
		final Class<? extends Node> rightHandSide = getRightHandSideResultType(and);
		boolean error = false;
		if (!isBooleanType(leftHandSide)) {
			errors.add("[And] the left hand side is not of the type Int or money");
			error = true;
		}
		if (!isBooleanType(rightHandSide)) {
			errors.add("[And] the right hand side is not of the type Int or money");
			error = true;
		}
		
		if (!error) {
			resultTypes.addTypeForNode(and, Bool.class);
			
			log.add("[And] valid");
		}
	}

	@Override
	public void visit(final Div div) {
		final Class<? extends Node> leftHandSide = getLeftHandSideResultType(div);
		final Class<? extends Node> rightHandSide = getRightHandSideResultType(div);
		boolean error = false;
		
		if (!isMoneyOrIntegerType(leftHandSide)) {
			errors.add("[Div] the left hand side is not of the type Int or money");
			error = true;
		}
		if (!isMoneyOrIntegerType(rightHandSide)) {
			errors.add("[Div] the right hand side is not of the type Int or money");
			error = true;
		}
		
		if (!error) {
			log.add("[Div] success");
			resultTypes.addTypeForNode(div, isMoneyTypeInvolved(div) ? Money.class : Int.class);
		}		
	}

	@Override
	public void visit(final Eq eq) {
		if (!hasOperationGotEqualTypes(eq)) {
			errors.add("[Eq] the operation requires both the left hand side and the right hands side to be of the same type");
		}
		else {
			log.add("[Eq] success");
			resultTypes.addTypeForNode(eq, Bool.class);			
		}
	}

	@Override
	public void visit(final GEq geq) {
		final Class<? extends Node> leftHandSide = getLeftHandSideResultType(geq);
		final Class<? extends Node> rightHandSide = getRightHandSideResultType(geq);
		boolean error = false;
		
		if (!isMoneyOrIntegerType(leftHandSide)) {
			errors.add("[GEq] the left hand side is not of the type Int or money");
			error = true;
		}

		if (!isMoneyOrIntegerType(rightHandSide)) {
			errors.add("[GEq] the right hand side is not of the type Int or money");
			error = true;
		}
		
		if (!hasOperationGotEqualTypes(geq)) {
			errors.add("[GEq] the operation requires both the left hand side and the right hands side to be of the same type");
			error = true;
		}
		
		if (!error) {
			log.add("[GEq] success");
			resultTypes.addTypeForNode(geq, Bool.class);			
		}		
	}
	
	
	@Override
	public void visit(final GT gt) {
		final Class<? extends Node> leftHandSide = getLeftHandSideResultType(gt);
		final Class<? extends Node> rightHandSide = getRightHandSideResultType(gt);
		boolean error = false;
		
		if (!isMoneyOrIntegerType(leftHandSide)) {
			errors.add("[GEq] the left hand side is not of the type Int or money");
			error = true;
		}

		if (!isMoneyOrIntegerType(rightHandSide)) {
			errors.add("[GEq] the right hand side is not of the type Int or money");
			error = true;
		}
		
		if (!hasOperationGotEqualTypes(gt)) {
			errors.add("[GEq] the operation requires both the left hand side and the right hands side to be of the same type");
			error = true;
		}
		
		if (!error) {
			log.add("[GEq] success");
			resultTypes.addTypeForNode(gt, Bool.class);			
		}		
	}
	
	@Override
	public void visit(final LEq leq) {
		final Class<? extends Node> leftHandSide = getLeftHandSideResultType(leq);
		final Class<? extends Node> rightHandSide = getRightHandSideResultType(leq);
		boolean error = false;
		
		if (!isMoneyOrIntegerType(leftHandSide)) {
			errors.add("[LEq] the left hand side is not of the type Int or money");
			error = true;
		}

		if (!isMoneyOrIntegerType(rightHandSide)) {
			errors.add("[LEq] the right hand side is not of the type Int or money");
			error = true;
		}
		
		if (!hasOperationGotEqualTypes(leq)) {
			errors.add("[LEq] the operation requires both the left hand side and the right hands side to be of the same type");
			error = true;
		}
		
		if (!error) {
			log.add("[LEq] success");
			resultTypes.addTypeForNode(leq, Bool.class);			
		}	
	}

	@Override
	public void visit(final Mul mul) {
		final Class<? extends Node> leftHandSide = getLeftHandSideResultType(mul);
		final Class<? extends Node> rightHandSide = getRightHandSideResultType(mul);
		boolean error = false;
		
		if (!isMoneyOrIntegerType(leftHandSide)) {
			errors.add("[Mul] the left hand side is not of the type Int or money");
			error = true;
		}

		if (!isMoneyOrIntegerType(rightHandSide)) {
			errors.add("[Mul] the right hand side is not of the type Int or money");
			error = true;
		}
		
		if (Money.class.equals(leftHandSide) && Money.class.equals(rightHandSide)) {
			errors.add("[Mul] you can not multiply money by money, that would make life way too easy");
			error = true;
		}
		
		if (!error) {
			log.add("[Mul] success");
			resultTypes.addTypeForNode(mul, isMoneyTypeInvolved(mul) ? Money.class : Int.class);
		}
	}
	
	@Override
	public void visit(final NEq neq) {
		if (!hasOperationGotEqualTypes(neq)) {
			errors.add("[NEq] the operation requires both the left hand side and the right hands side to be of the same type");
		}
		else {
			log.add("[NEq] success");
			resultTypes.addTypeForNode(neq, Bool.class);			
		}		
	}
	
	@Override
	public void visit(final Or or) {
		final Class<? extends Node> leftHandSide = getLeftHandSideResultType(or);
		final Class<? extends Node> rightHandSide = getRightHandSideResultType(or);
		boolean error = false;
		if (!isBooleanType(leftHandSide)) {
			errors.add("[Or] the left hand side is not of the type Int or money");
			error = true;
		}
		if (!isBooleanType(rightHandSide)) {
			errors.add("[Or] the right hand side is not of the type Int or money");
			error = true;
		}
		
		if (!error) {
			resultTypes.addTypeForNode(or, Bool.class);
			
			log.add("[Or] valid");
		}
	}
	
	@Override
	public void visit(final Sub sub) {
		final Class<? extends Node> leftHandSide = getLeftHandSideResultType(sub);
		final Class<? extends Node> rightHandSide = getRightHandSideResultType(sub);
		boolean error = false;

		if (!isMoneyOrIntegerType(leftHandSide)) {
			errors.add("[Sub] the left hand side is not of the type Int or money");
			error = true;
		}
		
		if (!isMoneyOrIntegerType(rightHandSide)) {
			errors.add("[Sub] the right hand side is not of the type Int or money");
			error = true;
		}

		if (!hasOperationGotEqualTypes(sub)) {
			errors.add("[Sub] the operation requires both the left hand side and the right hands side to be of the same type");
			error = true;
		}
		
		if (!error) {
			// result in money if necessary
			Class<? extends Node> resultType = isMoneyTypeInvolved(sub) ? Money.class : Int.class;
			resultTypes.addTypeForNode(sub, resultType);
			
			log.add("[Add] valid");
		}
	}

	@Override
	public void visit(final Neg neg) {
		final Class<? extends Node> resultType = getUnaryResultType(neg);
		if (!isMoneyOrIntegerType(resultType)) {
			errors.add("[Neg] negation requires the type of Int or Money");
		}
		else {
			log.add("[Neg] success");
			resultTypes.addTypeForNode(neg, resultType);
		}
	}

	@Override
	public void visit(final Not not) {
		final Class<? extends Node> resultType = getUnaryResultType(not);
		if (!isBooleanType(resultType)) {
			errors.add("[Not] negation requires the type of Int or Money");
		}
		else {
			log.add("[Not] success");
			resultTypes.addTypeForNode(not, resultType);
		}
	}

	@Override
	public void visit(final Pos pos) {
		final Class<? extends Node> resultType = getUnaryResultType(pos);
		if (!isBooleanType(resultType)) {
			errors.add("[Pos] operation requires the type of Int or Money");
		}
		else {
			log.add("[Pos] success");
			resultTypes.addTypeForNode(pos, resultType);
		}		
	}
	
	@Override
	public void visit(final Computation computation) {
		final Node calculationOperation = computation.getCalculationOperation();
		if (calculationOperation == null || !isMoneyOrIntegerType(resultTypes.getTypeOfNode(calculationOperation))) {
			errors.add("[Computation] A computation should result in an integer or money");
		}
		else {
			log.add("[Computation] success");
			resultTypes.addTypeForNode(computation, Computation.class);
		}
	}
	
	@Override
	public void visit(final Form form) {
		final List<Element> elements = form.getNodes();
		if (elements.isEmpty()) {
			errors.add("[Form] form does not contain valid elements");
		}
		else {
			log.add("[Form] success");
			resultTypes.addTypeForNode(form, Form.class);
		}
	}
	
	@Override
	public void visit(final Question question) {
		log.add("[Question] success");
		resultTypes.addTypeForNode(question, Question.class);
	}
	@Override
	public void visit(final IfThen ifThen) {
		final Node conditions = ifThen.getConditions();
		if (!Bool.class.equals(resultTypes.getTypeOfNode(conditions))) {
			errors.add("[IfThen] The condition does not result in boolean type");
		}
		else {
			log.add("[IfThen] success");
		
			final List<Element> successElements = ifThen.getSuccessElements();
			if (successElements == null || successElements.size() == 0) {
				errors.add("[IfThen] warning: empty success flow");
			}
			
			resultTypes.addTypeForNode(ifThen, IfThen.class);
		}
	}
	
	@Override
	public void visit(final IfThenElse ifThenElse) {
		final Node conditions = ifThenElse.getConditions();
		if (!Bool.class.equals(resultTypes.getTypeOfNode(conditions))) {
			errors.add("[IfThenElse] The condition does not result in boolean type");
		}
		else {
			log.add("[IfThenElse] success");
		
			final List<Element> successElements = ifThenElse.getSuccessElements();
			if (successElements == null || successElements.size() == 0) {
				errors.add("[IfThen] warning: empty success flow");
			}

			final List<Element> elseElements = ifThenElse.getElseElements();
			if (elseElements == null || elseElements.size() == 0) {
				errors.add("[IfThen] warning: empty success flow");
			}
			
			resultTypes.addTypeForNode(ifThenElse, IfThen.class);
		}		
	}
	
	@Override
	public void visit(final Bool bool) {
		resultTypes.addTypeForNode(bool, Bool.class);
	}
	
	@Override
	public void visit(final Int i) {
		resultTypes.addTypeForNode(i, Int.class);
	}

	@Override
	public void visit(final Money money) {
		resultTypes.addTypeForNode(money, Money.class);
	}
	@Override
	public void visit(final StringLiteral literal) {
		resultTypes.addTypeForNode(literal, StringLiteral.class);
	}

	@Override
	public void visit(final Add add) {
		final Class<? extends Node> leftHandSide = getLeftHandSideResultType(add);
		final Class<? extends Node> rightHandSide = getRightHandSideResultType(add);
		boolean error = false;

		if (!isMoneyOrIntegerType(leftHandSide)) {
			errors.add("[Add] the left hand side is not of the type Int or money");
			error = true;
		}
		
		if (!isMoneyOrIntegerType(rightHandSide)) {
			errors.add("[Add] the right hand side is not of the type Int or money");
			error = true;
		}

		if (!hasOperationGotEqualTypes(add)) {
			errors.add("[Add] the operation requires both the left hand side and the right hands side to be of the same type");
			error = true;
		}
		
		if (!error) {
			// result in money if necessary
			Class<? extends Node> resultType = isMoneyTypeInvolved(add) ? Money.class : Int.class;
			resultTypes.addTypeForNode(add, resultType);
			
			log.add("[Add] valid");
		}
	}

	@Override
	public void visit(final LT lt) {
		final Class<? extends Node> leftHandSide = getLeftHandSideResultType(lt);
		final Class<? extends Node> rightHandSide = getRightHandSideResultType(lt);
		
		boolean error = false;
		
		if (!isMoneyOrIntegerType(leftHandSide)) {
			errors.add("[LT] the left hand side is not of the type Int or money");
			error = true;
		}
		
		if (!isMoneyOrIntegerType(rightHandSide)) {
			errors.add("[LT] the right hand side is not of the type Int or money");
			error = true;
		}
		
		if (!error) {
			// TODO: result type factory?
			resultTypes.addTypeForNode(lt, Bool.class);
			
			log.add("[LT] valid");
		}
	}
	
	private boolean hasOperationGotEqualTypes(final BinaryOperator operator) {
		final Class<? extends Node> leftHandSide = getLeftHandSideResultType(operator);
		final Class<? extends Node> rightHandSide = getRightHandSideResultType(operator);		
		
		if (leftHandSide == null || rightHandSide == null) {
			return false;
		}
		else {
			return leftHandSide.equals(rightHandSide);
		}
	}
	
	private boolean isBooleanType(final Class<? extends Node> nodeType) {
		return (Bool.class.equals(nodeType));
	}
	
	private boolean isMoneyOrIntegerType(final Class<? extends Node> nodeType) {
		return (Int.class.equals(nodeType) || !Money.class.equals(nodeType));
	}
	
	private final boolean isMoneyTypeInvolved(final BinaryOperator operator) {
		final Class<? extends Node> leftHandSide = getLeftHandSideResultType(operator);
		final Class<? extends Node> rightHandSide = getRightHandSideResultType(operator);		
		
		return (leftHandSide.equals(Money.class) || rightHandSide.equals(Money.class));
	}

	private final Class<? extends Node> getLeftHandSideResultType(final BinaryOperator operator) {
		return resultTypes.getTypeOfNode(operator.getLeftHandSide());
	}
	
	private final Class<? extends Node> getRightHandSideResultType(final BinaryOperator operator) {
		return resultTypes.getTypeOfNode(operator.getRightHandSide());
	}
	
	private final Class<? extends Node> getUnaryResultType(final UnaryOperator operator) {
		return resultTypes.getTypeOfNode(operator.getNode());
	}
}
