package org.uva.sea.ql.parser.test;

// import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
// import org.junit.Test;
// import org.uva.sea.ql.ast.nodes.types.*;
// import org.uva.sea.ql.ast.nodes.statements.Question;
// import org.uva.sea.ql.ast.nodes.statements.Block;
// import org.uva.sea.ql.ast.nodes.statements.Form;
// import org.uva.sea.ql.parser.antlr.ANTLRParser;

public class TestStatements {

	// private static IParse parser;
	
	@BeforeClass
	public static void init(){
		// parser = new ANTLRParser();
	}
	/**
	@Test
	public void testFormStatement() throws ParseError {
		String formIdent = "Box1Housing";
		String parseString = "form "+formIdent+" { }";
		assertEquals(Form.class, parser.parse(parseString).getClass());
		Form form = (Form)parser.parse(parseString);
		assertEquals(true, form.isBinaryNode());
		assertEquals(false, form.isUnaryNode());
		assertEquals(false, form.isMultiNode());
		assertEquals(TIdent.class,form.getLhs().getClass());
		TIdent ident = (TIdent)form.getLhs();
		assertEquals(formIdent,ident.getValue());
		Block block = (Block)form.getRhs();
		assertEquals(0,block.getValuesCount());
	}
	
	@Test
	public void testQuestionStatement() throws ParseError {
		String questionIdent = "question1";
		String questionString = " \"Question ?\" ";
		String questionType = " boolean ";
		String parseString = questionIdent+":"+questionString+questionType;
		assertEquals(Question.class, parser.parse(parseString).getClass());
		Question question = (Question)parser.parse(parseString);
		assertEquals(true, question.isBinaryNode());
		assertEquals(false, question.isUnaryNode());
		assertEquals(false, question.isMultiNode());
		assertEquals(TIdent.class, question.getLhs().getClass());
		TIdent ident = (TIdent)question.getLhs();
		assertEquals(questionIdent,ident.getValue());
		assertEquals(QuestionBody.class, question.getRhs().getClass());
		QuestionBody body = (QuestionBody)question.getRhs();
		assertEquals(TStr.class, body.getLhs().getClass());
		assertEquals(TBool.class, body.getRhs().getClass());
		TStr str = (TStr)body.getLhs();
		assertEquals(questionString.trim(),str.getValue());
		TBool bl = (TBool)body.getRhs();
		assertEquals(false, bl.getValue());
	}
	
	@Test
	public void testBlockStatement() throws ParseError {
		String blockString = "{ }";
		String parseString = blockString;
		assertEquals(Block.class, parser.parse(parseString).getClass());
		Block block = (Block)parser.parse(parseString);
		assertEquals(0,block.getValuesCount());
	}
	
	@Test
	public void testConditionialStatement() throws ParseError {
		String conditionString = "Form Formtest { if ( isValidInput ) { } }";
		String parseString = conditionString;
		assertEquals(Form.class, parser.parse(parseString).getClass());
		Form form = (Form)parser.parse(parseString);
		assertEquals(TIdent.class,form.getLhs().getClass());
		TIdent formIdent = (TIdent)form.getLhs();
		assertEquals(Block.class, form.getRhs().getClass());
		assertEquals("Formtest", formIdent.getValue() );
		Block formBlock = (Block)form.getRhs();
		assertEquals(1,formBlock.getValuesCount());
		assertEquals(ConditionalStatement.class, formBlock.getValue(0).getClass());
		ConditionalStatement cs = (ConditionalStatement)formBlock.getValue(0);
		assertEquals(Condition.class, cs.getLhs().getClass());
		Condition condition = (Condition)cs.getLhs();
		assertEquals(Block.class, cs.getRhs().getClass());
		assertEquals(TIdent.class,condition.getExpr().getClass());
		TIdent condtionIdent = (TIdent)condition.getExpr();
		assertEquals("isValidInput", condtionIdent.getValue());
		Block conditionBlock = (Block)cs.getRhs();
		assertEquals(0,conditionBlock.getValuesCount());
	}
	
	@Test
	public void testFormWithQuestionsStatement() throws ParseError {
		String formSTring = "form Box1HouseOwning {"+
								"hasSoldHouse: \"Did you sell a house in 2010?\" boolean "+
								"hasBoughtHouse: \"Did you by a house in 2010?\" boolean "+
							    "hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean "+
						    "}";
		parser.parse(formSTring);	
	}
	
	@Test
	public void testWholeExamStatement() throws ParseError {
		String all = "form Box1HouseOwning { "+
						"hasSoldHouse: \"Did you sell a house in 2010?\" boolean "+
					    "hasBoughtHouse: \"Did you by a house in 2010?\" boolean "+
					    "hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean "+
						"if (hasSoldHouse) { "+
							"sellingPrice: \"Price the house was sold for:\" money "+
							"privateDebt: \"Private debts for the sold house:\" money "+
							"valueResidue: \"Value residue:\" money(sellingPrice - privateDebt) "+
						"} "+
					"} ";
		parser.parse(all);
	}
	**/
}




