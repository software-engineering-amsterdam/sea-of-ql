package org.uva.sea.ql.parser.stringparsing.formelement;

import org.junit.Test;
import org.uva.sea.ql.ast.QLStatement;
import org.uva.sea.ql.ast.nodetypes.formelement.Computation;
import org.uva.sea.ql.ast.nodetypes.formelement.Conditional;
import org.uva.sea.ql.ast.nodetypes.formelement.Form;
import org.uva.sea.ql.ast.nodetypes.formelement.Question;
import org.uva.sea.ql.parser.TestParser;
import org.uva.sea.ql.parser.exception.ParseError;

import java.util.List;

import static junit.framework.Assert.assertEquals;

public class CompleteFormTest extends TestParser {

    @Test
    public void shouldParseCompleteForm() throws ParseError {
        //Source is from lecture #1
        String source = "form Box1HouseOwning {\n" +
        "hasSoldHouse: \"Did you sell a house in 2010?\" boolean\n"  +
        "hasBoughtHouse: \"Did you buy a house in 2010?\" boolean\n"  +
        "hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean\n"  +
        "if (hasSoldHouse) {\n" +
        "sellingPrice: \"Price the house was sold for:\" integer\n" +
        "privateDebt: \"Private debts for the sold house:\" integer\n" +
        "valueResidue: \"Value residue:\" (sellingPrice - privateDebt)\n" +
        "}\n" +
        "}\n";

        Form form = parseForm(source);
        List<QLStatement> statements = form.getStatements();
        assertEquals(Question.class, statements.get(0).getClass());
        assertEquals(Question.class, statements.get(1).getClass());
        assertEquals(Question.class, statements.get(2).getClass());
        assertEquals(Conditional.class, statements.get(3).getClass());

        Conditional conditional = (Conditional) statements.get(3);
        List<QLStatement> conditonalSuccessStatements = conditional.getSuccessBlock();
        assertEquals(Question.class, conditonalSuccessStatements.get(0).getClass());
        assertEquals(Question.class, conditonalSuccessStatements.get(1).getClass());
        assertEquals(Computation.class, conditonalSuccessStatements.get(2).getClass());
    }
}