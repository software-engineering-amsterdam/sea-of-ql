package org.uva.sea.ql.tests.interpreter.interpreterTests;

import org.junit.Test;
import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.expr.value.*;

import static junit.framework.Assert.assertEquals;

public class AtomicExpressionTests extends InterpreterVisitorTests {

    private static final Bool TRUE = new Bool(true);
    private static final Bool FALSE = new Bool(false);
    private static final Bool[] BOOLEAN_VALUES = new Bool[] { TRUE, FALSE };

    @Test
    public void testAdd() {
        final Int left = new Int(1);
        final Int right = new Int(3);
        assertEquals(
                left.add(right),
                new Add(left, right).accept(visitor, context)
        );
    }

    @Test
    public void testSubtract() {
        final Int left = new Int(3);
        final Int right = new Int(1);
        assertEquals(
                left.subtract(right),
                new Sub(left, right).accept(visitor, context)
        );
    }

    @Test
    public void testMultiply() {
        final Int left = new Int(3);
        final Int right = new Int(4);
        assertEquals(
                left.multiply(right),
                new Mul(left, right).accept(visitor, context)
        );
    }

    @Test
    public void testDivide() {
        final Int left = new Int(10);
        final Int right = new Int(2);
        assertEquals(
                left.divide(right),
                new Div(left, right).accept(visitor, context)
        );
    }

    @Test
    public void testGreaterThan() {
        final Int left = new Int(1);
        final Int right = new Int(2);
        assertEquals(
                left.isGreaterThan(right),
                new GT(left, right).accept(visitor, context)
        );
        assertEquals(
                right.isGreaterThan(left),
                new GT(right, left).accept(visitor, context)
        );
        assertEquals(
                left.isGreaterThan(left),
                new GT(left, left).accept(visitor, context)
        );
    }

    @Test
    public void testLesserThan() {
        final Int left = new Int(1);
        final Int right = new Int(2);
        assertEquals(
                left.isLesserThan(right),
                new LT(left, right).accept(visitor, context)
        );
        assertEquals(
                right.isLesserThan(left),
                new LT(right, left).accept(visitor, context)
        );
        assertEquals(
                left.isGreaterThan(left),
                new LT(left, left).accept(visitor, context)
        );
    }

    @Test
    public void testGreaterThanOrEqual() {
        final Int left = new Int(1);
        final Int right = new Int(2);
        assertEquals(
                left.isGreaterThanOrEqualTo(right),
                new GEq(left, right).accept(visitor, context)
        );
        assertEquals(
                right.isGreaterThanOrEqualTo(left),
                new GEq(right, left).accept(visitor, context)
        );
        assertEquals(
                left.isGreaterThanOrEqualTo(left),
                new GEq(left, left).accept(visitor, context)
        );
    }

    @Test
    public void testLesserThanOrEqual() {
        final Int left = new Int(1);
        final Int right = new Int(2);
        assertEquals(
                left.isLesserThanOrEqualTo(right),
                new LEq(left, right).accept(visitor, context)
        );
        assertEquals(
                right.isLesserThanOrEqualTo(left),
                new LEq(right, left).accept(visitor, context)
        );
        assertEquals(
                left.isLesserThanOrEqualTo(left),
                new LEq(left, left).accept(visitor, context)
        );
    }

    @Test
    public void testPositive() {
        for(Int x : new Int[] { new Int(1), new Int(-1) })
            assertEquals(
                    x.positive(),
                    new Pos(x).accept(visitor, context)
            );
    }

    @Test
    public void testNegative() {
        for(Int x : new Int[] { new Int(1), new Int(-1) })
            assertEquals(
                    x.negative(),
                    new Neg(x).accept(visitor, context)
            );
    }

    @Test
    public void testIsEqualTo() {
        for(Bool x : BOOLEAN_VALUES)
            for(Bool y : BOOLEAN_VALUES)
                assertEquals(
                        x.isEqualTo(y),
                        new Eq(x, y).accept(visitor, context)
                );
        final Int[] intValues = new Int[] { new Int(1), new Int(2), new Int(3) };
        for(Int x : intValues)
            for(Int y : intValues)
                assertEquals(
                        x.isEqualTo(y),
                        new Eq(x, y).accept(visitor, context)
                );
        final Str[] strValues = new Str[] { new Str("a"), new Str("b"), new Str("c") };
        for(Str x : strValues)
            for(Str y : strValues)
                assertEquals(
                        x.isEqualTo(y),
                        new Eq(x, y).accept(visitor, context)
                );
    }

    @Test
    public void testIsNotEqualTo() {
        for(Bool x : BOOLEAN_VALUES)
            for(Bool y : BOOLEAN_VALUES)
                assertEquals(
                        x.isNotEqualTo(y),
                        new NEq(x, y).accept(visitor, context)
                );
        final Int[] intValues = new Int[] { new Int(1), new Int(2), new Int(3) };
        for(Int x : intValues)
            for(Int y : intValues)
                assertEquals(
                        x.isNotEqualTo(y),
                        new NEq(x, y).accept(visitor, context)
                );
        final Str[] strValues = new Str[] { new Str("a"), new Str("b"), new Str("c") };
        for(Str x : strValues)
            for(Str y : strValues)
                assertEquals(
                        x.isNotEqualTo(y),
                        new NEq(x, y).accept(visitor, context)
                );
    }

    @Test
    public void testAnd() {
        for(Bool x : BOOLEAN_VALUES)
            for(Bool y : BOOLEAN_VALUES)
                assertEquals(
                        x.and(y),
                        new And(x, y).accept(visitor, context)
                );
    }

    @Test
    public void testOr() {
        for(Bool x : BOOLEAN_VALUES)
            for(Bool y : BOOLEAN_VALUES)
                assertEquals(
                        x.or(y),
                        new Or(x, y).accept(visitor, context)
                );
    }

    @Test
    public void testNot() {
        for(Bool x : BOOLEAN_VALUES)
            assertEquals(
                    x.not(),
                    new Not(x).accept(visitor, context)
            );
    }

    @Test
    public void testValues() {
        assertEquals(
                new Bool(true),
                new Bool(true).accept(visitor, context)
        );
        assertEquals(
                new Int(1),
                new Int(1).accept(visitor, context)
        );
        assertEquals(
                new Str("abcd"),
                new Str("abcd").accept(visitor, context)
        );
    }
}
