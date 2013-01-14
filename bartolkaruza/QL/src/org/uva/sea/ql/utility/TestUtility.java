package org.uva.sea.ql.utility;

import static org.junit.Assert.fail;

public class TestUtility {
	
	public static void printAndFailErrors() {
		if (ErrorHandler.getInstance().getErrors() != null && ErrorHandler.getInstance().getErrors().size() > 0) {
			for (QLError error : ErrorHandler.getInstance().getErrors()) {
				System.out.println(error.getCause());
			}
			fail();
		}
	}

}
