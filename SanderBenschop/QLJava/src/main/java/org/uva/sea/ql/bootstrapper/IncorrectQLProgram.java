package org.uva.sea.ql.bootstrapper;

public class IncorrectQLProgram implements QLProgram {

    @Override
    public boolean isCorrect() {
        return false;
    }

    @Override
    public String getGeneratedQLCode() {
        throw new UnsupportedOperationException("QL code could not be correctly created from source code.");
    }
}
