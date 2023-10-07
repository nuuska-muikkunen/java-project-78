package hexlet.code;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;
@EqualsAndHashCode(callSuper = true)
@Data
public class NumberSchema extends BaseSchema {
    private int lowBorder = Integer.MIN_VALUE;
    private int highBorder = Integer.MAX_VALUE;
    private boolean isPositive = false;

    @Override
    public boolean isValid(Object numberForValidation) {

        if (Objects.equals(numberForValidation, null)) {
            return !isNotAllowed();
        }

        if (!(numberForValidation instanceof Integer)) {
            return false;
        }

        if (isPositive() && (Integer) numberForValidation <= 0) {
            return false;
        }

        return ((Integer) numberForValidation) >= getLowBorder() && ((Integer) numberForValidation) <= getHighBorder();
    }

    public NumberSchema positive() {
        setPositive(true);
        return this;
    }

    public NumberSchema range(int lBorder, int hBorder) {
        if (lBorder > getLowBorder()) {
            setLowBorder(lBorder);
        }
        if (hBorder < getHighBorder()) {
            setHighBorder(hBorder);
        }
        return this;
    }
}
