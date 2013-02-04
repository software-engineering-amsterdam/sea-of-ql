package khosrow.uva.sea.ql.parser.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import khosrow.uva.sea.ql.parser.jacc.JACCParser;
import khosrow.uva.sea.ql.resources.QlTypeError;
import khosrow.uva.sea.ql.visitor.check.StmtTypeChecker;

import org.junit.Before;
import org.junit.Test;

public class TestStmtTypeChecker {
	private IParse parser;
	
	private static List<QlTypeError> theErrorList() {
		return new ArrayList<QlTypeError>();
	}
	
	@Before
	public void setUp() {
		parser = new JACCParser();
	}
	
	@Test
	public void testAssignStmts() throws ParseError{
		assertEquals(StmtTypeChecker.Check(parser.ParseStatement("iA = 1"), TheTestEnv.getTypeEnv(), theErrorList()), true);
		assertEquals(StmtTypeChecker.Check(parser.ParseStatement("mA = 1.1"), TheTestEnv.getTypeEnv(), theErrorList()), true);
		assertEquals(StmtTypeChecker.Check(parser.ParseStatement("bA = true"), TheTestEnv.getTypeEnv(), theErrorList()), true);
		assertEquals(StmtTypeChecker.Check(parser.ParseStatement("sA = \"Text\""), TheTestEnv.getTypeEnv(), theErrorList()), true);
		assertEquals(StmtTypeChecker.Check(parser.ParseStatement("iA = mA"), TheTestEnv.getTypeEnv(), theErrorList()), true);
		assertEquals(StmtTypeChecker.Check(parser.ParseStatement("iA = iB"), TheTestEnv.getTypeEnv(), theErrorList()), true);
		
		assertEquals(StmtTypeChecker.Check(parser.ParseStatement("iA = true"), TheTestEnv.getTypeEnv(), theErrorList()), false);
		assertEquals(StmtTypeChecker.Check(parser.ParseStatement("mA = \"Text\""), TheTestEnv.getTypeEnv(), theErrorList()), false);
		assertEquals(StmtTypeChecker.Check(parser.ParseStatement("bA = iA"), TheTestEnv.getTypeEnv(), theErrorList()), false);
		assertEquals(StmtTypeChecker.Check(parser.ParseStatement("sA = mA"), TheTestEnv.getTypeEnv(), theErrorList()), false);
	}
	
	@Test
	public void testIfStmts() throws ParseError{
		assertEquals(StmtTypeChecker.Check(parser.ParseStatement("if (true) {}"), TheTestEnv.getTypeEnv(), theErrorList()), true);
		assertEquals(StmtTypeChecker.Check(parser.ParseStatement("if (false) {}"), TheTestEnv.getTypeEnv(), theErrorList()), true);
		assertEquals(StmtTypeChecker.Check(parser.ParseStatement("if (iA > iB) {}"), TheTestEnv.getTypeEnv(), theErrorList()), true);
		assertEquals(StmtTypeChecker.Check(parser.ParseStatement("if (iA < iB) {}"), TheTestEnv.getTypeEnv(), theErrorList()), true);
		assertEquals(StmtTypeChecker.Check(parser.ParseStatement("if (iA == iB) { Q1: \"Is this a simple question?\" boolean }"), TheTestEnv.getTypeEnv(), theErrorList()), true);
		assertEquals(StmtTypeChecker.Check(parser.ParseStatement("if (iA == iB) { Q1 (iA >= iB): \"Is this a expression question?\" boolean }"), TheTestEnv.getTypeEnv(), theErrorList()), true);
		assertEquals(StmtTypeChecker.Check(parser.ParseStatement("if (iA == iB) { \"This is a label\" (iA + iB > iC) }"), TheTestEnv.getTypeEnv(), theErrorList()), true);
		assertEquals(StmtTypeChecker.Check(parser.ParseStatement(
				"if (iA == iB) {" +
					" Q1: \"Is this a simple question?\" boolean " +
				    " Q2: \"Is this a simple question?\" integer " + 
				"}"), TheTestEnv.getTypeEnv(), theErrorList()), true);
		
		assertEquals(StmtTypeChecker.Check(parser.ParseStatement(
				"if (iA == iB) {" +
					" Q1: \"Is this a simple question?\" boolean " +
				    " Q2: \"Is this a simple question?\" integer " + 
				    " Q3 (iA >= iB): \"Is this a expression question?\" integer " + 
				"}"), TheTestEnv.getTypeEnv(), theErrorList()), true);
		
		assertEquals(StmtTypeChecker.Check(parser.ParseStatement(
				"if (iA == iB) {" +
					" \"This is a label\" (iA + iB > iC) " +
				    " \"This is another label\" (true) " + 
				    " \"This is yet another label\" (true) " + 
				"}"), TheTestEnv.getTypeEnv(), theErrorList()), true);
		
		assertEquals(StmtTypeChecker.Check(parser.ParseStatement(
				"if (iA == iB) {" +
					" Q1: \"Is this a simple question?\" boolean " + 
				    " Q2 (iA >= iB): \"Is this a expression question?\" integer " + 
				    " \"This is a label\" (iA + iB > iC) " +
				"}"), TheTestEnv.getTypeEnv(), theErrorList()), true);
		
		assertEquals(StmtTypeChecker.Check(parser.ParseStatement("if (iA > sB) {}"), TheTestEnv.getTypeEnv(), theErrorList()), false);
		assertEquals(StmtTypeChecker.Check(parser.ParseStatement("if (bA > iB) {}"), TheTestEnv.getTypeEnv(), theErrorList()), false);
		assertEquals(StmtTypeChecker.Check(parser.ParseStatement("if (sA < sB) {}"), TheTestEnv.getTypeEnv(), theErrorList()), false);
		assertEquals(StmtTypeChecker.Check(parser.ParseStatement("if (iA == iB) { Q1 (bA >= bB): \"Is this a expression question?\" boolean }"), TheTestEnv.getTypeEnv(), theErrorList()), false);
		assertEquals(StmtTypeChecker.Check(parser.ParseStatement("if (iA == iB) { \"This is a label\" (BA + iB > iC) }"), TheTestEnv.getTypeEnv(), theErrorList()), false);
	}
	
	@Test
	public void testSimpleQuestionStmt() throws ParseError{
		assertEquals(StmtTypeChecker.Check(parser.ParseStatement("Q1: \"Is this a simple question?\" boolean"), TheTestEnv.getTypeEnv(), theErrorList()), true);
	}
	
	@Test
	public void testExpressionQuestionStmt() throws ParseError{
		assertEquals(StmtTypeChecker.Check(parser.ParseStatement("Q1 (iA >= iB): \"Is this a expression question?\" string"), TheTestEnv.getTypeEnv(), theErrorList()), true);
		assertEquals(StmtTypeChecker.Check(parser.ParseStatement("Q1 (sA == sB): \"Is this a expression question?\" string"), TheTestEnv.getTypeEnv(), theErrorList()), true);
		assertEquals(StmtTypeChecker.Check(parser.ParseStatement("Q1 (iA >= sB): \"Is this a expression question?\" string"), TheTestEnv.getTypeEnv(), theErrorList()), false);
	}
	
	@Test
	public void testLabelStmt() throws ParseError{
		assertEquals(StmtTypeChecker.Check(parser.ParseStatement(" \"This is a label\" (iB > iC)"), TheTestEnv.getTypeEnv(), theErrorList()), true);
		assertEquals(StmtTypeChecker.Check(parser.ParseStatement(" \"This is a label\" (BA * iB > iC)"), TheTestEnv.getTypeEnv(), theErrorList()), false);
	}
}
