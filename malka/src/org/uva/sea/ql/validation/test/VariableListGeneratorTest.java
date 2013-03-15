package org.uva.sea.ql.validation.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.expression.Type;
import org.uva.sea.ql.ast.expression.Variable;
import org.uva.sea.ql.ast.expression.bool.BooleanType;
import org.uva.sea.ql.ast.expression.string.StringPrimitive;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.ast.form.FormElement;
import org.uva.sea.ql.validation.DuplicateVariableException;
import org.uva.sea.ql.validation.VariableListGenerator;
import org.uva.sea.ql.visitor.VisitingException;

public class VariableListGeneratorTest {
	
	@Test
	public void testFormVariables() throws VisitingException{
		VariableListGenerator list_generator = new VariableListGenerator();
		List<FormElement> elements = new ArrayList<FormElement>();
		
		Form form      = new Form("testForm", elements);
		Identifier id  = new Identifier("hi");
		Identifier id2 = new Identifier("hi2");
		Type type      = new BooleanType();
		
		Map<String, Variable> expected = new HashMap<String, Variable>();
		Map<String, Variable> actual;
		
		elements.add(new Question(id, new StringPrimitive("hiioooo"), type));
		elements.add(new Question(id2, new StringPrimitive("hiiooooo"), type));
		
		actual = list_generator.getVariableList(form);
		
		expected.put("hi", type.getVariable(id));
		expected.put("hi2", type.getVariable(id2));
		
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFormVariablesUniqueness() throws VisitingException{
		VariableListGenerator list_generator = new VariableListGenerator();
		List<FormElement> elements = new ArrayList<FormElement>();
		
		Form form     = new Form("testForm", elements);
		Identifier id = new Identifier("hi");
		Type type     = new BooleanType();
		
		elements.add(new Question(id, new StringPrimitive("hiioooo"), type));
		elements.add(new Question(id, new StringPrimitive("hiioooo"), type));
		
		try {
			list_generator.getVariableList(form);
			fail();
		} catch(DuplicateVariableException e) {
			assertTrue(true);
		} catch(Exception e) {
			fail();
		}
	}
	
}
