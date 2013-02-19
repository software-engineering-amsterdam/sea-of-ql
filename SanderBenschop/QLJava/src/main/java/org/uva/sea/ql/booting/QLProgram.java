package org.uva.sea.ql.booting;

/**
 * Interface for classes that wrap a QLProgram.
 */
public interface QLProgram {

    boolean isCorrect();

    String getGeneratedQLCode();
}
