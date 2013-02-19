package org.uva.sea.ql.parser.test.types;

import static org.junit.Assert.assertTrue;
import org.junit.Test;



public class ExpressionTest {
	
	private boolean typeCheck(String src) {
		getParser().parseExpression(src).accept(typeChecker);
	}
	
	@Test
	public void testAdds() {
		assertTrue();
	}
	
}
