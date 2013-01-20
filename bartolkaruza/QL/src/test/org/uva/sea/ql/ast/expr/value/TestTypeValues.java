package org.uva.sea.ql.ast.expr.value;

import junit.framework.Assert;

import org.junit.Test;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.ast.expr.value.Bool;
import org.uva.sea.ql.ast.expr.value.Int;
import org.uva.sea.ql.ast.expr.value.Money;
import org.uva.sea.ql.ast.expr.value.TextString;
import org.uva.sea.ql.error.ParseError;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

public class TestTypeValues {

	IParse parser = new ANTLRParser();

	@Test
	public void testTypeDeclaration() throws ParseError {
		Form form = (Form) parser.parseNode("form somelabel { question1: \" some text label\" boolean }");
		Question question = (Question) form.getStatements().get(0);
		Assert.assertEquals(Bool.class, question.getExpression().getClass());
		form = (Form) parser.parseNode("form somelabel { question1: \" some text label\" integer }");
		question = (Question) form.getStatements().get(0);
		Assert.assertEquals(Int.class, question.getExpression().getClass());
		form = (Form) parser.parseNode("form somelabel { question1: \" some text label\" string }");
		question = (Question) form.getStatements().get(0);
		Assert.assertEquals(TextString.class, question.getExpression().getClass());
		form = (Form) parser.parseNode("form somelabel { question1: \" some text label\" money }");
		question = (Question) form.getStatements().get(0);
		Assert.assertEquals(Money.class, question.getExpression().getClass());
	}

	@Test
	public void testTypeValues() throws ParseError {
		Form form = (Form) parser.parseNode("form somelabel { question1: \" some text label\" true }");
		Question question = (Question) form.getStatements().get(0);
		Assert.assertEquals(Bool.class, question.getExpression().getClass());
		form = (Form) parser.parseNode("form somelabel { question1: \" some text label\" 5 }");
		question = (Question) form.getStatements().get(0);
		Assert.assertEquals(Int.class, question.getExpression().getClass());
		form = (Form) parser.parseNode("form somelabel { question1: \" some text label\" \"some string\" }");
		question = (Question) form.getStatements().get(0);
		Assert.assertEquals(TextString.class, question.getExpression().getClass());
		System.out.println(((TextString) question.getExpression()).getValue());
		form = (Form) parser.parseNode("form somelabel { question1: \" some text label\" 10.01 }");
		question = (Question) form.getStatements().get(0);
		Assert.assertEquals(Money.class, question.getExpression().getClass());
	}

}
