package org.uva.sea.ql.visitor.codegeneration.codewrapper;

public class SimpleExpressionWebappCodeWrapper implements WebappCodeWrapper {

    private final String javascriptCode;

    public SimpleExpressionWebappCodeWrapper(String javascriptCode) {
        this.javascriptCode = javascriptCode;
    }

    @Override
    public String getJavascriptCode() {
        return javascriptCode;
    }

    @Override
    public String getHTMLCode() {
        throw new UnsupportedOperationException("Expressions do not process HTML code.");
    }
}
