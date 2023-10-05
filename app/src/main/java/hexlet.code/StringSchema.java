package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StringSchema {
    //constraints
    private int minimumLengthAllowed = 0;
    private List<String> arrayOfStringsIncluded = new ArrayList<>();
    private boolean isNotAllowed;

    public int getMinimumLengthAllowed() {
        return minimumLengthAllowed;
    }

    public void setMinimumLengthAllowed(int minimumLengthAllowed) {
        this.minimumLengthAllowed = minimumLengthAllowed;
    }

    public List<String> getArrayOfStringsIncluded() {
        return arrayOfStringsIncluded;
    }

    public void setArrayOfStringsIncluded(List<String> arrayOfStringsIncluded) {
        this.arrayOfStringsIncluded = arrayOfStringsIncluded;
    }

    public boolean isNotAllowed() {
        return this.isNotAllowed;
    }

    public void setNotAllowed(boolean notAllowed) {
        this.isNotAllowed = notAllowed;
    }

    public boolean isValid(String stringForValidation) {
        if (isNotAllowed()) {
            if (Objects.equals(stringForValidation, null) || stringForValidation.equals("")) {return false;}
        }
        if (!Objects.equals(stringForValidation, null) && stringForValidation.length() < minimumLengthAllowed) { return false;}
        for (String string : arrayOfStringsIncluded) {
            if (!stringForValidation.contains(string)) {return false;}
        }
        return true;
    }

    public StringSchema required() {
        setNotAllowed(true);
        return this;
    } //— делает данные обязательными для заполнения. Иными словами добавляет в схему ограничение,
      // которое не позволяет использовать null или пустую строку в качестве значения

    public StringSchema set(int length1) {
        if (length1 > getMinimumLengthAllowed()) {setMinimumLengthAllowed(length1);}
        return this;
    } //— добавляет в схему ограничение минимальной длины для строки.
      // Строка должна быть равна или длиннее указанного числа

    public StringSchema contains(String str) {
        if (!this.arrayOfStringsIncluded.contains(str)) this.arrayOfStringsIncluded.add(str);
        return this;
    } //— добавляет в схему ограничение по содержимому строки. Строка должна содержать определённую подстроку
}
