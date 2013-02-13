package org.uva.sea.ql.generation.html;

import java.io.IOException;
import java.util.Map;

import org.uva.sea.ql.common.IOHelper;
import org.uva.sea.ql.generation.GeneratorException;

public class Templates {

    private static final String NAME = "<?NAME?>";
    private static final String CONTENT = "<?CONTENT?>";
    private static final String ID = "<?ID?>";
    private static final String CONDITION = "<?CONDITION?>";
    private static final String BODY = "<?BODY?>";
    private static final String INPUT = "<?INPUT?>";
    private static final String TYPE = "<?TYPE?>";
    private static final String SCRIPT = "<?SCRIPT?>";
    private static final String HEADING = "<?HEADING?>";
    private static final String CLASS = "<?CLASS?>";

    private Map<String, String> values;

    public Templates(String path) throws GeneratorException {
        try {
            this.values = IOHelper.readFolder(path);
        } catch (IOException ex) {
            throw new GeneratorException(ex.getMessage());
        }
    }

    public final String question(String content, String input) {
        return this.values.get("question").replace(CONTENT, content)
                .replace(INPUT, input);
    }

    public final String input(String name, InputTypes type) {
        return this.values.get("input").replace(NAME, name)
                .replace(TYPE, getInputType(type))
                .replace(CLASS, getInputClass(type));
    }

    public final String getterBool(String name) {
        return this.values.get("getter_bool").replace(NAME, name);
    }

    public final String getterMoney(String name) {
        return this.values.get("getter_money").replace(NAME, name);
    }

    public final String getterString(String name) {
        return this.values.get("getter_string").replace(NAME, name);
    }

    public final String document(String heading, String body, String script) {
        return this.values.get("document").replace(BODY, body)
                .replace(SCRIPT, script).replace(HEADING, heading);
    }

    public final String listener(String name, String id) {
        return this.values.get("listener").replace(NAME, name).replace(ID, id);
    }

    public final String evaluator(String id, String condition) {
        return this.values.get("evaluator").replace(ID, id)
                .replace(CONDITION, condition);
    }

    public final String hiddenStart(String id) {
        return this.values.get("hidden_start").replace(ID, id);
    }

    public final String hiddenEnd() {
        return this.values.get("hidden_end");
    }

    private static String getInputType(InputTypes t) {
        String ret = null;
        if (t == InputTypes.BOOLEAN)
            ret = "checkbox";
        if (t == InputTypes.STRING || t == InputTypes.MONEY)
            ret = "text";
        return ret;
    }

    private static String getInputClass(InputTypes t) {
        String ret = null;
        if (t == InputTypes.BOOLEAN)
            ret = "input_boolean";
        if (t == InputTypes.STRING)
            ret = "required";
        if (t == InputTypes.MONEY)
            ret = "number required";
        return ret;
    }
}
