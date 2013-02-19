package org.uva.sea.ql.bootstrapper;

/**
 * Interface for classes that wrap a QLProgram.
 */
public interface QLProgram {

    boolean isCorrect();

    String getGeneratedQLCode();
}
