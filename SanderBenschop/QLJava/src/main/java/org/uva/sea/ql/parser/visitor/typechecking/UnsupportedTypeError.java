package org.uva.sea.ql.parser.visitor.typechecking;

import org.uva.sea.ql.parser.visitor.QLError;

import java.util.Collection;
import java.util.List;

public class UnsupportedTypeError extends QLError {

    private static final String TEMPLATE = "Error: variable on line %d of type %s was expected to be reduceable to %s.";

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
            } else if (last) {
                stringBuilder.append(" or " + simpleName);
            } else {
                stringBuilder.append(", " + simpleName);
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public String getErrorMessage() {
        return String.format(TEMPLATE, getLine(), actualTypeName, allowedTypeNames);
    }
}
