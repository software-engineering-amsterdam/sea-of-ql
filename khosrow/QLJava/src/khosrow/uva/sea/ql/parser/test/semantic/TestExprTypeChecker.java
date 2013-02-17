package khosrow.uva.sea.ql.parser.test.semantic;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import khosrow.uva.sea.ql.parser.jacc.JACCParser;
import khosrow.uva.sea.ql.parser.test.IParse;
import khosrow.uva.sea.ql.parser.test.ParseError;
import khosrow.uva.sea.ql.parser.test.TheTestEnv;
import khosrow.uva.sea.ql.resources.QlTypeError;
import khosrow.uva.sea.ql.visitor.check.ExprTypeChecker;

import org.junit.Before;
import org.junit.Test;

public class TestExprTypeChecker {
	private IParse parser;
	private List<QlTypeError> errorList;
		
	@Before
	public void setUp() {
		parser = new JACCParser();
		errorList = new ArrayList<QlTypeError>();
	}
	
	@Test
	public void testAddsType() throws ParseError {
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("1 + 2.01"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("1 + 2 + 3 + (1 + 2)"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("iA + iB"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("iA + mA"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("mA + mB"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("mB + iC"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("mA + 2.01"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA + sB"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA + iA"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA + bA"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("bA + bB"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("bA + 1"), TheTestEnv.getTypeEnv(), errorList), false);
	}
	
	@Test
	public void testSubsType() throws ParseError {
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("1 - 2.01"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("1 - 2 - 3 - (1 - 2)"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("iA - iB"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("iA - mA"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("mA - mB"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("mB - iC"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("mA - 2.01"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA - sB"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA - iA"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA - bA"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("bA - bB"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("bA - 1"), TheTestEnv.getTypeEnv(), errorList), false);
	}
	
	@Test
	public void testMulsType() throws ParseError {	
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("1 * 2.01"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("1 * 2 * 3 * (1 * 2)"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("iA * iB"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("iA * mA"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("mA * mB"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("mB * iC"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("mA * 2.01"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA * sB"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA * iA"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA * bA"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("bA * bB"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("bA * 1"), TheTestEnv.getTypeEnv(), errorList), false);
	}
	
	@Test
	public void testDivsType() throws ParseError {
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("1 / 2.01"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("1 / 2 / 3 / (1 / 2)"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("iA / iB"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("iA / mA"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("mA / mB"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("mB / iC"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("mA / 2.01"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA / sB"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA / iA"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA / bA"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("bA / bB"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("bA / 1"), TheTestEnv.getTypeEnv(), errorList), false);
	}
	
	@Test
	public void testModsType() throws ParseError {
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("1 % 2.01"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("1 % 2 % 3 % (1 % 2)"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("iA % iB"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("iA % mA"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("mA % mB"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("mB % iC"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("mA % 2.01"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA % sB"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA % iA"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA % bA"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("bA % bB"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("bA % 1"), TheTestEnv.getTypeEnv(), errorList), false);
	}
	
	@Test
	public void testAndsType() throws ParseError {
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("bA && bB"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("true && bA"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("bA && false"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("iA && iB"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("true && iB"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("iA && bA"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA && sB"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA && bA"), TheTestEnv.getTypeEnv(), errorList), false);
	}
	
	@Test
	public void testOrsType() throws ParseError {
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("bA || bB"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("true || bA"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("bA || false"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("iA || iB"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("true || iB"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("iA || bA"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA || sB"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA || bA"), TheTestEnv.getTypeEnv(), errorList), false);
	}
	
	@Test
	public void testEqsType() throws ParseError {
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("bA == bB"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("true == bA"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("bA == false"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("true == false"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("iA == iB"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA == sB"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("mA == mB"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("mA == iA"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("true == iB"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("iA == bA"), TheTestEnv.getTypeEnv(), errorList), false);		
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA == bA"), TheTestEnv.getTypeEnv(), errorList), false);		
	}
	
	@Test
	public void testNEqsType() throws ParseError {
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("bA != bB"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("true != bA"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("bA != false"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("true != false"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("iA != iB"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA != sB"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("mA != mB"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("mA != iA"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("true != iB"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("iA != bA"), TheTestEnv.getTypeEnv(), errorList), false);		
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA != bA"), TheTestEnv.getTypeEnv(), errorList), false);		
	}
	
	@Test
	public void testGEqsType() throws ParseError {
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("bA >= bB"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("true >= bA"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("bA >= false"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("true >= false"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("iA >= iB"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA >= sB"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("mA >= mB"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("mA >= iA"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("true >= iB"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("iA >= bA"), TheTestEnv.getTypeEnv(), errorList), false);		
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA >= bA"), TheTestEnv.getTypeEnv(), errorList), false);		
	}
	
	@Test
	public void testGTsType() throws ParseError {
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("bA > bB"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("true > bA"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("bA > false"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("true > false"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("iA > iB"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA > sB"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA > iB"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("mA > mB"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("mA > iA"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("true > iB"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("iA > bA"), TheTestEnv.getTypeEnv(), errorList), false);		
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA > bA"), TheTestEnv.getTypeEnv(), errorList), false);		
	}
	
	@Test
	public void testLEqsType() throws ParseError {
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("bA <= bB"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("true <= bA"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("bA <= false"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("true <= false"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("iA <= iB"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA <= sB"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA <= iB"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("mA <= mB"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("mA <= iA"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("true <= iB"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("iA <= bA"), TheTestEnv.getTypeEnv(), errorList), false);		
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA <= bA"), TheTestEnv.getTypeEnv(), errorList), false);		
	}
	
	@Test
	public void testLTsType() throws ParseError {
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("bA < bB"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("true < bA"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("bA < false"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("true < false"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("iA < iB"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA < sB"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA < iB"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("mA < mB"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("mA < iA"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("true < iB"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("iA < bA"), TheTestEnv.getTypeEnv(), errorList), false);		
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("sA < bA"), TheTestEnv.getTypeEnv(), errorList), false);		
	}
	
	@Test
	public void testNegsType() throws ParseError {
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("-1"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("-iA"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("-1.65"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("-mA"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("-bA"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("-sA"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("-true"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("-false"), TheTestEnv.getTypeEnv(), errorList), false);
	}
	
	@Test
	public void testPossType() throws ParseError {
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("+1"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("+iA"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("+1.65"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("+mA"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("+bA"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("+sA"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("+true"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("+false"), TheTestEnv.getTypeEnv(), errorList), false);
	}
	
	@Test
	public void testNotsType() throws ParseError {
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("!bA"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("!true"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("!false"), TheTestEnv.getTypeEnv(), errorList), true);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("!iA"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("!mA"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("!sA"), TheTestEnv.getTypeEnv(), errorList), false);
		assertEquals(ExprTypeChecker.Check(parser.ParseExpression("!1"), TheTestEnv.getTypeEnv(), errorList), false);
	}

}
