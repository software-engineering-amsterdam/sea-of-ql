package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.ast.form.BodyElements;
import org.uva.sea.ql.ast.form.ComputedQuestion;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.IfBlock;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.qlreader.InputReader;

@RunWith(Parameterized.class)
public class TestForm {
 
	private final IParse parser;
	private final String path="/home/jahn/workspace1/jahnestacado/jahnestacado/QLJava/src/org/uva/sea/ql/qlreader/SampleCode.ql";
    private InputReader reader;
	@Parameters
	public static List<Object[]> theParser() {
        List<Object[]> listANTLR=  new ArrayList<Object[]>();
		listANTLR.add(new Object[] {new ANTLRParser()});
		return listANTLR;
	}

	public TestForm(IParse parser) {
		this.parser = parser;
		
		try {
			reader=new InputReader(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	

	
	
	@Test
	public void testForm() throws ParseError {
		assertEquals( Form.class, parser.parseForm(reader.getQLCode()).getClass());
		
	}
	
	@Test
	public void testQuestion() throws ParseError {
		assertEquals( Question.class, parser.parseQuestion("id : \"label\" int").getClass());
		assertEquals( Question.class, parser.parseQuestion("id : \"label\" boolean").getClass());
        assertEquals( Question.class, parser.parseQuestion("id : \"label\" string").getClass());

	
		
	}
	
	@Test
	public void testComputedQuestion() throws ParseError {
		assertEquals( ComputedQuestion.class, parser.parseComputedQuestion("id : \"label\" int (a-b)").getClass());
		assertEquals( ComputedQuestion.class, parser.parseComputedQuestion("id : \"label\" boolean (a-b)").getClass());
		assertEquals( ComputedQuestion.class, parser.parseComputedQuestion("id : \"label\" string (a-b)").getClass());
		
	}
	
	@Test
	public void testIfBlock() throws ParseError {
		
		assertEquals( IfBlock.class, parser.parseIfBlock("if (a>b) {id :\"label\"int   id :\"label\" int (a-b)}").getClass());
		assertEquals( IfBlock.class, parser.parseIfBlock(	"if (a>b) {id :\"label\" int  	if (a>b) {id :\"label\" int   id :\"label\" int (a-b) } id :\"label\" int (a-b)}").getClass());
	
	}
	
	@Test
	public void testBodyElements() throws ParseError {
		
		assertEquals( BodyElements.class, parser.parseBodyElements(reader.getQLCode()).getClass());
		assertEquals( BodyElements.class, parser.parseBodyElements(	"if (a>b) {id :\"label\" int  	if (a>b) {id :\"label\" int   id :\"label\" int (a-b) } id :\"label\" int (a-b)}").getClass());
	
	}

}