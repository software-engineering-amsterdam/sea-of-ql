package org.uva.sea.ql.tests.ast.expr.value.intTests;

import junit.framework.Assert;
import org.junit.Test;
import org.uva.sea.ql.ast.expr.value.Int;

public class SubtractWithTests {

    @Test
    public void twoIntsAreSubstracted_resultIsSecondIntSubstractedFromFirstInt() {
        Assert.assertEquals(
                new Int(1),
                new Int(3).subtractWith(new Int(2))
        );
    }

}