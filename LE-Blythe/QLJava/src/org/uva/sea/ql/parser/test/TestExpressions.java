package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.comparative.*;
import org.uva.sea.ql.ast.form.Body;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.ast.numeric.*;
import org.uva.sea.ql.ast.propositional.*;
import org.uva.sea.ql.errors.ParseError;
import org.uva.sea.ql.interfaces.IParse;
import org.uva.sea.ql.parser.rats.RatsParser;
import org.uva.sea.ql.util.FormStringBuilder;


public class TestExpressions {

	private IParse parser;
	
	public TestExpressions() {
		this.parser = new RatsParser();
	}

	
	/** Wrap the given expression into a form with a question so it can be parsed */
	private String wrap(String expression){
		
		String question = FormStringBuilder.question("q1", expression);
		String form = FormStringBuilder.form("f1", question);
		return form;
	}
	
	
	/** Extract the parsed expression from the AST tree */ 
	private ASTNode extract(ASTNode node){
		
		Form form = (Form)node; 
		Body body = (Body)form.getBody();
		Question question = (Question)body.getNodes().get(0);
		
		//return the only node in the body 
		return question.getValue();
	}
	
	
	/** Given an expression string as input: wrap it, parse it and extract 
	 * it from the resulting AST tree  */
	private ASTNode parse(String expression) throws ParseError{
		String form = wrap(expression);
		return extract(parser.parse(form));
	}
	
	
	@Test
	public void testAdds() throws ParseError {
		assertEquals(parse("a + b").getClass(), Add.class);
		assertEquals(parse("a + b + c").getClass(), Add.class);
		assertEquals(parse("(a + b + c)").getClass(), Add.class);
		assertEquals(parse("a + (b + c)").getClass(), Add.class);
		assertEquals(parse("(a + b) + c").getClass(), Add.class);
		assertEquals(parse("(a + b)").getClass(), Add.class);
		assertEquals(parse("a + b * c").getClass(), Add.class);
		assertEquals(parse("a * b + c").getClass(), Add.class);
	}

	
	@Test
	public void testMuls() throws ParseError {
		assertEquals(parse("a * b").getClass(), Mul.class);
		assertEquals(parse("a * b * c").getClass(), Mul.class);
		assertEquals(parse("a * (b * c)").getClass(), Mul.class);
		assertEquals(parse("(a * b) * c").getClass(), Mul.class);
		assertEquals(parse("(a * b)").getClass(), Mul.class);
		assertEquals(parse("(a + b) * c").getClass(), Mul.class);
		assertEquals(parse("a * (b + c)").getClass(), Mul.class);
	}
	
	
	@Test
	public void testRels() throws ParseError {
		assertEquals(parse("a < b").getClass(), LT.class);
		assertEquals(parse("a < b + c").getClass(), LT.class);
		assertEquals(parse("a < (b * c)").getClass(), LT.class);
		assertEquals(parse("(a * b) < c").getClass(), LT.class);
		assertEquals(parse("(a <= b)").getClass(), LEq.class);
		assertEquals(parse("a + b > c").getClass(), GT.class);
		assertEquals(parse("a > b + c").getClass(), GT.class);
	}
	
	
	@Test
	public void testBools() throws ParseError {
		assertEquals(parse("!b").getClass(), Not.class);
		assertEquals(parse("a && b").getClass(), And.class);
		assertEquals(parse("a < b + c").getClass(), LT.class);
		assertEquals(parse("a < (b * c)").getClass(), LT.class);
		assertEquals(parse("(a * b) < c").getClass(), LT.class);
		assertEquals(parse("(a <= b)").getClass(), LEq.class);
		assertEquals(parse("a + b > c").getClass(), GT.class);
		assertEquals(parse("a > b + c").getClass(), GT.class);
	}


	@Test
	public void testIds() throws ParseError {
		assertEquals(parse("a").getClass(), Ident.class);
		assertEquals(parse("abc").getClass(), Ident.class);
		assertEquals(parse("ABC").getClass(), Ident.class);
		assertEquals(parse("ABCDEF").getClass(), Ident.class);
		assertEquals(parse("abc2323").getClass(), Ident.class);
		assertEquals(parse("a2bc232").getClass(), Ident.class);
		assertEquals(parse("a2bc232aa").getClass(), Ident.class);
	}

	
	@Test
	public void testNums() throws ParseError {
		assertEquals(parse("0").getClass(), Int.class);
		assertEquals(parse("1223").getClass(), Int.class);
		assertEquals(parse("234234234").getClass(), Int.class);
	}

	
}
