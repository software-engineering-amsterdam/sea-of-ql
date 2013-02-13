package org.uva.sea.ql.visitor.codegeneration.codewrapper;

import java.util.ArrayList;
import java.util.List;

public class CompositeStatementWebappCodeWrapper implements StatementWebappCodeWrapper {

    private static final String ILLEGAL_ARGUMENT_MESSAGE = "You can only add StatementWebappCodeWrappers to a CompositeStatementWebappCodeWrapper.";

    private final List<WebappCodeWrapper> statementWrappers;

    public CompositeStatementWebappCodeWrapper() {
        this.statementWrappers = new ArrayList<WebappCodeWrapper>();
    }

    public void addStatementWebappCodeWrapper(WebappCodeWrapper statementWebappCodeWrapper) {
        assert (statementWebappCodeWrapper instanceof StatementWebappCodeWrapper) : ILLEGAL_ARGUMENT_MESSAGE;
        statementWrappers.add(statementWebappCodeWrapper);
    }

    @Override
    public String getJavascriptCode() {
        StringBuilder javascriptCode = new StringBuilder();
        for (WebappCodeWrapper wrapper : statementWrappers) {
            javascriptCode.append(wrapper.getJavascriptCode());
        }
        return javascriptCode.toString();
    }

    @Override
    public String getHTMLCode() {
        StringBuilder htmlCode = new StringBuilder();
        for (WebappCodeWrapper wrapper : statementWrappers) {
            htmlCode.append(wrapper.getHTMLCode());
        }
        return htmlCode.toString();
    }
}
