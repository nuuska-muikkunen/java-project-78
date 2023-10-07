package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StringSchema extends BaseSchema {
    //constraints
    private int minimumLengthAllowed = 0;
    private List<String> arrayOfStringsIncluded = new ArrayList<>();
//    private boolean isNotAllowed;

    public int getMinimumLengthAllowed() {
        return minimumLengthAllowed;
    }

    public void setMinimumLengthAllowed(int minimumLengthAllowed) {
        this.minimumLengthAllowed = minimumLengthAllowed;
    }

    @Override
    public boolean isValid(Object stringForValidation) {
        if (!(Objects.equals(stringForValidation, null)) && (!(stringForValidation instanceof String))) {
            return false;
        }
        if (isNotAllowed() && Objects.equals(stringForValidation, null)) {
            return false;
        }
        if (isNotAllowed() && stringForValidation.toString().equals("")) {
            return false;
        }
        if (!Objects.equals(stringForValidation, null)
                && stringForValidation.toString().length() < getMinimumLengthAllowed()) {
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
    } //— добавляет в схему ограничение минимальной длины для строки.
      // Строка должна быть равна или длиннее указанного числа

    public StringSchema contains(String str) {
        if (!this.arrayOfStringsIncluded.contains(str)) {
            this.arrayOfStringsIncluded.add(str);
        }
        return this;
    } //— добавляет в схему ограничение по содержимому строки. Строка должна содержать определённую подстроку
}
