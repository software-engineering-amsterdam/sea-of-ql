package org.uva.sea.ql.evaluate.render;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.type.BooleanType;
import org.uva.sea.ql.ast.type.IntegerType;
import org.uva.sea.ql.ast.type.MoneyType;
import org.uva.sea.ql.ast.type.StringType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.evaluate.render.TypeEvaluator;
import org.uva.sea.ql.value.BooleanValue;
import org.uva.sea.ql.value.IntegerValue;
import org.uva.sea.ql.value.MoneyValue;
import org.uva.sea.ql.value.StringValue;
import org.uva.sea.ql.value.Value;

public class TypeEvaluatorTest {
	public TypeEvaluatorTest() {}

	private Value evaluate( Type type ) {
		return TypeEvaluator.initType( type );
	}

	@Test
	public void testBooleanType() {
		assertEquals(
			( new BooleanValue( false ) ).getValue(),
			this.evaluate( BooleanType.BOOLEAN ).getValue()
		);
	}

	@Test
	public void testIntegerType() {
		assertEquals(
			( new IntegerValue( 0 ) ).getValue(),
			this.evaluate( IntegerType.INTEGER ).getValue()
		);
	}

	@Test
	public void testStringType() {
		assertEquals(
			( new StringValue( "" ) ).getValue(),
			this.evaluate( StringType.STRING ).getValue()
		);
	}

	@Test
	public void testMoneyType() {
		assertEquals(
			( new MoneyValue( 0.00d ) ).getValue(),
			this.evaluate( MoneyType.MONEY ).getValue()
		);
	}
}
