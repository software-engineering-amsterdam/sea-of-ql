package org.uva.sea.ql.tests.webUI.KnockoutJSViewModelBuilderVisitorTests;

import org.junit.Test;
import org.uva.sea.ql.ast.type.*;
import org.uva.sea.ql.ast.type.Boolean;
import org.uva.sea.ql.ast.type.Integer;
import org.uva.sea.ql.ast.type.String;

import static junit.framework.Assert.assertEquals;

public class TypeTests extends KnockoutJSViewModelBuilderVisitorTests {

    @Test
    public void acceptCalledOnBoolean_returnsBooleanTypeString() {
        assertEquals(
                "DataType.BOOLEAN",
                new Boolean().accept(visitor, null)
        );
    }

    @Test
    public void acceptCalledOnInteger_returnsIntegerTypeString() {
        assertEquals(
                "DataType.INTEGER",
                new Integer().accept(visitor, null)
        );
    }

    @Test
    public void acceptCalledOnString_returnsStringTypeString() {
        assertEquals(
                "DataType.STRING",
                new String().accept(visitor, null)
        );
    }

    @Test(expected = RuntimeException.class)
    public void acceptCalledOnUnknown_throwsException() {
        new Unknown().accept(visitor, null);
    }

}
