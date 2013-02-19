package org.uva.sea.ql.formLoader;

public class StringFormSource implements FormSource {

    private final String source;

    public StringFormSource(String source) {
        this.source = source;
    }

    @Override
    public String loadFormData() {
        return source;
    }
}
