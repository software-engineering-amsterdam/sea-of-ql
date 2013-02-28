package org.uva.sea.ql.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.operative.Add;
import org.uva.sea.ql.ast.operative.And;
import org.uva.sea.ql.ast.operative.GT;
import org.uva.sea.ql.ast.operative.LEq;
import org.uva.sea.ql.ast.operative.LT;
import org.uva.sea.ql.ast.operative.Mul;
import org.uva.sea.ql.ast.operative.Not;
import org.uva.sea.ql.ast.primitive.Int;
import org.uva.sea.ql.ast.statement.Block;
import org.uva.sea.ql.ast.statement.QuestionComputed;
import org.uva.sea.ql.parser.rats.IParse;
import org.uva.sea.ql.parser.rats.ParseError;
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
		Block body = (Block)form.getBlock();
		QuestionComputed question = (QuestionComputed)body.getStatements().get(0);
		
		//return the only node in the body 
		return question.getExpression();
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
