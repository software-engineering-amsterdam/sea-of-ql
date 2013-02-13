package org.uva.sea.ql;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

import java.util.logging.Logger;

public class Main {

    private final static Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] arguments) {
        QLCommandLineParameters commandLineParameters = new QLCommandLineParameters();
        JCommander jCommander = new JCommander(commandLineParameters);
        try {
            jCommander.parse(arguments);
        } catch(ParameterException exception) {
            LOGGER.severe("Cannot parse these arguments, use this interpreter with the following command line options:");
            jCommander.usage();
            System.exit(-1);
        }
    }
}
