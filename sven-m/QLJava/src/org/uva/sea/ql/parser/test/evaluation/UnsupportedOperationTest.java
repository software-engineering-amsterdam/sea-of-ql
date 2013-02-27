package org.uva.sea.ql.parser.test.evaluation;

import org.junit.Test;

import org.uva.sea.ql.parser.evaluator.result.BoolValue;
import org.uva.sea.ql.parser.evaluator.result.IntValue;
import org.uva.sea.ql.parser.evaluator.result.StrValue;
import org.uva.sea.ql.parser.test.AbstractTest;

public class UnsupportedOperationTest extends AbstractTest {
	private final IntValue intVal = new IntValue(1);
	private final BoolValue boolVal = new BoolValue(true);
	private final StrValue strVal = new StrValue("test");
	
	@Test(expected=UnsupportedOperationException.class)
	public void testNotInt() {
		intVal.not();
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testIntAndInt() {
		intVal.and(intVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testIntOrInt() {
		intVal.or(intVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testIntAddBool() {
		intVal.add(boolVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testBoolAddInt() {
		boolVal.add(intVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testIntSubBool() {
		intVal.sub(boolVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testBoolSubInt() {
		boolVal.sub(intVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testIntMulBool() {
		intVal.mul(boolVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testBoolMulInt() {
		boolVal.mul(intVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testIntDivBool() {
		intVal.div(boolVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testBoolDivInt() {
		boolVal.div(intVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testIntLtBool() {
		intVal.lt(boolVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testBoolLtInt() {
		boolVal.lt(intVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testIntLeqBool() {
		intVal.leq(boolVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testBoolLeqInt() {
		boolVal.leq(intVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testIntEqBool() {
		intVal.eq(boolVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testBoolEqInt() {
		boolVal.eq(intVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testIntNeqBool() {
		intVal.neq(boolVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testBoolNeqInt() {
		boolVal.neq(intVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testIntGeqBool() {
		intVal.geq(boolVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testBoolGeqInt() {
		boolVal.geq(intVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testIntGtBool() {
		intVal.gt(boolVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testBoolGtInt() {
		boolVal.gt(intVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testIntAndBool() {
		intVal.and(boolVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testBoolAndInt() {
		boolVal.and(intVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testIntOrBool() {
		intVal.or(boolVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testBoolOrInt() {
		boolVal.or(intVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testIntAddStr() {
		intVal.add(strVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testStrAddInt() {
		strVal.add(intVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testIntSubStr() {
		intVal.sub(strVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testStrSubInt() {
		strVal.sub(intVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testIntMulStr() {
		intVal.mul(strVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testStrMulInt() {
		strVal.mul(intVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testIntDivStr() {
		intVal.div(strVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testStrDivInt() {
		strVal.div(intVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testIntLtStr() {
		intVal.lt(strVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testStrLtInt() {
		strVal.lt(intVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testIntLeqStr() {
		intVal.leq(strVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testStrLeqInt() {
		strVal.leq(intVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testIntEqStr() {
		intVal.eq(strVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testStrEqInt() {
		strVal.eq(intVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testIntNeqStr() {
		intVal.neq(strVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testStrNeqInt() {
		strVal.neq(intVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testIntGeqStr() {
		intVal.geq(strVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testStrGeqInt() {
		strVal.geq(intVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testIntGtStr() {
		intVal.gt(strVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testStrGtInt() {
		strVal.gt(intVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testIntAndStr() {
		intVal.and(strVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testStrAndInt() {
		strVal.and(intVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testIntOrStr() {
		intVal.or(strVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testStrOrInt() {
		strVal.or(intVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testPosBool() {
		boolVal.pos();
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testNegBool() {
		boolVal.neg();
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testBoolAddBool() {
		boolVal.add(boolVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testBoolSubBool() {
		boolVal.sub(boolVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testBoolMulBool() {
		boolVal.mul(boolVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testBoolDivBool() {
		boolVal.div(boolVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testBoolLtBool() {
		boolVal.lt(boolVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testBoolLeqBool() {
		boolVal.leq(boolVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testBoolGeqBool() {
		boolVal.geq(boolVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testBoolGtBool() {
		boolVal.gt(boolVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testBoolAddStr() {
		boolVal.add(strVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testStrAddBool() {
		strVal.add(boolVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testBoolSubStr() {
		boolVal.sub(strVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testStrSubBool() {
		strVal.sub(boolVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testBoolMulStr() {
		boolVal.mul(strVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testStrMulBool() {
		strVal.mul(boolVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testBoolDivStr() {
		boolVal.div(strVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testStrDivBool() {
		strVal.div(boolVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testBoolLtStr() {
		boolVal.lt(strVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testStrLtBool() {
		strVal.lt(boolVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testBoolLeqStr() {
		boolVal.leq(strVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testStrLeqBool() {
		strVal.leq(boolVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testBoolEqStr() {
		boolVal.eq(strVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testStrEqBool() {
		strVal.eq(boolVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testBoolNeqStr() {
		boolVal.neq(strVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testStrNeqBool() {
		strVal.neq(boolVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testBoolGeqStr() {
		boolVal.geq(strVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testStrGeqBool() {
		strVal.geq(boolVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testBoolGtStr() {
		boolVal.gt(strVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testStrGtBool() {
		strVal.gt(boolVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testBoolAndStr() {
		boolVal.and(strVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testStrAndBool() {
		strVal.and(boolVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testBoolOrStr() {
		boolVal.or(strVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testStrOrBool() {
		strVal.or(boolVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testPosStr() {
		strVal.pos();
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testNegStr() {
		strVal.neg();
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testNotStr() {
		strVal.not();
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testStrSubStr() {
		strVal.sub(strVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testStrMulStr() {
		strVal.mul(strVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testStrDivStr() {
		strVal.div(strVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testStrLtStr() {
		strVal.lt(strVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testStrLeqStr() {
		strVal.leq(strVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testStrGeqStr() {
		strVal.geq(strVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testStrGtStr() {
		strVal.gt(strVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testStrAndStr() {
		strVal.and(strVal);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testStrOrStr() {
		strVal.or(strVal);
	}

	
}
