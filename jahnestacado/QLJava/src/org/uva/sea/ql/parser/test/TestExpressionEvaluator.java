package org.uva.sea.ql.parser.test;

	import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.uva.sea.ql.ast.expr.values.BoolLit;
import org.uva.sea.ql.ast.expr.values.DecimalLit;
import org.uva.sea.ql.ast.expr.values.IntegerLit;
import org.uva.sea.ql.ast.expr.values.Value;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.visitor.evaluator.ExprEvaluator;

	public class TestExpressionEvaluator {

		private ANTLRParser parser;
		private final Map<String,Value> runTimeValues;


		public TestExpressionEvaluator() {

			parser = new ANTLRParser();
			this.runTimeValues=new HashMap<String,Value>();

		}

		@Test
		public void testBinAlgebraic() throws ParseError {
			runTimeValues.put("IntVal",new IntegerLit(100));
			assertEquals(136 , ((IntegerLit) ExprEvaluator.eval(parser.parseExpr("(3 * 12)+IntVal"),runTimeValues)).getValue() );
			assertEquals(120 , ((IntegerLit) ExprEvaluator.eval(parser.parseExpr("IntVal + (200 * 10)/(200 - 100)"),runTimeValues)).getValue() );

			runTimeValues.put("DecimalVal",new DecimalLit(100.0f));
			assertEquals(139.0, ((DecimalLit) ExprEvaluator.eval(parser.parseExpr("DecimalVal+(3.0 * 13.0)"),runTimeValues)).getValue() ,0.0);
			assertEquals(120.0, ((DecimalLit) ExprEvaluator.eval(parser.parseExpr("DecimalVal + (200.0 * 10.0)/(200.0 - 100.0)"),runTimeValues)).getValue(),0.0 );
			
				}


		@Test
		public void testBinBool() throws ParseError {
			runTimeValues.put("TRUE",new BoolLit(true));
			assertEquals(true , ((BoolLit) ExprEvaluator.eval(parser.parseExpr("((3 * 12) + 100) == 136"),runTimeValues)).getValue() );
			assertEquals(true , ((BoolLit) ExprEvaluator.eval(parser.parseExpr("((3 * 12) + 100) >= 136"),runTimeValues)).getValue() );
			assertEquals(true , ((BoolLit) ExprEvaluator.eval(parser.parseExpr("((3 * 12) + 100) <= 136"),runTimeValues)).getValue() );
			assertEquals(false , ((BoolLit) ExprEvaluator.eval(parser.parseExpr("((3 * 12) + 100) != 136"),runTimeValues)).getValue() );
			assertEquals(false , ((BoolLit) ExprEvaluator.eval(parser.parseExpr("((3 * 12) + 100) > 136"),runTimeValues)).getValue() );
			assertEquals(false , ((BoolLit) ExprEvaluator.eval(parser.parseExpr("((3 * 12) + 100) < 136"),runTimeValues)).getValue() );
			assertEquals(true, ((BoolLit) ExprEvaluator.eval(parser.parseExpr("((100 + (200 * 10)/(200 - 100)) == 120) && TRUE"),runTimeValues)).getValue() );
			assertEquals(false, ((BoolLit) ExprEvaluator.eval(parser.parseExpr("((100 + (200 * 10)/(200 - 100)) != 120) && TRUE"),runTimeValues)).getValue() );

			runTimeValues.put("FALSE",new BoolLit(false));
			assertEquals(false, ((BoolLit) ExprEvaluator.eval(parser.parseExpr("((100 + (200 * 10)/(200 - 100)) == 120) && FALSE"),runTimeValues)).getValue() );
			assertEquals(true, ((BoolLit) ExprEvaluator.eval(parser.parseExpr("((100 + (200 * 10)/(200 - 100)) == 120) || FALSE"),runTimeValues)).getValue() );
		}
		
		@Test
		public void testUnary() throws ParseError {
			runTimeValues.put("IntVal",new IntegerLit(100));
			assertEquals(136 , ((IntegerLit) ExprEvaluator.eval(parser.parseExpr("(-3 * -12)+IntVal"),runTimeValues)).getValue() );
			assertEquals(-120 , ((IntegerLit) ExprEvaluator.eval(parser.parseExpr("-IntVal + (200 * -10)/(200 - 100)"),runTimeValues)).getValue() );

			runTimeValues.put("DecimalVal",new DecimalLit(100.0f));
			assertEquals(-139.0, ((DecimalLit) ExprEvaluator.eval(parser.parseExpr("-DecimalVal+(-3.0 * 13.0)"),runTimeValues)).getValue() ,0.0);
			assertEquals(120.0, ((DecimalLit) ExprEvaluator.eval(parser.parseExpr("DecimalVal + (-200.0 * -10.0)/(200.0 - 100.0)"),runTimeValues)).getValue(),0.0 );
		
		}
		
		


		

	}
