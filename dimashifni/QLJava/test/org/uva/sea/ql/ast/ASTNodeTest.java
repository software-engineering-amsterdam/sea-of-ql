/**
 * 
 */
package org.uva.sea.ql.ast;

import junit.framework.Assert;
import org.junit.Test;
import org.uva.sea.ql.value.BooleanValue;
import org.uva.sea.ql.value.IntegerValue;
import org.uva.sea.ql.value.Value;

/**
 * @author dimashifni
 *
 */
public class ASTNodeTest {

    @Test
    public void testAdd()
    {
        IntegerValue value1 = new IntegerValue(5);
        IntegerValue value2 = new IntegerValue(15);
        Value result = value1.add(value2);
        Assert.assertEquals("20", result.getValue().toString());
    }

    @Test
    public void testAnd()
    {
        BooleanValue value1 = new BooleanValue(true);
        BooleanValue value2 = new BooleanValue(false);
        Value result = value1.and(value2);
        Assert.assertEquals("false", result.getValue().toString());
    }

}
