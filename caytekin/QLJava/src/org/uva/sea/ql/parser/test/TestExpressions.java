package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.parser.antlr.ANTLRAddsParser;
import org.uva.sea.ql.parser.antlr.ANTLRExpressionParser;
import org.uva.sea.ql.parser.antlr.ANTLRParser;


public class TestExpressions {



	public static void main(String[] args) {
		ANTLRExpressionParser aep = new ANTLRExpressionParser();
		try {
			System.out.println("Class is: " + aep.parse("a + 45 + 53 * 2").getClass()); 
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

			
}
