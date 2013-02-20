package org.uva.sea.ql.web;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Wrapper for identifier names and values which are automagically converted from JSON.
 * Apparently the library cannot work with constructor parameters, so I had to create (seemingly unused) setter methods.
 */
@XmlRootElement
public class IdentifierValuePair {

    private String identifierName;
    private String value;

    public String getIdentifierName() {
        return identifierName;
    }

    @SuppressWarnings("unused")
    public void setIdentifierName(String identifierName) {
        this.identifierName = identifierName;
    }

    public String getValue() {
        return value;
    }

    @SuppressWarnings("unused")
    public void setValue(String value) {
        this.value = value;
    }

    public String toCsvRow() {
        return value.isEmpty() ? "" : identifierName + "," + value;
    }
}
