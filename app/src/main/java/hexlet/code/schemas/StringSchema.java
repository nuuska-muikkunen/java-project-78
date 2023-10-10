package hexlet.code.schemas;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@Data
public final class StringSchema extends BaseSchema {

    private int minimumLengthAllowed = 0;

    @Override
    public boolean isValid(Object stringForValidation) {
        if (Objects.equals(stringForValidation, null)) {
            return !isNotAllowed();
        }

        if (!(stringForValidation instanceof String)
            || stringForValidation.toString().length() < getMinimumLengthAllowed()) {
            return false;
        }

        if (isNotAllowed() && stringForValidation.equals("")) {
            return false;
        }

        if (isActiveStringRestriction()) {
            for (String str : (List<String>) getListOfRestrictions()) {
                if (!stringForValidation.toString().contains(str)) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public StringSchema minLength(int length1) {
        if (length1 > getMinimumLengthAllowed()) {
            setMinimumLengthAllowed(length1);
        }
        return this;
    }
}
