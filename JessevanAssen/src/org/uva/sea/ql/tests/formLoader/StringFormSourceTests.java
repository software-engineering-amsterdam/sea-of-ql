package org.uva.sea.ql.tests.formLoader;

import org.junit.Test;
import org.uva.sea.ql.formLoader.FormSource;
import org.uva.sea.ql.formLoader.StringFormSource;

import static junit.framework.Assert.assertSame;

public class StringFormSourceTests {

    @Test
    public void loadFormDataCalled_returnsStringFromConstructor() {
        final String input = "This is the input";
        FormSource formSource = new StringFormSource(input);
        assertSame(input, formSource.loadFormData());
    }

}
