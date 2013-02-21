package org.uva.sea.ql.parser.test;

	import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.visitor.evaluator.ExprEvaluator;
import org.uva.sea.ql.visitor.evaluator.values.BoolValue;
import org.uva.sea.ql.visitor.evaluator.values.DecValue;
import org.uva.sea.ql.visitor.evaluator.values.IntValue;
import org.uva.sea.ql.visitor.evaluator.values.Value;

	public class TestExpressionEvaluator {

		private ANTLRParser parser;
		private final Map<String,Value> runTimeValues;


		public TestExpressionEvaluator() {

			parser = new ANTLRParser();
			this.runTimeValues=new HashMap<String,Value>();

		}

		@Test
		public void testBinAlgebraic() throws ParseError {
			runTimeValues.put("IntVal",new IntValue(100));
			assertEquals(new IntValue(136).getValue() , ((IntValue) ExprEvaluator.eval(parser.parseExpr("(3 * 12)+IntVal"),runTimeValues)).getValue() );
			assertEquals(new IntValue(120).getValue(), ((IntValue) ExprEvaluator.eval(parser.parseExpr("IntVal + (200 * 10)/(200 - 100)"),runTimeValues)).getValue() );

			runTimeValues.put("DecimalVal",new DecValue(100.0f));
			assertEquals(139.0, ((DecValue) ExprEvaluator.eval(parser.parseExpr("DecimalVal+(3.0 * 13.0)"),runTimeValues)).getValue() ,0.0);
			assertEquals(120.0, ((DecValue) ExprEvaluator.eval(parser.parseExpr("DecimalVal + (200.0 * 10.0)/(200.0 - 100.0)"),runTimeValues)).getValue(),0.0 );
			
				}


		@Test
		public void testBinBool() throws ParseError {
			runTimeValues.put("TRUE",new BoolValue(true));
			assertEquals(true , ((BoolValue) ExprEvaluator.eval(parser.parseExpr("((3 * 12) + 100) == 136"),runTimeValues)).getValue() );
			assertEquals(true , ((BoolValue) ExprEvaluator.eval(parser.parseExpr("((3 * 12) + 100) >= 136"),runTimeValues)).getValue() );
			assertEquals(true , ((BoolValue) ExprEvaluator.eval(parser.parseExpr("((3 * 12) + 100) <= 136"),runTimeValues)).getValue() );
			assertEquals(false , ((BoolValue) ExprEvaluator.eval(parser.parseExpr("((3 * 12) + 100) != 136"),runTimeValues)).getValue() );
			assertEquals(false , ((BoolValue) ExprEvaluator.eval(parser.parseExpr("((3 * 12) + 100) > 136"),runTimeValues)).getValue() );
			assertEquals(false , ((BoolValue) ExprEvaluator.eval(parser.parseExpr("((3 * 12) + 100) < 136"),runTimeValues)).getValue() );
			assertEquals(true, ((BoolValue) ExprEvaluator.eval(parser.parseExpr("((100 + (200 * 10)/(200 - 100)) == 120) && TRUE"),runTimeValues)).getValue() );
			assertEquals(false, ((BoolValue) ExprEvaluator.eval(parser.parseExpr("((100 + (200 * 10)/(200 - 100)) != 120) && TRUE"),runTimeValues)).getValue() );

			runTimeValues.put("FALSE",new BoolValue(false));
			assertEquals(false, ((BoolValue) ExprEvaluator.eval(parser.parseExpr("((100 + (200 * 10)/(200 - 100)) == 120) && FALSE"),runTimeValues)).getValue() );
			assertEquals(true, ((BoolValue) ExprEvaluator.eval(parser.parseExpr("((100 + (200 * 10)/(200 - 100)) == 120) || FALSE"),runTimeValues)).getValue() );
		}
		
		@Test
		public void testUnary() throws ParseError {
			runTimeValues.put("IntVal",new IntValue(100));
			assertEquals(new IntValue(136).getValue() , ((IntValue) ExprEvaluator.eval(parser.parseExpr("(-3 * -12)+IntVal"),runTimeValues)).getValue() );
			assertEquals(new IntValue(-120).getValue(), ((IntValue) ExprEvaluator.eval(parser.parseExpr("-IntVal + (200 * -10)/(200 - 100)"),runTimeValues)).getValue() );

			runTimeValues.put("DecimalVal",new DecValue(100.0f));
			assertEquals(-139.0, ((DecValue) ExprEvaluator.eval(parser.parseExpr("-DecimalVal+(-3.0 * 13.0)"),runTimeValues)).getValue() ,0.0);
			assertEquals(120.0, ((DecValue) ExprEvaluator.eval(parser.parseExpr("DecimalVal + (-200.0 * -10.0)/(200.0 - 100.0)"),runTimeValues)).getValue(),0.0 );
		
		}
		
		


		

	}
