package org.uva.sea.ql.bootstrapper;

import java.io.File;
import java.io.IOException;

public interface QLBootstrapper {

    boolean checkAndBuildQLFile(File file) throws IOException;
}
