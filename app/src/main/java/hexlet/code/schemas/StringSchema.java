package hexlet.code.schemas;

import java.util.function.Predicate;


public final class StringSchema extends BaseSchema {
    private boolean isNotAllowed = false;
    @Override
    public boolean isValid(Object stringForValidation) {

        if (super.isValid(stringForValidation) && !isNotAllowed) {
            return true;
        }

        isEmptyAndNotString();
        if (!((Predicate) checks.get("isAllowedAndEmpty")).test(stringForValidation)
                || !((Predicate) checks.get("isString")).test(stringForValidation)) {
            return false;
        }

        for (Object key: checks.keySet()) {
            if (!((Predicate) checks.get(key)).test(stringForValidation)) {
                return false;
            }
        }
        return true;
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
        isNotAllowed = true;
        return this;
    }
    public StringSchema isEmptyAndNotString() {
        addCheck("isAllowedAndEmpty", s -> (s != null) && (!isNotAllowed || !s.equals("")));
        addCheck("isString", s -> s instanceof String);
        return this;
    }
}
