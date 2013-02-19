package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.antlr.runtime.RecognitionException;
import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.And;
import org.uva.sea.ql.ast.expr.GT;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.LEq;
import org.uva.sea.ql.ast.expr.LT;
import org.uva.sea.ql.ast.expr.Mul;
import org.uva.sea.ql.ast.expr.Not;
import org.uva.sea.ql.ast.expr.Or;
import org.uva.sea.ql.ast.nodes.values.Doub;
import org.uva.sea.ql.ast.nodes.values.Int;
import org.uva.sea.ql.ast.nodes.values.Str;
import org.uva.sea.ql.ast.stat.AnswerableStat;
import org.uva.sea.ql.ast.stat.ComputedStat;
import org.uva.sea.ql.ast.stat.HiddenComputetStat;
import org.uva.sea.ql.ast.stat.IfThenElseStat;
import org.uva.sea.ql.ast.stat.IfThenStat;
import org.uva.sea.ql.ast.stat.Stat;
import org.uva.sea.ql.ast.type.DoubleType;
import org.uva.sea.ql.ast.type.IntType;
import org.uva.sea.ql.ast.type.MoneyType;
import org.uva.sea.ql.ast.type.StringType;
import org.uva.sea.ql.parser.antlr.ParserProcessor;
import org.uva.sea.ql.questionnaire.Questionnaire;

public class TestExpressions {

	ParserProcessor parser;

	@Before
	public void initParser() {
		parser = new ParserProcessor();

	}

	@Test
	public void testQuestionnaireId() throws RecognitionException {
		String qlString = "form QuestionnairId { intValue : \"intValue\" integer }";
		String qlString2 = "form QuestionnairId2 { intValue : \"intValue\" integer }";
		// Case 1
		Questionnaire questionnaire = parser.parse(qlString, true);
		assertNotNull(questionnaire);
		assertEquals("QuestionnairId", questionnaire.getName());

		// Case 2
		questionnaire = parser.parse(qlString2, true);
		assertNotNull(questionnaire);
		assertEquals("QuestionnairId2", questionnaire.getName());
	}

	@Test
	public void testQuestionnaireAnswerableQuestionTypes()
			throws RecognitionException {
		String qlString = "form QuestionnairId { moneySpent: \"How much money have you spent on games this year?\" money "
				+ "lastGame: \"Whats the name of the last game you bought?\" string "
				+ "playTimeDay: \"How many hours do you play during the week?\" double "
				+ "timePerYear: \"Calculated time played this year:\" integer }";

		Questionnaire questionnaire = parser.parse(qlString, true);
		assertNotNull(questionnaire);
		assertNotNull(questionnaire.getBlock());
		assertEquals(4, questionnaire.getBlock().getStatements().size());
		List<Stat> statements = questionnaire.getBlock().getStatements();
		assertEquals(MoneyType.class, ((AnswerableStat) statements.get(0))
				.getType().getClass());
		assertEquals(StringType.class, ((AnswerableStat) statements.get(1))
				.getType().getClass());
		assertEquals(DoubleType.class, ((AnswerableStat) statements.get(2))
				.getType().getClass());
		assertEquals(IntType.class, ((AnswerableStat) statements.get(3))
				.getType().getClass());
	}

	@Test
	public void testQuestionnaireComputedQuestionType() {
		String qlString = "form QuestionnairId { moneySpent: \"How much money have you spent on games this year?\" money(1*2) "
				+ "lastGame: \"Whats the name of the last game you bought?\" string(\"hallo\") "
				+ "playTimeDay: \"How many hours do you play during the week?\" double(1.2 + 2.1) "
				+ "timePerYear: \"Calculated time played this year:\" integer(4+5) }";
		Questionnaire questionnaire = parser.parse(qlString, true);
		assertNotNull(questionnaire);
		assertNotNull(questionnaire.getBlock());
		assertEquals(4, questionnaire.getBlock().getStatements().size());
		List<Stat> statements = questionnaire.getBlock().getStatements();
		assertEquals(MoneyType.class, ((ComputedStat) statements.get(0))
				.getType().getClass());
		assertEquals(StringType.class, ((ComputedStat) statements.get(1))
				.getType().getClass());
		assertEquals(DoubleType.class, ((ComputedStat) statements.get(2))
				.getType().getClass());
		assertEquals(IntType.class, ((ComputedStat) statements.get(3))
				.getType().getClass());
	}

	@Test
	public void testQuestionnaireHiddentComputedQuestionType() {
		String qlString = "form QuestionnairId { moneySpent: money(1*2) "
				+ "lastGame: string(\"hallo\") "
				+ "playTimeDay:  double(1.2 + 2.1) "
				+ "timePerYear:  integer(4+5) }";
		Questionnaire questionnaire = parser.parse(qlString, true);
		assertNotNull(questionnaire);
		assertNotNull(questionnaire.getBlock());
		assertEquals(4, questionnaire.getBlock().getStatements().size());
		List<Stat> statements = questionnaire.getBlock().getStatements();
		assertEquals(MoneyType.class, ((HiddenComputetStat) statements.get(0))
				.getType().getClass());
		assertEquals(StringType.class, ((HiddenComputetStat) statements.get(1))
				.getType().getClass());
		assertEquals(DoubleType.class, ((HiddenComputetStat) statements.get(2))
				.getType().getClass());
		assertEquals(IntType.class, ((HiddenComputetStat) statements.get(3))
				.getType().getClass());
	}

	@Test
	public void testQuestionnaireBlockSize() throws RecognitionException {
		String qlString = "form QuestionnairId { moneySpent: \"How much money have you spent on games this year?\" money "
				+ "lastGame: \"Whats the name of the last game you bought?\" string "
				+ "playTimeDay: \"How many hours do you play during the week?\" double "
				+ "timePerYear: \"Calculated time played this year:\" integer "
				+ "if(timePerYear>playTimeDay){"
				+ "playTimeDay: \"How many hours do you play during the week?\" double "
				+ "lastGame: \"Whats the name of the last game you bought?\" string "
				+ "moneySpent: \"How much money have you spent on games this year?\" money "
				+ "}"
				+ "if(moneySpent>playTimeDay){"
				+ "playTimeDay2: \"How many hours do you play during the week?\" double "
				+ "lastGame2: \"Whats the name of the last game you bought?\" string "
				+ "moneySpent2: \"How much money have you spent on games this year?\" money "
				+ "}"
				+ "if(moneySpent>playTimeDay){"
				+ "playTimeDay2: \"How many hours do you play during the week?\" double "
				+ "lastGame2: \"Whats the name of the last game you bought?\" string "
				+ "moneySpent2: \"How much money have you spent on games this year?\" money "
				+ "}else{"
				+ "playTimeDay3: \"How many hours do you play during the week?\" double "
				+ "lastGame3: \"Whats the name of the last game you bought?\" string "
				+ "moneySpent3: \"How much money have you spent on games this year?\" money "
				+ "playTimeDay4: \"How many hours do you play during the week?\" double "
				+ "lastGame4: \"Whats the name of the last game you bought?\" string "
				+ "moneySpent4: \"How much money have you spent on games this year?\" money "
				+ "}" + "}";

		Questionnaire questionnaire = parser.parse(qlString, true);
		assertNotNull(questionnaire);
		assertNotNull(questionnaire.getBlock());
		// First block-layer
		List<Stat> statements = questionnaire.getBlock().getStatements();
		assertEquals(7, statements.size());

		// First if block
		List<Stat> firstIfBlock = ((IfThenStat) statements.get(4)).getBody()
				.getStatements();
		assertEquals(3, firstIfBlock.size());

		// Second if block
		List<Stat> secondIfBlock = ((IfThenStat) statements.get(5)).getBody()
				.getStatements();
		assertEquals(3, secondIfBlock.size());

		// Third if block
		List<Stat> thirdBlockIf = ((IfThenElseStat) statements.get(6))
				.getBody().getStatements();
		assertEquals(3, thirdBlockIf.size());

		List<Stat> thirdBlockElse = ((IfThenElseStat) statements.get(6))
				.getElseBody().getStatements();
		assertEquals(6, thirdBlockElse.size());
	}

	@Test
	public void testNestedIfElse() {

		String qlString = "form QuestionnairId {"
				+ "if(timePerYear>playTimeDay){"
				+ "playTimeDay: \"How many hours do you play during the week?\" double "
				+ "lastGame: \"Whats the name of the last game you bought?\" string "
				+ "moneySpent: \"How much money have you spent on games this year?\" money "
				+ "if(moneySpent>playTimeDay){"
				+ "playTimeDay2: \"How many hours do you play during the week?\" double "
				+ "lastGame2: \"Whats the name of the last game you bought?\" string "
				+ "moneySpent2: \"How much money have you spent on games this year?\" money "
				+ "if(moneySpent>playTimeDay){"
				+ "playTimeDay2: \"How many hours do you play during the week?\" double "
				+ "lastGame2: \"Whats the name of the last game you bought?\" string "
				+ "moneySpent2: \"How much money have you spent on games this year?\" money "
				+ "}else{"
				+ "playTimeDay3: \"How many hours do you play during the week?\" double "
				+ "lastGame3: \"Whats the name of the last game you bought?\" string "
				+ "moneySpent3: \"How much money have you spent on games this year?\" money "
				+ "playTimeDay4: \"How many hours do you play during the week?\" double "
				+ "lastGame4: \"Whats the name of the last game you bought?\" string "
				+ "moneySpent4: \"How much money have you spent on games this year?\" money "
				+ "if(moneySpent>playTimeDay){"
				+ "playTimeDay2: \"How many hours do you play during the week?\" double "
				+ "lastGame2: \"Whats the name of the last game you bought?\" string "
				+ "moneySpent2: \"How much money have you spent on games this year?\" money "
				+ "}" + "}" + "}" + "}" + "}";

		Questionnaire questionnaire = parser.parse(qlString, true);
		assertNotNull(questionnaire);
		assertNotNull(questionnaire.getBlock());

		// First block-layer
		List<Stat> statements = questionnaire.getBlock().getStatements();
		assertEquals(1, statements.size());

		// First if-block
		IfThenStat firstIf = (IfThenStat) statements.get(0);
		assertNotNull(firstIf);
		assertEquals(4, firstIf.getBody().getStatements().size());

		// Nested if-block
		IfThenStat secondIf = (IfThenStat) firstIf.getBody().getStatements()
				.get(3);
		assertNotNull(secondIf);
		assertEquals(4, secondIf.getBody().getStatements().size());

		// Nested-nested if-else-block
		IfThenElseStat firstIfElse = (IfThenElseStat) secondIf.getBody()
				.getStatements().get(3);
		assertNotNull(firstIfElse);
		// IF block
		assertNotNull(firstIfElse.getBody());
		assertEquals(3, firstIfElse.getBody().getStatements().size());
		// Else block
		assertNotNull(firstIfElse.getElseBody());
		assertEquals(7, firstIfElse.getElseBody().getStatements().size());

		// Nested-nested if in if-else
		IfThenStat thirdIf = (IfThenStat) firstIfElse.getElseBody()
				.getStatements().get(6);
		assertNotNull(thirdIf);
		assertNotNull(thirdIf.getBody());
		assertEquals(3, thirdIf.getBody().getStatements().size());
	}

	@Test
	public void testExpressions() throws RecognitionException {
		String qlString = "form QuestionnairId { intValue : \"intValue\" integer(1 +1) }";

		// Case 1 ADD
		Questionnaire questionnaire = parser.parse(qlString, true);
		assertNotNull(questionnaire);
		ComputedStat compStat1 = (ComputedStat) questionnaire.getBlock()
				.getStatements().get(0);
		assertEquals(Add.class, compStat1.getExpr().getClass());

		// Case 2 ADD
		String qlString2 = "form QuestionnairId { intValue : \"intValue\" integer(1 +(1+2)) }";
		questionnaire = parser.parse(qlString2, true);
		ComputedStat compStat2 = (ComputedStat) questionnaire.getBlock()
				.getStatements().get(0);
		assertEquals(Add.class, compStat2.getExpr().getClass());

		// Case 3 AND
		String qlString3 = "form QuestionnairId { intValue : \"intValue\" boolean(you && me ) }";
		questionnaire = parser.parse(qlString3, true);
		ComputedStat compStat3 = (ComputedStat) questionnaire.getBlock()
				.getStatements().get(0);
		assertEquals(And.class, compStat3.getExpr().getClass());

		// Case 4 AND
		String qlString4 = "form QuestionnairId { intValue : \"intValue\" boolean(you && (me || you)) }";
		questionnaire = parser.parse(qlString4, true);
		ComputedStat compStat4 = (ComputedStat) questionnaire.getBlock()
				.getStatements().get(0);
		assertEquals(And.class, compStat4.getExpr().getClass());

		// Case 5 OR
		String qlString5 = "form QuestionnairId { intValue : \"intValue\" boolean(me || you) }";
		questionnaire = parser.parse(qlString5, true);
		ComputedStat compStat5 = (ComputedStat) questionnaire.getBlock()
				.getStatements().get(0);
		assertEquals(Or.class, compStat5.getExpr().getClass());

		// Case 6 OR
		String qlString6 = "form QuestionnairId { intValue : \"intValue\" boolean(me || (you && me)) }";
		questionnaire = parser.parse(qlString6, true);
		ComputedStat compStat6 = (ComputedStat) questionnaire.getBlock()
				.getStatements().get(0);
		assertEquals(Or.class, compStat6.getExpr().getClass());

		// Case 6 LT
		String qlString7 = "form QuestionnairId { intValue : \"intValue\" boolean( 1 < 2) }";
		questionnaire = parser.parse(qlString7, true);
		ComputedStat compStat7 = (ComputedStat) questionnaire.getBlock()
				.getStatements().get(0);
		assertEquals(LT.class, compStat7.getExpr().getClass());

	}

	@Test
	public void testAdds() throws RecognitionException {
		assertEquals(parser.checkExpression("(ada + bdd)").getClass(),
				Add.class);
		assertEquals(parser.checkExpression("(aad + bada)").getClass(),
				Add.class);
		assertEquals(parser.checkExpression("(a + b + c)").getClass(),
				Add.class);
		assertEquals(parser.checkExpression("(a + b + c)").getClass(),
				Add.class);
		assertEquals(parser.checkExpression("a + (b + c)").getClass(),
				Add.class);
		assertEquals(parser.checkExpression("(a + b) + c").getClass(),
				Add.class);
		assertEquals(parser.checkExpression("(a + b)").getClass(), Add.class);
		assertEquals(parser.checkExpression("a + b * c").getClass(), Add.class);
		assertEquals(parser.checkExpression("a * b + c").getClass(), Add.class);
	}

	@Test
	public void testMuls() throws RecognitionException {
		assertEquals(parser.checkExpression("a * b").getClass(), Mul.class);
		assertEquals(parser.checkExpression("a * b * c").getClass(), Mul.class);
		assertEquals(parser.checkExpression("a * (b * c)").getClass(),
				Mul.class);
		assertEquals(parser.checkExpression("(a * b) * c").getClass(),
				Mul.class);
		assertEquals(parser.checkExpression("(a * b)").getClass(), Mul.class);
		assertEquals(parser.checkExpression("(a + b) * c").getClass(),
				Mul.class);
		assertEquals(parser.checkExpression("a * (b + c)").getClass(),
				Mul.class);
	}

	@Test
	public void testRels() throws RecognitionException {
		assertEquals(parser.checkExpression("a < b").getClass(), LT.class);
		assertEquals(parser.checkExpression("a < b + c").getClass(), LT.class);
		assertEquals(parser.checkExpression("a < (b * c)").getClass(), LT.class);
		assertEquals(parser.checkExpression("(a * b) < c").getClass(), LT.class);
		assertEquals(parser.checkExpression("(a <= b)").getClass(), LEq.class);
		assertEquals(parser.checkExpression("a + b > c").getClass(), GT.class);
		assertEquals(parser.checkExpression("a > b + c").getClass(), GT.class);
	}

	@Test
	public void testBools() throws RecognitionException {
		assertEquals(parser.checkExpression("!b").getClass(), Not.class);
		assertEquals(parser.checkExpression("a && b").getClass(), And.class);
		assertEquals(parser.checkExpression("a > b && b > c").getClass(),
				And.class);
		assertEquals(parser.checkExpression("(a > b) && (b > c)").getClass(),
				And.class);
	}

	@Test
	public void testIds() throws RecognitionException {
		assertEquals(parser.checkExpression("g").getClass(), Ident.class);
		assertEquals(parser.checkExpression("gcd").getClass(), Ident.class);
		assertEquals(parser.checkExpression("ABC").getClass(), Ident.class);
		assertEquals(parser.checkExpression("ABCDEF").getClass(), Ident.class);
		assertEquals(parser.checkExpression("abc2323").getClass(), Ident.class);
		assertEquals(parser.checkExpression("a2bc232").getClass(), Ident.class);
		assertEquals(parser.checkExpression("a2bc232aa").getClass(),
				Ident.class);
	}

	@Test
	public void testNums() throws RecognitionException {
		assertEquals(parser.checkExpression("0").getClass(), Int.class);
		assertEquals(parser.checkExpression("1223").getClass(), Int.class);
		assertEquals(parser.checkExpression("234234234").getClass(), Int.class);
	}

	@Test
	public void testDouble() throws RecognitionException {
		assertEquals(parser.checkExpression("0.1").getClass(), Doub.class);
		assertEquals(parser.checkExpression("10.2").getClass(), Doub.class);
		assertEquals(parser.checkExpression("13.2").getClass(), Doub.class);
	}

	@Test
	public void testString() throws RecognitionException {
		assertEquals(parser.checkExpression("\"luka\"").getClass(), Str.class);
		assertEquals(parser.checkExpression("\"luka halloo\"").getClass(),
				Str.class);
		assertEquals(parser.checkExpression("\"luka yes yor\"").getClass(),
				Str.class);
	}

}
