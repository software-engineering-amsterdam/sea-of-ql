package org.uva.sea.ql.codegeneration.codewrapper;

public class AppendingStatementWebappCodeWrapper implements StatementWebappCodeWrapper {

    private final StringBuilder javascriptCodeBuilder;
    private final StringBuilder htmlCodeBuilder;

    public AppendingStatementWebappCodeWrapper() {
        this.javascriptCodeBuilder = new StringBuilder();
        this.htmlCodeBuilder = new StringBuilder();
    }

    public void appendJavascriptCode(String javascriptCode) {
        javascriptCodeBuilder.append(javascriptCode);
    }

    public void appendHtmlCode(String htmlCode) {
        htmlCodeBuilder.append(htmlCode);
    }

    @Override
    public String getJavascriptCode() {
        return javascriptCodeBuilder.toString();
    }

    @Override
    public String getHTMLCode() {
        return htmlCodeBuilder.toString();
    }
}
