package org.uva.sea.ql.tests.interpreter.interpreterTests;

import org.junit.Test;
import org.uva.sea.ql.ast.CompositeFormElement;
import org.uva.sea.ql.ast.FormElement;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CompositeFormElementTests extends InterpreterVisitorTests {

    @Test
    public void acceptCalled_returnsNull() {
        assertNull(new CompositeFormElement(new ArrayList<FormElement>()).accept(visitor, context));
    }

    @Test
    public void acceptCalled_acceptIsCalledOnAllChildren() {
        final List<FormElement> mockFormElements = new ArrayList<FormElement>(3);
        for(int i = 0; i < 3; ++i)
            mockFormElements.add(mock(FormElement.class));

        CompositeFormElement compositeFormElement = new CompositeFormElement(mockFormElements);
        compositeFormElement.accept(visitor, context);

        for(FormElement mockFormElement : mockFormElements)
            verify(mockFormElement).accept(visitor, context);
    }

}
