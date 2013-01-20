package org.uva.sea.ql.tests.webUI.KnockoutJSViewModelBuilderVisitorTests;

import org.uva.sea.ql.webUI.KnockoutJSViewModelBuilderVisitor;

public abstract class KnockoutJSViewModelBuilderVisitorTests {
    protected final KnockoutJSViewModelBuilderVisitor visitor;
    protected final KnockoutJSViewModelBuilderVisitor.Context context;

    public KnockoutJSViewModelBuilderVisitorTests() {
        visitor = new KnockoutJSViewModelBuilderVisitor();
        context = new KnockoutJSViewModelBuilderVisitor.Context();
    }
}
