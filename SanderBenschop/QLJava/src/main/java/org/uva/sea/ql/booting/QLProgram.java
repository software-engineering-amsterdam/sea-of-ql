package org.uva.sea.ql.booting;

import org.uva.sea.ql.general.SymbolTable;

/**
 * Interface for classes that wrap a QLProgram.
 */
public interface QLProgram {

    boolean isCorrect();

    String getGeneratedQLCode();

    SymbolTable getSymbolTable();
}
