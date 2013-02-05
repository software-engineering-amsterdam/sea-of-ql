package org.uva.sea.ql.test;

import org.junit.Test;
import org.uva.sea.ql.ast.math.Add;
import org.uva.sea.ql.ast.math.Div;
import org.uva.sea.ql.ast.math.Mul;
import org.uva.sea.ql.ast.math.Sub;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.test.common.MathTestHelper;

public class TestMath extends TestExpressions {
    private MathTestHelper mathTestHelper;

    public TestMath() {
        super();
        this.mathTestHelper = new MathTestHelper(parser);
    }

    @Test
    public final void testMulsWithAdd() throws ParseError {
        this.mathTestHelper.setClass(Mul.class).testMathOperations(
                this.mathTestHelper.setClass(Add.class));
    }

    @Test
    public final void testMulsWithSub() throws ParseError {
        this.mathTestHelper.setClass(Mul.class).testMathOperations(
                this.mathTestHelper.setClass(Sub.class));
    }

    @Test
    public final void testMulsWithDiv() throws ParseError {
        this.mathTestHelper.setClass(Mul.class).testMathOperations(
                this.mathTestHelper.setClass(Div.class));
    }

    @Test
    public final void testDivsWithMul() throws ParseError {
        this.mathTestHelper.setClass(Div.class).testMathOperations(
                this.mathTestHelper.setClass(Mul.class));
    }

    @Test
    public final void testDivsWithAdd() throws ParseError {
        this.mathTestHelper.setClass(Div.class).testMathOperations(
                this.mathTestHelper.setClass(Add.class));
    }

    @Test
    public final void testDivsWithSub() throws ParseError {
        this.mathTestHelper.setClass(Div.class).testMathOperations(
                this.mathTestHelper.setClass(Sub.class));
    }

    @Test
    public final void testAddsWithMul() throws ParseError {
        this.mathTestHelper.setClass(Add.class).testMathOperations(
                this.mathTestHelper.setClass(Mul.class));
    }

    @Test
    public final void testAddsWithDiv() throws ParseError {
        this.mathTestHelper.setClass(Add.class).testMathOperations(
                this.mathTestHelper.setClass(Div.class));
    }

    @Test
    public final void testAddsWithSub() throws ParseError {
        this.mathTestHelper.setClass(Add.class).testMathOperations(
                this.mathTestHelper.setClass(Sub.class));
    }

    @Test
    public final void testSubsWithMul() throws ParseError {
        this.mathTestHelper.setClass(Sub.class).testMathOperations(
                this.mathTestHelper.setClass(Mul.class));
    }

    @Test
    public final void testSubsWithAdd() throws ParseError {
        this.mathTestHelper.setClass(Sub.class).testMathOperations(
                this.mathTestHelper.setClass(Add.class));
    }

    @Test
    public final void testSubsWithDiv() throws ParseError {
        this.mathTestHelper.setClass(Sub.class).testMathOperations(
                this.mathTestHelper.setClass(Div.class));
    }
}
