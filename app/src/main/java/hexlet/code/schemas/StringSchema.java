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

        if (isActiveStringRestriction()) {
            boolean boo = true;
            for (String str : arrayOfStringsIncluded) {
                boo &= stringForValidation.toString().contains(str);
            }
            return boo;
        }

        return true;
    }

    public StringSchema minLength(int length1) {
        if (length1 > getMinimumLengthAllowed()) {
            setMinimumLengthAllowed(length1);
        }
        return this;
    }

    @Override
    public StringSchema contains(String str) {
        setActiveStringRestriction(true);
        saveRestrictionsStrings(str);
        return this;
    }

    public void saveRestrictionsStrings(String str) {
        if (!arrayOfStringsIncluded.contains(str)) {
            arrayOfStringsIncluded.add(str);
        }
    }
}
