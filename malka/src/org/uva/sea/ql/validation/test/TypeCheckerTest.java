package org.uva.sea.ql.validation.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.expression.Type;
import org.uva.sea.ql.ast.expression.bool.BooleanType;
import org.uva.sea.ql.ast.expression.bool.BooleanVariable;
import org.uva.sea.ql.ast.expression.integer.IntegerVariable;
import org.uva.sea.ql.ast.expression.integer.operation.Add;
import org.uva.sea.ql.ast.expression.string.StringPrimitive;
import org.uva.sea.ql.ast.expression.bool.operation.logical.And;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.FormElement;
import org.uva.sea.ql.ast.form.FormText;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.validation.FormTypeChecker;
import org.uva.sea.ql.validation.TypeCheckerDoesNotSupportQuestionnaireException;
import org.uva.sea.ql.visitor.VisitingException;

public class TypeCheckerTest {

	/*
	 * tests if the checker will recognize if an unknown variable is used
	 */
	@Test
	public void testUsageOfUndefinedVariable() throws VisitingException, TypeCheckerDoesNotSupportQuestionnaireException {
		FormTypeChecker type_checker;
		Expression undefined_var_expression;
		List<FormElement> elements;
		Identifier id, id2, unknown_id;
		Type type;
		Form form;
		boolean valid_types;
		List<Integer> errors;
		
		type_checker = new FormTypeChecker();
		elements     = new ArrayList<FormElement>();
		form         = new Form("testForm", elements);
		id           = new Identifier("hi");
		id2          = new Identifier("hi2");
		unknown_id   = new Identifier("unknown");
		type         = new BooleanType();
		
		undefined_var_expression = new And(
				new BooleanVariable(unknown_id),
				new BooleanVariable(id)
				);
		
		elements.add(new Question(id, new StringPrimitive("hiioooo"), type));
		elements.add(new FormText(id2, new StringPrimitive("hiioooo"), type, undefined_var_expression));
		
		valid_types = type_checker.checkTypes(form);
		
		assertTrue( ! valid_types);
		
		if (! valid_types) {
			errors = type_checker.getErrorCodes();
			assertTrue(errors.contains(FormTypeChecker.VARIABLE_NOT_DEFINED));
		}
	}
	
	/*
	 * tests if the checker will recognize if a variable is used as another type.
	 */
	@Test
	public void testVariableUsageConformDefinition() throws VisitingException, TypeCheckerDoesNotSupportQuestionnaireException {
		FormTypeChecker type_checker;
		Expression undefined_var_expression;
		List<FormElement> elements;
		Identifier id, id2, id3;
		Type type;
		Form form;
		boolean valid_types;
		List<Integer> errors;
		
		type_checker = new FormTypeChecker();
		elements     = new ArrayList<FormElement>();
		form         = new Form("testForm", elements);
		id           = new Identifier("hi");
		id2          = new Identifier("hi2");
		id3          = new Identifier("hi3");
		type         = new BooleanType();
		
		undefined_var_expression = new Add(
				new IntegerVariable(id),
				new IntegerVariable(id2)
				);
		
		elements.add(new Question(id, new StringPrimitive("hiioooo"), type));
		elements.add(new Question(id2, new StringPrimitive("hiioooo"), type));
		elements.add(new FormText(id3, new StringPrimitive("hiioooo"), type, undefined_var_expression));
		
		valid_types = type_checker.checkTypes(form);
		
		assertTrue( ! valid_types);
		
		if ( ! valid_types) {
			errors = type_checker.getErrorCodes();
			assertTrue(errors.contains(FormTypeChecker.VARIABLE_USED_AS_OTHER_TYPE));
			assertTrue(errors.size() == 3);
		}
	}
	
	/*
	 * tests if the checker will recognize correct AST
	 */
	@Test
	public void testCorrect() throws VisitingException, TypeCheckerDoesNotSupportQuestionnaireException {
		FormTypeChecker type_checker;
		Expression undefined_var_expression;
		List<FormElement> elements;
		Identifier id, id2;
		Type type;
		Form form;
		boolean valid_types;
		List<Integer> errors;
		
		type_checker = new FormTypeChecker();
		elements     = new ArrayList<FormElement>();
		form         = new Form("testForm", elements);
		id           = new Identifier("hi");
		id2          = new Identifier("hi2");
		type         = new BooleanType();
		
		undefined_var_expression = new And(
				new BooleanVariable(id2),
				new BooleanVariable(id)
				);
		
		elements.add(new Question(id, new StringPrimitive("hiioooo"), type));
		elements.add(new FormText(id2, new StringPrimitive("hiioooo"), type, undefined_var_expression));
		
		valid_types = type_checker.checkTypes(form);
		
		assertTrue( valid_types);
		
		errors = type_checker.getErrorCodes();
		assertTrue(errors.size() == 0);
	}

}
