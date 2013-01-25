package org.uva.sea.ql.tests.ast.expr.value.intTests;

import junit.framework.Assert;
import org.junit.Test;
import org.uva.sea.ql.ast.expr.value.Int;

public class DivideTests {

    @Test
    public void twoIntsAreDivided_resultIsFirstIntDividedBySecondInt() {
        Assert.assertEquals(
                new Int(2),
                new Int(6).divide(new Int(3))
        );
    }

}
