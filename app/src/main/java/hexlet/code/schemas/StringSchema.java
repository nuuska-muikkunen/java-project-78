package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<Object> {

    public StringSchema() {
        addCheck("isAllowedAndEmpty", s -> (s != null) && (!required || !s.equals("")));
        addCheck("isString", s -> s instanceof String);
    }

    public StringSchema minLength(int lengthOfString) {
        addCheck("minLength", s -> ((String) s).length() >= lengthOfString);
        return this;
    }

    public StringSchema contains(String restriction) {
        addCheck("contains", s -> ((String) s).contains(restriction));
        return this;
    }

    public StringSchema required() {
        required = true;
        return this;
    }
}
