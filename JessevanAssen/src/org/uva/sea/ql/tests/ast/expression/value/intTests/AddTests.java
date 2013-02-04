package org.uva.sea.ql.tests.ast.expression.value.intTests;

import junit.framework.Assert;
import org.junit.Test;
import org.uva.sea.ql.ast.expression.value.Int;

public class AddTests {

    @Test
    public void twoIntsAreAdded_resultIsSumOfInts() {
        Assert.assertEquals(
                new Int(3),
                new Int(1).add(new Int(2))
        );
    }

}
