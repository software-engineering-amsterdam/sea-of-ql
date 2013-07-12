package org.uva.sea.ql.parser.antlr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.visitor.check.CheckFormCorrectnessVisitor;
import org.uva.sea.ql.visitor.gui.FormRenderer;

public class QLRun {

	public static void main(String[] args) throws Exception {
		ANTLRParser parser = new ANTLRParser();
		//Form f = parser.parseForm("form abc {ding1:\"ding\" boolean if (ding1) { ding2:\"bla2\" boolean}}");
		
		//Form form1 = parser.parseForm("form Box1HouseOwning {\n	valueHouse: “Value of house?” int\n	computeValue: “Double value of house:” int(2 * valueHouse)\n		hasSoldHouse: “Did you sell a house in 2010?” boolean\n   hasBoughtHouse: “Did you buy a house in 2010?” boolean\n   hasMaintLoan: “Did you enter a loan for maintenance/reconstruction?”\nboolean\n   if (hasSoldHouse) {\n     sellingPrice: “Price the house was sold for:” money\n     privateDebt: “Private debts for the sold house:” money\n     valueResidue: “Value residue:” money(sellingPrice - privateDebt)\n   }\n}");
		Form form1 = parser.parseForm(readFile("C:\\Users\\Steven\\Documents\\GitHub\\sea-of-ql\\svombergen\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\test\\toParse.txt"));
		CheckFormCorrectnessVisitor correctVisitor = new CheckFormCorrectnessVisitor();
		form1.accept(correctVisitor);
		FormRenderer formRenderer1 = new FormRenderer();
		form1.accept(formRenderer1);
		System.out.println("form: " + form1);
		
		
		
//		Expr exp = parser.parse("3 * (4 + 6) / 10");
//		TypeCheckExpressionVisitor exprVis = new TypeCheckExpressionVisitor();
//		ValueExpressionVisitor exprVis2 = new ValueExpressionVisitor(null);
//		exp.accept(exprVis);
//		System.out.println(exp.accept(exprVis2));
//		System.out.println(exprVis.returnErrorMsgs());
//		System.out.println(exprVis.returnWarningMsgs());
//		System.out.println(exp.calculateValue());
		

	}
	
	public static String readFile(String location) {
		File file = new File(location);
        StringBuilder contents = new StringBuilder();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;

            while ((text = reader.readLine()) != null) {
                contents.append(text)
                        .append(System.getProperty(
                                "line.separator"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return contents.toString();
	}

}
