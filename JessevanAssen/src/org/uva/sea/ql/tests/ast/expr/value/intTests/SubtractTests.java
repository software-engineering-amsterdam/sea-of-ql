package org.uva.sea.ql.tests.ast.expr.value.intTests;

import junit.framework.Assert;
import org.junit.Test;
import org.uva.sea.ql.ast.expr.value.Int;

public class SubtractTests {

    @Test
    public void twoIntsAreSubstracted_resultIsSecondIntSubstractedFromFirstInt() {
        Assert.assertEquals(
                new Int(1),
                new Int(3).subtract(new Int(2))
        );
    }

}
