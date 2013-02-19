package org.uva.sea.ql.bootstrapper;

import java.io.File;
import java.io.IOException;

public interface QLBootstrapper {

    QLProgram bootstrapQLProgram(File sourceCode) throws IOException;
}
