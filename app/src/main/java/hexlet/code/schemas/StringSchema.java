package hexlet.code.schemas;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@Data
public class StringSchema extends BaseSchema {

    private int minimumLengthAllowed = 0;
    private List<String> arrayOfStringsIncluded = new ArrayList<>();

    @Override
    public boolean isValid(Object stringForValidation) {

        if (Objects.equals(stringForValidation, null)) {
            if (isNotAllowed()) {
                return false;
            }
        } else {
            if (!(stringForValidation instanceof String)
                || stringForValidation.toString().length() < getMinimumLengthAllowed()) {
                return false;
            }
        }

        if (isNotAllowed() && stringForValidation.equals("")) {
            return false;
        }

        for (String string : arrayOfStringsIncluded) {
            if (!stringForValidation.toString().contains(string)) {
                return false;
            }
        }

        return true;
    }

    public StringSchema set(int length1) {
        if (length1 > getMinimumLengthAllowed()) {
            setMinimumLengthAllowed(length1);
        }
        return this;
    }

    public StringSchema contains(String str) {
        if (!this.arrayOfStringsIncluded.contains(str)) {
            this.arrayOfStringsIncluded.add(str);
        }
        return this;
    }
}
