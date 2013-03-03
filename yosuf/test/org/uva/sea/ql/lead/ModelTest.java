package org.uva.sea.ql.lead;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.Computed;
import org.uva.sea.ql.ast.exp.Expression;
import org.uva.sea.ql.ast.exp.Identifier;
import org.uva.sea.ql.ast.type.DataType;
import org.uva.sea.ql.ast.type.IntegerType;
import org.uva.sea.ql.ast.value.NumericValue;

public class ModelTest {

	private Model model;
	private Computed computed;
	private DataType type;
	private Identifier identifier;
	private Expression expression;

	@Before
	public void setUp() {
		model = new Model();
		type = new IntegerType();
		identifier = new Identifier("identifier");
		expression = new NumericValue(5);
		computed = new Computed(type, identifier, expression);
	}

	@Test
	public void testTrivials() {
		model.registerComputed(computed);
		assertEquals(computed, model.getComputed(identifier));

		assertNull(model.getComputed(expression));
	}

	@Test
	public void testChanged() {
		model.registerComputed(computed);

		final StringBuffer buffer = new StringBuffer("");
		ModelChangeListener listener = new ModelChangeListener() {

			@Override
			public void changed(final Expression expression) {
				buffer.append("changed");
			}
		};
		model.addListener(identifier, listener);
		assertEquals("", buffer.toString());

		model.registerComputed(computed);
		assertEquals("changed", buffer.toString());
	}

}
