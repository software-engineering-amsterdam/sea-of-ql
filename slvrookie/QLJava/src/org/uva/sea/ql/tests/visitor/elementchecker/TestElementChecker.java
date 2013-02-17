package org.uva.sea.ql.tests.visitor.elementchecker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.antlr.IParse;
import org.uva.sea.ql.parser.antlr.ParseError;
import org.uva.sea.ql.visitors.typechecking.ElementChecker;
import org.uva.sea.ql.visitors.utils.Errors;
import org.uva.sea.ql.visitors.utils.State;

public class TestElementChecker {

	private final State state = new State();
	private final Errors errors = new Errors();
	private final IParse parser = new ANTLRParser();
	
	@Test
	public void testMultipleDecls1() throws ParseError {
		String form1 = "form bigBox1HouseOwning {"
				+ "   		hasSoldHouse1: \"Did you sell a house in 2010?\" int \n"
				+ "   		hasSoldHouse1: \"Did you by a house in 2010?\" boolean \n }";
		
		ElementChecker.check(parser.parseForm(form1), state, errors);
		assertEquals(1 , errors.returnErrors().size());
	}
	
	@Test
	public void testMultipleDecls2() throws ParseError {
		String form1 = "form bigBox1HouseOwning {"
				+ "   		hasSoldHouse1: \"Did you sell a house in 2010?\" int \n"
				+ "   		hasSoldHouse1: \"Did you by a house in 2010?\" int \n }";
		
		ElementChecker.check(parser.parseForm(form1), state, errors);
		assertEquals(1 , errors.returnErrors().size());
	}
	
	@Test
	public void testNestedMultipleDecls1() throws ParseError {
		String form1 = "form bigBox1HouseOwning {"
				+ "   		hasSoldHouse1: \"Did you sell a house in 2010?\" int \n"
				+ "   		hasSoldHouse2: \"Did you by a house in 2010?\" int \n "
				+ "   			if (true){ \n"
				+ "     			hasSoldHouse1: \"Value residue:\" int \n }}" ;
		
		ElementChecker.check(parser.parseForm(form1), state, errors);
		assertEquals(1 , errors.returnErrors().size());
	}
	
	@Test
	public void testUndeclaredQuestion1() throws ParseError {
		String form1 = "form bigBox1HouseOwning {"
				+ "   		hasSoldHouse1: \"Did you sell a house in 2010?\" int \n"
				+ "   		hasSoldHouse2: \"Did you by a house in 2010?\" int \n "
				+ "   			if (hasSoldHouse3){ \n"
				+ "     			hasSoldHouse4: \"Value residue:\" int \n }}" ;
		
		ElementChecker.check(parser.parseForm(form1), state, errors);
		assertEquals(2 , errors.returnErrors().size());
	}
	
	@Test
	public void testCyclicDependency1() throws ParseError {
		String form1 = "form bigBox1HouseOwning {"
				+ "   		hasSoldHouse1: \"Did you sell a house in 2010?\" int(hasSoldHouse2) \n"
				+ "   		hasSoldHouse2: \"Did you by a house in 2010?\" int(hasSoldHouse1) \n "
				+ "     			}" ;
		
		ElementChecker.check(parser.parseForm(form1), state, errors);
		assertEquals(1 , errors.returnErrors().size());
	}
	
	@Test
	public void testCyclicDependency2() throws ParseError {
		String form1 = "form bigBox1HouseOwning {"
				+ "   		hasSoldHouse1: \"Did you sell a house in 2010?\" boolean(hasSoldHouse4) \n"
				+ "   			if (hasSoldHouse1){ \n"
				+ "     			hasSoldHouse4: \"Value residue:\" boolean \n }}" ;
		
		ElementChecker.check(parser.parseForm(form1), state, errors);
		assertEquals(1 , errors.returnErrors().size());
	}
	
	@Test
	public void testUndeclaredQuestion2() throws ParseError {
		String form1 = "form bigBox1HouseOwning {"
				+ "   		hasSoldHouse1: \"Did you sell a house in 2010?\" int \n"
				+ "   		hasSoldHouse2: \"Did you by a house in 2010?\" int \n "
				+ "   			if (true){ \n"
				+ "     			hasSoldHouse4: \"Value residue:\" int(hasSoldHouse5) \n }}" ;
		
		ElementChecker.check(parser.parseForm(form1), state, errors);
		assertEquals(1 , errors.returnErrors().size());
	}
	
	@Test
	public void testNestedMultipleDecls2() throws ParseError {
		String form1 = "form bigBox1HouseOwning {"
				+ "   		hasSoldHouse1: \"Did you sell a house in 2010?\" int \n"
				+ "   		hasSoldHouse2: \"Did you by a house in 2010?\" int \n "
				+ "   			if (false){ \n"
				+ "     			hasSoldHouse3: \"Value residue:\" int \n }" 
				+ "		 				else {"
				+ "							hasSoldHouse1: \"Value residue:\" int(7-3) }}";
		
		ElementChecker.check(parser.parseForm(form1), state, errors);
		assertEquals(1 , errors.returnErrors().size());
	}
	
	@Test
	public void testIfThenElseComputed() throws ParseError {
		String form1 = "form bigBox1HouseOwning {"
				+ "   		hasSoldHouse1: \"Did you sell a house in 2010?\" int \n"
				+ "   		hasSoldHouse2: \"Did you by a house in 2010?\" int \n "
				+ "   			if (false){ \n"
				+ "     			hasSoldHouse3: \"Value residue:\" int(hasSoldHouse1 * hasSoldHouse2) \n }" 
				+ "		 				else {"
				+ "							hasSoldHouse4: \"Value residue:\" int(hasSoldHouse1 / hasSoldHouse2) }}";
		
		ElementChecker.check(parser.parseForm(form1), state, errors);
		assertEquals(0 , errors.returnErrors().size());
	}
	
	@Test
	public void testAssignementInt() throws ParseError {
		String form1 = "form bigBox1HouseOwning {"
				+ "   		hasSoldHouse1: \"Did you sell a house in 2010?\" int \n"
				+ "   		 }";
		
		ElementChecker.check(parser.parseForm(form1), state, errors);
		assertTrue(state.getTypeEnv().get("hasSoldHouse1").isCompatibleToIntType());
	}
	
	@Test
	public void testAssignementMoney() throws ParseError {
		String form1 = "form bigBox1HouseOwning {"
				+ "   		hasSoldHouse1: \"Did you sell a house in 2010?\" money \n"
				+ "   		 }";
		
		ElementChecker.check(parser.parseForm(form1), state, errors);
		assertTrue(state.getTypeEnv().get("hasSoldHouse1").isCompatibleToMoneyType());
	}
	
	@Test
	public void testAssignementBoolean() throws ParseError {
		String form1 = "form bigBox1HouseOwning {"
				+ "   		hasSoldHouse1: \"Did you sell a house in 2010?\" boolean \n"
				+ "   		 }";
		
		ElementChecker.check(parser.parseForm(form1), state, errors);
		assertTrue(state.getTypeEnv().get("hasSoldHouse1").isCompatibleToBoolType());
	}
	
	@Test
	public void testAssignementString() throws ParseError {
		String form1 = "form bigBox1HouseOwning {"
				+ "   		hasSoldHouse1: \"Did you sell a house in 2010?\" string \n"
				+ "   		 }";
		
		ElementChecker.check(parser.parseForm(form1), state, errors);
		assertTrue(state.getTypeEnv().get("hasSoldHouse1").isCompatibleToStringType());
	}
	
	@Test
	public void testExprTypeConsistencyInt1() throws ParseError {
		String form1 = "form bigBox1HouseOwning {"
				+ "   		hasSoldHouse1: \"Did you sell a house in 2010?\" int(3.00) \n"
				+ "   		 }";
		
		ElementChecker.check(parser.parseForm(form1), state, errors);
		assertEquals(1 , errors.returnErrors().size());
	}
	
	@Test
	public void testExprTypeConsistencyInt2() throws ParseError {
		String form1 = "form bigBox1HouseOwning {"
				+ "   		hasSoldHouse1: \"Did you sell a house in 2010?\" int(true) \n"
				+ "   		 }";
		
		ElementChecker.check(parser.parseForm(form1), state, errors);
		assertEquals(1 , errors.returnErrors().size());
	}
	
	@Test
	public void testExprTypeConsistencyInt3() throws ParseError {
		String form1 = "form bigBox1HouseOwning {"
				+ "   		hasSoldHouse1: \"Did you sell a house in 2010?\" int(\"kek\") \n"
				+ "   		 }";
		
		ElementChecker.check(parser.parseForm(form1), state, errors);
		assertEquals(1 , errors.returnErrors().size());
	}
	
	@Test
	public void testExprTypeConsistencyInt4() throws ParseError {
		String form1 = "form bigBox1HouseOwning {"
				+ "   		hasSoldHouse1: \"Did you sell a house in 2010?\" int(3) \n"
				+ "   		 }";
		
		ElementChecker.check(parser.parseForm(form1), state, errors);
		assertEquals(0 , errors.returnErrors().size());
	}
	
	@Test
	public void testExprTypeConsistencyMoney1() throws ParseError {
		String form1 = "form bigBox1HouseOwning {"
				+ "   		hasSoldHouse1: \"Did you sell a house in 2010?\" money(\"kek\") \n"
				+ "   		 }";
		
		ElementChecker.check(parser.parseForm(form1), state, errors);
		assertEquals(1 , errors.returnErrors().size());
	}
	
	@Test
	public void testExprTypeConsistencyMoney2() throws ParseError {
		String form1 = "form bigBox1HouseOwning {"
				+ "   		hasSoldHouse1: \"Did you sell a house in 2010?\" money(true) \n"
				+ "   		 }";
		
		ElementChecker.check(parser.parseForm(form1), state, errors);
		assertEquals(1 , errors.returnErrors().size());
	}
	
	@Test
	public void testExprTypeConsistencyMoney3() throws ParseError {
		String form1 = "form bigBox1HouseOwning {"
				+ "   		hasSoldHouse1: \"Did you sell a house in 2010?\" money(3) \n"
				+ "   		 }";
		
		ElementChecker.check(parser.parseForm(form1), state, errors);
		assertEquals(1 , errors.returnErrors().size());
	}
	
	@Test
	public void testExprTypeConsistencyMoney4() throws ParseError {
		String form1 = "form bigBox1HouseOwning {"
				+ "   		hasSoldHouse1: \"Did you sell a house in 2010?\" money(3.00) \n"
				+ "   		 }";
		
		ElementChecker.check(parser.parseForm(form1), state, errors);
		assertEquals(0 , errors.returnErrors().size());
	}
	
	@Test
	public void testExprTypeConsistencyString1() throws ParseError {
		String form1 = "form bigBox1HouseOwning {"
				+ "   		hasSoldHouse1: \"Did you sell a house in 2010?\" string(3) \n"
				+ "   		 }";
		
		ElementChecker.check(parser.parseForm(form1), state, errors);
		assertEquals(1 , errors.returnErrors().size());
	}
	
	@Test
	public void testExprTypeConsistencyString2() throws ParseError {
		String form1 = "form bigBox1HouseOwning {"
				+ "   		hasSoldHouse1: \"Did you sell a house in 2010?\" string(3.00) \n"
				+ "   		 }";
		
		ElementChecker.check(parser.parseForm(form1), state, errors);
		assertEquals(1 , errors.returnErrors().size());
	}
	
	@Test
	public void testExprTypeConsistencyString3() throws ParseError {
		String form1 = "form bigBox1HouseOwning {"
				+ "   		hasSoldHouse1: \"Did you sell a house in 2010?\" string(false) \n"
				+ "   		 }";
		
		ElementChecker.check(parser.parseForm(form1), state, errors);
		assertEquals(1 , errors.returnErrors().size());
	}
	
	@Test
	public void testExprTypeConsistencyString4() throws ParseError {
		String form1 = "form bigBox1HouseOwning {"
				+ "   		hasSoldHouse1: \"Did you sell a house in 2010?\" string(\"kek\") \n"
				+ "   		 }";
		
		ElementChecker.check(parser.parseForm(form1), state, errors);
		assertEquals(0 , errors.returnErrors().size());
	}
	
	@Test
	public void testExprTypeConsistencyBoolean1() throws ParseError {
		String form1 = "form bigBox1HouseOwning {"
				+ "   		hasSoldHouse1: \"Did you sell a house in 2010?\" boolean(3) \n"
				+ "   		 }";
		
		ElementChecker.check(parser.parseForm(form1), state, errors);
		assertEquals(1 , errors.returnErrors().size());
	}
	
	@Test
	public void testExprTypeConsistencyBoolean2() throws ParseError {
		String form1 = "form bigBox1HouseOwning {"
				+ "   		hasSoldHouse1: \"Did you sell a house in 2010?\" boolean(3.00) \n"
				+ "   		 }";
		
		ElementChecker.check(parser.parseForm(form1), state, errors);
		assertEquals(1 , errors.returnErrors().size());
	}
	
	@Test
	public void testExprTypeConsistencyBoolean3() throws ParseError {
		String form1 = "form bigBox1HouseOwning {"
				+ "   		hasSoldHouse1: \"Did you sell a house in 2010?\" boolean(\"kkthxbye\") \n"
				+ "   		 }";
		
		ElementChecker.check(parser.parseForm(form1), state, errors);
		assertEquals(1 , errors.returnErrors().size());
	}
	
	@Test
	public void testExprTypeConsistencyBoolean4() throws ParseError {
		String form1 = "form bigBox1HouseOwning {"
				+ "   		hasSoldHouse1: \"Did you sell a house in 2010?\" boolean(true) \n"
				+ "   		 }";
		
		ElementChecker.check(parser.parseForm(form1), state, errors);
		assertEquals(0 , errors.returnErrors().size());
	}
	
	@Test
	public void testConditionInt() throws ParseError {
		String form1 = "form bigBox1HouseOwning {"
				+ "   		hasSoldHouse1: \"Did you sell a house in 2010?\" int \n"
				+ "   		hasSoldHouse2: \"Did you sell a house in 2010?\" int \n"
				+ "   			if (hasSoldHouse1 + hasSoldHouse2){ \n"
				+ "   				hasSoldHouse3: \"Price the house was sold for:\" int \n }" 
				+ "   		 }";
		
		ElementChecker.check(parser.parseForm(form1), state, errors);
		assertEquals(1 , errors.returnErrors().size());
	}
	
	@Test
	public void testConditionMoney() throws ParseError {
		String form1 = "form bigBox1HouseOwning {"
				+ "   		hasSoldHouse1: \"Did you sell a house in 2010?\" money \n"
				+ "   		hasSoldHouse2: \"Did you sell a house in 2010?\" money \n"
				+ "   			if (hasSoldHouse1 + hasSoldHouse2){ \n"
				+ "   				hasSoldHouse3: \"Price the house was sold for:\" int \n }" 
				+ "   		 }";
		
		ElementChecker.check(parser.parseForm(form1), state, errors);
		assertEquals(1 , errors.returnErrors().size());
	}
	
	@Test
	public void testConditionString() throws ParseError {
		String form1 = "form bigBox1HouseOwning {"
				+ "   		hasSoldHouse1: \"Did you sell a house in 2010?\" string \n"
				+ "   		hasSoldHouse2: \"Did you sell a house in 2010?\" money \n"
				+ "   			if (hasSoldHouse1){ \n"
				+ "   				hasSoldHouse3: \"Price the house was sold for:\" int \n }" 
				+ "   		 }";
		
		ElementChecker.check(parser.parseForm(form1), state, errors);
		assertEquals(1 , errors.returnErrors().size());
	}
	
	@Test
	public void testConditionBoolean() throws ParseError {
		String form1 = "form bigBox1HouseOwning {"
				+ "   		hasSoldHouse1: \"Did you sell a house in 2010?\" money \n"
				+ "   		hasSoldHouse2: \"Did you sell a house in 2010?\" money \n"
				+ "   			if (hasSoldHouse1 > hasSoldHouse2){ \n"
				+ "   				hasSoldHouse3: \"Price the house was sold for:\" int \n }" 
				+ "   		 }";
		
		ElementChecker.check(parser.parseForm(form1), state, errors);
		assertEquals(0 , errors.returnErrors().size());
	}
	
}
