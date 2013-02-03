package org.uva.sea.ql.test;

import junit.framework.Assert;

import org.junit.Test;
import org.uva.sea.ql.ast.elements.Form;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.common.ASTVisitor;
import org.uva.sea.ql.common.VisitorException;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.validation.AstValidationError;
import org.uva.sea.ql.validation.ValidationVisitor;

public class TestValidator extends TestExpressions {
	@Test
	public void TestValidatorVisitorFromFile() {
		try {
			Expr e = parser.parseFile();
			ASTVisitor visitor = new ValidationVisitor();
			Assert.assertTrue(Form.class.equals(e.getClass()));
			Form f = (Form) e;
			f.accept(visitor);
		} catch (ParseError ex) {
			Assert.fail("Parse Exception occured during test: "
					+ ex.getMessage());
		} catch (VisitorException ex) {
			Assert.fail("Visitor Exception occured during test: "
					+ ex.getMessage());
		}
	}

	@Test
	public void TestValidatorVisitorPositive() {
		try {
			Expr e = parser.parseFull(getQL());
			ASTVisitor visitor = new ValidationVisitor();
			Assert.assertTrue(Form.class.equals(e.getClass()));
			Form f = (Form) e;
			f.accept(visitor);
		} catch (ParseError ex) {
			Assert.fail("Parse Exception occured during test: "
					+ ex.getMessage());
		} catch (VisitorException ex) {
			Assert.fail("Visitor Exception occured during test: "
					+ ex.getMessage());
		}
	}

	@Test
	public void TestValidatorVisitorLeftBoolNegative() {
		boolean exceptionThrown = false;
		try {
			Expr e = parser.parseFull(getQL("money", "boolean", "boolean",
					"hasSoldHouse && (hasBoughtHouse || hasMaintLoan)"));
			ASTVisitor visitor = new ValidationVisitor();
			Assert.assertTrue(Form.class.equals(e.getClass()));
			Form f = (Form) e;
			f.accept(visitor);
		} catch (AstValidationError ex) {
			exceptionThrown = true;
		} catch (VisitorException ex) {
			Assert.fail("unexpected exception occured: " + ex.getMessage());
		}
		Assert.assertEquals(true, exceptionThrown);
		exceptionThrown = false;
		try {
			Expr e = parser.parseFull(getQL("boolean", "money", "boolean",
					"hasSoldHouse && (hasBoughtHouse || hasMaintLoan)"));
			ASTVisitor visitor = new ValidationVisitor();
			Assert.assertTrue(Form.class.equals(e.getClass()));
			Form f = (Form) e;
			f.accept(visitor);
		} catch (AstValidationError ex) {
			exceptionThrown = true;

		} catch (VisitorException ex) {
			Assert.fail("unexpected exception occured: " + ex.getMessage());
		}
		Assert.assertEquals(true, exceptionThrown);
	}

	@Test
	public void TestValidatorVisitorRightBoolNegative() {
		boolean exceptionThrown = false;
		try {
			Expr e = parser.parseFull(getQL("boolean", "money", "boolean",
					"hasSoldHouse && (hasBoughtHouse || hasMaintLoan)"));
			ASTVisitor visitor = new ValidationVisitor();
			Assert.assertTrue(Form.class.equals(e.getClass()));
			Form f = (Form) e;
			f.accept(visitor);
		} catch (AstValidationError ex) {
			exceptionThrown = true;
		} catch (VisitorException ex) {
			Assert.fail("unexpected exception occured: " + ex.getMessage());
		}
		Assert.assertEquals(true, exceptionThrown);
		exceptionThrown = false;
		try {
			Expr e = parser.parseFull(getQL("boolean", "boolean", "money",
					"hasSoldHouse && (hasBoughtHouse || hasMaintLoan)"));
			ASTVisitor visitor = new ValidationVisitor();
			Assert.assertTrue(Form.class.equals(e.getClass()));
			Form f = (Form) e;
			f.accept(visitor);
		} catch (AstValidationError ex) {
			exceptionThrown = true;
		} catch (VisitorException ex) {
			Assert.fail("unexpected exception occured: " + ex.getMessage());
		}
		Assert.assertEquals(true, exceptionThrown);
	}

	private String getQL() {
		return getQL("boolean", "boolean", "boolean",
				"hasSoldHouse && (hasBoughtHouse || hasMaintLoan)");
	}

	private String getQL(String hasSoldHouseType, String hasBoughHouseType,
			String hasMaintLoanType, String ifCondition) {
		return "form Box1HouseOwning {\n"
				+ "taxId: \"Please enter your tax identification number\" string\n"
				+ "hasSoldHouse: \"Did you sell a house in 2010?\" "
				+ hasSoldHouseType
				+ "\n"
				+ "hasBoughtHouse: \"Did you by a house in 2010?\" "
				+ hasBoughHouseType
				+ "\n"
				+ "hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" "
				+ hasMaintLoanType
				+ "\n"
				+ "if ("
				+ ifCondition
				+ ") {\n"
				+ " sellingPrice: \"Price the house was sold for:\" money\n"
				+ " privateDebt: \"Private debts for the sold house:\" money\n"
				+ " valueResidue: \"Value residue:\" money(sellingPrice - privateDebt)\n"
				+ " if(valueResidue > 20000) {\n"
				+ " 	askedForPermissionValRes20 : \"Did you ask for permission to have a value residue larger than 20000?\" boolean\n"
				+ " }\n"
				+ "  /**\n"
				+ "  this is a multi line comment\n"
				+ "  */\n"
				+ "  if(sellingPrice < 80000) {\n"
				+ " 	askedForPermissionSelPri80 : \"Did you ask for permission to sell a house for less than 80000?\" boolean\n"
				+ " 	if(askedForPermissionSelPri80) {\n"
				+ " 		askedForPermissionSelPri80Who : \"Who did you ask for permission to sell a house for less than 80000?\" boolean\n"
				+ "	}\n" + " }\n" + " }\n" + "}\n";
	}
}
