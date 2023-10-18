package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {

    public NumberSchema() {
        addCheck("isInteger", i -> (i != null) && (i instanceof Integer));
    }
    public NumberSchema positive() {
        addCheck("positive", i -> (Integer) i > 0);
        return this;
    }

    public NumberSchema range(int lowBorder, int highBorder) {
        addCheck("range", i -> (((Integer) i) >= lowBorder && ((Integer) i) <= highBorder));
        return this;
    }

    public NumberSchema required() {
        setNotAllowed(true);
        return this;
    }
}
