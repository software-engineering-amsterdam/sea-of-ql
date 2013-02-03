package org.uva.sea.ql.ast.expr.value;

import junit.framework.Assert;

import org.junit.Test;
import org.uva.sea.ql.ast.AnswerableQuestion;
import org.uva.sea.ql.ast.ComputedQuestion;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.expr.type.BoolType;
import org.uva.sea.ql.ast.expr.type.IntType;
import org.uva.sea.ql.ast.expr.type.MoneyType;
import org.uva.sea.ql.ast.expr.type.TextStringType;
import org.uva.sea.ql.error.ParseError;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

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
		Assert.assertEquals(TextStringType.class, question.getType().getClass());
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
		Assert.assertEquals(TextString.class, question.getExpr().getClass());
		System.out.println(((TextString) question.getExpr()).getValue());
		form = (Form) parser.parseNode("form somelabel { question1: \" some text label\" 10.01 }");
		question = (ComputedQuestion) form.getStatements().get(0);
		Assert.assertEquals(Money.class, question.getExpr().getClass());
	}

}
