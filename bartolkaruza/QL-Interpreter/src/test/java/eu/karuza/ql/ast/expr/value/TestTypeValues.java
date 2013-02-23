package eu.karuza.ql.ast.expr.value;

import junit.framework.Assert;

import org.junit.Test;

import eu.karuza.ql.ast.Form;
import eu.karuza.ql.ast.statement.AnswerableQuestion;
import eu.karuza.ql.ast.statement.ComputedQuestion;
import eu.karuza.ql.ast.type.BoolType;
import eu.karuza.ql.ast.type.IntType;
import eu.karuza.ql.ast.type.MoneyType;
import eu.karuza.ql.ast.type.TextType;
import eu.karuza.ql.ast.value.Bool;
import eu.karuza.ql.ast.value.Int;
import eu.karuza.ql.ast.value.Money;
import eu.karuza.ql.ast.value.Text;
import eu.karuza.ql.error.ParseError;
import eu.karuza.ql.parser.IParse;
import eu.karuza.ql.parser.antlr.ANTLRParser;

public class TestTypeValues {

	IParse parser = new ANTLRParser();

	@Test
	public void testTypeDeclaration() throws ParseError {
		Form form = (Form) parser.parseNode("form somelabel { question1: \" some text label\" boolean }");
		AnswerableQuestion question = (AnswerableQuestion) form.getStatements().get(0);
		Assert.assertEquals(BoolType.class, question.getType().getClass());
		form = (Form) parser.parseNode("form somelabel { question1: \" some text label\" integer }");
		question = (AnswerableQuestion) form.getStatements().get(0);
		Assert.assertEquals(IntType.class, question.getType().getClass());
		form = (Form) parser.parseNode("form somelabel { question1: \" some text label\" string }");
		question = (AnswerableQuestion) form.getStatements().get(0);
		Assert.assertEquals(TextType.class, question.getType().getClass());
		form = (Form) parser.parseNode("form somelabel { question1: \" some text label\" money }");
		question = (AnswerableQuestion) form.getStatements().get(0);
		Assert.assertEquals(MoneyType.class, question.getType().getClass());
	}

	@Test
	public void testTypeValues() throws ParseError {
		Form form = (Form) parser.parseNode("form somelabel { question1: \" some text label\" true }");
		ComputedQuestion question = (ComputedQuestion) form.getStatements().get(0);
		Assert.assertEquals(Bool.class, question.getExpr().getClass());
		form = (Form) parser.parseNode("form somelabel { question1: \" some text label\" 5 }");
		question = (ComputedQuestion) form.getStatements().get(0);
		Assert.assertEquals(Int.class, question.getExpr().getClass());
		form = (Form) parser.parseNode("form somelabel { question1: \" some text label\" \"some string\" }");
		question = (ComputedQuestion) form.getStatements().get(0);
		Assert.assertEquals(Text.class, question.getExpr().getClass());
		System.out.println(((Text) question.getExpr()).getRawValue());
		form = (Form) parser.parseNode("form somelabel { question1: \" some text label\" 101.1 }");
		question = (ComputedQuestion) form.getStatements().get(0);
		Assert.assertEquals(Money.class, question.getExpr().getClass());
	}

}
