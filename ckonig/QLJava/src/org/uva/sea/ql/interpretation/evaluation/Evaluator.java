package org.uva.sea.ql.interpretation.evaluation;

import org.uva.sea.ql.interpretation.SwingRegistry;

public class Evaluator {
    protected SwingRegistry registry;
    protected boolean boolRet;
    protected boolean isBoolMode;
    public Evaluator(SwingRegistry reg, boolean isBool){
        this.registry = reg;
        this.isBoolMode = isBool;
    }
}
