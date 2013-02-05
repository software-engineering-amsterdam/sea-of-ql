package org.uva.sea.ql.tests.ast.expression.value.intTests;

import junit.framework.Assert;
import org.junit.Test;
import org.uva.sea.ql.ast.expression.value.Int;

public class DivideByTests {

    @Test
    public void twoIntsAreDivided_resultIsFirstIntDividedBySecondInt() {
        Assert.assertEquals(
                new Int(2),
                new Int(6).divideBy(new Int(3))
        );
    }

}
