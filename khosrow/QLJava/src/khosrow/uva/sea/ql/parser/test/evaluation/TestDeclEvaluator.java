package khosrow.uva.sea.ql.parser.test.evaluation;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import khosrow.uva.sea.ql.ast.expr.Ident;
import khosrow.uva.sea.ql.ast.type.*;
import khosrow.uva.sea.ql.env.Env;
import khosrow.uva.sea.ql.parser.jacc.JACCParser;
import khosrow.uva.sea.ql.parser.test.IParse;
import khosrow.uva.sea.ql.parser.test.ParseError;
import khosrow.uva.sea.ql.resources.QlDeclarationError;
import khosrow.uva.sea.ql.visitor.eval.DeclEvaluator;

import org.junit.Before;
import org.junit.Test;

public class TestDeclEvaluator {
	private IParse parser;
	private Env env;
	private StringBuilder formToEvaluate;
	private List<QlDeclarationError> errorList;

	@Before
	public void setUp() {
		parser = new JACCParser();
		env = new Env();
		formToEvaluate = new StringBuilder();
		errorList = new ArrayList<QlDeclarationError>();
	}

	@Test
	public void testDeclarations() throws ParseError {
		Ident q1 = new Ident("Q1"),
			  q2 = new Ident("Q2"),
			  q3 = new Ident("Q3"),
			  q4 = new Ident("Q4");
		
		formToEvaluate.append("form form1 { ");
		formToEvaluate.append(" " + q1.getName() + ": \"Ask a question?\" boolean ");
		formToEvaluate.append(" " + q2.getName() + " (a + B): \"Ask a question?\" boolean ");
		formToEvaluate.append(" if (a - b > c) { "+ q3.getName() + " (a + B): \"Ask a question?\" money ");
		formToEvaluate.append(" " + q4.getName() + ": \"Ask a question?\" integer ");
		formToEvaluate.append("} ");
		formToEvaluate.append("}");
		String src = formToEvaluate.toString();	
		DeclEvaluator.Evaluate(parser.ParseForm(src).getStmts(), env, errorList);
		assertEquals(env.typeOf(q1).getClass(), Bool.class);
		assertEquals(env.typeOf(q2).getClass(), Bool.class);
		assertEquals(env.typeOf(q3).getClass(), Money.class);
		assertEquals(env.typeOf(q4).getClass(), Int.class);
	}
	
	@Test
	public void testCorrectDecls() throws ParseError {
		formToEvaluate.append("form form1 { ");
		formToEvaluate.append(" Q1: \"Ask a question?\" boolean ");
		formToEvaluate.append(" Q2 (a + B): \"Ask a question?\" boolean ");
		formToEvaluate.append(" if (a - b > c) { Q3 (a + B): \"Ask a question?\" boolean  ");
		formToEvaluate.append(" Q1 = true ");
		formToEvaluate.append("} ");
		formToEvaluate.append(" \"This is a label\" (a + b * c) ");		
		formToEvaluate.append("}");
		String src = formToEvaluate.toString();	
		boolean result = DeclEvaluator.Evaluate(parser.ParseForm(src).getStmts(), env, errorList);
		boolean expected = true;
		assertEquals(result, expected);		
	}
	
	@Test
	public void testWrongDecls() throws ParseError {
		formToEvaluate.append("form form1 { ");
		formToEvaluate.append(" Q1: \"Ask a question?\" boolean ");
		formToEvaluate.append(" Q2 (a + B): \"Ask a question?\" boolean ");
		formToEvaluate.append(" if (a - b > c) { Q1 (a + B): \"Ask a question?\" boolean  "); //error
		formToEvaluate.append(" Q1 = true ");
		formToEvaluate.append("} ");
		formToEvaluate.append(" \"This is a label\" (a + b * c) ");		
		formToEvaluate.append(" Q2: \"Ask a question?\" boolean "); //error
		formToEvaluate.append("}");
		String src = formToEvaluate.toString();	
		boolean result = DeclEvaluator.Evaluate(parser.ParseForm(src).getStmts(), env, errorList);
		boolean expected = false;
		if(result == expected) {
		for(QlDeclarationError error: errorList)
			System.out.println(error.getMessage());
		}
		assertEquals(result, expected);		
	}
	

}
