package org.uva.sea.ql.tests.webUI.KnockoutJSViewModelBuilderVisitorTests;

import org.junit.Test;
import org.uva.sea.ql.ast.CompositeFormElement;
import org.uva.sea.ql.ast.Computed;
import org.uva.sea.ql.ast.FormElement;
import org.uva.sea.ql.ast.expr.value.Bool;

import java.util.Arrays;

import static junit.framework.Assert.assertEquals;

public class CompositeFormElementTests extends KnockoutJSViewModelBuilderVisitorTests {

    @Test
    public void compositeFormElementContainsMultipleFormElements_separateByComma() {
        CompositeFormElement compositeFormElement = new CompositeFormElement(Arrays.asList(
            (FormElement) new Computed("a", new Bool(true)),
            (FormElement) new Computed("b", new Bool(true)),
            (FormElement) new Computed("c", new Bool(true))
        ));
        compositeFormElement.accept(visitor, context);

        final String COMPUTED_TEMPLATE = "new Computed(\"%s\",function(){return true;})";
        assertEquals(
            String.format(
                    COMPUTED_TEMPLATE + "," + COMPUTED_TEMPLATE + "," + COMPUTED_TEMPLATE,
                    "a", "b", "c"),
            context.getObjectHierarchy().toString()
        );
    }

}
