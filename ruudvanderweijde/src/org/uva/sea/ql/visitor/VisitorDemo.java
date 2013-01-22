package org.uva.sea.ql.visitor;

import java.util.ArrayList;
import java.util.HashMap;

import org.antlr.tool.Message;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.primary.Ident;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.parser.ANTLRParser;
import org.uva.sea.ql.parser.error.ParseError;
import org.uva.sea.ql.visitor.checker.ExpressionChecker;
import org.uva.sea.ql.visitor.checker.FormChecker;
import org.uva.sea.ql.visitor.printer.ExpressionVisitorPrinter;
import org.uva.sea.ql.visitor.printer.FormVisitorPrinter;

/*
 * This file is added to test visitors
 * and will be removed in the future 
 * and replaced by decent unittests.
 */
public class VisitorDemo {
	
    static public void main(String[] args) throws ParseError {
    	ANTLRParser parser = new ANTLRParser();
    	
//    	String exprString = "1 && -1";
    	String exprString = "true && true";
    	Expr expr = parser.parseExpression(exprString);
    	System.out.println("Visiting string: " + exprString);
    	expr.accept(new ExpressionVisitorPrinter());
    	
    	HashMap<Ident, Type> ExprMap = new HashMap<Ident, Type>();
    	ArrayList<Message> errors = new ArrayList<Message>();
    	
    	Boolean result = expr.accept(new ExpressionChecker(ExprMap, errors));
    	System.out.println("ExpressionResult done, result: " + result);
    	System.out.println("Errors: " + errors);
    	
    	// full form check
    	String testString = "";
    	testString += "form Box1HouseOwning {\n";
//    	testString += "   hasSoldHouse: \"Did you sell a house in 2010?\" boolean\n";
//    	testString += "   hasSoldHouse: \"Did you sell a house in 2010?\" boolean\n";
//    	testString += "   hasBoughtHouse: \"Did you by a house in 2010?\" boolean\n";
//    	testString += "   hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean\n";
//    	testString += "   if (hasSoldHouse == true) {\n";
//    	testString += "     sellingPrice1: \"Price the house was sold for:\" integer\n";
//    	testString += "   	if (anotherIf) {\n";
//    	testString += "     	sellingPrice1: \"Price the house was sold for:\" integer\n";
//    	testString += "   	}\n";
//    	testString += "     privateDebt1: \"Private debts for the sold house:\" integer\n";
//    	testString += "     valueResidue1: \"Value residue:\" integer(sellingPrice - privateDebt)\n";
//    	testString += "	  } else {\n";
//    	testString += "     sellingPrice2: \"Price the house was sold for:\" integer\n";
//    	testString += "     privateDebt2: \"Private debts for the sold house:\" integer\n";
//    	testString += "     valueResidue2: \"Value residue:\" integer(sellingPrice - privateDebt)\n";
//    	testString += "   }\n";
//    	testString += "   finalQuestion: \"Please confirm that you have filled in everything correctly?\" boolean\n";
//    	testString += "   terms: \"I accept the terms... etc\" boolean\n";
    	testString += "}\n";
    	    	
		Form form = parser.parseForm(testString);
		form.accept(new FormVisitorPrinter());
		System.out.println("----- Now running FormChecker: ------");
		form.accept(new FormChecker());
    }
}