package org.uva.sea.ql.ast.traversal;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.base.Node;
import org.uva.sea.ql.ast.conditionals.*;
import org.uva.sea.ql.ast.form.*;
import org.uva.sea.ql.ast.operators.base.BinaryOperator;
import org.uva.sea.ql.ast.operators.binary.*;
import org.uva.sea.ql.ast.operators.unary.*;
import org.uva.sea.ql.ast.traversal.base.HandSide;
import org.uva.sea.ql.ast.traversal.base.IVisitor;
import org.uva.sea.ql.ast.traversal.logging.*;
import org.uva.sea.ql.ast.types.*;

/**
 * Visitor that type checks (semantics) of the abstract syntax tree.
 * The tree it checks has been parsed by ANTLR.
 * @author J. Dijkstra
 */
public class TypeChecker implements IVisitor {
	/**
	 * Error log.
	 */
	private final TypeErrorLog errorLog = new TypeErrorLog();
	/**
	 * Event log.
	 */
	private final TypeEventLog eventLog = new TypeEventLog();

	/**
	 * Stores result types after reduction.
	 */
	private final ResultTypeTable resultTable = new ResultTypeTable();
	/**
	 * Stores result types for defined labels.
	 */
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
		resultTable.addTypeForNode(form, Form.class);
		eventLog.addCorrectSemantics(form);
	}
	
	@Override
	public void visit(final Computation computation) {
		final Label label = computation.getLabel();
		if (symbolTable.isLabelDeclared(label)) {
			errorLog.addLabelRedeclaration(computation, label);
		}
		else {
			// The label has not yet been declared before, thus we store it in the symbol table here
			symbolTable.addTypeForNode(label, computation.getExpectedType());
		}
		
		// Should be a calculation
		final Node calculationOperation = computation.getCalculationOperation();
		if (calculationOperation == null || !resultTable.isMoneyOrIntegerType(resultTable.getTypeOfNode(calculationOperation))) {
			// Mention expected types in the error log
			final List<Class<? extends Node>> expectedTypes = new ArrayList<Class <? extends Node>>();
			expectedTypes.add(Int.class);
			expectedTypes.add(Money.class);
			
			errorLog.addExpectedDifferentTypes(computation, expectedTypes);
		}
		else {
			// Correct semantics
			resultTable.addTypeForNode(computation, Computation.class);
			eventLog.addCorrectSemantics(computation);
		}
	}

	@Override
	public void visit(final Question question) {	
		final Label label = question.getLabel();
		if (symbolTable.isLabelDeclared(label)) {
			errorLog.addLabelRedeclaration(question, label);
		}
		else {
			resultTable.addTypeForNode(question, Question.class);
			eventLog.addCorrectSemantics(question);
			
			// The label has not yet been declared before, thus we store it in the symbol table here
			symbolTable.addTypeForNode(question.getLabel(), question.getExpectedType());
		}
	}
	
	// Conditionals
	@Override
	public void visit(final IfThen ifThen) {
		final Node conditions = ifThen.getCondition();
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
		final Node conditions = ifThenElse.getCondition();
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
		if (!checkForBooleanBothSideErrors(and)) {
			resultTable.addTypeForNode(and, Bool.class);
			
			eventLog.addCorrectSemantics(and);
		}
	}
	
	@Override
	public void visit(final Or or) {
		if (!checkForBooleanBothSideErrors(or)) {
			resultTable.addTypeForNode(or, Bool.class);
			
			eventLog.addCorrectSemantics(or);
		}
	}

	@Override
	public void visit(final Div div) {			
		if (!checkForNumberTypeErrors(div)) {
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
	
	public TypeEventLog getEventLog() {
		return eventLog;
	}
	
	private boolean checkForEmptyFlow(final IfStatement conditional, final List<Element> flowElements) {
		// The flow of the condition appears to be empty. The error log should contain a warning
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
	
	// Both sides have to be of the same type
	private boolean checkForSameTypeErrors(final BinaryOperator operator) {	
		if (!resultTable.hasOperationGotEqualTypes(operator)) {
			errorLog.addBothSidesAreDifferentTypes(operator);
			
			return true;
		}
		
		return false;
	}
	
	// Both sides have to be booleans
	private boolean checkForBooleanBothSideErrors(final BinaryOperator operator) {
		// TODO: operators typeof
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
