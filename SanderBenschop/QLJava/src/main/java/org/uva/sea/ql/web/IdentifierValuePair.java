package org.uva.sea.ql.web;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@SuppressWarnings("unused")
public class IdentifierValuePair {

    private String identifierName;
    private String value;

    public String getIdentifierName() {
        return identifierName;
    }

    public void setIdentifierName(String identifierName) {
        this.identifierName = identifierName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
