package hexlet.code;

import java.util.Objects;

public class NumberSchema extends BaseSchema {
    //constraints
    private int lowBorder = Integer.MIN_VALUE;
    private int highBorder = Integer.MAX_VALUE;
    private boolean isPositive = false;

    public int getLowBorder() {
        return lowBorder;
    }

    public void setLowBorder(int lowBorder) {
        this.lowBorder = lowBorder;
    }

    public int getHighBorder() {
        return highBorder;
    }

    public void setHighBorder(int highBorder) {
        this.highBorder = highBorder;
    }

    public boolean isPositive() {
        return this.isPositive;
    }

    public void setPositive(boolean positive) {
        this.isPositive = positive;
    }

    @Override
    public boolean isValid(Object numberForValidation) {
        if (isNotAllowed() && Objects.equals(numberForValidation, null)) {
            return false;
        }

        if (!(Objects.equals(numberForValidation, null)) && (!(numberForValidation instanceof Integer))) {
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
        if (lBorder < getLowBorder()) {
            setLowBorder(lBorder);
        }
        if (hBorder > getHighBorder()) {
            setHighBorder(hBorder);
        }
        return this;
    }
}
