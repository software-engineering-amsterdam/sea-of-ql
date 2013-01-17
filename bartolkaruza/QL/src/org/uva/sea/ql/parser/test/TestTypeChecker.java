package org.uva.sea.ql.parser.test;

import junit.framework.Assert;

import org.junit.Test;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.utility.ErrorHandler;
import org.uva.sea.ql.visitor.TypeCheckVisitor;

public class TestTypeChecker {
	
	IParse parser = new ANTLRParser();
	
	@Test
	public void testInvalidTypes() throws ParseError {
		Form form = (Form) parser.parseNode("form somelabel { if(1>\"kaas\") { question1: \" some text label\" boolean} }");
		form.accept(new TypeCheckVisitor());
		form = (Form) parser.parseNode("form somelabel { if(1<\"kaas\") { question1: \" some text label\" boolean} }");
		form.accept(new TypeCheckVisitor());
		form = (Form) parser.parseNode("form somelabel { if(1>=\"kaas\") { question1: \" some text label\" boolean} }");
		form.accept(new TypeCheckVisitor());
		form = (Form) parser.parseNode("form somelabel { if(1<=\"kaas\") { question1: \" some text label\" boolean} }");
		form.accept(new TypeCheckVisitor());
		form = (Form) parser.parseNode("form somelabel { if(!\"kaas\") { question1: \" some text label\" boolean} }");
		form.accept(new TypeCheckVisitor());
		form = (Form) parser.parseNode("form somelabel { if(1!=\"kaas\") { question1: \" some text label\" boolean} }");
		form.accept(new TypeCheckVisitor());
		form = (Form) parser.parseNode("form somelabel { if(1==\"kaas\") { question1: \" some text label\" boolean} }");
		form.accept(new TypeCheckVisitor());
		form = (Form) parser.parseNode("form somelabel { if(1+\"kaas\") { question1: \" some text label\" boolean} }");
		form.accept(new TypeCheckVisitor());
		form = (Form) parser.parseNode("form somelabel { if(1-\"kaas\") { question1: \" some text label\" boolean} }");
		form.accept(new TypeCheckVisitor());
//		form = (Form) parser.parseNode("form somelabel { if(\"kaas\"++) { question1: \" some text label\" boolean} }");
//		form.accept(new TypeCheckVisitor());
//		form = (Form) parser.parseNode("form somelabel { if(\"kaas\"--) { question1: \" some text label\" boolean} }");
//		form.accept(new TypeCheckVisitor());
		form = (Form) parser.parseNode("form somelabel { if(1<\"kaas\") { question1: \" some text label\" boolean} }");
		form.accept(new TypeCheckVisitor());
		Assert.assertEquals(7, ErrorHandler.getInstance().getErrors().size()); // TODO Should be 10 when done implementing
	}
	
	@Test
	public void testValidTypes() throws ParseError {
		
	}
	
	@Test
	public void testTypeChecker() throws ParseError {
		Form form = (Form) parser.parseNode("form somelabel { if(1==kaas) { question1: \" some text label\" boolean} }");
		form.accept(new TypeCheckVisitor());
		ErrorHandler.getInstance().printErrors();
	}

}
