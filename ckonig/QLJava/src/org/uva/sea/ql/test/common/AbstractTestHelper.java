package org.uva.sea.ql.test.common;

import org.junit.Assert;
import org.uva.sea.ql.ast.bool.And;
import org.uva.sea.ql.ast.bool.Eq;
import org.uva.sea.ql.ast.bool.GEq;
import org.uva.sea.ql.ast.bool.GT;
import org.uva.sea.ql.ast.bool.LEq;
import org.uva.sea.ql.ast.bool.LT;
import org.uva.sea.ql.ast.bool.NEq;
import org.uva.sea.ql.ast.bool.Not;
import org.uva.sea.ql.ast.bool.Or;
import org.uva.sea.ql.ast.expressions.BinaryExpr;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.math.Add;
import org.uva.sea.ql.ast.math.Div;
import org.uva.sea.ql.ast.math.Mul;
import org.uva.sea.ql.ast.math.Neg;
import org.uva.sea.ql.ast.math.Sub;
import org.uva.sea.ql.parser.ParseError;

public abstract class AbstractTestHelper<T> {
    protected final static String A = " a ";
    protected final static String B = " b ";
    protected final static String C = " c ";
    protected final static String D = " d ";
    private final static String BROPEN = " ( ";
    private final static String BRCLOSE = " ) ";
    protected Class<?> asClass;
    protected String asString;
    protected TestParser parser;

    protected AbstractTestHelper(TestParser parser) {
        this.parser = parser;
    }

    public abstract T setClass(Class<?> c);

    public final void setClassAndString(Class<?> c) {
        this.asClass = c;
        if (c == Add.class) {
            this.asString = new Add(null, null).toString();
        }
        if (c == Sub.class) {
            this.asString = new Sub(null, null).toString();
        }
        if (c == Mul.class) {
            this.asString = new Mul(null, null).toString();
        }
        if (c == Div.class) {
            this.asString = new Div(null, null).toString();
        }
        if (c == Eq.class) {
            this.asString = new Eq(null, null).toString();
        }
        if (c == NEq.class) {
            this.asString = new NEq(null, null).toString();
        }
        if (c == LT.class) {
            this.asString = new LT(null, null).toString();
        }
        if (c == LEq.class) {
            this.asString = new LEq(null, null).toString();
        }
        if (c == GT.class) {
            this.asString = new GT(null, null).toString();
        }
        if (c == GEq.class) {
            this.asString = new GEq(null, null).toString();
        }
        if (c == Neg.class) {
            this.asString = new Neg(null).toString();
        }
        if (c == Not.class) {
            this.asString = new Not(null).toString();
        }
        if (c == And.class) {
            this.asString = new And(null, null).toString();
        }
        if (c == Or.class) {
            this.asString = new Or(null, null).toString();
        }
        if (this.asString == null) {
            throw new RuntimeException("class not recognized");
        }
    }

    protected final void testBinary(Class<?> c, String in, Class<?> left,
            Class<?> right) throws ParseError {
        final Expr e = this.parser.parse(in);
        Assert.assertNotNull("result was null", e);
        Assert.assertEquals(c, e.getClass());
        final BinaryExpr b = (BinaryExpr) e;
        final Expr leftChild = b.getLeft();
        Assert.assertNotNull("left child of binary expr was null", leftChild);
        Assert.assertEquals(left, leftChild.getClass());
        final Expr rightChild = b.getRight();
        Assert.assertNotNull("right child of binary expr was null", rightChild);
        Assert.assertEquals(right, rightChild.getClass());
    }

    protected final String getBracket(String left, AbstractTestHelper<?> op, String right) {
        return BROPEN + left + op.asString + right + BRCLOSE;
    }

}
