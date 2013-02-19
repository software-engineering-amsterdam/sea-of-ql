package org.uva.sea.ql.tests.type;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
import org.uva.sea.ql.ast.expr.primary.Ident;
import org.uva.sea.ql.message.Message;
import org.uva.sea.ql.parser.ANTLRParser;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.error.ParseError;
import org.uva.sea.ql.type.BooleanType;
import org.uva.sea.ql.type.IntegerType;
import org.uva.sea.ql.visitor.typeCheck.FormTypeCheckVisitor;
import org.uva.sea.ql.visitor.typeCheck.TypeMapper;

public class TestForm {
	private final IParse parser = new ANTLRParser();
	public static TypeMapper typeMapper = new TypeMapper();
	public static ArrayList<Message> errors = new ArrayList<Message>();
	private String formString = "form Box1HouseOwning {\n"
			+ "   hasSoldHouse: \"Did you sell a house in 2010?\" boolean\n"
			+ "   hasBoughtHouse: \"Did you by a house in 2010?\" boolean\n"
			+ "   hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean\n"
			+ "   if (hasSoldHouse) {\n"
			+ "     sellingPrice: \"Price the house was sold for:\" integer\n"
			+ "     privateDebt: \"Private debts for the sold house:\" integer\n"
			+ "     valueResidue: \"Value residue:\" integer(sellingPrice - privateDebt)\n"
			+ "   }\n" 
			+ "}\n";

	@Test
	public void testProvidedForm() throws ParseError {
		parser.parseForm(formString).accept(new FormTypeCheckVisitor(typeMapper, errors));
    	assertEquals(errors.size(), 0);
    	
		assertEquals(typeMapper.getType(new Ident("hasSoldHouse")).getClass(), BooleanType.class);
		assertEquals(typeMapper.getType(new Ident("hasBoughtHouse")).getClass(), BooleanType.class);
		assertEquals(typeMapper.getType(new Ident("hasMaintLoan")).getClass(), BooleanType.class);
		assertEquals(typeMapper.getType(new Ident("sellingPrice")).getClass(), IntegerType.class);
		assertEquals(typeMapper.getType(new Ident("privateDebt")).getClass(), IntegerType.class);
		assertEquals(typeMapper.getType(new Ident("valueResidue")).getClass(), IntegerType.class);
	}
}
