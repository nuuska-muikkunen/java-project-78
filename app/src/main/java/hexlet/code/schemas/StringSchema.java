package hexlet.code.schemas;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;
import java.util.function.Predicate;

@EqualsAndHashCode(callSuper = true)
@Data
public final class StringSchema extends BaseSchema {
    @Override
    public boolean isValid(Object stringForValidation) {
        if (Objects.equals(stringForValidation, null)) {
            return !isNotAllowed();
        }

        if (isNotAllowed() && stringForValidation.equals("")) {
            return false;
        }

        if (!(stringForValidation instanceof String)) {
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
}
