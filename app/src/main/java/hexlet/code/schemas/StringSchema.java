package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {

    public StringSchema() {
        addCheck("isAllowedAndEmpty", s -> (s != null) && (!isNotAllowed() || !s.equals("")));
        addCheck("isString", s -> s instanceof String);
    }

    public StringSchema minLength(int lengthOfString) {
        addCheck("minLength", s -> ((String) s).length() >= lengthOfString);
        return this;
    }

    public StringSchema contains(Object restriction) {
        addCheck("contains", s -> ((String) s).contains((String) restriction));
        return this;
    }

    public StringSchema required() {
        setNotAllowed(true);
        return this;
    }
}
