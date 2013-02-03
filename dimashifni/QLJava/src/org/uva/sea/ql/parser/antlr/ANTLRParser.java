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
		TestForm();
		TestPrimary();
		TestUnaryExpression();
		TestMultiplyExpression();
		TestAddExpression();
		TestRelExpression();
		TestAndExpression();
	}
	
	public static void TestForm()
	{
		ANTLRStringStream stream = new ANTLRStringStream("form boxhousing1 {\n " + 
				"hasSoldHouse : \"did you just sell you house! \" Boolean\n" +
				"if(hasSoldHouse) {\n" +
				"isExpensive : \"Is the house expensive?\" Boolean\n"+
				"}" + "}");
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
	
	public static void TestPrimary()
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
	
	public static void TestUnaryExpression()
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
	
	public static void TestMultiplyExpression()
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
	
	public static void TestAddExpression()
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
	
	public static void TestRelExpression()
	{
		ANTLRStringStream stream = new ANTLRStringStream("a<b");
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
	
	public static void TestAndExpression()
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
	
	public static void TestOrExpression()
	{
		ANTLRStringStream stream = new ANTLRStringStream("(a||b)");
				CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		QLParser parser = new QLParser(tokens);
		try {
			parser.orExpression();
			System.out.println();
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
