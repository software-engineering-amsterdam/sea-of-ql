package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.ast.statement.Form;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.jacc.JaccQLParser;
import org.uva.sea.ql.visitor.TypeCheckVisitor;

import com.google.common.base.Joiner;

@RunWith(Parameterized.class)
public class TestSemanticConsistency {

	private IParse parser;
	
	private final String sourceFile;
	private final int expectedNumberOfTypeErrors;

	public TestSemanticConsistency(Object sourceFile, Object expectedTypeErrNum) {
		this.sourceFile = sourceFile.toString();
		this.expectedNumberOfTypeErrors = (int)expectedTypeErrNum;
	}

	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] { 
					{ "semanticVarUndef.ql", 1}, {"semanticCyclicDep.ql", 1}, 
					{"semanticExpressionType1.ql", 1}, {"semanticExpressionType2.ql", 1}, {"semanticExpressionType3.ql", 1}, {"semanticExpressionType4.ql", 1}, {"semanticExpressionType5.ql", 0} };
		return Arrays.asList(data);
	}

	@Before
	public void setup() {
		parser = new JaccQLParser();
	}

	@Test
	public void test() throws ParseError, IOException {
		final String qlText = readResource(sourceFile);
		Form form = parser.parseForm(qlText);
		assertNotNull(form);
		
		TypeCheckVisitor visitor = new TypeCheckVisitor();
		form.accept(visitor);
		
		assertNotNull(visitor.getTypeCheckErrorIterator());
		assertEquals(expectedNumberOfTypeErrors, count(visitor.getTypeCheckErrorIterator()));
		
		System.out.println("==" + this.sourceFile);
		System.out.println(Joiner.on('\n').join(visitor.getTypeCheckErrorIterator()));
	}

	private String readResource(final String resourceName) throws IOException {
		return IOUtils.toString(this.getClass().getResourceAsStream(
				"resources\\" + resourceName));
	}
	
	private int count(final Iterator it){
		int i = 0;
		while(it.hasNext()){
			it.next();
			i++;
		}
		return i;
	}

}
