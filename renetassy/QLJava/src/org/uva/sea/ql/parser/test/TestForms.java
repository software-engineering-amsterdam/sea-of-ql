package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.ast.Add;
import org.uva.sea.ql.ast.And;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.GT;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.Int;
import org.uva.sea.ql.ast.LEq;
import org.uva.sea.ql.ast.LT;
import org.uva.sea.ql.ast.Mul;
import org.uva.sea.ql.ast.Not;
import org.uva.sea.ql.parser.antlr.ANTLRParser;


@RunWith(Parameterized.class)
public class TestForms {

	private IParse parser;

	//@Parameters
	//public static List<Object[]> theParsers() {
	  //return Arrays.asList(
		//	  new Object[] {new JACCParser()}, 
			//  new Object[] {new RatsParser()},
			 // new Object[] {new ANTLRParser()}
			 //);
	//}*/
	
	@Parameters
	public static List<Object[]> theParsers() {

		List<Object[]> antlrList = new ArrayList<Object[]>();
		antlrList.add(new Object[] {new ANTLRParser()});
		return antlrList;

	} 

	
	public TestForms(IParse parser) {
		this.parser = parser;
	}

	
	@Test
	public void Test1() throws ParseError {
		
		assertEquals(Form.class, parser.parseForm("form abc { abc abc abc }").getClass());
		
	}
	
	

}
