package org.uva.sea.ql.parser.antlr;

import net.miginfocom.swing.MigLayout;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.uva.sea.ql.ast.expression.Add;
import org.uva.sea.ql.ast.expression.Expr;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.statement.Assignment;
import org.uva.sea.ql.ast.statement.Block;
import org.uva.sea.ql.ast.statement.ObservableStatement;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.value.IntegerValue;
import org.uva.sea.ql.value.Value;
import org.uva.sea.ql.visitor.expression.ExpressionDefaultValue;
import org.uva.sea.ql.visitor.expression.ExpressionValidator;
import org.uva.sea.ql.visitor.statement.StatementDependencyAnalyzer;
import org.uva.sea.ql.visitor.statement.StatementValidator;
import org.uva.sea.ql.visitor.statement.Renderer;
import org.uva.sea.ql.visitor.statement.StatementVisitor;

import javax.swing.*;
import java.util.Collection;
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
//		testAddExpression();
//		testRelExpression();
//		testAndExpression();
//		testOrExpression();
      testAssignment();
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
                "   name : \"what is your name bro? \" string" +
                "   age : \"what is your age bro? \" integer" +
                "   hasSoldHouse2 : \"did you just sell you house2! \" boolean" +
                "   hasSoldHouse3 : \"did you just sell you house3! \" boolean" +
                "   if(hasSoldHouse2) {" +
                "       hasSoldHouse4 : \"did you just sell you house4! \" boolean" +
                "       watchPrice : \"what is your watch price bro? \" money" +
                "   }" +
                "   else" +
                "   {" +
                "      hasSoldHouse6 : \"did you just sell you house6! \" boolean" +
                "   }" +
                "   carPrice : \"what is your car price bro? \" integer" )
                ;
        CommonTokenStream tokens = new CommonTokenStream();
        tokens.setTokenSource(new QLLexer(stream));
        QLParser parser = new QLParser(tokens);
        try {
            Block block = parser.block().node;

            // variable map
            Map<Ident, Value> variables = new HashMap<Ident, Value>();
            Map<Ident, List<ObservableStatement>> observableMap = new HashMap<Ident, List<ObservableStatement>>();

            StatementDependencyAnalyzer statementDependencyAnalyzer = new StatementDependencyAnalyzer(variables, observableMap);
            StatementValidator statementValidator = new StatementValidator();

            // validate statement
            block.accept(statementValidator);

            // check dependency
            block.accept(statementDependencyAnalyzer);

            // generate GUI
            if(statementValidator.getErrors().isEmpty())
            {
                renderGUI(block, variables, observableMap);
            }
            else
            {
                // error founds - no need to generate GUI
                System.out.println(statementValidator.getErrors());
                System.exit(1);
            }

        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }

    private static void renderGUI(final Block block, final Map<Ident, Value> variables, final Map<Ident, List<ObservableStatement>> observableStatementMap)
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                final JFrame frame = new JFrame("QL Test");
                final JPanel mainPanel = new JPanel(new MigLayout("hidemode 3"));
                renderWidget(frame, mainPanel, block, variables, observableStatementMap);
                frame.getContentPane().add(mainPanel);
                frame.pack();
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }

    private static void renderWidget(final JFrame frame, final JPanel mainPanel, final Block block, final Map<Ident, Value> variables, final Map<Ident, List<ObservableStatement>> observableStatementMap)
    {
        // render statements widget
        for(final Statement statement : block.getStatements())
        {
            Renderer.render(frame, mainPanel, statement, variables, observableStatementMap);
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

}
