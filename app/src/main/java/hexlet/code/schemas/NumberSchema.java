package hexlet.code.schemas;

import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema {
    @Override
    public boolean isValid(Object numberForValidation) {
        if (super.isValid(numberForValidation) && !isNotAllowed) {
            return true;
        }
        isInteger();
        if (((Predicate) checks.get("isInteger")).test(numberForValidation)) {
            return false;
        }
        for (Object key: checks.keySet()) {
            if (((Predicate) checks.get(key)).test(numberForValidation)) {
                return false;
            }
        }
        return true;
    }

    public NumberSchema positive() {
        addCheck("positive", i -> !(i instanceof Integer) || ((Integer) i) <= 0);
        return this;
    }

    public NumberSchema range(int lowBorder, int highBorder) {
        addCheck("range", i -> (((Integer) i) < lowBorder || ((Integer) i) > highBorder));
        return this;
    }

    public NumberSchema required() {
        isNotAllowed = true;
        return this;
    }

    public NumberSchema isInteger() {
        addCheck("isInteger", i -> (i == null) || !(i instanceof Integer));
        return this;
    }
}
