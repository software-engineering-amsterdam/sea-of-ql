package org.uva.sea.ql.codegeneration.codewrapper;

public class SimpleStatementWebappCodeWrapper implements StatementWebappCodeWrapper {

    private final String javascriptCode;
    private final String htmlCode;

    public SimpleStatementWebappCodeWrapper(String javascriptCode, String htmlCode) {
        this.javascriptCode = javascriptCode;
        this.htmlCode = htmlCode;
    }

    @Override
    public String getJavascriptCode() {
        return javascriptCode;
    }

    @Override
    public String getHTMLCode() {
        return htmlCode;
    }
}
