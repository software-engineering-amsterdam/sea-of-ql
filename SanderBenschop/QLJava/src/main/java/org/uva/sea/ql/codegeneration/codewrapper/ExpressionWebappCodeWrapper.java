package org.uva.sea.ql.codegeneration.codewrapper;

public class ExpressionWebappCodeWrapper implements WebappCodeWrapper {

    private final String javascriptCode;

    public ExpressionWebappCodeWrapper(String javascriptCode) {
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
