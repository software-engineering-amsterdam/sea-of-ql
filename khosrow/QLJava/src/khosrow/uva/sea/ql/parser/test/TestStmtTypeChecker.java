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
	public void testIfStmts() throws ParseError{
		assertEquals(StmtTypeChecker.Check(parser.ParseStatement("if (true) {}"), TheTestEnv.getTypeEnv(), theErrorList()), true);
		assertEquals(StmtTypeChecker.Check(parser.ParseStatement("if (false) {}"), TheTestEnv.getTypeEnv(), theErrorList()), true);
		assertEquals(StmtTypeChecker.Check(parser.ParseStatement("if (iA > iB) {}"), TheTestEnv.getTypeEnv(), theErrorList()), true);
		assertEquals(StmtTypeChecker.Check(parser.ParseStatement("if (iA < iB) {}"), TheTestEnv.getTypeEnv(), theErrorList()), true);
		assertEquals(StmtTypeChecker.Check(parser.ParseStatement("if (iA == iB) { Q1: \"Is this a simple question?\" boolean }"), TheTestEnv.getTypeEnv(), theErrorList()), true);
		
		assertEquals(StmtTypeChecker.Check(parser.ParseStatement("if (iA > sB) {}"), TheTestEnv.getTypeEnv(), theErrorList()), false);
	}
	

}
