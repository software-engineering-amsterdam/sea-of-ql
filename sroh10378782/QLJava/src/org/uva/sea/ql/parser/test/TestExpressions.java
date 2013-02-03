package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import org.uva.sea.ql.ast.Add;
import org.uva.sea.ql.ast.And;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.GT;
import org.uva.sea.ql.ast.LEq;
import org.uva.sea.ql.ast.LT;
import org.uva.sea.ql.ast.Mul;
import org.uva.sea.ql.ast.Not;
import org.uva.sea.ql.ast.statements.Block;
import org.uva.sea.ql.ast.statements.Condition;
import org.uva.sea.ql.ast.statements.ConditionalStatement;
import org.uva.sea.ql.ast.statements.Form;
import org.uva.sea.ql.ast.statements.Question;
import org.uva.sea.ql.ast.types.Bool;
import org.uva.sea.ql.ast.types.Ident;
import org.uva.sea.ql.ast.types.Int;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

public class TestExpressions {

	private static IParse parser;
	
	@BeforeClass
	public static void init(){
		parser = new ANTLRParser();
	}
	
	@Test
	public void testAdds() throws ParseError {
		assertEquals(parser.parse("a + b").getClass(), Add.class);
		assertEquals(parser.parse("a + b + c").getClass(), Add.class);
		assertEquals(parser.parse("(a + b + c)").getClass(), Add.class);
		assertEquals(parser.parse("a + (b + c)").getClass(), Add.class);
		assertEquals(parser.parse("(a + b) + c").getClass(), Add.class);
		assertEquals(parser.parse("(a + b)").getClass(), Add.class);
		assertEquals(parser.parse("a + b * c").getClass(), Add.class);
		assertEquals(parser.parse("a * b + c").getClass(), Add.class);
	}

	@Test
	public void testMuls() throws ParseError {
		assertEquals(parser.parse("a * b").getClass(), Mul.class);
		assertEquals(parser.parse("a * b * c").getClass(), Mul.class);
		assertEquals(parser.parse("a * (b * c)").getClass(), Mul.class);
		assertEquals(parser.parse("(a * b) * c").getClass(), Mul.class);
		assertEquals(parser.parse("(a * b)").getClass(), Mul.class);
		assertEquals(parser.parse("(a + b) * c").getClass(), Mul.class);
		assertEquals(parser.parse("a * (b + c)").getClass(), Mul.class);
	}
	
	@Test
	public void testRels() throws ParseError {
		assertEquals(parser.parse("a < b").getClass(), LT.class);
		assertEquals(parser.parse("a < b + c").getClass(), LT.class);
		assertEquals(parser.parse("a < (b * c)").getClass(), LT.class);
		assertEquals(parser.parse("(a * b) < c").getClass(), LT.class);
		assertEquals(parser.parse("(a <= b)").getClass(), LEq.class);
		assertEquals(parser.parse("a + b > c").getClass(), GT.class);
		assertEquals(parser.parse("a > b + c").getClass(), GT.class);
	}
	
	@Test
	public void testBools() throws ParseError {
		assertEquals(parser.parse("!b").getClass(), Not.class);
		assertEquals(parser.parse("a && b").getClass(), And.class);
		Expr parsed = parser.parse("a && b");
		assertEquals(true, parsed.isBinaryNode());
		assertEquals(parser.parse("a > b && b > c").getClass(), And.class);
		assertEquals(parser.parse("(a > b) && (b > c)").getClass(), And.class);
	}


	@Test
	public void testIds() throws ParseError {
		assertEquals(parser.parse("a").getClass(), Ident.class);
		assertEquals(parser.parse("abc").getClass(), Ident.class);
		assertEquals(parser.parse("ABC").getClass(), Ident.class);
		assertEquals(parser.parse("ABCDEF").getClass(), Ident.class);
		assertEquals(parser.parse("abc2323").getClass(), Ident.class);
		assertEquals(parser.parse("a2bc232").getClass(), Ident.class);
		assertEquals(parser.parse("a2bc232aa").getClass(), Ident.class);
	}

	@Test
	public void testNums() throws ParseError {
		assertEquals(parser.parse("0").getClass(), Int.class);
		assertEquals(parser.parse("1223").getClass(), Int.class);
		assertEquals(parser.parse("234234234").getClass(), Int.class);
	}
	
	@Test
	public void testBooleanTypes() throws ParseError {
		assertEquals(Bool.class, parser.parse("true").getClass());
		assertEquals(Bool.class, parser.parse("false").getClass());
		assertEquals(Bool.class, parser.parse("boolean").getClass());
	}
	
	@Test
	public void testMoneyTypes() throws ParseError {
		assertEquals(Money.class, parser.parse("money").getClass());
	}
	/*
	@Test
	public void testFormTypeWithSingleQuestion() throws ParseError {
		String parseString = "form Box1Housing { "+
							 	"hasSoldHouse: \"Did you sell a house in 2010?\" boolean"+
							 "}";
		
		assertEquals(Form.class, parser.parse(parseString).getClass());
		Form form = (Form)parser.parse(parseString);
		evaluateFormNode(form);
	}
	
	@Test
	public void testFormTypeWithMultipleQuestions() throws ParseError {
		String parseString = "form Box1Housing { "+
							 	"hasSoldHouse: \"Did you sell a house in 2010?\" boolean "+
							 	"hasBoughtHouse: \"Did you by a house in 2010?\" boolean "+
							 	"hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean "+
							 "}";
		
		assertEquals(Form.class, parser.parse(parseString).getClass());
		Form form = (Form)parser.parse(parseString);
		evaluateFormNode(form);
	}
	*/
	@Test
	public void testFormTypeWithMultipleQuestionsAndIfStatementWithQuestions() throws ParseError {
		String parseString = "form Box1Housing { "+
							 	"hasSoldHouse: \"Did you sell a house in 2010?\" boolean "+
							 	"hasBoughtHouse: \"Did you by a house in 2010?\" boolean "+
							 	"hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean " +
							 	"if (hasSoldHouse) { " +
							 		"sellingPrice: \"Price the house was sold for:\" money "+
							 		"privateDebt: \"Private debts for the sold house:\" money "+
							 		"valueResidue: \"Value residue:\" money(sellingPrice - privateDebt) "+
							 	"} " +
							 "}";
		
		// assertEquals(Form.class, parser.parse(parseString).getClass());
		Form form = (Form)parser.parse(parseString);
		evaluateFormNode(form);
	}
	
	private void evaluateFormNode(Form form){
		assertEquals(Ident.class, form.getLhs().getClass());
		assertEquals(Block.class, form.getRhs().getClass());
		evaluatePrimaryExpressionNode(form.getLhs());
		evaluateBlockNode((Block)form.getRhs());
	}
	
	private void evaluateBlockNode(Block b){
		int statementCounter = b.getValuesCount();
		System.out.println("Eval Block Node Endtered");
		for(int i = 0; i < statementCounter; i++ ){
			evaluateStatement(b.getValue(i));
		}
	}
	
	private void evaluateStatement(Expr x){
		System.out.println("Eval Statement Node Endtered");
		if(x.getClass() == Question.class){
			System.out.println("Eval Question Node Endtering");
			evaluateQuestionNode(x);
		} else {
			ConditionalStatement cSt = (ConditionalStatement)x;
			evaluateConditionalStatementNode(cSt);
		}
	}
	
	private void evaluateQuestionNode(Expr q){
		assertEquals(Question.class, q.getClass() );
	}
	
	private void evaluateConditionalStatementNode(Expr cSt){
		System.out.println("Eval Conditional Statement Entered ");
		assertEquals(ConditionalStatement.class, cSt.getClass() );
		ConditionalStatement conSt = (ConditionalStatement)cSt;
		assertEquals(Condition.class, conSt.getLhs().getClass());
		assertEquals(Block.class, conSt.getRhs().getClass());
		evaluateConditionNode((Condition)conSt.getLhs());
		evaluateBlockNode((Block)conSt.getRhs());
	}
	
	private void evaluateConditionNode(Expr c){
		System.out.println("Eval Condition Entered ");
		assertEquals(Condition.class, c.getClass() );
		Condition condition = (Condition)c;
		evaluateConditionalExpressionNode(condition.getExpr());
	}
	
	private void evaluateConditionalExpressionNode(Expr x){
		boolean isPrimaryNode = evaluatePrimaryExpressionNode(x);
		if(!isPrimaryNode){
			System.out.println("TODO Check Expression left and right");
			
		}
	}
	
	private boolean evaluatePrimaryExpressionNode(Expr x){
		boolean isPrimaryNode = false;
		if(x.getClass() == Bool.class){
			assertEquals(Bool.class, x.getClass());
			Bool b = (Bool)x;
			assertEquals("boolean",b.getValue());
			isPrimaryNode = true;
		}
		if(x.getClass() == Money.class){
			assertEquals(Money.class, x.getClass());
			Money m = (Money)x;
			assertEquals("money", m.getValue());
			isPrimaryNode = true;
		}
		if(x.getClass() == Ident.class){
			assertEquals(Ident.class, x.getClass());
			Ident i = (Ident)x;
			System.out.println("Indent found : " + i.getValue());
			isPrimaryNode = true;
		}
		return isPrimaryNode;
	}
}
