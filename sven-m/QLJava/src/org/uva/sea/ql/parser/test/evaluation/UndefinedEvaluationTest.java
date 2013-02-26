package org.uva.sea.ql.parser.test.evaluation;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import org.uva.sea.ql.parser.evaluator.result.BoolValue;
import org.uva.sea.ql.parser.evaluator.result.IntValue;
import org.uva.sea.ql.parser.evaluator.result.StrValue;
import org.uva.sea.ql.parser.evaluator.result.UndefinedValue;
import org.uva.sea.ql.parser.test.AbstractTest;

public class UndefinedEvaluationTest extends AbstractTest {
	private final UndefinedValue undefinedVal = new UndefinedValue();
	private final IntValue intVal = new IntValue(1);
	private final BoolValue boolVal = new BoolValue(true);
	private final StrValue strVal = new StrValue("test");
	
	
	@Test
	public void testInts() {
		/* add */
		assertTrue(intVal.add(intVal).isDefined());
		
		assertFalse(intVal.add(undefinedVal).isDefined());
		assertFalse(undefinedVal.add(intVal).isDefined());
		assertFalse(undefinedVal.add(undefinedVal).isDefined());
		
		/* sub */
		assertTrue(intVal.sub(intVal).isDefined());
		
		assertFalse(intVal.sub(undefinedVal).isDefined());
		assertFalse(undefinedVal.sub(intVal).isDefined());
		assertFalse(undefinedVal.sub(undefinedVal).isDefined());
		
		/* mul */
		assertTrue(intVal.mul(intVal).isDefined());
		
		assertFalse(intVal.mul(undefinedVal).isDefined());
		assertFalse(undefinedVal.mul(intVal).isDefined());
		assertFalse(undefinedVal.mul(undefinedVal).isDefined());
		
		/* div */
		assertTrue(intVal.div(intVal).isDefined());
		
		assertFalse(intVal.div(undefinedVal).isDefined());
		assertFalse(undefinedVal.div(intVal).isDefined());
		assertFalse(undefinedVal.div(undefinedVal).isDefined());
		
		/* pos */
		assertTrue(intVal.pos().isDefined());
		assertFalse(undefinedVal.pos().isDefined());
		
		/* neg */
		assertTrue(intVal.neg().isDefined());
		assertFalse(undefinedVal.neg().isDefined());
		
		/* gt */
		assertTrue(intVal.gt(intVal).isDefined());
		
		assertFalse(intVal.gt(undefinedVal).isDefined());
		assertFalse(undefinedVal.gt(intVal).isDefined());
		assertFalse(undefinedVal.gt(undefinedVal).isDefined());
		
		/* geq */
		assertTrue(intVal.geq(intVal).isDefined());
		
		assertFalse(intVal.geq(undefinedVal).isDefined());
		assertFalse(undefinedVal.geq(intVal).isDefined());
		assertFalse(undefinedVal.geq(undefinedVal).isDefined());
		
		/* eq */
		assertTrue(intVal.eq(intVal).isDefined());
		
		assertFalse(intVal.eq(undefinedVal).isDefined());
		assertFalse(undefinedVal.eq(intVal).isDefined());
		assertFalse(undefinedVal.eq(undefinedVal).isDefined());
		
		/* neq */
		assertTrue(intVal.neq(intVal).isDefined());
		
		assertFalse(intVal.neq(undefinedVal).isDefined());
		assertFalse(undefinedVal.neq(intVal).isDefined());
		assertFalse(undefinedVal.neq(undefinedVal).isDefined());
		
		/* leq */
		assertTrue(intVal.leq(intVal).isDefined());
		
		assertFalse(intVal.leq(undefinedVal).isDefined());
		assertFalse(undefinedVal.leq(intVal).isDefined());
		assertFalse(undefinedVal.leq(undefinedVal).isDefined());
		
		/* lt */
		assertTrue(intVal.lt(intVal).isDefined());
		
		assertFalse(intVal.lt(undefinedVal).isDefined());
		assertFalse(undefinedVal.lt(intVal).isDefined());
		assertFalse(undefinedVal.lt(undefinedVal).isDefined());	
	}
	
	@Test
	public void testStrings() {
		/* add */
		assertTrue(strVal.add(strVal).isDefined());
		
		assertFalse(strVal.add(undefinedVal).isDefined());
		assertFalse(undefinedVal.add(strVal).isDefined());
		assertFalse(undefinedVal.add(undefinedVal).isDefined());
		
		/* eq */
		assertTrue(strVal.eq(strVal).isDefined());
		
		assertFalse(strVal.eq(undefinedVal).isDefined());
		assertFalse(undefinedVal.eq(strVal).isDefined());
		assertFalse(undefinedVal.eq(undefinedVal).isDefined());
		
		/* neq */
		assertTrue(strVal.neq(strVal).isDefined());
		
		assertFalse(strVal.neq(undefinedVal).isDefined());
		assertFalse(undefinedVal.neq(strVal).isDefined());
		assertFalse(undefinedVal.neq(undefinedVal).isDefined());
	}
	
	@Test
	public void testBools() {
		/* and */
		assertTrue(boolVal.and(boolVal).isDefined());
		
		assertFalse(boolVal.and(undefinedVal).isDefined());
		assertFalse(undefinedVal.and(boolVal).isDefined());
		assertFalse(undefinedVal.and(undefinedVal).isDefined());
		
		/* or */
		assertTrue(boolVal.or(boolVal).isDefined());
		
		assertFalse(boolVal.or(undefinedVal).isDefined());
		assertFalse(undefinedVal.or(boolVal).isDefined());
		assertFalse(undefinedVal.or(undefinedVal).isDefined());
		
		/* not */
		assertTrue(boolVal.not().isDefined());
		assertFalse(undefinedVal.not().isDefined());
	}
	
}
