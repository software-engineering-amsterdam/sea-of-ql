package org.uva.sea.ql.ast.traversal;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.base.Node;
import org.uva.sea.ql.ast.conditionals.IfStatement;
import org.uva.sea.ql.ast.conditionals.IfThen;
import org.uva.sea.ql.ast.conditionals.IfThenElse;
import org.uva.sea.ql.ast.form.Computation;
import org.uva.sea.ql.ast.form.Element;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.Label;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.ast.operators.base.BinaryOperator;
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
import org.uva.sea.ql.ast.traversal.base.HandSide;
import org.uva.sea.ql.ast.traversal.base.IVisitor;
import org.uva.sea.ql.ast.traversal.logging.TypeErrorLog;
import org.uva.sea.ql.ast.traversal.logging.TypeEventLog;
import org.uva.sea.ql.ast.types.Bool;
import org.uva.sea.ql.ast.types.Ident;
import org.uva.sea.ql.ast.types.Int;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.ast.types.StringLiteral;

public class TypeChecker implements IVisitor {
	private final TypeErrorLog errorLog = new TypeErrorLog();
	private final TypeEventLog eventLog = new TypeEventLog();

	private final ResultTypeTable resultTable = new ResultTypeTable(); 
	private final SymbolTable symbolTable = new SymbolTable();

	// DataTypes
	@Override
	public void visit(final Label label) {
		resultTable.addTypeForNode(label, Label.class);
	}

	@Override
	public void visit(final Ident ident) {
		final String name = ident.getName();
		
		// Invalid reference, this label has not been declared and can not be used
		if (!symbolTable.isLabelDeclared(name)) {
			errorLog.addInvalidReference(ident, name);
		}
		else {
			// Substitute ident for the value from the symbol table
			resultTable.addTypeForNode(ident, symbolTable.getTypeOfNode(new Label(name)));
			eventLog.addCorrectSemantics(ident);
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

	// Form Types
	@Override
	public void visit(final Form form) {
		final List<Element> elements = form.getNodes();
		if (elements.isEmpty()) {
			errorLog.addFormContainsInvalidElements(form);
		}
		else {
			resultTable.addTypeForNode(form, Form.class);
			eventLog.addCorrectSemantics(form);
		}
	}
	
	@Override
	public void visit(final Computation computation) {
		final Label label = computation.getLabel();
		if (symbolTable.isLabelDeclared(label)) {
			errorLog.addLabelRedeclaration(computation, label);
		}
		else {
			// The label has not yet been declared before, thus we store it in the symbol table here
			symbolTable.addTypeForNode(label, computation.getExpectedType().getClass());
		}
		
		final Node calculationOperation = computation.getCalculationOperation();
		if (calculationOperation == null || !resultTable.isMoneyOrIntegerType(resultTable.getTypeOfNode(calculationOperation))) {
			
			final List<Class<? extends Node>> expectedTypes = new ArrayList<Class <? extends Node>>();
			expectedTypes.add(Int.class);
			expectedTypes.add(Money.class);
			
			errorLog.addExpectedDifferentTypes(computation, expectedTypes);
		}
		else {
			resultTable.addTypeForNode(computation, Computation.class);
			eventLog.addCorrectSemantics(computation);
		}
	}

	@Override
	public void visit(final Question question) {
		resultTable.addTypeForNode(question, Question.class);
		eventLog.addCorrectSemantics(question);
		
		final Label label = question.getLabel();
		if (symbolTable.isLabelDeclared(label)) {
			errorLog.addLabelRedeclaration(question, label);
		}
		else {
			// The label has not yet been declared before, thus we store it in the symbol table here
			symbolTable.addTypeForNode(question.getLabel(), question.getExpectedType().getClass());
		}
	}
	
	// Conditionals
	@Override
	public void visit(final IfThen ifThen) {
		final Node conditions = ifThen.getConditions();
		if (!Bool.class.equals(resultTable.getTypeOfNode(conditions))) {
			errorLog.addExpectedDifferentType(ifThen, Bool.class);
		}
		else {
			checkForEmptyFlow(ifThen, ifThen.getSuccessElements());
			
			resultTable.addTypeForNode(ifThen, IfThen.class);
			eventLog.addCorrectSemantics(ifThen);
		}
	}
	
	@Override
	public void visit(final IfThenElse ifThenElse) {
		final Node conditions = ifThenElse.getConditions();
		if (!Bool.class.equals(resultTable.getTypeOfNode(conditions))) {
			errorLog.addExpectedDifferentType(ifThenElse, Bool.class);
		}
		else {
			checkForEmptyFlow(ifThenElse, ifThenElse.getSuccessElements());
			checkForEmptyFlow(ifThenElse, ifThenElse.getElseElements());

			resultTable.addTypeForNode(ifThenElse, IfThenElse.class);
			
			eventLog.addCorrectSemantics(ifThenElse);
		}		
	}

	// Binary operators
	@Override
	public void visit(final And and) {
		if (!checkForBooleanBothSideErors(and)) {
			resultTable.addTypeForNode(and, Bool.class);
			
			eventLog.addCorrectSemantics(and);
		}
	}
	
	@Override
	public void visit(final Or or) {
		if (!checkForBooleanBothSideErors(or)) {
			resultTable.addTypeForNode(or, Bool.class);
			
			eventLog.addCorrectSemantics(or);
		}
	}

	@Override
	public void visit(final Div div) {
		boolean error = checkForNumberTypeErrors(div);
		if (!error) {
			error = checkForSameTypeErrors(div);
		}
		
		if (!error) {
			resultTable.addTypeForNode(div, getNumberResultType(div));
			eventLog.addCorrectSemantics(div);
		}		
	}

	@Override
	public void visit(final Eq eq) {
		if (!resultTable.hasOperationGotEqualTypes(eq)) {
			errorLog.addBothSidesAreDifferentTypes(eq);
		}
		else {
			resultTable.addTypeForNode(eq, Bool.class);			
			eventLog.addCorrectSemantics(eq);
		}
	}

	@Override
	public void visit(final GEq geq) {
		boolean error = checkForNumberTypeErrors(geq);
		if (!error) {
			error = checkForSameTypeErrors(geq);
		}
		
		if (!error) {
			resultTable.addTypeForNode(geq, Bool.class);			
			eventLog.addCorrectSemantics(geq);
		}		
	}
	
	
	@Override
	public void visit(final GT gt) {
		boolean error = checkForNumberTypeErrors(gt);
		if (!error) {
			error = checkForSameTypeErrors(gt);
		}
		
		if (!error) {
			resultTable.addTypeForNode(gt, Bool.class);			
			eventLog.addCorrectSemantics(gt);			
		}		
	}
	
	@Override
	public void visit(final LEq leq) {
		boolean error = checkForNumberTypeErrors(leq);
		if (!error) {
			error = checkForSameTypeErrors(leq);
		}
		
		if (!error) {
			resultTable.addTypeForNode(leq, Bool.class);
			eventLog.addCorrectSemantics(leq);
		}	
	}

	@Override
	public void visit(final Mul mul) {
		// TODO: can not multiply money with money

		if (!checkForNumberTypeErrors(mul)) {
			resultTable.addTypeForNode(mul, getNumberResultType(mul));
			eventLog.addCorrectSemantics(mul);
		}
	}
	
	@Override
	public void visit(final NEq neq) {
		if (!checkForSameTypeErrors(neq)) {
			resultTable.addTypeForNode(neq, Bool.class);
			eventLog.addCorrectSemantics(neq);
		}		
	}

	@Override
	public void visit(final Sub sub) {
		boolean error = checkForNumberTypeErrors(sub);
		if (!error) {
			error = checkForSameTypeErrors(sub);
		}
		
		if (!error) {
			resultTable.addTypeForNode(sub, getNumberResultType(sub));
			eventLog.addCorrectSemantics(sub);
		}
	}
	
	@Override
	public void visit(final Add add) {
		// Error check
		boolean error = checkForNumberTypeErrors(add);
		if (!error) {
			error = checkForSameTypeErrors(add);
		}
		
		if (!error) {
			resultTable.addTypeForNode(add, getNumberResultType(add));
			eventLog.addCorrectSemantics(add);
		}
	}

	@Override
	public void visit(final LT lt) {		
		// Error check
		boolean error = checkForNumberTypeErrors(lt);
		if (!error) {
			error = checkForSameTypeErrors(lt);
		}
		
		// No errors
		if (!error) {
			resultTable.addTypeForNode(lt, Bool.class);
			eventLog.addCorrectSemantics(lt);
		}
	}
	
	// Unary operators
	@Override
	public void visit(final Not not) {
		final Class<? extends Node> resultType = resultTable.getUnaryResultType(not);
		if (!resultTable.isBooleanType(resultType)) {
			errorLog.addTypeIsNotBoolean(HandSide.RIGHT, not);
		}
		else {
			resultTable.addTypeForNode(not, resultType);
			eventLog.addCorrectSemantics(not);
		}
	}

	
	@Override
	public void visit(final Neg neg) {
		final Class<? extends Node> resultType = resultTable.getUnaryResultType(neg);
		if (!resultTable.isMoneyOrIntegerType(resultType)) {
			errorLog.addTypeIsNotIntegerOrMoney(HandSide.RIGHT, neg);
		}
		else {
			resultTable.addTypeForNode(neg, resultType);
			eventLog.addCorrectSemantics(neg);
		}
	}

	@Override
	public void visit(final Pos pos) {		
		final Class<? extends Node> resultType = resultTable.getUnaryResultType(pos);
		if (!resultTable.isMoneyOrIntegerType(resultType)) {
			errorLog.addTypeIsNotIntegerOrMoney(HandSide.RIGHT, pos);
		}
		else {
			resultTable.addTypeForNode(pos, resultType);
			eventLog.addCorrectSemantics(pos);
		}		
	}
	
	
	public TypeErrorLog getErrorLog() {
		return errorLog;
	}	
	
	private boolean checkForEmptyFlow(final IfStatement conditional, final List<Element> flowElements) {
		if (flowElements == null || flowElements.size() == 0) {
			errorLog.addEmptyFlow(conditional);
			
			return true;
		}
		
		return false;
	}
	
	
	// Both sides have to be of a number type
	private boolean checkForNumberTypeErrors(final BinaryOperator operator) {
		final Class<? extends Node> leftHandSide = resultTable.getLeftHandSideResultType(operator);
		final Class<? extends Node> rightHandSide = resultTable.getRightHandSideResultType(operator);
		
		boolean error = false;
		
		if (!resultTable.isMoneyOrIntegerType(leftHandSide)) {
			errorLog.addTypeIsNotIntegerOrMoney(HandSide.LEFT, operator);
			error = true;
		}
		
		if (!resultTable.isMoneyOrIntegerType(rightHandSide)) {
			errorLog.addTypeIsNotIntegerOrMoney(HandSide.RIGHT, operator);
			error = true;
		}
		
		return error;
	}
	
	private boolean checkForSameTypeErrors(final BinaryOperator operator) {	
		if (!resultTable.hasOperationGotEqualTypes(operator)) {
			errorLog.addBothSidesAreDifferentTypes(operator);
			
			return true;
		}
		
		return false;
	}
	
	private boolean checkForBooleanBothSideErors(final BinaryOperator operator) {
		final Class<? extends Node> leftHandSide = resultTable.getLeftHandSideResultType(operator);
		final Class<? extends Node> rightHandSide = resultTable.getRightHandSideResultType(operator);
		
		boolean error = false;
		if (!resultTable.isBooleanType(leftHandSide)) {
			errorLog.addTypeIsNotBoolean(HandSide.LEFT, operator);
			error = true;
		}
		
		if (!resultTable.isBooleanType(rightHandSide)) {
			errorLog.addTypeIsNotBoolean(HandSide.RIGHT, operator);
			error = true;
		}

		return error;
	}

	// Determine what of the two types to return
	private Class<? extends Node> getNumberResultType(final BinaryOperator operator) {
		return (resultTable.isMoneyTypeInvolved(operator) ? Money.class : Int.class); 
	}
}
