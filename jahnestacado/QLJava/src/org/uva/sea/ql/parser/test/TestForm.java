package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.parser.antlr.*;
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
		assertEquals( Form.class,parser.parseForm(reader.getQLCode()).getClass());
		System.out.println(reader.getQLCode());
	
		
	}

}