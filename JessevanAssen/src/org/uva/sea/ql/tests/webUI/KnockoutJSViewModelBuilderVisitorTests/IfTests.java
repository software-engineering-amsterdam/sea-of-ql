package org.uva.sea.ql.tests.webUI.KnockoutJSViewModelBuilderVisitorTests;

import org.junit.Test;
import org.uva.sea.ql.ast.If;
import org.uva.sea.ql.ast.IfElse;
import org.uva.sea.ql.ast.NullFormElement;
import org.uva.sea.ql.ast.expr.value.Bool;

import static junit.framework.Assert.assertEquals;

public class IfTests extends KnockoutJSViewModelBuilderVisitorTests {

    @Test
    public void visitCalledOnIf_blockIsAddedToStringBuilder() {
        new If(new Bool(true), new NullFormElement()).accept(visitor, context);
        assertEquals(String.format("new Block(function(){return true;},[])"), context.getObjectHierarchy().toString());
    }

    @Test
    public void visitCalledOnIfElse_blocksAreAddedToStringBuilder() {
        new IfElse(new Bool(true), new NullFormElement(), new NullFormElement()).accept(visitor, context);
        assertEquals(String.format("new Block(function(){return true;},[]),new Block(function(){return (!true);},[])"), context.getObjectHierarchy().toString());
    }

}
