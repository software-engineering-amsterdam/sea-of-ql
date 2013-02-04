package org.uva.sea.ql.tests.webUI.KnockoutJSViewModelBuilderVisitorTests;

import org.junit.Test;
import org.uva.sea.ql.ast.CompositeStatement;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.type.Bool;

import java.util.Arrays;

import static junit.framework.Assert.assertTrue;

public class CreateViewModelTests extends KnockoutJSViewModelBuilderVisitorTests {

    private static final Form FORM = new Form(
            new Ident("a"),
            new CompositeStatement(
                    Arrays.asList(
                            (Statement) new Question("a", new Ident("a"), new Bool()),
                            (Statement) new Question("b", new Ident("b"), new Bool()),
                            (Statement) new Question("c", new Ident("c"), new Bool())
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
