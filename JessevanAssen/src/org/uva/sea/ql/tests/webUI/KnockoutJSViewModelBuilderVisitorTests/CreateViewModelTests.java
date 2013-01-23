package org.uva.sea.ql.tests.webUI.KnockoutJSViewModelBuilderVisitorTests;

import org.junit.Test;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.type.Bool;

import java.util.Arrays;

import static junit.framework.Assert.assertTrue;

public class CreateViewModelTests extends KnockoutJSViewModelBuilderVisitorTests {

    private static final Form FORM = new Form(
            new Ident("a"),
            new CompositeFormElement(
                    Arrays.asList(
                            (FormElement) new Question("a", new Ident("a"), new Bool()),
                            (FormElement) new Question("b", new Ident("b"), new Bool()),
                            (FormElement) new Question("c", new Ident("c"), new Bool())
                    )
            )
    );

    @Test
    public void methodCalled_identifiersAreAddedToViewModel() {
        String viewModel = visitor.createViewModel(FORM);

        assertTrue(viewModel.contains(
                "identifiers={a:ko.observable(),b:ko.observable(),c:ko.observable()}"
        ));
    }

    @Test
    public void methodCalled_formIsAddedToViewModel() {
        String viewModel = visitor.createViewModel(FORM);
        FORM.accept(visitor, context);
        assertTrue(viewModel.contains("root=" + context.getObjectHierarchy().toString()));
    }

}
