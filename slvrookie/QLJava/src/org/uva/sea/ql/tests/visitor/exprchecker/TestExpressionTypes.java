package org.uva.sea.ql.tests.visitor.exprchecker;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.antlr.IParse;
import org.uva.sea.ql.parser.antlr.ParseError;
import org.uva.sea.ql.visitors.typechecking.ExprChecker;
import org.uva.sea.ql.visitors.utils.Errors;
import org.uva.sea.ql.visitors.utils.State;


public class TestExpressionTypes {

	private final State state = new State();
	private final Errors errors = new Errors();
	private final IParse parser = new ANTLRParser();
	
	@Test
	public void testSuccesfullAdds() throws ParseError {
		ExprChecker.check(parser.parseExpr("3+5 + 10"), state, errors);
		ExprChecker.check(parser.parseExpr("3+5"), state, errors);
		ExprChecker.check(parser.parseExpr("3.00+5.00"), state, errors);
		ExprChecker.check(parser.parseExpr("3.00+5.00 + 4.00"), state, errors);
		assertEquals(0 , errors.returnErrors().size());
	}
	
	@Test
	public void testFailedAdds() throws ParseError {
		ExprChecker.check(parser.parseExpr("5.00 + 10"), state, errors);
		ExprChecker.check(parser.parseExpr("3+5.00"), state, errors);
		ExprChecker.check(parser.parseExpr("3.00+5"), state, errors);
		ExprChecker.check(parser.parseExpr("(3.00+5.00) + 4"), state, errors);
		ExprChecker.check(parser.parseExpr("3.00+ true"), state, errors);
		assertEquals(6, errors.returnErrors().size());
	}
	
	@Test
	public void testSuccesfullPos() throws ParseError {
		ExprChecker.check(parser.parseExpr("+10"), state, errors);
		ExprChecker.check(parser.parseExpr("+10.00"), state, errors);
		ExprChecker.check(parser.parseExpr("+(3.00+5.00)"), state, errors);
		ExprChecker.check(parser.parseExpr("+(3.00+5.00 + 4.00)"), state, errors);
		assertEquals(0 , errors.returnErrors().size());
	}
	
	@Test
	public void testFailedPos() throws ParseError {
		ExprChecker.check(parser.parseExpr("+true"), state, errors);
		ExprChecker.check(parser.parseExpr("+\"karate\""), state, errors);
		ExprChecker.check(parser.parseExpr("+(3.00>5.00)"), state, errors);
		ExprChecker.check(parser.parseExpr("+(!true)"), state, errors);
		assertEquals(4, errors.returnErrors().size());
	}
	
	@Test
	public void testSuccesfullNeg() throws ParseError {
		ExprChecker.check(parser.parseExpr("-10"), state, errors);
		ExprChecker.check(parser.parseExpr("-10.00"), state, errors);
		ExprChecker.check(parser.parseExpr("-(3.00+5.00)"), state, errors);
		ExprChecker.check(parser.parseExpr("-(3.00+5.00 + 4.00)"), state, errors);
		assertEquals(0 , errors.returnErrors().size());
	}
	
	@Test
	public void testFailedNeg() throws ParseError {
		ExprChecker.check(parser.parseExpr("-true"), state, errors);
		ExprChecker.check(parser.parseExpr("-\"karate\""), state, errors);
		ExprChecker.check(parser.parseExpr("-(3.00>5.00)"), state, errors);
		ExprChecker.check(parser.parseExpr("-(!true)"), state, errors);
		assertEquals(4, errors.returnErrors().size());
	}
	
	@Test
	public void testSuccesfullNot() throws ParseError {
		ExprChecker.check(parser.parseExpr("!true"), state, errors);
		ExprChecker.check(parser.parseExpr("!(3>3)"), state, errors);
		ExprChecker.check(parser.parseExpr("!(3.00<5.00)"), state, errors);
		ExprChecker.check(parser.parseExpr("!((3.00+5.00) < 4.00)"), state, errors);
		assertEquals(0 , errors.returnErrors().size());
	}
	
	@Test
	public void testFailedNot() throws ParseError {
		ExprChecker.check(parser.parseExpr("!3"), state, errors);
		ExprChecker.check(parser.parseExpr("!\"karate\""), state, errors);
		ExprChecker.check(parser.parseExpr("!(3.00+5.00)"), state, errors);
		ExprChecker.check(parser.parseExpr("!(3 *3)"), state, errors);
		assertEquals(4, errors.returnErrors().size());
	}
	
	@Test
	public void testSuccesfullAnds() throws ParseError {
		ExprChecker.check(parser.parseExpr("3>3 && 2<2"), state, errors);
		ExprChecker.check(parser.parseExpr("true && false"), state, errors);
		ExprChecker.check(parser.parseExpr("3 == 3 && 2 < 3"), state, errors);
		assertEquals(0 , errors.returnErrors().size());
	}
	
	@Test
	public void testFailedAnds() throws ParseError {
		ExprChecker.check(parser.parseExpr("3+3 && 2<2"), state, errors);
		ExprChecker.check(parser.parseExpr("true && \"cake\""), state, errors);
		ExprChecker.check(parser.parseExpr("3 == 3 && 2.00"), state, errors);
		assertEquals(3, errors.returnErrors().size());
	}
	
	@Test
	public void testSuccesfullOrs() throws ParseError {
		ExprChecker.check(parser.parseExpr("3>3 || 2<2"), state, errors);
		ExprChecker.check(parser.parseExpr("true || false"), state, errors);
		ExprChecker.check(parser.parseExpr("3 == 3 || 2 < 3"), state, errors);
		assertEquals(0 , errors.returnErrors().size());
	}
	
	@Test
	public void testFailedOrs() throws ParseError {
		ExprChecker.check(parser.parseExpr("3+3 || 2<2"), state, errors);
		ExprChecker.check(parser.parseExpr("true || \"cake\""), state, errors);
		ExprChecker.check(parser.parseExpr("3 == 3 || 2.00"), state, errors);
		assertEquals(3, errors.returnErrors().size());
	}
	
	@Test
	public void testSuccesfullSubs() throws ParseError {
		ExprChecker.check(parser.parseExpr("3 - (5 - 10)"), state, errors);
		ExprChecker.check(parser.parseExpr("3 - 5"), state, errors);
		ExprChecker.check(parser.parseExpr("3.00 - 5.00"), state, errors);
		ExprChecker.check(parser.parseExpr("3.00 - 5.00 - 4.00"), state, errors);
		assertEquals(0 , errors.returnErrors().size());
	}
	
	@Test
	public void testFailedSubs() throws ParseError {
		ExprChecker.check(parser.parseExpr("5.00 - (10 + 10)"), state, errors);
		ExprChecker.check(parser.parseExpr("3 - 5.00"), state, errors);
		ExprChecker.check(parser.parseExpr("3.00 - 5"), state, errors);
		ExprChecker.check(parser.parseExpr("3.00 - 5 - 4.00"), state, errors);
		ExprChecker.check(parser.parseExpr("3.00 - true - 4.00"), state, errors);
		assertEquals(6, errors.returnErrors().size());
	}
	
	@Test
	public void testSuccesfullMuls() throws ParseError {
		ExprChecker.check(parser.parseExpr("3 * (5 * 10)"), state, errors);
		ExprChecker.check(parser.parseExpr("3 * 5"), state, errors);
		ExprChecker.check(parser.parseExpr("3.00 * 5.00"), state, errors);
		ExprChecker.check(parser.parseExpr("3.00 * 5.00 * 4.00"), state, errors);
		assertEquals(0 , errors.returnErrors().size());
	}
	
	@Test
	public void testFailedMuls() throws ParseError {
		ExprChecker.check(parser.parseExpr("5.00 * (10 + 10)"), state, errors);
		ExprChecker.check(parser.parseExpr("3 * 5.00"), state, errors);
		ExprChecker.check(parser.parseExpr("3.00 * 5"), state, errors);
		ExprChecker.check(parser.parseExpr("3.00 * 5 * 4.00"), state, errors);
		ExprChecker.check(parser.parseExpr("3.00 * true * 4.00"), state, errors);
		assertEquals(6, errors.returnErrors().size());
	}
	
	@Test
	public void testSuccesfullDivs() throws ParseError {
		ExprChecker.check(parser.parseExpr("3 / (5 / 10)"), state, errors);
		ExprChecker.check(parser.parseExpr("3 / 5"), state, errors);
		ExprChecker.check(parser.parseExpr("3.00 / 5.00"), state, errors);
		ExprChecker.check(parser.parseExpr("3.00 / 5.00 / 4.00"), state, errors);
		assertEquals(0 , errors.returnErrors().size());
	}
	
	@Test
	public void testFailedDivs() throws ParseError {
		ExprChecker.check(parser.parseExpr("5.00 / (10 + 10)"), state, errors);
		ExprChecker.check(parser.parseExpr("3 / 5.00"), state, errors);
		ExprChecker.check(parser.parseExpr("3.00 / 5"), state, errors);
		ExprChecker.check(parser.parseExpr("3.00 / 5 / 4.00"), state, errors);
		ExprChecker.check(parser.parseExpr("3.00 / true / 4.00"), state, errors);
		assertEquals(6, errors.returnErrors().size());
	}
	
	@Test
	public void testSuccesfullGEquals() throws ParseError {
		ExprChecker.check(parser.parseExpr("3 >= (5 + 10)"), state, errors);
		ExprChecker.check(parser.parseExpr("3 >= 5"), state, errors);
		ExprChecker.check(parser.parseExpr("3.00 >= 5.00"), state, errors);
		ExprChecker.check(parser.parseExpr("3.00 >= 5.00 + 4.00"), state, errors);
		assertEquals(0 , errors.returnErrors().size());
	}
	
	@Test
	public void testFailedGEquals() throws ParseError {
		ExprChecker.check(parser.parseExpr("5.00 >= (10 + 10)"), state, errors);
		ExprChecker.check(parser.parseExpr("3 >= 5.00"), state, errors);
		ExprChecker.check(parser.parseExpr("3.00 >= 5"), state, errors);
		ExprChecker.check(parser.parseExpr("3.00 + 5 >= 4.00"), state, errors);
		ExprChecker.check(parser.parseExpr("3.00 >= true"), state, errors);
		assertEquals(6, errors.returnErrors().size());
	}
	
	@Test
	public void testSuccesfullLEquals() throws ParseError {
		ExprChecker.check(parser.parseExpr("3 <= (5 + 10)"), state, errors);
		ExprChecker.check(parser.parseExpr("3 <= 5"), state, errors);
		ExprChecker.check(parser.parseExpr("3.00 <= 5.00"), state, errors);
		ExprChecker.check(parser.parseExpr("3.00 <= 5.00 + 4.00"), state, errors);
		assertEquals(0 , errors.returnErrors().size());
	}
	
	@Test
	public void testFailedLEquals() throws ParseError {
		ExprChecker.check(parser.parseExpr("5.00 <= (10 + 10)"), state, errors);
		ExprChecker.check(parser.parseExpr("3 <= 5.00"), state, errors);
		ExprChecker.check(parser.parseExpr("3.00 <= 5"), state, errors);
		ExprChecker.check(parser.parseExpr("3.00 + 5 <= 4.00"), state, errors);
		ExprChecker.check(parser.parseExpr("3.00 <= true"), state, errors);
		assertEquals(6, errors.returnErrors().size());
	}
	
	@Test
	public void testSuccesfullGThans() throws ParseError {
		ExprChecker.check(parser.parseExpr("3 > (5 + 10)"), state, errors);
		ExprChecker.check(parser.parseExpr("3 > 5"), state, errors);
		ExprChecker.check(parser.parseExpr("3.00 > 5.00"), state, errors);
		ExprChecker.check(parser.parseExpr("3.00 > 5.00 + 4.00"), state, errors);
		assertEquals(0 , errors.returnErrors().size());
	}
	
	@Test
	public void testFailedGThans() throws ParseError {
		ExprChecker.check(parser.parseExpr("5.00 > (10 + 10)"), state, errors);
		ExprChecker.check(parser.parseExpr("3 > 5.00"), state, errors);
		ExprChecker.check(parser.parseExpr("3.00 > 5"), state, errors);
		ExprChecker.check(parser.parseExpr("3.00 + 5 > 4.00"), state, errors);
		ExprChecker.check(parser.parseExpr("3.00 > true"), state, errors);
		assertEquals(6, errors.returnErrors().size());
	}
	
	@Test
	public void testSuccesfullLThans() throws ParseError {
		ExprChecker.check(parser.parseExpr("3 < (5 + 10)"), state, errors);
		ExprChecker.check(parser.parseExpr("3 < 5"), state, errors);
		ExprChecker.check(parser.parseExpr("3.00 < 5.00"), state, errors);
		ExprChecker.check(parser.parseExpr("3.00 < 5.00 + 4.00"), state, errors);
		assertEquals(0 , errors.returnErrors().size());
	}
	
	@Test
	public void testFailedLThans() throws ParseError {
		ExprChecker.check(parser.parseExpr("5.00 < (10 + 10)"), state, errors);
		ExprChecker.check(parser.parseExpr("3 < 5.00"), state, errors);
		ExprChecker.check(parser.parseExpr("3.00 < 5"), state, errors);
		ExprChecker.check(parser.parseExpr("3.00 + 5 < 4.00"), state, errors);
		ExprChecker.check(parser.parseExpr("3.00 < true"), state, errors);
		assertEquals(6, errors.returnErrors().size());
	}
	
	
	@Test
	public void testSuccesfullEquals() throws ParseError {
		ExprChecker.check(parser.parseExpr("4 == 4"), state, errors);
		ExprChecker.check(parser.parseExpr("3.00 == 3.00"), state, errors);
		ExprChecker.check(parser.parseExpr("true == true"), state, errors);
		ExprChecker.check(parser.parseExpr("\"karate\" == \"karate\""), state, errors);
		assertEquals(0 , errors.returnErrors().size());
	}
	
	@Test
	public void testFailedEquals() throws ParseError {
		ExprChecker.check(parser.parseExpr("4 == 4.00"), state, errors);
		ExprChecker.check(parser.parseExpr("3.00 == true"), state, errors);
		ExprChecker.check(parser.parseExpr("true == \"true\""), state, errors);
		ExprChecker.check(parser.parseExpr("\"karate\" == 5"), state, errors);
		assertEquals(4, errors.returnErrors().size());
	}
	
	@Test
	public void testSuccesfullNEquals() throws ParseError {
		ExprChecker.check(parser.parseExpr("4+4 != 4+4"), state, errors);
		ExprChecker.check(parser.parseExpr("3.00 != 3.00"), state, errors);
		ExprChecker.check(parser.parseExpr("true != true"), state, errors);
		ExprChecker.check(parser.parseExpr("\"karate\" != \"karate\""), state, errors);
		assertEquals(0 , errors.returnErrors().size());
	}
	
	@Test
	public void testFailedNEquals() throws ParseError {
		ExprChecker.check(parser.parseExpr("4 != 4.00"), state, errors);
		ExprChecker.check(parser.parseExpr("3.00 != true"), state, errors);
		ExprChecker.check(parser.parseExpr("true != \"true\""), state, errors);
		ExprChecker.check(parser.parseExpr("\"karate\" != 5"), state, errors);
		assertEquals(4, errors.returnErrors().size());
	}
}
