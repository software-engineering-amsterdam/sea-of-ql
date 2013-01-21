package org.uva.sea.ql;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.Parser;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.typechecker.TypecheckerVisitor;
import org.uva.sea.ql.webUI.KnockoutJSViewModelBuilderVisitor;

import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        new Main();
    }

    private static final String SAMPLE_FORM =
    "form Box1HouseOwning {" +
    "    \"Did you sell a house in 2010?\" hasSoldHouse: boolean" +
    "    \"Did you by a house in 2010?\" hasBoughtHouse: boolean" +
    "    \"Did you enter a loan for maintenance/reconstruction?\" hasMaintLoan: boolean" +
    "    if (hasSoldHouse) {" +
    "        \"Private debts for the sold house:\" privateDebt: integer" +
    "        \"Price the house was sold for:\" sellingPrice: integer" +
    "        \"Value residue:\" sellingPrice - privateDebt" +
    "    }" +
    "}";

    public Main() {
        Parser parser = new ANTLRParser();
        try {
            Form parsedForm = (Form) parser.parse(SAMPLE_FORM);
            List<String> errors = new TypecheckerVisitor().typecheck(parsedForm);
            if(!errors.isEmpty()) {
                StringBuilder stringBuilder = new StringBuilder("Errors occurred when type checking the form:\n");
                for(Iterator<String> errorIterator = errors.iterator(); errorIterator.hasNext(); ) {
                    stringBuilder
                            .append(" - ")
                            .append(errorIterator.next());
                    if(errorIterator.hasNext())
                        stringBuilder.append("\n");
                }
                throw new RuntimeException(stringBuilder.toString());
            }
            String viewModel = new KnockoutJSViewModelBuilderVisitor().createViewModel(parsedForm);
            viewModel.toString();
        } catch(ParseError parseError) {
            throw new RuntimeException("Error while parsing.", parseError);
        }
    }
}
