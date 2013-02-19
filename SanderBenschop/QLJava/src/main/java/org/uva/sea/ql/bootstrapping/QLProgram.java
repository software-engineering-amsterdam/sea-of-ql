package org.uva.sea.ql.bootstrapping;

/**
 * Interface for classes that wrap a QLProgram.
 */
public interface QLProgram {

    boolean isCorrect();

    String getGeneratedQLCode();
}
