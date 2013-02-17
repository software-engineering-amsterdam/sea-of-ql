package org.uva.sea.ql.tests.ast.expression.value.intTests;

import junit.framework.Assert;
import org.junit.Test;
import org.uva.sea.ql.ast.expression.value.Int;

public class MultiplyTests {

    @Test
    public void twoIntsAreMultiplied_resultIsMultiplicationOfInts() {
        Assert.assertEquals(
                new Int(6),
                new Int(2).multiply(new Int(3))
        );
    }

}
