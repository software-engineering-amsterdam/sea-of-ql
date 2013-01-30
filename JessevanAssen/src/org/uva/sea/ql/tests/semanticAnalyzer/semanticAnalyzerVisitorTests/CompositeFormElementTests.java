package org.uva.sea.ql.tests.semanticAnalyzer.semanticAnalyzerVisitorTests;

import org.junit.Test;
import org.uva.sea.ql.ast.CompositeFormElement;
import org.uva.sea.ql.ast.FormElement;

import java.util.Arrays;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CompositeFormElementTests extends SemanticAnalyzerVisitorTests {

    @Test
    public void acceptIsCalled_acceptIsCalledOnAllSubFormElements() {
        Iterable<FormElement> mockFormElements = Arrays.asList(
                mock(FormElement.class),
                mock(FormElement.class),
                mock(FormElement.class)
        );
        CompositeFormElement compositeFormElement = new CompositeFormElement(mockFormElements);

        compositeFormElement.accept(visitor, context);

        for(FormElement formElement : mockFormElements)
            verify(formElement).accept(visitor, context);
    }
}
