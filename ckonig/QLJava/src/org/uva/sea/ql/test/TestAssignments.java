package org.uva.sea.ql.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;
import org.uva.sea.ql.ast.elements.Block;
import org.uva.sea.ql.ast.elements.AbstractBlockElement;
import org.uva.sea.ql.ast.elements.Form;
import org.uva.sea.ql.ast.elements.IfStatement;
import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.ast.types.StrType;
import org.uva.sea.ql.parser.ParseError;

public class TestAssignments extends TestExpressions {
    
    public TestAssignments(){
        
    }
    
    @Test
    public final void testExampleFile() throws ParseError {
        final Form e = parser.parseFile();
        assertNotNull("result was null", e);
        assertEquals(Form.class, e.getClass());
        final Form f = (Form) e;
        assertNotNull(f.getBlock());
        assertNotNull(f.getName());
        assertEquals("Box1HouseOwning", f.getName());
        final Block b = f.getBlock();
        testBlock(b);
    }

    private final void testBlock(Block b) {
        for (AbstractBlockElement line : b.getContent()) {
            Assert.assertTrue(line.getClass().equals(IfStatement.class)
                    || line.getClass().equals(Question.class));
            if (line.getClass().equals(Question.class)) {
                final Question q = (Question) line;
                if (q.getIdentName().equals("hasSoldHouse")) {
                    assertEquals(BooleanType.class, q.getType().getClass());
                }
                if (q.getIdentName().equals("hasBoughtHouse")) {
                    assertEquals(BooleanType.class, q.getType().getClass());
                }
                if (q.getIdentName().equals("hasBoughtHouse")) {
                    assertEquals(BooleanType.class, q.getType().getClass());
                }
                if (q.getIdentName().equals("taxId")) {
                    assertEquals(StrType.class, q.getType().getClass());
                }
                if (q.getIdentName().equals("sellingPrice")) {
                    assertEquals(Money.class, q.getType().getClass());
                    final Money m = (Money) q.getType();
                   // Assert.assertNull(m.getExpr());
                }
                if (q.getIdentName().equals("privateDebt")) {
                    assertEquals(Money.class, q.getType().getClass());
                    final Money m = (Money) q.getType();
                   // Assert.assertNull(m.getExpr());
                }
                if (q.getIdentName().equals("valueResidue")) {
                    assertEquals(Money.class, q.getType().getClass());
                    final Money m = (Money) q.getType();
                   // Assert.assertNotNull(m.getExpr());
                }
            }
            if (line.getClass().equals(IfStatement.class)) {
                final IfStatement i = (IfStatement) line;
                Assert.assertNotNull(i.getCondition());

                this.testBlock(i.getContent());
            }
        }
    }

}
