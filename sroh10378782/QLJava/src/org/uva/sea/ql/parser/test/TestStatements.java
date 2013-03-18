package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.uva.sea.ql.ast.nodes.expressions.Bool;
import org.uva.sea.ql.ast.nodes.expressions.Ident;
import org.uva.sea.ql.ast.nodes.expressions.Str;
import org.uva.sea.ql.ast.nodes.statements.*;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

public class TestStatements {

	private static IParse parser;
	
	@BeforeClass
	public static void init(){
		parser = new ANTLRParser();
	}
	
	@Test
	public void testFormStatement() throws ParseError {
		String formIdent = "Box1Housing";
		String parseString = "form "+formIdent+" { }";
		Statement stat = parser.start(parseString);
		assertEquals(Form.class, stat.getClass());
		Form form = (Form)stat;
		assertEquals(Ident.class,form.getIdent().getClass());
		assertEquals(Block.class,form.getBlock().getClass());
		Block block = (Block)form.getBlock();
		assertEquals(0,block.getValuesCount());
	}
	
	@Test
	public void testQuestionStatement() throws ParseError {
		String questionIdent = "question1";
		String questionString = " \"Question ?\" ";
		String questionType = " boolean ";
		String parseString = questionIdent+":"+questionString+questionType;
		Statement stat = parser.start(parseString);
		assertEquals(Question.class, stat.getClass());
		Question question = (Question)stat;
		assertEquals(Ident.class, question.getIdent().getClass());
		Ident ident = (Ident)question.getIdent();
		assertEquals(questionIdent,ident.getValue());
		assertEquals(Str.class, question.getQuestionString().getClass());
		assertEquals(Bool.class, question.getAnswerType().getClass());
		Str str = (Str)question.getQuestionString();
		assertEquals(questionString.trim(),str.getValue());
		Bool bl = (Bool)question.getAnswerType();
		assertEquals(questionType.trim(), bl.getValue());
	}
	
	@Test
	public void testBlockStatement() throws ParseError {
		String blockString = "{ }";
		String parseString = blockString;
		Statement stat = parser.start(parseString);
		assertEquals(Block.class, stat.getClass());
		Block block = (Block)stat;
		assertEquals(0,block.getValuesCount());
	}
	
	@Test
	public void testIfThenStatement() throws ParseError {
		String conditionString = "Form Formtest { if ( isValidInput ) { } }";
		String parseString = conditionString;
		Statement stat = parser.start(parseString);
		assertEquals(Form.class, stat.getClass());
		Form form = (Form)stat;
		assertEquals(Ident.class,form.getIdent().getClass());
		Ident formIdent = (Ident)form.getIdent();
		assertEquals(Block.class, form.getBlock().getClass());
		assertEquals("Formtest", formIdent.getValue());
			
	}
	
	@Test
	public void testIfThenElseStatement() throws ParseError {
		String conditionString = "Form Formtest { if ( isValidInput ) { } else { } }";
		String parseString = conditionString;
		Statement stat = parser.start(parseString);
		assertEquals(Form.class, stat.getClass());
		Form form = (Form)stat;
		assertEquals(Ident.class,form.getIdent().getClass());
		Ident formIdent = (Ident)form.getIdent();
		assertEquals(Block.class, form.getBlock().getClass());
		assertEquals("Formtest", formIdent.getValue());
		
	}
	
}