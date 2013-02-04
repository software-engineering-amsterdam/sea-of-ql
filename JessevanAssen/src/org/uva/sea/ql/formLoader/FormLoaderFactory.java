package org.uva.sea.ql.formLoader;

import org.uva.sea.ql.parser.ParserFactory;

public class FormLoaderFactory {

    public static FormLoader createFormLoader() {
        final String formData =
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

        return new FormLoaderImpl(
                new StringFormSource(formData),
                ParserFactory.createParser());
    }

}
