package org.uva.sea.ql.parser.antlr;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
// import org.uva.sea.ql.ast.Expr;

public class ANTLRParser {//implements IParse {

//	@Override
//	public Expr parse(String src) throws ParseError {
//		ANTLRStringStream stream = new ANTLRStringStream(src);
//		CommonTokenStream tokens = new CommonTokenStream();
//		tokens.setTokenSource(new QLLexer(stream));
//		QLParser parser = new QLParser(tokens);
//		try {
//			return parser.orExpr();
//		} catch (RecognitionException e) {
//			throw new ParseError(e.getMessage());
//		}
//	}
	
	public static void main(String[] args) throws RecognitionException
	{
		System.out.println("Start test..");			
		testForm();
		testPrimary();
		testUnaryExpression();
		testMultiplyExpression();
		testAddExpression();
		testRelExpression();
		testAndExpression();
		testOrExpression();
	}
	
	public static void testForm()
	{
		ANTLRStringStream stream = new ANTLRStringStream("" +
                "form boxhousing1 { " +
				"   hasSoldHouse : \"did you just sell you house! \" Boolean" +
				"   if(hasSoldHouse) {" +
				"       isExpensive : \"Is the house expensive?\" Boolean"+
				"       isnice : \"Is the house nice?\" Boolean"+
				"   }" +
                "   else if(hasSoldHouse) {" +
                "       if(hasSoldHouse) {" +
                "          isExpensive : \"Is the house expensive?\" Boolean"+
                "       }" +
                "       else" +
                "       {" +
                "           isExpensive : \"Is the house expensive?\" Boolean" +
                "       }" +
                "       isExpensive : \"Is the house expensive?\" Boolean" +
                "   }" +
                "   else {" +
                "      isCheap : \"Is the house cheap?\" Boolean" +
                "   }"+
                "}");
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		QLParser parser = new QLParser(tokens);
		try {
			parser.form();
			System.out.println();
		} catch (RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public static void testPrimary()
	{
		final String testPrimary = "100000";
		ANTLRStringStream stream = new ANTLRStringStream(testPrimary);
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		QLParser parser = new QLParser(tokens);
		try {
			parser.primary();
			System.out.println("OK primary");
		} catch (RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void testUnaryExpression()
	{
		ANTLRStringStream stream = new ANTLRStringStream("+t");
				CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		QLParser parser = new QLParser(tokens);
		try {
			parser.unaryExpression();
			System.out.println("OK unary");
		} catch (RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public static void testMultiplyExpression()
	{
		ANTLRStringStream stream = new ANTLRStringStream("1*2");
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		QLParser parser = new QLParser(tokens);
		try {
			parser.multiplyExpression();
			System.out.println("OK multiply");
		} catch (RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void testAddExpression()
	{
		ANTLRStringStream stream = new ANTLRStringStream("a+b");
				CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		QLParser parser = new QLParser(tokens);
		try {
			parser.addExpression();
			System.out.println("OK add");
		} catch (RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public static void testRelExpression()
	{
		ANTLRStringStream stream = new ANTLRStringStream("a > b");
				CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		QLParser parser = new QLParser(tokens);
		try {
			parser.relExpression();
			System.out.println("OK rel");
		} catch (RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public static void testAndExpression()
	{
		ANTLRStringStream stream = new ANTLRStringStream("a&&b");
				CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		QLParser parser = new QLParser(tokens);
		try {
			parser.andExpression();
			System.out.println("OK and");
		} catch (RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public static void testOrExpression()
	{
		ANTLRStringStream stream = new ANTLRStringStream("(a||b)");
				CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		QLParser parser = new QLParser(tokens);
		try {
			parser.orExpression();
			System.out.println("OK or");
		} catch (RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}	
	
	public static void TestAssignment()
	{
		final String testAssignment = "x : \"Have you ever worked ?\" Boolean";
		ANTLRStringStream stream = new ANTLRStringStream(testAssignment);
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		QLParser parser = new QLParser(tokens);
		try {
			parser.assignment();
			System.out.println("OK assignment");
		} catch (RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	

}
