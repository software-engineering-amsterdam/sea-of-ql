package org.uva.sea.ql.tests.ast.expr.value.intTests;

import junit.framework.Assert;
import org.junit.Test;
import org.uva.sea.ql.ast.expr.value.Int;

public class MultiplyTests {

    @Test
    public void twoIntsAreMultiplied_resultIsMultiplicationOfInts() {
        Assert.assertEquals(
                new Int(6),
                new Int(2).multiply(new Int(3))
        );
    }

}
