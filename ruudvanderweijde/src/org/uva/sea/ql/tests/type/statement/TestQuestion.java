package org.uva.sea.ql.tests.type.statement;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
import org.uva.sea.ql.ast.expr.primary.Ident;
import org.uva.sea.ql.message.Message;
import org.uva.sea.ql.parser.ANTLRParser;
import org.uva.sea.ql.parser.error.ParseError;
import org.uva.sea.ql.tests.IParse;
import org.uva.sea.ql.type.BooleanType;
import org.uva.sea.ql.type.IntegerType;
import org.uva.sea.ql.type.StringType;
import org.uva.sea.ql.visitor.typeCheck.FormTypeCheckVisitor;
import org.uva.sea.ql.visitor.typeCheck.TypeMapper;

public class TestQuestion {
	private final IParse parser = new ANTLRParser();
	private TypeMapper typeMapper = new TypeMapper();
	private static ArrayList<Message> errors = new ArrayList<Message>();

	public TestQuestion() {
		typeMapper = new TypeMapper();
		errors.clear();
	}

	@Test
	public void testQuestionTypes() throws ParseError {
		String formString = "";
		formString += "form Box1HouseOwning {\n";
		formString += "   sellingPrice: \"Price the house was sold for:\" integer\n";
		formString += "   hasSoldHouse: \"Did you sell a house in 2010?\" boolean\n";
		formString += "   reasonSelling: \"Why did you sell a house in 2010?\" string\n";
		formString += "}\n";

		parser.parseForm(formString).accept(new FormTypeCheckVisitor(typeMapper, errors));
		
		assertEquals(errors.size(), 0);
		assertEquals(typeMapper.getType(new Ident("sellingPrice")).getClass(), IntegerType.class);
		assertEquals(typeMapper.getType(new Ident("hasSoldHouse")).getClass(), BooleanType.class);
		assertEquals(typeMapper.getType(new Ident("reasonSelling")).getClass(), StringType.class);
	}
	
	@Test
	public void testDuplicateQuestionId() throws ParseError {
		String formString = "";
    	formString += "form Box1HouseOwning {\n";
    	formString += "   hasSoldHouse: \"Did you sell a house in 2010?\" boolean;\n";
    	formString += "   hasSoldHouse: \"Did you sell a house in 2010?\" boolean\n";
    	formString += "}\n";
    	
    	parser.parseForm(formString).accept(new FormTypeCheckVisitor(typeMapper, errors));
    	assertEquals(errors.size(), 1);
	} 
	
	@Test
	public void testQuestionUndefinedType() throws ParseError {
		String formString = "";
		formString += "form Box1HouseOwning {\n";
		formString += "		valueResidue: \"Value residue:\" integer(sellingPrice - privateDebt)\n";
		formString += "}\n";

		parser.parseForm(formString).accept(new FormTypeCheckVisitor(typeMapper, errors));
		
		assertEquals(errors.size(), 1);
		assertEquals(typeMapper.getType(new Ident("valueResidue")).getClass(), IntegerType.class);
	}

	@Test
	public void testComputedQuestion() throws ParseError {
		String formString = "";
		formString += "form Box1HouseOwning {\n";
		formString += "     sellingPrice: \"Price the house was sold for:\" integer\n";
		formString += "     privateDebt: \"Private debts for the sold house:\" integer\n";
		formString += "		valueResidue: \"Value residue:\" integer(sellingPrice - privateDebt)\n";
		formString += "}\n";

		parser.parseForm(formString).accept(new FormTypeCheckVisitor(typeMapper, errors));
		
		assertEquals(errors.size(), 0);
		assertEquals(typeMapper.getType(new Ident("sellingPrice")).getClass(), IntegerType.class);
		assertEquals(typeMapper.getType(new Ident("sellingPrice")).getClass(), IntegerType.class);
		assertEquals(typeMapper.getType(new Ident("sellingPrice")).getClass(),	IntegerType.class);

	}

	@Test
	public void testComputedQuestionErrorDifferentType() throws ParseError {
		String formString = "";
		formString += "form Box1HouseOwning {\n";
		formString += "     sellingPrice: \"Price the house was sold for:\" boolean\n";
		formString += "     privateDebt: \"Private debts for the sold house:\" integer\n";
		formString += "		valueResidue: \"Value residue:\" integer(sellingPrice - privateDebt)\n";
		formString += "}\n";

		parser.parseForm(formString).accept(new FormTypeCheckVisitor(typeMapper, errors));
		
		assertEquals(errors.size(), 1);	
		assertEquals(typeMapper.getType(new Ident("sellingPrice")).getClass(), BooleanType.class);
		assertEquals(typeMapper.getType(new Ident("privateDebt")).getClass(), IntegerType.class);
		assertEquals(typeMapper.getType(new Ident("valueResidue")).getClass(),	IntegerType.class);
	}

	@Test
	public void testComputedQuestionErrorInvalidType() throws ParseError {
		String formString = "";
		formString += "form Box1HouseOwning {\n";
		formString += "     sellingPrice: \"Price the house was sold for:\" integer\n";
		formString += "     privateDebt: \"Private debts for the sold house:\" integer\n";
		formString += "		valueResidue: \"Value residue:\" boolean(sellingPrice - privateDebt)\n";
		formString += "}\n";

		parser.parseForm(formString).accept(new FormTypeCheckVisitor(typeMapper, errors));
		assertEquals(typeMapper.getType(new Ident("sellingPrice")).getClass(), IntegerType.class);
		assertEquals(typeMapper.getType(new Ident("privateDebt")).getClass(), IntegerType.class);
		assertEquals(typeMapper.getType(new Ident("valueResidue")).getClass(),	BooleanType.class);
	}

	@Test
	public void testComputedQuestionErrorWrongType() throws ParseError {
		String formString = "";
		formString += "form Box1HouseOwning {\n";
		formString += "     sellingPrice: \"Price the house was sold for:\" boolean\n";
		formString += "     privateDebt: \"Private debts for the sold house:\" boolean\n";
		formString += "		valueResidue: \"Value residue:\" integer(sellingPrice - privateDebt)\n";
		formString += "}\n";

		parser.parseForm(formString).accept(new FormTypeCheckVisitor(typeMapper, errors));
		assertEquals(errors.size(), 1);
		assertEquals(typeMapper.getType(new Ident("sellingPrice")).getClass(), BooleanType.class);
		assertEquals(typeMapper.getType(new Ident("privateDebt")).getClass(), BooleanType.class);
		assertEquals(typeMapper.getType(new Ident("valueResidue")).getClass(), IntegerType.class);
	}
}
