package org.uva.sea.ql.ast.traversal;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.base.Node;
import org.uva.sea.ql.ast.conditionals.IfThen;
import org.uva.sea.ql.ast.conditionals.IfThenElse;
import org.uva.sea.ql.ast.form.Computation;
import org.uva.sea.ql.ast.form.Element;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.Label;
import org.uva.sea.ql.ast.form.Question;
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
import org.uva.sea.ql.ast.traversal.base.IVisitor;
import org.uva.sea.ql.ast.types.Bool;
import org.uva.sea.ql.ast.types.Ident;
import org.uva.sea.ql.ast.types.Int;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.ast.types.StringLiteral;

// TODO: use observer pattern to store errors
public class TypeChecker implements IVisitor {
	private List<String> errors = new ArrayList<String>();
	private List<String> log = new ArrayList<String>();

	private ResultTypeTable resultTable = new ResultTypeTable(); 
	private SymbolTable symbolTable = new SymbolTable();

	public List<String> getErrors() {
		return errors;
	}
	
	public List<String> getLog() {
		return log;
	}
	
	@Override
	public void visit(final Label label) {
		resultTable.addTypeForNode(label, Label.class);
	}

	@Override
	public void visit(final Ident ident) {
		final String name = ident.getName();
		
		// Invalid reference, this label has not been declared and can not be used
		if (!symbolTable.isLabelDeclared(name)) {
			errors.add("[Ident] Invalid reference to label (" + name + ")");
		}
		else {
			// Substitute ident for the value from the symbol table
			log.add("[Ident] Success");
			resultTable.addTypeForNode(ident, symbolTable.getTypeOfNode(new Label(name)));
		}
	}
	
	@Override
	public void visit(final And and) {
		// TODO: remove duplicate code of And and Or
		final Class<? extends Node> leftHandSide = resultTable.getLeftHandSideResultType(and);
		final Class<? extends Node> rightHandSide = resultTable.getRightHandSideResultType(and);
		boolean error = false;
		if (!resultTable.isBooleanType(leftHandSide)) {
			errors.add("[And] the left hand side is not of the type Int or money");
			error = true;
		}
		if (!resultTable.isBooleanType(rightHandSide)) {
			errors.add("[And] the right hand side is not of the type Int or money");
			error = true;
		}
		
		if (!error) {
			resultTable.addTypeForNode(and, Bool.class);
			
			log.add("[And] valid");
		}
	}

	@Override
	public void visit(final Div div) {
		final Class<? extends Node> leftHandSide =resultTable.getLeftHandSideResultType(div);
		final Class<? extends Node> rightHandSide = resultTable.getRightHandSideResultType(div);
		boolean error = false;
		
		if (!resultTable.isMoneyOrIntegerType(leftHandSide)) {
			errors.add("[Div] the left hand side is not of the type Int or money");
			error = true;
		}
		if (!resultTable.isMoneyOrIntegerType(rightHandSide)) {
			errors.add("[Div] the right hand side is not of the type Int or money");
			error = true;
		}
		
		if (!error) {
			log.add("[Div] success");
			resultTable.addTypeForNode(div, resultTable.isMoneyTypeInvolved(div) ? Money.class : Int.class);
		}		
	}

	@Override
	public void visit(final Eq eq) {
		if (!resultTable.hasOperationGotEqualTypes(eq)) {
			errors.add("[Eq] the operation requires both the left hand side and the right hands side to be of the same type");
		}
		else {
			log.add("[Eq] success");
			resultTable.addTypeForNode(eq, Bool.class);			
		}
	}

	@Override
	public void visit(final GEq geq) {
		final Class<? extends Node> leftHandSide =resultTable.getLeftHandSideResultType(geq);
		final Class<? extends Node> rightHandSide = resultTable.getRightHandSideResultType(geq);
		boolean error = false;
		
		if (!resultTable.isMoneyOrIntegerType(leftHandSide)) {
			errors.add("[GEq] the left hand side is not of the type Int or money");
			error = true;
		}

		if (!resultTable.isMoneyOrIntegerType(rightHandSide)) {
			errors.add("[GEq] the right hand side is not of the type Int or money");
			error = true;
		}
		
		if (!resultTable.hasOperationGotEqualTypes(geq)) {
			errors.add("[GEq] the operation requires both the left hand side and the right hands side to be of the same type");
			error = true;
		}
		
		if (!error) {
			log.add("[GEq] success");
			resultTable.addTypeForNode(geq, Bool.class);			
		}		
	}
	
	
	@Override
	public void visit(final GT gt) {
		final Class<? extends Node> leftHandSide =resultTable.getLeftHandSideResultType(gt);
		final Class<? extends Node> rightHandSide = resultTable.getRightHandSideResultType(gt);
		boolean error = false;
		
		if (!resultTable.isMoneyOrIntegerType(leftHandSide)) {
			errors.add("[GEq] the left hand side is not of the type Int or money");
			error = true;
		}

		if (!resultTable.isMoneyOrIntegerType(rightHandSide)) {
			errors.add("[GEq] the right hand side is not of the type Int or money");
			error = true;
		}
		
		if (!resultTable.hasOperationGotEqualTypes(gt)) {
			errors.add("[GEq] the operation requires both the left hand side and the right hands side to be of the same type");
			error = true;
		}
		
		if (!error) {
			log.add("[GEq] success");
			resultTable.addTypeForNode(gt, Bool.class);			
		}		
	}
	
	@Override
	public void visit(final LEq leq) {
		final Class<? extends Node> leftHandSide =resultTable.getLeftHandSideResultType(leq);
		final Class<? extends Node> rightHandSide = resultTable.getRightHandSideResultType(leq);
		boolean error = false;
		
		if (!resultTable.isMoneyOrIntegerType(leftHandSide)) {
			errors.add("[LEq] the left hand side is not of the type Int or money");
			error = true;
		}

		if (!resultTable.isMoneyOrIntegerType(rightHandSide)) {
			errors.add("[LEq] the right hand side is not of the type Int or money");
			error = true;
		}
		
		if (!resultTable.hasOperationGotEqualTypes(leq)) {
			errors.add("[LEq] the operation requires both the left hand side and the right hands side to be of the same type");
			error = true;
		}
		
		if (!error) {
			log.add("[LEq] success");
			resultTable.addTypeForNode(leq, Bool.class);			
		}	
	}

	@Override
	public void visit(final Mul mul) {
		final Class<? extends Node> leftHandSide =resultTable.getLeftHandSideResultType(mul);
		final Class<? extends Node> rightHandSide = resultTable.getRightHandSideResultType(mul);
		boolean error = false;
		
		if (!resultTable.isMoneyOrIntegerType(leftHandSide)) {
			errors.add("[Mul] the left hand side is not of the type Int or money");
			error = true;
		}

		if (!resultTable.isMoneyOrIntegerType(rightHandSide)) {
			errors.add("[Mul] the right hand side is not of the type Int or money");
			error = true;
		}
		
		if (Money.class.equals(leftHandSide) && Money.class.equals(rightHandSide)) {
			errors.add("[Mul] you can not multiply money by money, that would make life way too easy");
			error = true;
		}
		
		if (!error) {
			log.add("[Mul] success");
			resultTable.addTypeForNode(mul, resultTable.isMoneyTypeInvolved(mul) ? Money.class : Int.class);
		}
	}
	
	@Override
	public void visit(final NEq neq) {
		if (!resultTable.hasOperationGotEqualTypes(neq)) {
			errors.add("[NEq] the operation requires both the left hand side and the right hands side to be of the same type");
		}
		else {
			log.add("[NEq] success");
			resultTable.addTypeForNode(neq, Bool.class);			
		}		
	}
	
	@Override
	public void visit(final Or or) {
		final Class<? extends Node> leftHandSide =resultTable.getLeftHandSideResultType(or);
		final Class<? extends Node> rightHandSide = resultTable.getRightHandSideResultType(or);
		boolean error = false;
		if (!resultTable.isBooleanType(leftHandSide)) {
			errors.add("[Or] the left hand side is not of the type Int or money");
			error = true;
		}
		if (!resultTable.isBooleanType(rightHandSide)) {
			errors.add("[Or] the right hand side is not of the type Int or money");
			error = true;
		}
		
		if (!error) {
			resultTable.addTypeForNode(or, Bool.class);
			
			log.add("[Or] valid");
		}
	}
	
	@Override
	public void visit(final Sub sub) {
		final Class<? extends Node> leftHandSide = resultTable.getLeftHandSideResultType(sub);
		final Class<? extends Node> rightHandSide = resultTable.getRightHandSideResultType(sub);
		boolean error = false;

		if (!resultTable.isMoneyOrIntegerType(leftHandSide)) {
			errors.add("[Sub] the left hand side is not of the type Int or money");
			error = true;
		}
		
		if (!resultTable.isMoneyOrIntegerType(rightHandSide)) {
			errors.add("[Sub] the right hand side is not of the type Int or money");
			error = true;
		}

		if (!resultTable.hasOperationGotEqualTypes(sub)) {
			errors.add("[Sub] the operation requires both the left hand side and the right hands side to be of the same type");
			error = true;
		}
		
		if (!error) {
			// result in money if necessary
			Class<? extends Node> resultType = resultTable.isMoneyTypeInvolved(sub) ? Money.class : Int.class;
			resultTable.addTypeForNode(sub, resultType);
			
			log.add("[Add] valid");
		}
	}

	@Override
	public void visit(final Neg neg) {
		final Class<? extends Node> resultType = resultTable.getUnaryResultType(neg);
		if (!resultTable.isMoneyOrIntegerType(resultType)) {
			errors.add("[Neg] negation requires the type of Int or Money");
		}
		else {
			log.add("[Neg] success");
			resultTable.addTypeForNode(neg, resultType);
		}
	}

	@Override
	public void visit(final Not not) {
		final Class<? extends Node> resultType = resultTable.getUnaryResultType(not);
		if (!resultTable.isBooleanType(resultType)) {
			errors.add("[Not] negation requires the type of Int or Money");
		}
		else {
			log.add("[Not] success");
			resultTable.addTypeForNode(not, resultType);
		}
	}

	@Override
	public void visit(final Pos pos) {
		final Class<? extends Node> resultType = resultTable.getUnaryResultType(pos);
		if (!resultTable.isBooleanType(resultType)) {
			errors.add("[Pos] operation requires the type of Int or Money");
		}
		else {
			log.add("[Pos] success");
			resultTable.addTypeForNode(pos, resultType);
		}		
	}
	
	@Override
	public void visit(final Computation computation) {
		final Label label = computation.getLabel();
		if (symbolTable.isLabelDeclared(label)) {
			errors.add("[Computation] redeclaration of label " + label.getIdentifier());
		}
		else {
			symbolTable.addTypeForNode(computation.getLabel(), computation.getExpectedType().getClass());
		}
		
		final Node calculationOperation = computation.getCalculationOperation();
		if (calculationOperation == null || !resultTable.isMoneyOrIntegerType(resultTable.getTypeOfNode(calculationOperation))) {
			errors.add("[Computation] A computation should result in an integer or money");
		}
		else {
			log.add("[Computation] success");
			resultTable.addTypeForNode(computation, Computation.class);
		}
	}

	@Override
	public void visit(final Question question) {
		log.add("[Question] success");
		resultTable.addTypeForNode(question, Question.class);
		
		
		final Label label = question.getLabel();
		if (symbolTable.isLabelDeclared(label)) {
			errors.add("[Question] redeclaration of label " + label.getIdentifier());
		}
		else {
			symbolTable.addTypeForNode(question.getLabel(), question.getExpectedType().getClass());
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
			resultTable.addTypeForNode(form, Form.class);
		}
	}

	@Override
	public void visit(final IfThen ifThen) {
		final Node conditions = ifThen.getConditions();
		if (!Bool.class.equals(resultTable.getTypeOfNode(conditions))) {
			errors.add("[IfThen] The condition does not result in boolean type");
		}
		else {
			log.add("[IfThen] success");
		
			final List<Element> successElements = ifThen.getSuccessElements();
			if (successElements == null || successElements.size() == 0) {
				errors.add("[IfThen] warning: empty success flow");
			}
			
			resultTable.addTypeForNode(ifThen, IfThen.class);
		}
	}
	
	@Override
	public void visit(final IfThenElse ifThenElse) {
		final Node conditions = ifThenElse.getConditions();
		if (!Bool.class.equals(resultTable.getTypeOfNode(conditions))) {
			errors.add("[IfThenElse] The condition does not result in boolean type");
		}
		else {
			log.add("[IfThenElse] success");
		
			final List<Element> successElements = ifThenElse.getSuccessElements();
			if (successElements == null || successElements.size() == 0) {
				errors.add("[IfThenElse] warning: empty success flow");
			}

			final List<Element> elseElements = ifThenElse.getElseElements();
			if (elseElements == null || elseElements.size() == 0) {
				errors.add("[IfThenElse] warning: empty success flow");
			}
			
			resultTable.addTypeForNode(ifThenElse, IfThen.class);
		}		
	}
	
	@Override
	public void visit(final Bool bool) {
		resultTable.addTypeForNode(bool, Bool.class);
	}
	
	@Override
	public void visit(final Int i) {
		resultTable.addTypeForNode(i, Int.class);
	}

	@Override
	public void visit(final Money money) {
		resultTable.addTypeForNode(money, Money.class);
	}
	@Override
	public void visit(final StringLiteral literal) {
		resultTable.addTypeForNode(literal, StringLiteral.class);
	}

	@Override
	public void visit(final Add add) {
		final Class<? extends Node> leftHandSide =resultTable.getLeftHandSideResultType(add);
		final Class<? extends Node> rightHandSide = resultTable.getRightHandSideResultType(add);
		boolean error = false;

		if (!resultTable.isMoneyOrIntegerType(leftHandSide)) {
			errors.add("[Add] the left hand side is not of the type Int or money");
			error = true;
		}
		
		if (!resultTable.isMoneyOrIntegerType(rightHandSide)) {
			errors.add("[Add] the right hand side is not of the type Int or money");
			error = true;
		}

		if (!resultTable.hasOperationGotEqualTypes(add)) {
			errors.add("[Add] the operation requires both the left hand side and the right hands side to be of the same type");
			error = true;
		}
		
		if (!error) {
			// result in money if necessary
			Class<? extends Node> resultType = (resultTable.isMoneyTypeInvolved(add) ? Money.class : Int.class);
			resultTable.addTypeForNode(add, resultType);
			
			log.add("[Add] valid");
		}
	}

	@Override
	public void visit(final LT lt) {
		final Class<? extends Node> leftHandSide = resultTable.getLeftHandSideResultType(lt);
		final Class<? extends Node> rightHandSide = resultTable.getRightHandSideResultType(lt);
		
		boolean error = false;
		
		if (!resultTable.isMoneyOrIntegerType(leftHandSide)) {
			errors.add("[LT] the left hand side is not of the type Int or money");
			error = true;
		}
		
		if (!resultTable.isMoneyOrIntegerType(rightHandSide)) {
			errors.add("[LT] the right hand side is not of the type Int or money");
			error = true;
		}
		
		if (!error) {
			// TODO: result type factory?
			resultTable.addTypeForNode(lt, Bool.class);
			
			log.add("[LT] valid");
		}
	}
}
