package org.uva.sea.ql.interpretation.components.input;

public interface QLInput {

    public void setInputPossible(boolean val);

    public String getStringValue();

    public boolean getBoolValue();
    
    public void setStringValue(String text);
    
    public void setBoolean(boolean bool);
}
