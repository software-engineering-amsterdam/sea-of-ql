package org.uva.sea.ql.parser.antlr;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.visitor.IFormVisitor;
import org.uva.sea.ql.visitor.check.CheckFormCorrectnessVisitor;
import org.uva.sea.ql.visitor.check.TypeCheckExpressionVisitor;
import org.uva.sea.ql.visitor.gui.FormRenderer;

public class QLRun {

	public static void main(String[] args) throws Exception {
		ANTLRParser parser = new ANTLRParser();
		//Form f = parser.parseForm("form abc {ding1:\"ding\" boolean if (ding1) { ding2:\"bla2\" boolean}}");
		
		Form f2 = parser.parseForm("form Box1HouseOwning {\n	valueHouse: “Value of house?” int\n	computeValue: “Double value of house:” int(2 * valueHouse)\n		hasSoldHouse: “Did you sell a house in 2010?” boolean\n   hasBoughtHouse: “Did you buy a house in 2010?” boolean\n   hasMaintLoan: “Did you enter a loan for maintenance/reconstruction?”\nboolean\n   if (hasSoldHouse) {\n     sellingPrice: “Price the house was sold for:” money\n     privateDebt: “Private debts for the sold house:” money\n     valueResidue: “Value residue:” money(sellingPrice - privateDebt)\n   }\n}");
		IFormVisitor dupVis = new CheckFormCorrectnessVisitor();
		f2.accept(dupVis);
		//IfStatement fs = parser.parseIf("if (ding1) { ding2:\"bla2\" boolean}");
		//System.out.println("parse: " + parser.parse("3 * (2+3+4+5+6)"));
//		System.out.println(dupVis.returnErrorMsgs());
//		System.out.println(dupVis.returnWarningMsgs());
//		System.out.println("form: " + f2);
		
		Expr exp = parser.parse("5 * 3");
		TypeCheckExpressionVisitor exprVis = new TypeCheckExpressionVisitor();
		exp.accept(exprVis);
		System.out.println(exprVis.returnErrorMsgs());
		System.out.println(exprVis.returnWarningMsgs());
		System.out.println(exp.calculateValue());
		FormRenderer fr = new FormRenderer();
		f2.accept(fr);
		

	}

}
