package org.uva.sea.ql.tests.webUI.KnockoutJSViewModelBuilderVisitorTests;

import org.junit.Test;
import org.uva.sea.ql.ast.CompositeStatement;
import org.uva.sea.ql.ast.Computed;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.expression.value.Bool;

import java.util.Arrays;

import static junit.framework.Assert.assertEquals;

public class CompositeStatementTests extends KnockoutJSViewModelBuilderVisitorTests {

    @Test
    public void compositeStatementContainsMultipleStatements_separateByComma() {
        CompositeStatement compositeStatement = new CompositeStatement(Arrays.asList(
            (Statement) new Computed("a", new Bool(true)),
            (Statement) new Computed("b", new Bool(true)),
            (Statement) new Computed("c", new Bool(true))
        ));
        compositeStatement.accept(visitor, context);

        final String COMPUTED_TEMPLATE = "new Computed(\"%s\",function(){return true;})";
        assertEquals(
            String.format(
                    COMPUTED_TEMPLATE + "," + COMPUTED_TEMPLATE + "," + COMPUTED_TEMPLATE,
                    "a", "b", "c"),
            context.getObjectHierarchy().toString()
        );
    }

}
