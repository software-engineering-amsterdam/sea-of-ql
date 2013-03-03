package org.uva.sea.ql.parser.antlr;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.uva.sea.ql.ast.expression.Add;
import org.uva.sea.ql.ast.expression.Expr;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.statement.Assignment;
import org.uva.sea.ql.value.IntegerValue;
import org.uva.sea.ql.value.Value;
import org.uva.sea.ql.visitor.expression.ExpressionValidator;
import org.uva.sea.ql.visitor.statement.StatementValidator;
import org.uva.sea.ql.visitor.statement.StatementVisitor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
// import org.uva.sea.ql.ast.expression.Expr;

public class ANTLRParser implements IParse {

	@Override
	public Expr parse(String src) throws ParseError {
		ANTLRStringStream stream = new ANTLRStringStream(src);
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		QLParser parser = new QLParser(tokens);
		try {
			return parser.orExpression().result;
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		}
	}
	
	public static void main(String[] args) throws RecognitionException
	{
		System.out.println("Start test..");			
//		testForm();
//		testPrimary();
//		testUnaryExpression();
//		testMultiplyExpression();
		testAddExpression();
//		testRelExpression();
//		testAndExpression();
//		testOrExpression();
//      testAssignment();
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
//                "   else if(hasSoldHouse) {" +
//                "       if(hasSoldHouse) {" +
//                "          isExpensive : \"Is the house expensive?\" Boolean"+
//                "       }" +
//                "       else" +
//                "       {" +
//                "           isExpensive : \"Is the house expensive?\" Boolean" +
//                "       }" +
//                "       isExpensive : \"Is the house expensive?\" Boolean" +
//                "   }" +
                "   else {" +
                "      isCheap : \"Is the house cheap?\" Boolean" +
                "   }"+
                "}");
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		QLParser parser = new QLParser(tokens);
		try {
            CommonTree commonTree = parser.form().tree;
            System.out.println(commonTree.toStringTree());
		} catch (RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

    public static void testAssignment()
    {
        ANTLRStringStream stream = new ANTLRStringStream(
                "   hasSoldHouse : \"did you just sell you house! \" boolean" +
                "   hasSoldHouse2 : \"did you just sell you house! \" boolean" );
        CommonTokenStream tokens = new CommonTokenStream();
        tokens.setTokenSource(new QLLexer(stream));
        QLParser parser = new QLParser(tokens);
        try {
            Assignment assignment = parser.assignment().node;
            // TODO expression dependency visitor
            Map<Ident, Value> variables = new HashMap<Ident, Value>();
            variables.put(new Ident("var1"), new IntegerValue(1));
            variables.put(new Ident("var1"), new IntegerValue(1));
            StatementValidator statementVisitor = new StatementValidator(variables);
            statementVisitor.visit(assignment);
            List<String> errors = statementVisitor.getErrors();
            for (String error : errors) {
                System.out.println("error = " + error);
            }
        } catch (RecognitionException e) {
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
            CommonTree commonTree = parser.unaryExpression().tree;
            System.out.println(commonTree.toStringTree());
			System.out.println("OK unary");
		} catch (RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public static void testMultiplyExpression()
	{
		ANTLRStringStream stream = new ANTLRStringStream("3 / 0.11");
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		QLParser parser = new QLParser(tokens);
		try {
            ExpressionValidator expressionValidator = new ExpressionValidator();
            Expr result = parser.multiplyExpression().result;
            result.accept(expressionValidator);
            System.out.println(expressionValidator.getErrors());

        } catch (RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void testAddExpression()
	{
		ANTLRStringStream stream = new ANTLRStringStream("1 + 1.00");
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		QLParser parser = new QLParser(tokens);
		try
        {

            ExpressionValidator expressionValidator = new ExpressionValidator();
            Expr result = parser.addExpression().result;
            result.accept(expressionValidator);
            System.out.println(expressionValidator.getErrors());
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
            //CommonTree commonTree = parser.relExpression().tree;
            parser.relExpression();
            //System.out.println(commonTree.toStringTree());
			System.out.println("OK rel");
		} catch (RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public static void testAndExpression()
	{
		ANTLRStringStream stream = new ANTLRStringStream("true&&1");
				CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		QLParser parser = new QLParser(tokens);
		try {
            ExpressionValidator expressionValidator = new ExpressionValidator();
            Expr result = parser.andExpression().result;
            result.accept(expressionValidator);
            System.out.println(expressionValidator.getErrors());
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
            CommonTree commonTree = parser.orExpression().tree;
            System.out.println(commonTree.toStringTree());
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
