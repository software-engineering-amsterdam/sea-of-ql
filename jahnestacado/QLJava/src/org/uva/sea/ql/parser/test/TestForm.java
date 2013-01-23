package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.antlr.runtime.ANTLRFileStream;
import org.junit.Test;
import org.uva.sea.ql.ast.form.Body;
import org.uva.sea.ql.ast.form.ComputedQuestion;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.IfBlock;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

public class TestForm {
	

	private final ANTLRParser parser;
	private final String question1 = "id : \"label\" int (a-b)";
	private final String question2 = "id : \"label\" int ";
	private final String ifBlock = "if (cond){".concat(question1).concat("").concat(question2)+ "}";

	public TestForm() {
		parser = new ANTLRParser();
	}

	@Test
	public void testForm() throws ParseError {
		try {
			final String path = "/src/org/uva/sea/ql/launcher/SampleCode.ql";
			File filePath = new File(path);
			ANTLRFileStream charStream = new ANTLRFileStream(filePath.getAbsolutePath());
			assertEquals(Form.class, parser.parseForm(charStream.toString()).getClass());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testQuestion() throws ParseError {
		assertEquals(Question.class, parser.parseQuestion("id : \"label\" int").getClass());
		assertEquals(Question.class,parser.parseQuestion("id : \"label\" boolean").getClass());
		assertEquals(Question.class,parser.parseQuestion("id : \"label\" string").getClass());
		assertEquals(Question.class,parser.parseQuestion("id : \"label\" money").getClass());

	}

	@Test
	public void testComputedQuestion() throws ParseError {
		assertEquals(ComputedQuestion.class,parser.parseComputedQuestion("id : \"label\" int (a-b)").getClass());
		assertEquals(ComputedQuestion.class,parser.parseComputedQuestion("id : \"label\" boolean (a-b)").getClass());
		assertEquals(ComputedQuestion.class,parser.parseComputedQuestion("id : \"label\" money (a-b)").getClass());
		assertEquals(ComputedQuestion.class,parser.parseComputedQuestion("id : \"label\" string (a-b)").getClass());

	}

	@Test
	public void testIfBlock() throws ParseError {

		assertEquals(IfBlock.class,parser.parseIfBlock("if (a>b) {id1 :\"label\"int   id2 :\"label\" int (a-b)}").getClass());
		assertEquals(IfBlock.class,parser.parseIfBlock("if (a>b) {id3 :\"label\" money  	if (a>b) {id4 :\"label\" int   id :\"label\" int (a-b) } id :\"label\" int (a-b)}").getClass());

	}

	@Test
	public void testBody() throws ParseError {

		assertEquals(Body.class,parser.parseBody("id1 :\"label\"int   id :\"label\"  int (a-b)").getClass());
		assertEquals(Body.class,parser.parseBody("if (name) { " + question1 + "" + question2 + "}").getClass());
		assertEquals(Body.class, parser.parseBody(ifBlock).getClass());
		assertEquals(Body.class,parser.parseBody("if (name) { " + question1 + "" + question2 + ifBlock+ "}").getClass());

	}
}