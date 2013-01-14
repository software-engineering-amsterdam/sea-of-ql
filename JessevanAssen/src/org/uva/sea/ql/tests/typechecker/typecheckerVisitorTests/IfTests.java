package org.uva.sea.ql.tests.typechecker.typecheckerVisitorTests;

import org.junit.Test;
import org.uva.sea.ql.ast.FormElement;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.If;
import org.uva.sea.ql.ast.expr.value.Bool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class IfTests extends TypecheckerVisitorTests {

    @Test
    public void acceptIsCalled_conditionAcceptIsCalled() {
        Expr mockExpression = mock(Expr.class);
        If i = new If(mockExpression, new ArrayList<FormElement>(), new ArrayList<FormElement>());
        i.accept(visitor, context);
        verify(mockExpression).accept(visitor, context);
    }

    @Test
    public void acceptIsCalled_ifBodyAcceptIsCalled() {
        List<FormElement> mockFormElements = Arrays.asList(
            mock(FormElement.class),
            mock(FormElement.class),
            mock(FormElement.class)
        );
        If i = new If(new Bool(true), mockFormElements, new ArrayList<FormElement>());
        i.accept(visitor, context);

        for(FormElement f : mockFormElements)
            verify(f).accept(visitor, context);
    }

    @Test
    public void acceptIsCalled_elseBodyAcceptIsCalled() {
        List<FormElement> mockFormElements = Arrays.asList(
                mock(FormElement.class),
                mock(FormElement.class),
                mock(FormElement.class)
        );
        If i = new If(new Bool(true), new ArrayList<FormElement>(), mockFormElements);
        i.accept(visitor, context);

        for(FormElement f : mockFormElements)
            verify(f).accept(visitor, context);
    }

}
