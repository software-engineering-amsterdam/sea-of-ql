package org.uva.sea.ql.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.Questionnaire;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.expression.Type;
import org.uva.sea.ql.ast.expression.Variable;
import org.uva.sea.ql.ast.expression.bool.BooleanExpression;
import org.uva.sea.ql.ast.expression.bool.BooleanPrimitive;
import org.uva.sea.ql.ast.expression.bool.BooleanVariable;
import org.uva.sea.ql.ast.expression.bool.operation.logical.And;
import org.uva.sea.ql.ast.expression.bool.operation.logical.Not;
import org.uva.sea.ql.ast.expression.bool.operation.logical.Or;
import org.uva.sea.ql.ast.expression.bool.operation.relational.Eq;
import org.uva.sea.ql.ast.expression.bool.operation.relational.GEq;
import org.uva.sea.ql.ast.expression.bool.operation.relational.GT;
import org.uva.sea.ql.ast.expression.bool.operation.relational.LEq;
import org.uva.sea.ql.ast.expression.bool.operation.relational.LT;
import org.uva.sea.ql.ast.expression.bool.operation.relational.NEq;
import org.uva.sea.ql.ast.expression.integer.IntegerExpression;
import org.uva.sea.ql.ast.expression.integer.IntegerPrimitive;
import org.uva.sea.ql.ast.expression.integer.IntegerVariable;
import org.uva.sea.ql.ast.expression.integer.operation.Add;
import org.uva.sea.ql.ast.expression.integer.operation.Div;
import org.uva.sea.ql.ast.expression.integer.operation.Mul;
import org.uva.sea.ql.ast.expression.integer.operation.Neg;
import org.uva.sea.ql.ast.expression.integer.operation.Pos;
import org.uva.sea.ql.ast.expression.integer.operation.Sub;
import org.uva.sea.ql.ast.expression.string.StringExpression;
import org.uva.sea.ql.ast.expression.string.StringPrimitive;
import org.uva.sea.ql.ast.expression.string.StringVariable;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.FormElement;
import org.uva.sea.ql.ast.form.FormText;
import org.uva.sea.ql.ast.form.IfStatement;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.visitor.NodeNotSupportedByVisitorException;
import org.uva.sea.ql.visitor.Visitor;
import org.uva.sea.ql.visitor.VisitingException;

public class FormTypeChecker implements Visitor, IQuestionnaireTypeChecker {
	
	/*
	 * TODO comment the constants
	 */
	public static final int COMPARE_DIFFERENT_TYPES = 0;
	public static final int VARIABLE_USED_AS_OTHER_TYPE = 1;
	public static final int VARIABLE_NOT_DEFINED = 2;
	
	
	protected List<String> errors;
	protected List<Integer> error_codes;
	
	Map<String, Variable> variables;
	
	public FormTypeChecker() {
		errors      = new ArrayList<String>();
		error_codes = new ArrayList<Integer>();
	}
	
	private void addError(String error_message, int error_code) {
		this.errors.add(error_message);
		this.error_codes.add(new Integer(error_code));
	}
	
	private boolean isBooleanExpression(Expression expression1) {
		return expression1 instanceof BooleanExpression;
	}
	
	private boolean isIntegerExpression(Expression expression1) {
		return expression1 instanceof IntegerExpression;
	}
	
	private boolean isStringExpression(Expression expression1) {
		return expression1 instanceof StringExpression;
	}
	
	private boolean areBooleanExpressions(Expression expression1,
			Expression expression2) {
		
		return (isBooleanExpression(expression1)
				&& isBooleanExpression(expression2));
	}
	
	private boolean areIntegerExpressions(Expression expression1,
			Expression expression2) {
		
		return (isIntegerExpression(expression1)
				&& isIntegerExpression(expression2));
	}
	
	private boolean areStringExpressions(Expression expression1,
			Expression expression2) {
		
		return (isStringExpression(expression1)
				&& isStringExpression(expression2));
	}
	
	private boolean expressionsHaveSameType(Expression expression1,
			Expression expression2) {
		
		return (areBooleanExpressions(expression1, expression2)
					|| areIntegerExpressions(expression1, expression2)
					|| areStringExpressions(expression1, expression2));
	}
	
	/*
	 * Checks if a form AST does not have typing errors.
	 * Returns true if there are no errors, otherwise return false
	 */
	public boolean checkTypes(Questionnaire form) throws VisitingException, TypeCheckerDoesNotSupportQuestionnaireException {
		VariableListGenerator variable_list_generator = null;
		
		variable_list_generator = new VariableListGenerator();
		
		if (form instanceof Form) {
			variables = variable_list_generator.getVariableList((Form) form);
			
			((Form) form).accept(this);
		} else {
			throw new TypeCheckerDoesNotSupportQuestionnaireException();
		}
		
		return (errors.size() == 0);
	}
	
	public List<String> getErrors() {
		return errors;
	}
	
	public List<Integer> getErrorCodes() {
		return error_codes;
	}
	
	
	/*
	 * Below are all the visiting functions
	 */
	
	
	
	/**
	 * Check 1: check if the calculated type and the text type are the same 
	 */
	
	@Override
	public void visit(FormText form_text)  throws VisitingException {
		Identifier id = form_text.getId();
		Type type = form_text.getType();
		Variable variable = type.getVariable(id);
		Expression calculation = form_text.getCalculation();
		
		if ( ! expressionsHaveSameType(variable, calculation)) {
			addError("The type of the question and the calculated question are different", VARIABLE_USED_AS_OTHER_TYPE);
		}
		
		calculation.accept(this);
	}
	
	/*
	 *  relational operations (operands of relational operations are not restricted to
	 *  a specific type in the AST, so we have to check here if we are
	 *  comparing expressions of the same type)
	 */
	
	@Override
	public void visit(Eq relation) throws VisitingException {
		if (expressionsHaveSameType(relation.getLeftOperand(), relation.getRightOperand()))
			this.addError("Comparison of two different types", COMPARE_DIFFERENT_TYPES);
	}
	
	@Override
	public void visit(GT relation) throws VisitingException {
		if (expressionsHaveSameType(relation.getLeftOperand(), relation.getRightOperand()))
			this.addError("Comparison of two different types", COMPARE_DIFFERENT_TYPES);
	}

	@Override
	public void visit(GEq relation) throws VisitingException {
		if (expressionsHaveSameType(relation.getLeftOperand(), relation.getRightOperand()))
			this.addError("Comparison of two different types", COMPARE_DIFFERENT_TYPES);
	}

	@Override
	public void visit(LEq relation) throws VisitingException {
		if (expressionsHaveSameType(relation.getLeftOperand(), relation.getRightOperand()))
			this.addError("Comparison of two different types", COMPARE_DIFFERENT_TYPES);
	}

	@Override
	public void visit(NEq relation) throws VisitingException {
		if (expressionsHaveSameType(relation.getLeftOperand(), relation.getRightOperand()))
			this.addError("Comparison of two different types", COMPARE_DIFFERENT_TYPES);
	}
	
	@Override
	public void visit(LT relation) throws VisitingException {
		if (expressionsHaveSameType(relation.getLeftOperand(), relation.getRightOperand()))
			this.addError("Comparison of two different types", COMPARE_DIFFERENT_TYPES);
	}
	
	
	
	/*
	 * Variables
	 * Check 1: variables (check if a variable is parsed with type a, while defined with type b)
	 * Check 2: if variables are used but not defined!
	 */
	
	private void checkVariableConformDefinition(Variable variable) {
		String variable_name = variable.getID().getName();
		if (variables.containsKey(variable_name)) {
			if (! expressionsHaveSameType(variables.get(variable_name), variable)) {
				this.addError("Variable '" + variable_name + "' is used as another type", VARIABLE_USED_AS_OTHER_TYPE);
			}
		} else {
			this.addError("Variable '" + variable_name + "' is not defined", VARIABLE_NOT_DEFINED);
		}
	}
	
	@Override
	public void visit(IntegerVariable variable) throws VisitingException {
		checkVariableConformDefinition(variable);
	}
	
	@Override
	public void visit(StringVariable variable) throws VisitingException {
		checkVariableConformDefinition(variable);
	}
	
	
	@Override
	public void visit(BooleanVariable variable) throws VisitingException {
		checkVariableConformDefinition(variable);
	}
	
	
	/*
	 *  Following need no checks, only help traversal (AST ensures correct types).
	 */
	
	@Override
	public void visit(Form form) throws VisitingException {
		List<FormElement> elements = form.getElements(); 
		for(FormElement element : elements) {
			element.accept(this);
		}
	}
	
	@Override
	public void visit(IfStatement statement) throws VisitingException {
		BooleanExpression condition = statement.getCondition();
		condition.accept(this);
		
		List<FormElement> elements = statement.getIfList();
		List<FormElement> else_elements = statement.getElseList();
		
		if (else_elements != null) {
			elements.addAll(else_elements);
		}
		
		for(FormElement element : elements) {
			element.accept(this);
		}
	}
	
	@Override
	public void visit(And operator) throws VisitingException {
		operator.getLeftOperand().accept(this);
		operator.getRightOperand().accept(this);
	}

	@Override
	public void visit(Not operator) throws VisitingException {
		operator.getOperand().accept(this);
	}

	@Override
	public void visit(Or operator) throws VisitingException {
		operator.getLeftOperand().accept(this);
		operator.getRightOperand().accept(this);
	}
	
	@Override
	public void visit(Sub operator) throws VisitingException {
		operator.getLeftOperand().accept(this);
		operator.getRightOperand().accept(this);
	}

	@Override
	public void visit(Neg operator) throws VisitingException {
		operator.getOperand().accept(this);
	}

	@Override
	public void visit(Mul operator) throws VisitingException {
		operator.getLeftOperand().accept(this);
		operator.getRightOperand().accept(this);
	}

	@Override
	public void visit(Div operator) throws VisitingException {
		operator.getLeftOperand().accept(this);
		operator.getRightOperand().accept(this);
	}

	@Override
	public void visit(Add operator) throws VisitingException {
		operator.getLeftOperand().accept(this);
		operator.getRightOperand().accept(this);
	}

	@Override
	public void visit(Pos operator) throws VisitingException {
		operator.getOperand().accept(this);
	}
	
	
	/*
	 * Following are leaves which need no checks (The parser and AST ensure the correct types for these)
	 */
	
	
	@Override
	public void visit(IntegerPrimitive integerPrimitive)
			throws VisitingException {}
	
	@Override
	public void visit(StringPrimitive stringPrimitive) throws VisitingException {}
	
	@Override
	public void visit(BooleanPrimitive booleanPrimitive)
			throws VisitingException {}
	
	@Override
	public void visit(Question question) throws VisitingException {}
	
	// TODO check if identifier should really be in the AST!
	@Override
	public void visit(Identifier identifier) throws VisitingException {
		throw new NodeNotSupportedByVisitorException();
	}
	
}
