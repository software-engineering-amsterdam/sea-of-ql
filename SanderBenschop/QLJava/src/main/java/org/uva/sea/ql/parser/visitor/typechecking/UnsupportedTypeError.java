package org.uva.sea.ql.parser.visitor.typechecking;

import org.uva.sea.ql.parser.visitor.QLError;

import java.util.List;

public class UnsupportedTypeError extends QLError {

    private static final String ERROR_MESSAGE_TEMPLATE = "Error: variable on line %d of type %s was expected to be reduceable to %s.";
    private static final String NON_LAST_CLASS_TEMPLATE = ", %s";
    private static final String LAST_CLASS_TEMPLATE = " or %s";

    private final String allowedTypeNames;
    private final String actualTypeName;

    public UnsupportedTypeError(int line, String actualTypeName, List<Class<?>> allowedTypes) {
        super(line);
        this.actualTypeName = actualTypeName;
        this.allowedTypeNames = createAllowedTypesString(allowedTypes);
    }

    private String createAllowedTypesString(List<Class<?>> allowedTypes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int index = 0; index < allowedTypes.size(); index++) {

            boolean first = index == 0, last = index == allowedTypes.size() - 1;
            String simpleName = allowedTypes.get(index).getSimpleName();

            if (first) {
               stringBuilder.append(simpleName);
            } else if (!last) {
                stringBuilder.append(String.format(NON_LAST_CLASS_TEMPLATE, simpleName));
            } else {
                stringBuilder.append(String.format(LAST_CLASS_TEMPLATE, simpleName));
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public String getErrorMessage() {
        return String.format(ERROR_MESSAGE_TEMPLATE, getLine(), actualTypeName, allowedTypeNames);
    }
}
