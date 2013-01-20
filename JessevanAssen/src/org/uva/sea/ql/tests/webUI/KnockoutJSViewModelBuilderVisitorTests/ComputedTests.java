package org.uva.sea.ql.tests.webUI.KnockoutJSViewModelBuilderVisitorTests;

import org.junit.Test;
import org.uva.sea.ql.ast.Computed;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.value.Bool;

import static org.junit.Assert.assertEquals;

public class ComputedTests extends KnockoutJSViewModelBuilderVisitorTests {

    private static final String COMPUTED_LABEL = "computed label";
    private static final Expr EXPRESSION = new Bool(true);

    @Test
    public void visitCalled_computedIsAddedToStringBuilder() {
        new Computed(COMPUTED_LABEL, EXPRESSION).accept(visitor, context);
        assertEquals(String.format("new Computed(\"%s\",function(){return true;})", COMPUTED_LABEL), context.getObjectHierarchy().toString());
    }

}
