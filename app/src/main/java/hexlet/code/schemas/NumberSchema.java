package hexlet.code.schemas;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;
import java.util.function.Predicate;

@EqualsAndHashCode(callSuper = true)
@Data
public final class NumberSchema extends BaseSchema {

    @Override
    public boolean isValid(Object numberForValidation) {
        if (Objects.equals(numberForValidation, null)) {
            return !isNotAllowed();
        }
        if (!(numberForValidation instanceof Integer)) {
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
        addCheck("positive", i -> ((Integer) i) <= 0);
        return this;
    }

    public NumberSchema range(int lowBorder, int highBorder) {
        addCheck("range", i -> (((Integer) i) < lowBorder || ((Integer) i) > highBorder));
        return this;
    }
}
