package org.uva.sea.ql.test;

import org.junit.Test;
import org.uva.sea.ql.ast.bool.Eq;
import org.uva.sea.ql.ast.bool.GEq;
import org.uva.sea.ql.ast.bool.GT;
import org.uva.sea.ql.ast.bool.LEq;
import org.uva.sea.ql.ast.bool.LT;
import org.uva.sea.ql.ast.bool.NEq;
import org.uva.sea.ql.ast.math.Add;
import org.uva.sea.ql.ast.math.Div;
import org.uva.sea.ql.ast.math.Mul;
import org.uva.sea.ql.ast.math.Sub;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.test.common.BoolTestHelper;

public class TestComparisons extends TestExpressions {
    private BoolTestHelper left;
    private BoolTestHelper right;

    public TestComparisons() {
        super();
        this.left = new BoolTestHelper(parser);
        this.right = new BoolTestHelper(parser);
    }

    @Test
    public final void testLTWithAdd() throws ParseError {
        this.left.setClass(LT.class).testRels(this.right.setClass(Add.class));
    }

    @Test
    public final void testLTWithSub() throws ParseError {
        this.left.setClass(LT.class).testRels(this.right.setClass(Sub.class));
    }

    @Test
    public final void testLTWithMul() throws ParseError {
        this.left.setClass(LT.class).testRels(this.right.setClass(Mul.class));
    }

    @Test
    public final void testLTWithDiv() throws ParseError {
        this.left.setClass(LT.class).testRels(this.right.setClass(Div.class));
    }

    @Test
    public final void testLEqWithAdd() throws ParseError {
        this.left.setClass(LEq.class).testRels(this.right.setClass(Add.class));
    }

    @Test
    public final void testLEqWithSub() throws ParseError {
        this.left.setClass(LEq.class).testRels(this.right.setClass(Sub.class));
    }

    @Test
    public final void testLEqWithMul() throws ParseError {
        this.left.setClass(LEq.class).testRels(this.right.setClass(Mul.class));
    }

    @Test
    public final void testLEqWithDiv() throws ParseError {
        this.left.setClass(LEq.class).testRels(this.right.setClass(Div.class));
    }

    @Test
    public final void testGTWithAdd() throws ParseError {
        this.left.setClass(GT.class).testRels(this.right.setClass(Add.class));
    }

    @Test
    public final void testGTWithSub() throws ParseError {
        this.left.setClass(GT.class).testRels(this.right.setClass(Sub.class));
    }

    @Test
    public final void testGTWithMul() throws ParseError {
        this.left.setClass(GT.class).testRels(this.right.setClass(Mul.class));
    }

    @Test
    public final void testGTWithDiv() throws ParseError {
        this.left.setClass(GT.class).testRels(this.right.setClass(Div.class));
    }

    @Test
    public final void testGEqWithAdd() throws ParseError {
        this.left.setClass(GEq.class).testRels(this.right.setClass(Add.class));
    }

    @Test
    public final void testGEqWithSub() throws ParseError {
        this.left.setClass(GEq.class).testRels(this.right.setClass(Sub.class));
    }

    @Test
    public final void testGEqWithMul() throws ParseError {
        this.left.setClass(GEq.class).testRels(this.right.setClass(Mul.class));
    }

    @Test
    public final void testGEqWithDiv() throws ParseError {
        this.left.setClass(GEq.class).testRels(this.right.setClass(Div.class));
    }

    @Test
    public final void testEqWithAdd() throws ParseError {
        this.left.setClass(Eq.class).testRels(this.right.setClass(Add.class));
    }

    @Test
    public final void testEqWithSub() throws ParseError {
        this.left.setClass(Eq.class).testRels(this.right.setClass(Sub.class));
    }

    @Test
    public final void testEqWithMul() throws ParseError {
        this.left.setClass(Eq.class).testRels(this.right.setClass(Mul.class));
    }

    @Test
    public final void testEqWithDiv() throws ParseError {
        this.left.setClass(Eq.class).testRels(this.right.setClass(Div.class));
    }

    @Test
    public final void testNEqWithAdd() throws ParseError {
        this.left.setClass(NEq.class).testRels(this.right.setClass(Add.class));
    }

    @Test
    public final void testNEqWithSub() throws ParseError {
        this.left.setClass(NEq.class).testRels(this.right.setClass(Sub.class));
    }

    @Test
    public final void testNEqWithMul() throws ParseError {
        this.left.setClass(NEq.class).testRels(this.right.setClass(Mul.class));
    }

    @Test
    public final void testNEqWithDiv() throws ParseError {
        this.left.setClass(NEq.class).testRels(this.right.setClass(Div.class));
    }

}
