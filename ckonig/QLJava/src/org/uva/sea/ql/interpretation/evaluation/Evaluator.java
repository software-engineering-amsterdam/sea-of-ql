package org.uva.sea.ql.interpretation.evaluation;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.interfaces.Expression;
import org.uva.sea.ql.common.QLException;
import org.uva.sea.ql.interpretation.SwingRegistry;

public class Evaluator {
    
    private MathEvaluationVisitor mathEvaluator;    
    private BoolEvaluationVisitor boolEvaluator;

     public Evaluator(SwingRegistry reg, boolean replaceEmptyWithZero) {
       this.mathEvaluator = new MathEvaluationVisitor(reg, this, replaceEmptyWithZero);
       this.boolEvaluator = new BoolEvaluationVisitor(reg, this);
    }
     
    public final float evalFloat(Expr e) throws QLException {
        System.out.println("math eval: " + e.toString());
        ((Expression) e).accept(this.mathEvaluator);
        return this.mathEvaluator.mathRet;
    }
    
    public final boolean evalBool(Expr e) throws QLException {
        System.out.println("bool eval: " + e.toString());
        ((Expression) e).accept(this.boolEvaluator);
        return this.boolEvaluator.boolRet;
    }

}
