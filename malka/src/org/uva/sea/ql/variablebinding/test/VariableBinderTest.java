package org.uva.sea.ql.variablebinding.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.expression.Primitive;
import org.uva.sea.ql.ast.expression.Type;
import org.uva.sea.ql.ast.expression.Variable;
import org.uva.sea.ql.ast.expression.bool.BooleanExpression;
import org.uva.sea.ql.ast.expression.bool.BooleanPrimitive;
import org.uva.sea.ql.ast.expression.bool.BooleanType;
import org.uva.sea.ql.ast.expression.bool.BooleanVariable;
import org.uva.sea.ql.ast.expression.bool.operation.logical.And;
import org.uva.sea.ql.ast.expression.string.StringPrimitive;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.FormElement;
import org.uva.sea.ql.ast.form.IfStatement;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.variablebinding.VariableBinder;
import org.uva.sea.ql.visitor.VisitingException;

public class VariableBinderTest {

	@Test
	public void testBindVariables() {
		Form form = null;
		
		List<FormElement> elements      = null;
		List<FormElement> if_elements   = null;
		List<FormElement> else_elements = null;
		
		
		Identifier bool_id1 = null;
		Identifier bool_id2 = null;
		Identifier bool_id3 = null;
		
		Type type = null;
		VariableBinder binder = null;
		Map<Identifier, Primitive> variable_boundations = null;
		BooleanExpression if_condition = null;
		
		bool_id1             = new Identifier("test_id");
		bool_id2             = new Identifier("test_id2");
		bool_id3             = new Identifier("test_id");
		// bool_id3 and bool_id1 are the same!
		
		elements             = new ArrayList<FormElement>();
		if_elements          = new ArrayList<FormElement>();
		else_elements        = new ArrayList<FormElement>();
		
		
		variable_boundations = new HashMap<Identifier, Primitive>();
		type                 = new BooleanType();
		binder               = new VariableBinder();
		
		elements.add(new Question(bool_id1, new StringPrimitive("hiioooo"), type));
		
		
		if_condition = new And(new BooleanVariable(bool_id3), new BooleanVariable(bool_id2));
		elements.add(new IfStatement(if_condition, if_elements, else_elements));
		
		// make all booleans true
		variable_boundations.put(bool_id1, new BooleanPrimitive(true));
		variable_boundations.put(bool_id2, new BooleanPrimitive(true));
		
		
		form = new Form("testForm", elements);
		
		try {
			binder.bindVariables(form, variable_boundations);
		} catch (VisitingException e) {
			// no exception should arise here!!!
			fail();
		}
		
		// test if the question is bound correctly
		Variable test_variable;
		test_variable = ((Question)elements.get(0)).getVariable();
		assertTrue(((BooleanVariable)test_variable).evaluate());
		
		
		// the if statement should return true!
		assertTrue(if_condition.evaluate());
	}
}
