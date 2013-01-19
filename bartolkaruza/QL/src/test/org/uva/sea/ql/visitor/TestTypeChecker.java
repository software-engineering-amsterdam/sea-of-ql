package org.uva.sea.ql.visitor;

import junit.framework.Assert;

import org.junit.Test;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.antlr.IParse;
import org.uva.sea.ql.parser.antlr.ParseError;
import org.uva.sea.ql.utility.ErrorHandler;
import org.uva.sea.ql.visitor.TypeChecker;

public class TestTypeChecker {

	IParse parser = new ANTLRParser();

	@Test
	public void testInvalidTypes() throws ParseError {
		Form form = (Form) parser.parseNode("form somelabel { if(1>\"kaas\") { question1: \" some text label\" boolean} }");
		form.accept(new TypeChecker());
		form = (Form) parser.parseNode("form somelabel { if(1<\"kaas\") { question1: \" some text label\" boolean} }");
		form.accept(new TypeChecker());
		form = (Form) parser.parseNode("form somelabel { if(1>=\"kaas\") { question1: \" some text label\" boolean} }");
		form.accept(new TypeChecker());
		form = (Form) parser.parseNode("form somelabel { if(1<=\"kaas\") { question1: \" some text label\" boolean} }");
		form.accept(new TypeChecker());
		form = (Form) parser.parseNode("form somelabel { if(!\"kaas\") { question1: \" some text label\" boolean} }");
		form.accept(new TypeChecker());
		form = (Form) parser.parseNode("form somelabel { if(1+\"kaas\") { question1: \" some text label\" boolean} }");
		form.accept(new TypeChecker());
		form = (Form) parser.parseNode("form somelabel { if(1-\"kaas\") { question1: \" some text label\" boolean} }");
		form.accept(new TypeChecker());
		form = (Form) parser.parseNode("form somelabel { if(+\"kaas\") { question1: \" some text label\" boolean} }");
		form.accept(new TypeChecker());
		form = (Form) parser.parseNode("form somelabel { if(-\"kaas\") { question1: \" some text label\" boolean} }");
		form.accept(new TypeChecker());
		Assert.assertEquals(9, ErrorHandler.getInstance().getErrors().size());
		ErrorHandler.printErrors();
		ErrorHandler.getInstance().getErrors().clear();
	}

	@Test
	public void testValidTypes() throws ParseError {
		Form form = (Form) parser.parseNode("form somelabel { if(1>2) { question1: \" some text label\" boolean} }");
		form.accept(new TypeChecker());
		form = (Form) parser.parseNode("form somelabel { if(1<2) { question1: \" some text label\" boolean} }");
		form.accept(new TypeChecker());
		form = (Form) parser.parseNode("form somelabel { if(1>=2) { question1: \" some text label\" boolean} }");
		form.accept(new TypeChecker());
		form = (Form) parser.parseNode("form somelabel { if(1<=2) { question1: \" some text label\" boolean} }");
		form.accept(new TypeChecker());
		form = (Form) parser.parseNode("form somelabel { if(!true) { question1: \" some text label\" boolean} }");
		form.accept(new TypeChecker());
		form = (Form) parser.parseNode("form somelabel { if(true==true) { question1: \" some text label\" boolean} }");
		form.accept(new TypeChecker());
		form = (Form) parser.parseNode("form somelabel { if(false!=true) { question1: \" some text label\" boolean} }");
		form.accept(new TypeChecker());
		form = (Form) parser.parseNode("form somelabel { if(1+2) { question1: \" some text label\" boolean} }");
		form.accept(new TypeChecker());
		form = (Form) parser.parseNode("form somelabel { if(\"kaas\"+\"kaas\") { question1: \" some text label\" boolean} }");
		form.accept(new TypeChecker());
		form = (Form) parser.parseNode("form somelabel { if(1-2) { question1: \" some text label\" boolean} }");
		form.accept(new TypeChecker());
		form = (Form) parser.parseNode("form somelabel { if(+2) { question1: \" some text label\" boolean} }");
		form.accept(new TypeChecker());
		form = (Form) parser.parseNode("form somelabel { if(-2) { question1: \" some text label\" boolean} }");
		form.accept(new TypeChecker());
		Assert.assertEquals(0, ErrorHandler.getInstance().getErrors().size());
		System.out.println();
		System.out.println();
		ErrorHandler.printErrors();
		ErrorHandler.getInstance().getErrors().clear();
	}

	@Test
	public void testTypeChecker() throws ParseError {
		Form form = (Form) parser.parseNode("form somelabel { if(1==kaas) { question1: \" some text label\" boolean} }");
		form.accept(new TypeChecker());
		ErrorHandler.printErrors();
		ErrorHandler.getInstance().getErrors().clear();
	}

}
