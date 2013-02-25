package org.uva.sea.ql.interpretation.components.input;

import org.uva.sea.ql.ast.literals.StringLiteral;

public interface QLInput {

    public void setInputPossible(boolean val);

    public StringLiteral getStringValue();

    public boolean getBoolValue();
    
    public void setStringValue(StringLiteral text);
    
    public void setBoolean(boolean bool);
}
